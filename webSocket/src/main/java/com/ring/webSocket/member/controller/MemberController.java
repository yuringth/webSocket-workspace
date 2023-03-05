package com.ring.webSocket.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ring.webSocket.member.model.service.MemberService;
import com.ring.webSocket.member.model.vo.Member;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session) {
		
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser == null) {
			// model.addAttribute("키", "밸류");
			mv.addObject("errorMsg","로그인에 실패했습니다");
			mv.setViewName("common/errorPage");
		} else {
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	

	
	
}
