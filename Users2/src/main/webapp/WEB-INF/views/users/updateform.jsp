<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 정보 수정 폼입니다</h3>
<form action="update.do" method="post">
	<input type="hidden" name="num" value="${dto.num }" />
	<label for="num">번호</label>
	<input type="text" id="num" value="${dto.num }" />
	<br />
	<label for="id">이름</label>
	<input type="text" name="id" id="id" value="${dto.id }" />
	<br />
	<label for="pwd">비번</label>
	<input type="password" name="pwd" id="pwd" value="${dto.pwd }" />
	<br />
	<button type="submit">수정 확인</button>
</form>
</body>
</html>