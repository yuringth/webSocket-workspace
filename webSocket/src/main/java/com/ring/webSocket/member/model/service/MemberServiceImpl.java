package com.ring.webSocket.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
