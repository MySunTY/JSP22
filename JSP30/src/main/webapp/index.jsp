<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>여기는 메인 페이지</title>
	</head>
	<body>
		<h1>여기는 메인 페이지입니다.</h1>
		<a href="login.do">로그인 처리</a>
		<a href="list.do">전체 멤버 조회</a><br>
		<a href="join.do">회원 가입</a>
		<!-- 
			서블릿의 호출기준 * 500000000000
			doGet() : a태그 클릭, 폼태그(get방식) , 브라우저 도메인 직접 입력, ajax  send(null)
			doPost() : form태그의 method =post, ajax send(data)
		 -->
		
		
		
	</body>
</html>