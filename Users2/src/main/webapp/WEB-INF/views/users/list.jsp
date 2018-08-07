<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/list.jsp</title>
</head>
<body>
<a href="insertform.do">유저 추가 폼</a>
<h3>유저 목록입니다</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.id }</td>
				<td>${tmp.pwd }</td>
				<td><a href="updateform.do?num=${tmp.num }">수정</a></td>
				<td><a href="javascript:deleteConfirm(${tmp.num })">삭제</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script>
	function deleteConfirm(num){
		var isDelete=confirm(num+" 번 회원을 삭제할까요?");
		if(isDelete){
			location.href="delete.do?num="+num;
		}
	}
</script>
</body>
</body>
</html>