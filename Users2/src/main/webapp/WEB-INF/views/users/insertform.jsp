<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/insertform.jsp</title>
</head>
<body>
<h3>회원 정보 추가 폼입니다</h3>
<form action="insert.do" method="post">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" />
	<label for="pwd">비번</label>
	<input type="password" name="pwd" id="pwd" />
	<button type="submit">추가</button>
</form>
</body>
</html>