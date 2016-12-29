package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;


public class ShowAllUsers extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	private static String LIST_USER = "/private/listUser.jsp";
	
	private UserDao dao;

    public ShowAllUsers() {
        super();
        dao = new UserDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("Show")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } 

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		 request.setAttribute("users", dao.getAllUsers());
	     view.forward(request, response);        
		
	}
}
