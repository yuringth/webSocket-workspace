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
                    <input type="password" class="form-control" id="memPwd" placeholder="8~15자의 영문, 숫자, ~!@# 특수문자의 입력이 가능합니다." name="memPwd" required> <br>

					<!--비밀번호 유효성 검사-->
					<div id="regExp-Result" style="font-size:0.7em; display:none;"></div>
					<br>


                    <label for="checkPwd">* Password Check : </label>
                    <input type="password" class="form-control" id="checkPwd" placeholder="Please Enter Password" name="checkPwd" required> <br>

					<!--비밀번호 일치 검사-->
					<div id="checkPwd-Result" style="font-size:0.7em; display:none;"></div>
					<br>


                    <label for="memName">* Name : </label>
                    <input type="text" class="form-control" id="memName" placeholder="Please Enter Name" name="memName" required> <br>



                    <label for="email"> &nbsp;* Email : </label>
                    
                    <!-- 메일 인증 -->
                    <div id="email-Area">
	                    <input type="text" class="form-control" id="email" placeholder="Please Enter Email" name="email" required> <br>
						<button type="button" class="btn btn-primary" onclick="emailCheck();">인증요청</button>
					</div>
					
					<!-- 메일 인증 확인  -->
					<div id="secret-Area" style="display:none;">
						<input type="text" class="form-control" id="secret" placeholder="Please Enter Verification Code" name="secret" required> <br>
						<button type="button" class="btn btn-primary" onclick="secretCheck();">인증확인</button>
					</div>
					
					<!-- 메일 인증 확인 결과-->
					<div id="secret-Result" style="font-size:0.7em; display:none;"></div>
					<br><br>					
					
					
                    <label for="age"> &nbsp;* Age : </label>
                    <input type="number" class="form-control" id="age" placeholder="Please Enter Age" name="age" required> <br>

                    <label for="phone"> &nbsp;* Phone : </label>
                    <input type="tel" class="form-control" id="phone" placeholder="Please Enter Phone (-없이)" name="phone" required> <br>
                    
                    <label for="address"> &nbsp;* Address : </label>
                    <input type="text" class="form-control" id="address" placeholder="Please Enter Address" name="address" required> <br>
                    
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
    	// id 중복 체크용 스크립트
    	
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
    
    
    <script>
    	// 비밀번호 유효성 검사(정규표현식 사용)
    	$('input[name=memPwd]').focusout(function(){
    		
    		var regExp = /^[a-zA-Z\d~!@#]{8,15}$/;
			var $memPwd = $('#memPwd').val();
			
			if(regExp.test($('#memPwd').val())){
				$('#regExp-Result').show();
				$('#regExp-Result').css('color', 'forestgreen').text('비밀번호를 사용할 수 있습니다.');
				$('#enroll-form :submit').removeAttr('disabled');
			} else{
				$('#regExp-Result').show();
				$('#regExp-Result').css('color', 'red').text('8~15자의 영문, 숫자, ~!@# 특수문자의 입력이 가능합니다.');
				$('#enroll-form :submit').attr('disabled', true);
			}
    	})
    </script>
    
    
    <script>
    	// 비밀번호 일치 검사 스크립트
    	
    	$('input[name=checkPwd]').focusout(function(){
    		var $memPwd = $('#memPwd').val();
    		var $checkPwd = $('#checkPwd').val();
    	
   			if($memPwd == $checkPwd){
   				$('#checkPwd-Result').show();
				$('#checkPwd-Result').css('color', 'forestgreen').text('비밀번호가 일치합니다.');
   			} else {
   				$('#checkPwd-Result').show();
				$('#checkPwd-Result').css('color', 'red').text('비밀번호가 불일치합니다.');
				$('#enroll-form :submit').attr('disabled', true);
   			}
    	})
    </script>
    
    
	<!-- 주소란 클릭 시, 우편번호 API 나타나는 스크립트  -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    
    	$('#address').click(function(){
    		
    		new daum.Postcode({
	            oncomplete: function(data) {
	            	document.getElementById('address').value = data.address; 
	            }
	        }).open();
    	})
    </script>
    
    
    
    
    <!-- 이메일 인증요청 클릭 시 -->
    <script>
    	function emailCheck(){
	    	$.ajax({
	    		url : 'insertCode.me',
	    		type : 'post',
	    		data : {
	    			email : $('#email').val()
	    		},
	    		success : function(result){
	    			if(result > 0){
	    				$('#secret-Area').show();
	    				$('#enroll-form :submit').attr('disabled', true);
	    			}
	    		},
	    		error : function(){
					console.log('이메일 인증 ajax통신 실패');
				}    	
	    	})
    	}
    </script>


    <!-- 이메일 인증확인 클릭 시 -->
    <script>
    	function secretCheck(){
    		$.ajax({
    			url : 'selectCode.me',
    			type : 'post',
    			data : {
    				secret : $('#secret').val()
    			},
    			success : function(result){
    				
    				if(result == 'success'){
    					alert('인증 성공');
    					$('#secret-Result').show();
    					$('#secret-Result').css('color', 'forestgreen').text('인증되었습니다.');
    					$('#email').attr('readonly', true);
    					$('#secret-Area').hide();
    					$('#enroll-form :submit').removeAttr('disabled');
    				} else{
    					alert('인증 실패');
    					$('#secret-Result').show();
    					$('#secret-Result').css('color', 'red').text('인증번호가 일치하지 않습니다. 다시 입력해주세요.');
    					$('#enroll-form :submit').attr('disabled', true);
    				}
    			},
    			error : function(){
					console.log('이메일 인증 ajax통신 실패');
				}
    		})
    	}
    </script>
    
    
    

    <jsp:include page="../common/footer.jsp" />

</body>
</html>