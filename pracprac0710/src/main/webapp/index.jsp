<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>게시판</title>
	</head>
	<body>
		<h1>게시글보기</h1>
		<form method="get" action="show.do" name="frm">
			<input type="text" value="1" name="currentPage">
			<select name="recordsPerPage">
				<option value="5">5개씩 보기</option>
				<option value="10">10개씩 보기</option>
				<option value="15">15개씩 보기</option>
			</select>
			<input type="submit" value="보기">
		</form>
	</body>
</html>