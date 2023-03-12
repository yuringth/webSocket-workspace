package com.ring.webSocket.member.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ring.webSocket.member.model.service.MemberService;
import com.ring.webSocket.member.model.vo.Member;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	private JavaMailSender sender; // 메일 전송도구
	
	
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
		session.invalidate(); // session의 기능을 중단시키고 무효화 하는 함수
		return "redirect:/";
	}
	

	// 회원가입창으로 포워딩
	@RequestMapping("enrollForm.me")
	public String enrollForm() {
		return "member/memberEnrollForm";
	}
	
	
	/**
	 * @param m : 내가 입력한 회원정보
	 * @return
	 */
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
	
	
	// 회원정보 수정
	@RequestMapping("update.me")
	public String updateMember(Member m, Model model, HttpSession session) {
		
		int result = memberService.updateMember(m);
		
		if(result > 0) { // 수정성공
		
			// DB로부터 수정된 회원정보를 다시 조회 후, session에 loginUser라는 키값으로 덮어씌우기
			session.setAttribute("loginUser", memberService.loginMember(m));
			session.setAttribute("alertMsg", "성공적으로 변경 되었습니다");
			return "redirect:myPage.me";
			
		} else { // 수정실패
			
			model.addAttribute("errorMsg", "회원 정보 변경 실패");
			return "common/errorPage";
		
		}
	}
	
	
	// 회원탈퇴
	/**
	 * @param memPwd : 회원 탈퇴 요청 시 사용자가 입력한 비밀번호 평문
	 * @param session : 로그인 되어있는 loginUser Member객체에서 userPwd를 뽑음 => DB에 기록된 암호화된 비밀번호
	 * @return
	 */
	@RequestMapping("delete.me")
	public String deleteMember(String memId, String memPwd, HttpSession session) {
		
		String encPwd = ((Member)session.getAttribute("loginUser")).getMemPwd();
		if(bcryptPasswordEncoder.matches(memPwd, encPwd)) { // 평문 비밀번호와 암호문 비밀번호와 일치하는 경우
			int result = memberService.deleteMember(memId);
			if(result > 0) { // 탈퇴 성공
				session.removeAttribute("loginUser");
				session.setAttribute("alertMsg", "회원탈퇴가 성공하였습니다");
				return "redirect:/";
			} else {
				session.setAttribute("errorMsg", "회원탈퇴가 실패하였습니다");
				return "common/errorPage";
			}
		} else {
			session.setAttribute("alertMsg", "비밀번호가 다릅니다");
			return "redirect:myPage.me";
		}
		
	}
	
	
	/**
	 * @param checkId : 내가 입력한 id값
	 */
	// 아이디 중복체크
	@ResponseBody
	@RequestMapping("idCheck.me")
	public String idCheck(String checkId) {
		
		int count = memberService.idCheck(checkId);
		
		// 네이버 방식 참고 NNNNY : 사용가능 / NNNNN : 사용불가능
		if(count > 0) { // 이미 존재하는 아이디  (NNNNN : 사용불가능)
			return "NNNNN";
		} else { // 사용 가능 아이디 (NNNNY : 사용가능)
			return "NNNNY";
		}
	}
	
	
	
	@GetMapping("input")
	public String input() {
		return "member/input";
	}
	
	@GetMapping("check")
	public String check() {
		return "member/check";
	}
	
	

	
	
	
	
	
}
