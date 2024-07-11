package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import DAO.BoardDAO;
import DTO.BoardDTO;
import java.util.*;



@WebServlet("/show.do")
public class showServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO bDAO = BoardDAO.getInstance();
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("recordsPerPage", recordsPerPage);
		List<BoardDTO> list = bDAO.getList(currentPage,recordsPerPage);
		request.setAttribute("list", list);
		int npage = bDAO.getPage();
		request.setAttribute("npage",npage);
		
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
