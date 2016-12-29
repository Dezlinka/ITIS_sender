package sms;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static java.lang.System.out;

/**
 * Created by Danil on 28.12.2016.
 */
public class senderServlet extends HttpServlet {

    private static final long serialVersionUID = 102831973239L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        smsSender sd= new smsSender("Danil", "itis507", "utf-8", true);//
        sd.sendSms(request.getParameter("phone"),request.getParameter("message"), 1, "", "", 0, "", "");


        RequestDispatcher view = request.getRequestDispatcher("/sended.jsp");
        view.forward(request, response);

    }
}
