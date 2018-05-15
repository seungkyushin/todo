package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;

/**
 * Servlet implementation class TodoTypeServlet
 */
@WebServlet("/todotype")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     	res.setCharacterEncoding("UTF-8");
    	res.setContentType("text/html");


    	TodoDao dao = new TodoDao();
    	int id = Integer.parseInt(req.getParameter("id"));
    	String type = req.getParameter("type");
    	
    	if( type.equals("TODO"))
    	{
    		dao.updateTodo("DOING",id);
    	}
    	else if( type.equals("DOING"))
    	{
    		dao.updateTodo("DONE",id);
    	}
    	
    	RequestDispatcher rd = req.getRequestDispatcher("/main");
		rd.forward(req, res);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

}
