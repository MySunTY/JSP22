package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import DAO.MemberDAO;
import DTO.Member;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		MemberDAO mDAO = MemberDAO.getInstance();
		Member m = mDAO.getMember(userid); //데이터베이스에서 검색된 7개의 데이터를 담은 객체
		request.setAttribute("mem",m); //리퀘스트동안 데이터가 목적지까지 살아있음
		
		
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("update.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userId");
		String name = request.getParameter("nm");
		String pwd = request.getParameter("pwd");
		String email= request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		Member m = new Member();
		m.setName(name);
		m.setPwd(pwd);
		m.setUserid(userid);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAdmin(admin);
		
		MemberDAO mDAO = MemberDAO.getInstance();
		mDAO.updateMember(m);
		response.sendRedirect("login.do");
		
	}

}
