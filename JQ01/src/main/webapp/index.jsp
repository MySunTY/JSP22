<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>제이쿼리</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	</head>
	<body>
		<p>안녕하세요</p>
		<script>
			var p = document.getElementsByTagName("p")[0];
			//p.setAttribute("style","color:red");
			console.log(p);
			var q = $("p");
			q.css("color","blue");
			q.css("backgroundColor","yellow");
			//Jquery는 css의 선택자를 이용해서 DOM을 다루는 자바스크립트의 줄임말이다.
			//$("CSS선택자");
			function event(){
				this.setAttribute("style","display:none");
			}
			//p.addEventListener("click",event);
			
			$("p").click(function(){
				$(this).hide();
			})
		</script>
	</body>
</html>