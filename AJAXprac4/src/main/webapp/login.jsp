<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>로그인창</title>
	</head>
	<body>
		<form method="post" action="login.do" name="frm">
			아이디 :<input type="text" name="id" >
			비밀번호 : <input type="text" name="pw">
			<input type="submit" value="가입" onclick="return check()">
			<input type="button" value="회원가입" onclick="goServ()">
		</form>
		
		<script>
			var frm = document.getElementById("frm");
			
			function goServ(){
				location.href="register.jsp";
			}
			function check(){
				if(document.frm.getElementsByTagName("input")[0].value==""){
					alert("아이디를 입력해주세요");
					return false;
				}
			}
		</script>
	</body>
</html>