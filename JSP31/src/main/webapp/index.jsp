<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>게시판 페이징 처리</title>
	</head>
	<body>
		<form method="get" action="ReadPage">
		<!-- currentPage : 현재 보고 있는 페이지 번호 -->
		<!-- recordsPerPage : 한페이지당 보여줄 게시글 수  -->
		<!-- limit n1, n2  -->
		<!-- 다음번 시작되는 자료번호는 n1+n2+1  -->
		<!-- P1 : 1~10 ( n1=0 , n2 =10) -->
		<!-- p2 : 11~20( n1=11 , n2 =10) -->
		<!-- p3 : 21~30( n1=21 , n2 =10 -->
			<input type="hidden" name="currentPage" value="1"> <!-- 사용자가 볼 필요는 없어서 hidden, 현재 몇페이지 보고있는지 -->
			한페이지에 보여줄 게시글 수를 골라주세요
			<select name="recordsPerPage">
				<option value="5">5개씩 보기</option>
				<option value="10">10개씩 보기</option>
				<option value="15">15개씩 보기</option>
			</select>
			<input type="submit" value="보기">
			<!-- select * from board limit 10,10; -->
		</form>
	</body>
</html>