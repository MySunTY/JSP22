package controller;



import java.io.*;

import javax.servlet.*;

import javax.servlet.annotation.*;

import javax.servlet.http.*;

import java.text.*; // 자바 문자 서식에 관련된 내용들이 들어있는경로



@WebServlet("/VServlet")

public class VServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

   

    

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); //받아오는데이터 깨짐 방지

		response.setCharacterEncoding("utf-8"); // 보내는 데이터 깨짐방지

		response.setContentType("text/xml; charset='utf-8'"); // 브라우저가 새로 받아온 데이터의 정체를 확인하기 위한 정보

		String param= request.getParameter("birthDate");

		boolean passed= Vali(param);

		String msg="잘못된 정보를 입력하셨습니다";

		if(passed) {

			msg="올바른 정보를 입력하셨습니다";

		}

		PrintWriter out = response.getWriter();

		out.println("<response>");

		out.println("다음 데이터 확보 : "+param);

		out.println("<passed>"+Boolean.toString(passed)+"</passed>"); //불리언을 문자로 변경해서 xml로가공

		out.println("<message>"+msg+"</message>");

		

		out.println("</response>");

		out.close();  							//사용이 끝난 객체는 닫아서 회선문제방지

		System.out.println("get방식 동작확인" + param);

		

		

		

	}

	static boolean Vali(String date) {   //들어온 데이터가 날짜 서식에 맞는지 확인 , format이용해서 변환이 가능한지 여부

		boolean result = false;

		if(date!=null) {//input에 뭐라도 적고 통신을 건 경우

			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

			try {

				format.parse(date);

				result=true;

			}catch(Exception e) {

				System.out.println("포멧변환중 오류발생"+e);

				result=false;

			}

		}else { // 아무것도 안적고 통신을 건 경우

			result =false;

		}

		

		

		

		return result;

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		

	}



}