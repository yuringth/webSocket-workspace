package com.ring.webSocket.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ring.webSocket.member.model.service.MemberService;
import com.ring.webSocket.member.model.vo.Member;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	// 로그인
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session) {
		
		Member loginUser = memberService.loginMember(m);
		
		// BCryptPasswordEncoder 객체에 match(평문, 암호문) 전달 후, 두 값이 같으면 true 반환
		if(loginUser != null && bcryptPasswordEncoder.matches(m.getMemPwd(), loginUser.getMemPwd())) {
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("errorMsg","로그인에 실패했습니다");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	// 로그아웃
	@RequestMapping("logout.me")
	public String logoutMember(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	

	// 회원가입창으로 포워딩
	@RequestMapping("enrollForm.me")
	public String enrollForm() {
		return "member/memberEnrollForm";
	}
	
	
	// 회원가입
	@RequestMapping("insert.me")
	public String insertMember(Member m, Model model) {
		
		// System.out.println("평문 : " + m.getMemPwd());
		
		// 암호문을 만들어내는 작업
		String encPwd = bcryptPasswordEncoder.encode(m.getMemPwd());
		// System.out.println("암호문 : " + encPwd);
		
		m.setMemPwd(encPwd); // 평문이 아닌 암호문으로 세팅
		
		int result = memberService.insertMember(m);
		
		if(result>0) {
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "회원가입 실패하셨습니다");
			return "common/errorPage";
		}
		
	}
	
	
	// 마이페이지 창으로 포워딩
	@RequestMapping("myPage.me")
	public String myPage() {
		return "member/myPage";
	}
	
	
	
	
	
	
}
