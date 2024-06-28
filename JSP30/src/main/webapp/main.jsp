<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="DTO.Member" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>메인페이지</title>
	</head>
	<body>
		<%
			Member m = (Member)session.getAttribute("loginUser");
		%>
		<h1><%=m.getPwd() %></h1>
		<h1><%=m.getEmail() %></h1>
		
		<h1>안녕하세요 ${loginUser.name },${loginUser.userid}님</h1>
	</body>
</html>