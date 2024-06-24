/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.89
 * Generated at: 2024-06-20 07:10:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class member_005finsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"utf-8\">\r\n");
      out.write("		<title>회원가입 처리 페이지</title>\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("		");
	
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
		
      out.write("\r\n");
      out.write("	</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
