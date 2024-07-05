package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import DTO.Member;		//데이터를 담을 객체의 설계도
import DAO.MemberDAO;   //데이터를 전송할 회선과 방식의 설계도


@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
		dis.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력받은 패러미터를 담아와서 sql문을 만들고 데이터베이스에 전송하는 기능
		
		//register.jsp에서 form태그를 통해 전송한 데이터를 받아 변수에 저장하는 부분
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("nm");
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		
		Member m = new Member();
		m.setName(name);
		m.setUserid(userId);
		m.setPwd(pwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAdmin(admin);
		//데이터베이스에 해당 내용 전달
		MemberDAO mDAO = MemberDAO.getInstance();
		int result = mDAO.insertMember(m); //result : -1은 실패, 1은 성공
		//입력처리 이후 서비스 제작
		HttpSession session = request.getSession();
		if(result==1) {//회원가입 성공
			session.setAttribute("userid", m.getUserid()); //바로 로그인이 되는 경우 이 기능 사용
			request.setAttribute("message", "회원가입에 성공하셨습니다.");
		}else if(result==-1) { //회원가입 실패
			request.setAttribute("message" , "회원가입에 실패하셨습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("login.do");
		dis.forward(request, response);
		
	}//dopost

}
