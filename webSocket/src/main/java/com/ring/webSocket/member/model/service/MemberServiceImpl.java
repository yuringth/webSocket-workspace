package com.ring.webSocket.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ring.webSocket.email.CertVO;
import com.ring.webSocket.member.model.dao.MemberDao;
import com.ring.webSocket.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	// 로그인
	@Override
	public Member loginMember(Member m) {
		// Member loginUser = memberDao.loginMember(sqlSession, m);
		return memberDao.loginMember(sqlSession, m);
	}

	// 회원가입
	@Override
	public int insertMember(Member m) {
		// int result = memberDao.insertMember(sqlSession, m);
		return memberDao.insertMember(sqlSession, m);
	}

	
	// 회원정보수정
	@Override
	public int updateMember(Member m) {
		return memberDao.updateMember(sqlSession, m);
	}

	
	// 회원탈퇴
	@Override
	public int deleteMember(String memId) {
		return memberDao.deleteMember(sqlSession, memId);
	}

	
	// 아이디 중복체크
	@Override
	public int idCheck(String checkId) {
		return memberDao.idCheck(sqlSession, checkId);
	}

	// 메일인증 번호 발급
	@Override
	public int insertEmail(CertVO certVO) {
		return memberDao.insertEmail(sqlSession, certVO);
	}

	// 메일인증 확인
	@Override
	public int selectEmail(CertVO certVO) {
		
		System.out.println("서비스단 : " + memberDao.selectEmail(sqlSession, certVO)); // 1을 return하니까 무조건 1이뜨지
		
		return memberDao.selectEmail(sqlSession, certVO);
	}

}
