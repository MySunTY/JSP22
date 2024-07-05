package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.*;
import DTO.BoardDTO;
import DAO.BoardDAO;


@WebServlet("/show")
public class showServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("show doget");
		String currentPage = request.getParameter("currentPage");
		String recordsPerPage = request.getParameter("recordsPerPage");
		
		BoardDAO bDAO = BoardDAO.getInstance();
		List<BoardDTO> list = bDAO.findList();
		request.setAttribute("data", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("recordsPerPage", recordsPerPage);
		
		RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
