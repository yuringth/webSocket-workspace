<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>

    <style>
        /* div{border:1px solid red;} */
        #footer {
            width:80%;
            height:200px; 
            margin:auto;
            margin-top:50px;
        }
        #footer-1 {
            width:100%;
            height:20%;
            border-top:1px solid lightgray;
            border-bottom:1px solid lightgray;
        }
        #footer-2 {width:100%; height:80%;}
        #footer-1, #footer-2 {padding-left:50px;}
        #footer-1>a {
            text-decoration:none;
            font-weight:600;
            margin:10px;
            line-height:40px;
            color:black;
        }
        #footer-2>p {
            margin:0;
            padding:10px;
            font-size:13px;
        }
        #p2 {text-align:center;}
	</style>
    
</head>
<body>

    <div id="footer">
        <div id="footer-1">
            <a href="https://www.madeedam.com/service/company.php">회사소개</a> | 
            <a href="https://www.madeedam.com/service/agreement.php">이용약관</a> | 
            <a href="https://www.madeedam.com/service/private.php">개인정보처리방침</a> | 
            <a href="https://www.madeedam.com/service/guide.php">이용안내</a>
        </div>

        <div id="footer-2">
            <p id="p1">
            	IU Entertainment <br>
	           	주소 : 서울특별시 강남구 테헤란로 103길 17 <br>
           		통신판매업신고 : 제20-서울강남-01836호 <br>
            </p>
            <p id="p2">Copyright © 1998-2023 유림 All Right Reserved</p>
        </div>
    </div>

</body>
</html>