package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import DAO.MemberDAO;

@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userId");
		MemberDAO mDAO = MemberDAO.getInstance();
		int result = mDAO.confirmId(userid);
		request.setAttribute("userid",userid); //EL로 userid를 확인할 수 있는 처리
		request.setAttribute("result", result);
		RequestDispatcher dis = request.getRequestDispatcher("idcheck.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
