<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax/upload_form.jsp</title>
</head>
<style>
img{
	width: 200px;
}
#profileImg{
	width: 100px;
	heigth: 100px;
	background-color: yellow;
	cursor: pointer;
	border-radius: 100%;
}

#fileForm4{
	display: none;
}
</style>
<body>
<h3>ajax 파일 업로드 예제</h3>
<form action="upload.do" method="post" enctype="multipart/form-data" id="fileForm">
	<label for="file">파일 첨부</label>
	<input type="file" name="file" id="file" />
	<button type="submit">업로드</button>	
</form>

<h3>ajax 파일 업로드 예제2</h3>
<form action="upload2.do" method="post" enctype="multipart/form-data" id="fileForm2">
	<label for="file">파일 첨부</label>
	<input type="file" name="file" id="file" />
	<button type="submit">업로드</button>	
</form>

<h3>ajax 파일 업로드 예제3</h3>
<!-- 파일을 선택을 하면 자동으로 업로드 되도록 하는 예제. 버튼 없이 -->
<form action="upload2.do" method="post" enctype="multipart/form-data" id="fileForm3">
	<label for="file">파일 첨부</label>
	<input type="file" name="file" id="file" />
</form>

<div id="result">
	
</div>

<h3>ajax 파일 업로드 예제4</h3>
<form action="upload2.do" method="post" enctype="multipart/form-data" id="fileForm4">
	<label for="file">파일 첨부</label>
	<input type="file" name="file" id="file" />
</form>
<img src="${pageContext.request.contextPath}/resources/images/kim1.png" id="profileImg"/> <!-- 기본 프로필 이미지로 가정. -->


<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.min.js"></script>
<!-- ajax 폼 만들때, 코딩을 줄여주는 제이쿼리 플러그인. -->
<script>
	//form 플러그인 동작 시키기
	$("#fileForm").ajaxForm(function(responseData){
		console.log(responseData);
	});
	
	$("#fileForm2").ajaxForm(function(responseData){
		//저장된 파일명을 얻어온다
		var fileName = responseData.fileName;
		//이미지 경로
		var imagePath = "${pageContext.request.contextPath}/upload/"+fileName;
		//이미지 요소를 만들어서 div에 추가
		$("<img/>").attr("src", imagePath).appendTo("#result");
	});
	
	$("#fileForm3").ajaxForm(function(responseData){
		//저장된 파일명을 얻어온다
		var fileName = responseData.fileName;
		//이미지 경로
		var imagePath = "${pageContext.request.contextPath}/upload/"+fileName;
		//이미지 요소를 만들어서 div에 추가
		$("<img/>").attr("src", imagePath).appendTo("#result");
		//파일 input 리셋
		$("#fileForm3 input[type=file]")
		.attr("type","")
		.attr("type","file");
	});
	
	//파일을 선택했을 때 실행할 함수 등록, 인풋이란 이벤트가 일어났을 때 처리
	$("#fileForm3 input[type=file]").on("input", function(){
		$("#fileForm3").submit();
	});
	
	$("#fileForm4").ajaxForm(function(responseData){
		//저장된 파일명을 얻어온다
		var fileName = responseData.fileName;
		//이미지 경로
		var imagePath = "${pageContext.request.contextPath}/upload/"+fileName;
		//아래서 클릭해서 폼이 전송 되면 여기에 붙이기
		$("#profileImg").attr("src", imagePath);
	});
	
	$("#profileImg").click(function(){
	      //폼 안에 있는 input[type=file] 을 강제 클릭 시킨다. 
	      $("#fileForm4 input[type=file]").click();
	   });
	   
	   // 파일을 선택했을때 실행할 함수 등록 
	   $("#fileForm4 input[type=file]").on("input", function(){
	      $("#fileForm4").submit();
	   });
</script>

</body>
</html>