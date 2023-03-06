package com.ring.webSocket.member.model.vo;

import java.sql.Date;

import lombok.Data;


@Data
public class Member {

	private int memNo; // MEM_NO	NUMBER
	private String memId; //MEM_ID	VARCHAR2(30 BYTE)
	private String memPwd; //MEM_PWD	VARCHAR2(2000 BYTE)
	private String memName; //MEM_NAME	VARCHAR2(30 BYTE)
	private String email; //EMAIL	VARCHAR2(100 BYTE)
	private String gender; //GENDER	VARCHAR2(1 BYTE)
	private String age; //AGE	NUMBER
	private String phone; //PHONE	VARCHAR2(13 BYTE)
	private String address; //ADDRESS	VARCHAR2(100 BYTE)
	private Date enrollDate; // ENROLL_DATE	DATE
	private Date modifyDate; //MODIFY_DATE	DATE
	private String status; //STATUS	VARCHAR2(1 BYTE)

}
