package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import DAO.MemberDAO; // 로그인 메서드, Connection연결처리, 싱글톤 구현
import DTO.Member;	  // 객체 정보를 확인할 수 있는 설계도 위치


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//a태그 또는 도메인 직접입력, Ajax get호출등의 방식에서 doGet 실행 *500000000
		System.out.println("login.doGet() 실행");
		RequestDispatcher dis= request.getRequestDispatcher("login.jsp");
		dis.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form 태그의 post submit 또는 ajax post호출등의 방식 = > doPost 실행
		String url = "login.jsp";
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		MemberDAO mDAO =MemberDAO.getInstance();// 회원이 여러개 생기는 경우 발생할 수 있는 문제 원천차단
		int result = mDAO.userCheck(userid,pwd);
		System.out.println("입력받은 아이디 "+userid);
		System.out.println("입력받은 비밀번호 "+pwd);
		System.out.println("로그인 결과 : "+result);
		if(result==1) {
			//로그인 성공
			HttpSession session = request.getSession(); // 서블릿에서 세션을 사용하려면 request를 통한다.
			Member m = mDAO.getMember(userid); 			//해당 아이디가 가지고 있는 DB 정보를 저장한 객체 생성
			session.setAttribute("loginUser", m);		//세션에 회원정보를 가진 객체를 저장
			request.setAttribute("message", "로그인에 성공하셨습니다");
			url = "main.jsp"; //로그인에 성공한사람은 main화면으로 이동
		}else if(result==0) {
			//아이디는 있는데 비밀번호 오류
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result==-1) {
			request.setAttribute("message", "존재하지 않는 회원입니다"); //회원가입 안된경우,select 결과가 empty set인경우
		}
		
		RequestDispatcher dis= request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		
	}

}
