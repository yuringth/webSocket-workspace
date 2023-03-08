<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <style>
        .content {
            background-color:rgb(247, 245, 245);
            width:80%;
            margin:auto;
        }
        .innerOuter {
            border:1px solid lightgray;
            width:80%;
            margin:auto;
            padding:5% 10%;
            background-color:white;
        }
    </style>

</head>
<body>

    <jsp:include page="../common/header.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>회원가입</h2>
            <br>

            <form action="insert.me" method="post" id="enroll-form">
                <div class="form-group">
                    <label for="memId">* ID : </label>
                    <input type="text" class="form-control" id="memId" placeholder="Please Enter ID" name="memId" required> <br>
					
					<!--아이디 중복체크-->
					<div id="checkResult" style="font-size:0.7em; display:none;"></div>
					<br>

                    <label for="memPwd">* Password : </label>
                    <input type="password" class="form-control" id="memPwd" placeholder="Please Enter Password" name="memPwd" required> <br>

                    <label for="checkPwd">* Password Check : </label>
                    <input type="password" class="form-control" id="checkPwd" placeholder="Please Enter Password" required> <br>

                    <label for="memName">* Name : </label>
                    <input type="text" class="form-control" id="memName" placeholder="Please Enter Name" name="memName" required> <br>

                    <label for="email"> &nbsp; Email : </label>
                    <input type="text" class="form-control" id="email" placeholder="Please Enter Email" name="email"> <br>

                    <label for="age"> &nbsp; Age : </label>
                    <input type="number" class="form-control" id="age" placeholder="Please Enter Age" name="age"> <br>

                    <label for="phone"> &nbsp; Phone : </label>
                    <input type="tel" class="form-control" id="phone" placeholder="Please Enter Phone (-없이)" name="phone"> <br>
                    
                    <label for="address"> &nbsp; Address : </label>
                    <input type="text" class="form-control" id="address" placeholder="Please Enter Address" name="address"> <br>
                    
                    <label for=""> &nbsp; Gender : </label> &nbsp;&nbsp;
                    <input type="radio" id="Male" value="M" name="gender" checked>
                    <label for="Male">남자</label> &nbsp;&nbsp;
                    <input type="radio" id="Female" value="F" name="gender">
                    <label for="Female">여자</label> &nbsp;&nbsp;
                </div> 
                <br>
                <div class="btns" align="center">
                	<!-- 회원가입버튼 비활성화  -->
                    <button type="submit" class="btn btn-primary disabled">회원가입</button>
                    <button type="reset" class="btn btn-danger">초기화</button>
                </div>
            </form>
        </div>
        <br><br>

    </div>
    
    
    <script>
    	$(function(){
    		// 내가 입력한 id값
    		const $idInput = $('.form-group #memId');
    		
    		$idInput.keyup(function(){
    			// console.log($idInput.val());
    			
    			// 최소 다섯글자 이상으로 입력할 때만 ajax요청해서 중복체크(입력한 값이 다섯글자 이상인지)
    			if($idInput.val().length >= 5){
    				
    				$.ajax({
    					url : 'idCheck.me',
    					data : {
    						checkId : $idInput.val()
    					},
    					success : function(result){
    						// console.log(result);
    						if(result == 'NNNNN'){ // 사용 불가능
    							$('#checkResult').show();
    							$('#checkResult').css('color', 'red').text('이미 사용중이거나 탈퇴한 아이디입니다.');
    							$('#enroll-form :submit').attr('disabled', true);
    						} 
    						else{ // 사용가능
    							$('#checkResult').show();
    							$('#checkResult').css('color', 'forestgreen').text('멋진 아이디네요!');
    							$('#enroll-form :submit').removeAttr('disabled');
    						}
    					},
    					error : function(){
    						console.log('아이디 중복체크용 ajax통신 실패');
    					}
    				});
    			} else {
    				$('#checkResult').hide();
    				$('#enroll-form :submit').attr('disabled', true);
    			}
    			
    		});
    	})
    </script>
    
    
    

    <jsp:include page="../common/footer.jsp" />

</body>
</html>