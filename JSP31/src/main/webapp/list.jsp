<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>게시글 리스트</title>
		<style>
			th , td{
				border : 1px solid gray;
			}
		</style>
	</head>
	<body>
		<h1>
			currentPage : ${currentPage }<br>
			recordsPerPage : ${recordsPerPage }<br>
		</h1>
		<table>
			<tr>
				<th>게시글 번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
			<c:forEach var="data" items="${data }">
				<tr>
					<td>${data.num }</td>
					<td>${data.title }</td>
					<td>${data.content }</td>
					
				</tr>
			</c:forEach>
			<td>데이터 총 갯수 : ${count }</td>
			<td>총 페이지 수 : ${npage }</td>
		</table>
		<c:if test="${currentPage != 1 }">
			[<a href="ReadPage?currentPage=${currentPage-1 }&recordsPerPage=${recordsPerPage}">이전페이지</a>]
		</c:if>
		<c:forEach begin="1" end="${npage }" var="i">
			<c:choose>
				<c:when test="${currentPage eq i }">
					<b><a>[${i }]</a></b>
				</c:when>
				<c:otherwise>
					<a href="ReadPage?currentPage=${i }&recordsPerPage=${recordsPerPage}">[${i }]</a>		
				</c:otherwise>
			</c:choose>
			
		</c:forEach>
		<c:if test="${currentPage != npage}">
			[<a href="ReadPage?currentPage=${currentPage+1 }&recordsPerPage=${recordsPerPage}">다음페이지</a>]
		</c:if>
	</body>
</html>