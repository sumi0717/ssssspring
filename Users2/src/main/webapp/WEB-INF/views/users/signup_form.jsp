<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/views/users/signup_form.jsp</title>
</head>
<body>
<h3>회원가입 페이지 입니다</h3>
<form action="signup.do" method="post" id="signupForm">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" />
	<span id="checkResult"></span><br />
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd" /><br />
	<label for="email">이메일</label>
	<input type="text" name="email" id="email" /><br />
	<button type="submit">가입</button>
</form>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<script>
	//폼의 유효성 여부
	var formValid=false;
	
	$("#signupForm").submit(function(){
		//만일 폼의 유효성 여부가 false면
		if(formValid==false){
			return false;//폼 전송 막기
		} 
	});

	//아이디 입력란에 입력했을 때 실행할 함수 등록
	$("#id").on("input", function(){
		//입력한 아이디를 읽어와서
		var inputId=$(this).val();
		//ajax 요청을 이용해서 서버에 보낸다, 그냥 요청은 url에 페이지 이동이 표시되지만
		//ajax요청은 함수로 받아지는 것이기 때문에 url에 요청과 응답의 변화가 나타나지않음
		$.ajax({
			url:"checkid.do",
			method:"post", 
			//ajax는 요청 때문에 DB에 변동되는게 없기 때문에 get이든 post든 상관 없음
			//서버 입장에서는 ajax 요청이든, 그냥 요청이든 차이 없음
			//이런 요청 응답 방식의 차이는 클라이언트에게만 차이가 있음
			//ajax는 서버 프로그래밍과는 상관 없음
			data:{"inputId":inputId},
			success:function(responseData){
				//responseData에 들어가는 인자 언어 형식은, html, json,xml 등 자유롭게 코딩해서 표시 가능
				
				//뭐가 응답되는지 콘솔에 출력해보기
				console.log(responseData);
				
				// responseData 는 object이다
				// {canUse:true} 또는 {canUse:false}
				if(responseData.canUse){
					formValid=true;
					$("#checkResult")
					.text("사용 가능")
					.css("color","blue");
				}else{
					formVaild=false;
					$("#checkResult")
					.text("사용 불가")
					.css("color","red");
				}
			}
		});
	});
</script>
</body>
</html>