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

<h3>로그인 폼입니다</h3>
<form action="login.do?url=${url }" method="post">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" />
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd" />
	<button type="submit">로그인</button>
</form>
</body>
</html>