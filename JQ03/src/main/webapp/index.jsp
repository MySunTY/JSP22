<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Jquery 특수 선택자 사용</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	</head>
	<body>
		<form>
			<h1>회원가입</h1>
			<hr>
			<h2>뉴스레터 정보</h2>
			<span class="tag">이름 : </span><input type="text"><br>
			<span class="tag">이메일 : </span><input type="text"><br>
			<span class="tag">비밀번호 : </span><input type="password"><br>
			<span class="tag">성별 :  </span>
			<input type="radio" name="check">남성
			<input type="radio" name="check">여성
			<input type="radio" name="check">기타
			<hr>
			<h2>뉴스 카테고리</h2>
			<span class="tag">경제</span><input type="checkbox" name="checkbox-1" checked>
			<span class="tag">사회</span><input type="checkbox" name="checkbox-2">
			<span class="tag">문화</span><input type="checkbox" name="checkbox-3">
			<input type="reset" value="초기화" name="btn-1">
			<input type="button" value="버튼" name="btn-2">
			<input type="submit" value="제출" name="btn-3">
			
			
		</form>
		<script>
			$("form").attr("style","border:1px solid black; background-color:azure;");
			$(".tag").attr("style","display:inline-block; width:80px;");
			$(":header").attr("style","color:red");
			$(":header:not(h1)").attr("style","color:blue;");
			//자바스크립트를 통한 스타일의 변경은 CSS의 우선권과 달리 가장 마지막에 입력된 스타일이 최우선이다
			$("input:password").attr("style","background-color:black; color:white");
			$("input:checked").attr("style","width:20px; height:20px");
			//자바스크립트를 통한 스타일의 변경은 스크립트의 실행 시점기준이므로 매 변경마다 실행 시점을 특정해줘야 한다.
			$("input[name^=b]").attr("style","background-color:red;"); //name이 b로시작하는
			$("input[name$=3]").attr("style","background-color:black; color:white");//name이 3으로 끝나는
		</script>
	</body>
</html>