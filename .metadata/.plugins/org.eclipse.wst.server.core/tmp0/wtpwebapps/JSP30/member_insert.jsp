<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원가입 처리 페이지</title>
	</head>
	<body>
		<%	
			String sql = "insert into member(name,userid,pwd,email,phone,admin) values(?,?,?,?,?,?);";
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("nm");
			String userId = request.getParameter("userId");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String admin = request.getParameter("admin");
			Connection conn = null;
			//Statement stmt = null;
			PreparedStatement pstmt = null;
			
			
			String url = "jdbc:mysql://127.0.0.1:3306/sample";
			String db_id="root";
			String db_pw="iotiot";
			//String sql = "insert into member(name, userid , pwd , email, phone, admin) values('";
			//sql += name+"', '"+userId+"','"+pwd+"','"+email+"','"+phone+"','"+admin+"');";
			
			
			
			System.out.println(sql);
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn= DriverManager.getConnection(url,db_id,db_pw);
				pstmt = conn.prepareStatement(sql); 
				//PreparedStatement방식은 미리 쿼리문을 준비해놓고 ?로 적혀있는 부분에 데이터를 집어넣는 방식이다.
				//Statement방식과는 달리 제작할때 쿼리문이 필요하고 실행할때는 필요가 없다.
				//?안에 데이터를 잘 넣어주어야 동작하고 , 완결전까지 오류를 확인할 수 없다. ?의 번호는 1번부터 시작
				
				out.print("접속 이상 없음");
				pstmt.setString(1,name);
				pstmt.setString(2,userId);
				pstmt.setString(3,pwd);
				pstmt.setString(4,email);
				pstmt.setString(5,phone);
				pstmt.setString(6,admin);
				
				pstmt.execute();
			}catch(Exception e){
				System.out.println("member_insert.jsp ing error "+e);
			}finally{
				try{
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				}catch(Exception ex){
					System.out.println("member_insert.jsp end error "+ex);
				}
			}
		%>
	</body>
</html>