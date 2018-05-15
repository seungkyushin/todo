package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

/**
 * Servlet implementation class TodoAddServlet
 */
@WebServlet("/todoadd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	res.setCharacterEncoding("UTF-8");
    	res.setContentType("text/html");
    	
    	try
    	{
    		TodoDto dto = new TodoDto();
    		
    	  	String title = (String)req.getParameter("title");
        	String name = (String)req.getParameter("name");
        	int sequence = Integer.parseInt(req.getParameter("sequence"));
        	
        	
        	dto.setTodoTitle(title);
        	dto.setTodoName(name);
        	dto.setTodoSequence(sequence);
        	
        	TodoDao dao = new TodoDao();
           	if( dao.addTodo(dto) == TodoDao.SUCCESS )
        	{
        		req.setAttribute("result", TodoDao.SUCCESS);
        		RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
        		rd.forward(req, res);
        		
        	}
        	else
        	{
        		req.setAttribute("result", TodoDao.FAILED);
        		RequestDispatcher rd = req.getRequestDispatcher("/todoForm.jsp");
        		rd.forward(req, res);
        		
        	}
        	
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
  
    	
    	
    
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
