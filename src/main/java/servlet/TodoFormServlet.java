package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoFormServlet
 */
@WebServlet("/todoform")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TodoFormServlet() {
        super();
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
    	res.setCharacterEncoding("UTF-8");
    	res.setContentType("text/html");
    	
    	System.out.println("/todoform");

    	//res.sendRedirect("/Todo/todoForm.jsp");
    	RequestDispatcher rd = req.getRequestDispatcher("/todoForm.jsp");
		rd.forward(req, res);
 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request,response);
	}

}
