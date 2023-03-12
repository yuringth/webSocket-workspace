package com.ring.webSocket.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ring.webSocket.email.CertVO;
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

	public void insertSecret(SqlSessionTemplate sqlSession, CertVO certVO) {
		sqlSession.insert("memberMapper.insertSecret", certVO);
	}

	public boolean validate(SqlSessionTemplate sqlSession, CertVO certVO) {
		
		CertVO result = sqlSession.selectOne("memberMapper.validate", certVO);
		
		// 인증완료된 인증번호는 인증 후, 데이터 삭제
		if(result != null) {
			sqlSession.delete("memberMapper.remove", certVO);
		}
		
		return result != null; // == true
	}
	
}
