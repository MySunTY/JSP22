<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>연습</title>
	</head>
	<body>
		<form method="get" action="show" name="frm">
			<input type="hidden" name="currentPage" value="1">
			<select name="recordsPerPage">
				<option value="5">5개씩보기</option>
				<option value="10">10개씩보기</option>
				<option value="15">15개씩보기</option>
				
			</select>
			<input type="submit" value="보기">
		
		</form>
	</body>
</html>