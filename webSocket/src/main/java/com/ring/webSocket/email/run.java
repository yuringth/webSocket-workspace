package com.ring.webSocket.email;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class run {
	
	public static JavaMailSenderImpl sender; // 메일 전송도구 설정
	public static void main(String[] args) {
		
		JavaMailSenderImpl impl = new JavaMailSenderImpl();
		
		// - 계정 설정
		impl.setHost("smtp.gmail.com"); // 구글 사용(고정)
		impl.setPort(587); // 구글 포트 번호(고정)
		impl.setUsername("testemaildayo"); // 아이디
		impl.setPassword("gtcktgxlxpckyunl"); // 패스워드
		
		// - 옵션 설정
		Properties prop = new Properties(); 
		prop.put("mail.smtp.auth", true); // 권한 관련 옵션
		prop.put("mail.smtp.starttls.enable", true); // 보안 관련 옵션
		
		impl.setJavaMailProperties(prop); // 옵션과 연결
		
		sender = impl; 
		
		
		// 메시지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		
		// 메시지 정보 설정 : 제목, 내용, 받는사람, 참조, 숨은참조 (첨부파일은 simple에선 불가)
		message.setSubject("테스트메일");
		message.setText("테스트메일의 본문 내용입니다.");

		String[] to = {"testemaildayo@gmail.com", "dldlwlrma@gmail.com"}; // 받는사람 배열로 생성 후 message객체에 대입
		message.setTo(to);
		
		message.setCc("dldlwlrma@gmail.com"); // 참조
		message.setBcc("dldlwlrma@gamil.com"); // 숨은 참조
		
		// 전송
		sender.send(message); // 전송할때 메시지 정보들을 담아서 보냄
		
		
	}

}
