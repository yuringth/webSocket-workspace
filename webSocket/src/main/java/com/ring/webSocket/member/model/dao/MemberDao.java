package com.ring.webSocket.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ring.webSocket.email.Cert;
import com.ring.webSocket.member.model.vo.Member;

@Repository
public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember",m);
	}
	
	public int updateMember(SqlSession sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMember", m);
	}

	public int deleteMember(SqlSession sqlSession, String memId) {
		return sqlSession.update("memberMapper.deleteMember", memId);
	}

	public int idCheck(SqlSession sqlSession, String checkId) {
		return sqlSession.selectOne("memberMapper.idCheck", checkId);
	}

	public int insertEmail(SqlSessionTemplate sqlSession, Cert certVO) {
		return sqlSession.insert("memberMapper.insertSecret", certVO);
	}

	public int selectEmail(SqlSessionTemplate sqlSession, Cert certVO) {
		
		int result = sqlSession.selectOne("memberMapper.selectEmail", certVO);
		
		if(result > 0) { // 발급받은 인증키가 있음 => 인증완료 후 데이터 삭제
			sqlSession.delete("memberMapper.removeEmail", certVO);
		}
		
		return result; // result(certVO), true	
		
		
		/*
		// 이렇게 하면 통신 실패는 안함. 대신 1만 리턴됨
		CertVO result = sqlSession.selectOne("memberMapper.selectEmail", certVO);
		
		if(result != null) { // 발급받은 인증키가 있음 => 인증완료 후 데이터 삭제
			sqlSession.delete("memberMapper.removeEmail", certVO);
		}
		
		return 1; // result(certVO), true
		
		//////////////
		
		int result = sqlSession.selectOne("memberMapper.selectEmail", certVO);
		
		// 인증완료된 인증번호는 인증 후, 데이터 삭제
	
	
		if(result > 0) {
			sqlSession.delete("memberMapper.removeEmail", certVO);
		}
		
		return result;
		*/
	}
	
}
