<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Jquery 효과</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	</head>
	<body>
		<p>클릭하여 페이드 처리</p>
		<h1 style="display:none">이 문장이 나타나게 합니다.</h1>
		<h2>이 문장이 사라지게 합니다.</h2>
		<h3>클릭하여 페이드 토글 처리</h3>
		<div id="first" style="width:100px; height:100px; background-color:blue;"></div>
		<div id="second" style="width:100px; height:100px; background-color:red;"></div>
		<script>
			//.hide() :지우기
			//.show() :보이기
			//.fadeIn(): 안보이던걸 서서히 보이도록
			//.fadeOut() : 보이던걸 서서히 안보이도록
			//.fadeToggle(): 안보이던건 서서히 보이게 , 보이던건 서서히 안보이게, 같은 요소에서도 반복사용가능
			// n/1000초를 적어서 동작완료까지 걸리는 시간을 조절할 수 있다. 기본값은 500
			//.fadeTo() : 특정 투명도까지 흐려지는 효과 0:완전투명, 1 완전불투명
			$("p").click(function(){
				$("h1").fadeIn(5000);	
				$("h2").fadeOut(5000,function(){
					alert("동작 완료!");
				});
			});
			$("h3").click(function(){
				$("#first").fadeToggle(3000);
				$("#second").fadeTo(3000,0.1);
			})
		</script>
	</body>
</html>