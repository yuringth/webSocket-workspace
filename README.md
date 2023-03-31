# Toy project

---

## :page_with_curl: 1) 미니 프로젝트 소개
<h3 align="center">"회원가입 / 로그인"</h3>
<br>
<p align="center">
팀프로젝트에서 게시판만 맡아왔기때문에 <b>회원가입 / 로그인 기능</b>을 구현하였습니다.<br>
주소 입력 란은 API를 사용하여 구현하였습니다.<br>
</p>

***

| `프로젝트 이름` | 개인 미니 프로젝트 |
| ------------ | -------------------------------------------------- |
| `프로젝트 기간` | 2023.03.05 ~ 2023.03.13 |
| `개발자` | 박유림 |
| `개발목표` | 이메일 인증을 통한 회원가입과, 로그인, 주소 API 기능 구현. |
<br>


## :wrench: 2) 개발환경
### OS
<img src="https://img.shields.io/badge/window10-1572B6?style=for-the-badge&logo=windows&logoColor=white">

### Languages
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"><img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"><img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white"><img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white">

### IDE/Tools
<img src="https://img.shields.io/badge/Visual Studio-5C2D91?style=for-the-badge&logo=Visual Studio&logoColor=white"><img src="https://img.shields.io/badge/STS-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">

### DBMS
<img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white"><img src="https://img.shields.io/badge/SqlDeveloper-gray?style=for-the-badge&logo=SqlDeveloper&logoColor=white">

### Web Server
<img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=for-the-badge&logo=Apache Tomcat&logoColor=white">

### FrameWorks
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"><img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white">

### Cooperation
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<br>


## 📌 3) 주요기능(GIF有)

![유효성검사](https://user-images.githubusercontent.com/121650385/224617741-aeea9a84-fa4d-42db-8001-b7d9e786793e.gif)
<br>
<b>아이디&비밀번호 유효성 검사</b>

1. 아이디 입력 - 중복 검사 (ajax로 사용가능/불가 text나타남)
2. 비밀번호 입력/재입력 - 유효성 검사, 일치 검사 (ajax로 일치/불가 text나타남)
<br><br>


![이메일인증](https://user-images.githubusercontent.com/121650385/224619292-bb01b837-cd74-4905-bc17-2c6930813bf1.gif)
<br>
<b>이메일 입력 및 인증</b>
1. 이메일 입력 - 이메일로 인증번호 전달
2. 이메일 인증 - 인증 성공 시, ajax로 성공 알람 안내와 회원가입 가능 / 인증 실패 시, ajax로 실패 알람 안내와 회원가입 불가
<br><br>


![주소api](https://user-images.githubusercontent.com/121650385/224617782-a6b913a9-ee9d-4aeb-a8f0-0244000bbb1a.gif)
<br>
<b>주소 API</b>
1. 주소 칸에 커서 클릭 시 카카오 우편번호로 주소찾기 양식 보여줌(API양식이 녹화에 안찍힙니다..)
2. 주소 클릭하면 해당 주소 입력됨
3. 모든 항목 작성 시 회원가입 버튼 활성화
<br><br>


![로그인로그아웃](https://user-images.githubusercontent.com/121650385/224629493-5fe2d24e-b60a-464f-a887-935a0f755426.gif)
<br>
<b>웹사이트 로그인/로그아웃</b>
1. 일치하는 아이디&비밀번호 입력 시 로그인(비밀번호는 암호화하여 구현)
2. 로그아웃 클릭시, session에 담긴 loginUser의 회원정보를 무효화함
<br><br>


![마이페이지수정](https://user-images.githubusercontent.com/121650385/224629498-6dcd57c2-01a6-4e16-befa-4c2bc62a200c.gif)
<br>
<b>회원정보 수정</b>
1. 회원정보 정정 후, 수정버튼 클릭 시 회원정보 변경
<br><br>


![회원탈퇴](https://user-images.githubusercontent.com/121650385/224629482-c935111a-ab30-4a65-9afa-e088d3b35b1a.gif)
<br>
<b>회원탈퇴</b>
1. 탈퇴버튼 클릭 후, 회원 비밀번호 입력 시 회원탈퇴 성공
<br><br><br><br>




## :pencil2: 4) 참고 사이트
### 카카오(Daum) 우편번호 API
https://postcode.map.daum.net/guide


## 📝 License

Copyright © 2023  박유림 <br>
