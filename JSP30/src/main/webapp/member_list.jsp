<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>전체 회원 조회</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<%
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String url = "jdbc:mysql://127.0.0.1:3306/sample";
			String db_id = "root";
			String db_pw = "iotiot";
			String sql="select * from member;";
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,db_id,db_pw);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				System.out.println(sql);
				
				out.print("<table>");
				out.print("<tr>");
				out.print("<th>회원번호</th>");
				out.print("<th>이름</th>");
				out.print("<th>아이디</th>");
				out.print("<th>비밀번호</th>");
				out.print("<th>이메일</th>");
				out.print("<th>연락처</th>");
				out.print("<th>관리자여부</th>");
				out.print("</tr>");
				
				while(rs.next()){
					
					
					
					out.print("<tr>");
					out.print("<td class='num'>"+rs.getString("num")+"</td>");
					out.print("<td>"+rs.getString("name")+"</td>");
					out.print("<td>"+rs.getString("userid")+"</td>");
					out.print("<td>"+rs.getString("pwd")+"</td>");
					out.print("<td>"+rs.getString("email")+"</td>");
					out.print("<td>"+rs.getString("phone")+"</td>");
					out.print("<td>"+rs.getString("admin")+"</td>");
					
					out.print("</tr>");
					
					
					
				}
				
				
				out.print("</table>");
				
			}catch(Exception e){
				System.out.println("member_list.jsp 접속중 오류 : "+e);
			}finally{
				try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					if(conn!=null)conn.close();
					
				}catch(Exception ex){
					System.out.println("member_list.jsp 접속 해제중 오류 "+ex);
				}
			}
		%>
	</body>
</html>