<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>리스트</title>
	</head>
	<body>
		<h1>게시판 보여주기</h1>
		<c:forEach var="i" items="${list }">
			<h3>${i.num } , ${i.title }, ${i.content }</h3>
		</c:forEach>
		
		<c:if test="${currentPage != 1 }">
			[<a>이전페이지</a>]
		</c:if>
		<c:choose>
			<c:when test="${npage%recordsPerPage eq 0 }">
				<c:forEach begin="1" end="${npage/recordsPerPage}" var="i">
					<c:choose>
						<c:when test="${currentPage == i }">
							<b>[<a>${i }</a>]</b>
						</c:when>
						<c:otherwise>
							[<a href="show.do?currentPage=${i }&recordsPerPage=${recordsPerPage}">${i }</a>]
						</c:otherwise>
						
					</c:choose>
					
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach begin="1" end="${npage/recordsPerPage+1 }" var="i">
					<c:choose>
						<c:when test="${currentPage == i }">
							<b>[<a>${i }</a>]</b>
						</c:when>
						<c:otherwise>
							[<a href="show.do?currentPage=${i }&recordsPerPage=${recordsPerPage}">${i }</a>]
						</c:otherwise>
						
					</c:choose>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<c:if test="${currentPage != (npage/recordsPerPage) }">
			[<a>다음페이지</a>]
		</c:if>
		
		
		
	</body>
</html>