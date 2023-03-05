package com.ring.webSocket.member.model.vo;

import java.sql.Date;

public class Member {

	private int memNo; // MEM_NO	NUMBER
	private String memId; //MEM_ID	VARCHAR2(30 BYTE)
	private String memPwd; //MEM_PWD	VARCHAR2(2000 BYTE)
	private String memName; //MEM_NAME	VARCHAR2(30 BYTE)
	private String email; //EMAIL	VARCHAR2(100 BYTE)
	private String gender; //GENDER	VARCHAR2(1 BYTE)
	private int age; //AGE	NUMBER
	private String phone; //PHONE	VARCHAR2(13 BYTE)
	private String address; //ADDRESS	VARCHAR2(100 BYTE)
	private Date enrollDate; // ENROLL_DATE	DATE
	private Date modifyDate; //MODIFY_DATE	DATE
	private String status; //STATUS	VARCHAR2(1 BYTE)
	
	public Member() {
		super();
	}

	public Member(int memNo, String memId, String memPwd, String memName, String email, String gender, int age,
			String phone, String address, Date enrollDate, Date modifyDate, String status) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memId=" + memId + ", memPwd=" + memPwd + ", memName=" + memName
				+ ", email=" + email + ", gender=" + gender + ", age=" + age + ", phone=" + phone + ", address="
				+ address + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
}
