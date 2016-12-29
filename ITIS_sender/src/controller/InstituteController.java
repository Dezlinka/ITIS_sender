package controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;




public class InstituteController extends HttpServlet {

	final static Logger logger = Logger.getLogger(InstituteController.class);
    private static final long serialVersionUID = 102831973239L;
    private static String INSERT_OR_EDIT = "/private/student.jsp";
    private static String LIST_USER = "/private/listUser.jsp";
    private UserDao dao;
   
    
    public InstituteController() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
        forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);       	
        	
        	
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }
        if (action.equalsIgnoreCase("Show")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
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
        user.setArms(request.getParameter("arms"));
        user.setRating(request.getParameter("height"), request.getParameter("weight"));
        String userid = request.getParameter("userid");        
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
            System.out.println("");
            
        }
        else
        {       	
        	
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
            logger.info("User number : "+ userid +" updated");    
            
                                                   
        }
        
      RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
      
       request.setAttribute("users", dao.getAllUsers());
       view.forward(request, response);
      
    }
}
