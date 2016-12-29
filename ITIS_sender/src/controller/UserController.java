package controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 102831973239L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    
    private UserDao dao;

    public UserController() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward="";
        String action = request.getParameter("action");

       if (action.equalsIgnoreCase("insert")){
    	   forward = INSERT_OR_EDIT;
        }  

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("email"));
        user.setHeight(request.getParameter("height"));
        user.setWeight(request.getParameter("weight"));
        user.setCategory(request.getParameter("category"));
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
//        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
//        request.setAttribute("users", dao.getAllUsers());
//        view.forward(request, response);
       String forward = "/studentCreated.jsp";
       RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}