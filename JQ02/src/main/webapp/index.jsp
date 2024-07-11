<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>JQuery 기초 문법</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	</head>
	<body>
		<h1>h1입니다</h1>
		<h1>두번째 h1입니다</h1>
		<h2>h2입니다. id가 없습니다</h2>
		<h2 id="hid">h2입니다. id는 hid입니다</h2>
		<h3 class="hclass">h3입니다. class는 hclass입니다</h3>
		<h4>h4입니다 <span>class가없습니다</span></h4>
		<h5 class="hclass">h5입니다. class는 hclass입니다</h5>
		<h6>h6입니다. id도 class도 없습니다.</h6>
		<script>
			//document.getElementsByTagName("h1")[0].setAttribute("style","display:none");
			//document.getElementsByTagName("h1")[0].style.display="none";
			$("h1").hide();
			$("#hid").hide();
			$(".hclass").hide();
			$("h6").css("font-size","30px");
			$("h6").attr("style","color:red; font-size:30px");
			$("h4 span").css("color","red");
		</script>
	</body>
</html>