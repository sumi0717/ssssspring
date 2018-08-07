<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 가입 결과 페이지</h3>
<c:choose>
	<c:when test="${isSuccess }">
		<p>${id }님 가입 되었습니다</p> 
		<a href="loginform.do">로그인 하기</a>
	</c:when>
	<c:otherwise>
		<p>가입 실패!</p>
		<a href="signup_form.do">다시 가입하러 가기</a>
	</c:otherwise>
</c:choose>
</body>
</html>