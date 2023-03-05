package com.ring.webSocket.member.model.service;

import com.ring.webSocket.member.model.vo.Member;

public interface MemberService {
	
	// 로그인(select)
	Member loginMember(Member m);
	
	// 회원가입(insert)
	int insertMember(Member m);
	
	// 회원정보수정(update)
	int updateMember(Member m);
	
	// 회원탈퇴(update)
	int deleteMember(Member m);
	
	// 아이디 중복체크(select)
	int idCheck(String checkId);
	
	
}
