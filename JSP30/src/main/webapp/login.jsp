<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>로그인 페이지</title>
	</head>
	<body>
		<h1>여기는 로그인 페이지 입니다.</h1>
		<form method="post" action="login.do" name="frm">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="로그인" onclick="return check()">
						<input type="reset" value="취소">
						<input type="button" value="회원가입" onclick="reg()">
					</td>
				</tr>
			</table>
		</form>
		<script>
			function reg(){
				location.href="register.jsp";
			}
			//form 유효성검사
			function check(){
				if(document.frm.userId.value.length==0){
					alert("아이디를 입력하셔야 합니다.");
					document.frm.userId.focus(); // 해등 input을 포커싱하도록
					return false; //submit이 안되게 함
				}
				if(document.frm.pwd.value==""){
					alert("비밀번호를 입력하셔야 합니다.");
					document.frm.pwd.focus();
					return false;
				}
				return true;
				
			}
		</script>
	</body>
</html>