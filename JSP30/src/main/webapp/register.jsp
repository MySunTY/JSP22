<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원가입 페이지</title>
	</head>
	<body>
		<h1>여기는 회원가입 페이지 입니다.</h1>
		<form method="post" action="join.do" name="frm">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="nm"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="userId">
						<input type="hidden" name="reId">
						<input type="button" value="중복확인" onclick="idCheck()">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="password" name="pwd_check"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>등급</td>
					<td>
						<input type="radio" name="admin" value="1">관리자<br>
						<input type="radio" name="admin" value="0" checked>일반회원
					</td>
				</tr>
				<tr>
					<td>입력</td>
						<td>
							<input type="submit" value="회원가입">
							<input type="reset" value="초기화">
						</td>
				</tr>
				
			</table>
		</form>
		
		<script>
			function idCheck(){
				if(document.frm.userId.value==""){
					alert("아이디를 입력하셔야 중복 확인이 가능합니다");
					document.frm.userId.focus();
				}
				var url = "idCheck.do?userId="+document.frm.userId.value;
				var popupX=(window.screen.width/2) - (450/2);  //기준좌표에서 x 방향으로 화면이 등장하는 위치
				var popupY=(window.screen.height/2)-(200/2);  //기준좌표에서 Y 방향으로 화면이 등장하는 위치
				
				window.open(url,"_blank_1","toolbar=no,width=450 , height=200, left="+popupX+", top ="+popupY);
			}
		</script>
	</body>
</html>