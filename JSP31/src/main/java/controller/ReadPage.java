package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.*; //리스트 불러오기
import DTO.BoardDTO;
import DAO.BoardDAO;


@WebServlet("/ReadPage")
public class ReadPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
		
		BoardDAO bDAO = BoardDAO.getInstance();
		List<BoardDTO> list = bDAO.findList(currentPage,recordsPerPage);
		request.setAttribute("data", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("recordsPerPage", recordsPerPage);
		
		int count = bDAO.getCount();
		
		request.setAttribute("count", count); //전체 게시물수
		
		int npage = count/recordsPerPage;
		if(count%recordsPerPage>0) { 			//만약 나머지가 존재한다면 페이지수 추가
			npage++;
		}
		request.setAttribute("npage",npage); //해당페이지수를 request scope에 전달
		
		
		RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
