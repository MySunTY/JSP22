package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//a태그 또는 도메인 직접입력, Ajax get호출등의 방식에서 doGet 실행
		System.out.println("login.doGet() 실행");
		RequestDispatcher dis= request.getRequestDispatcher("login.jsp");
		dis.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form 태그의 post submit 또는 ajax post호출등의 방식 = > doPost 실행
		System.out.println("doPost실행");
	}

}
