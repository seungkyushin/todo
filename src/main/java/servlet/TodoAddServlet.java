package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public TodoAddServlet() {
        super();
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	req.setCharacterEncoding("UTF-8");
    	
    	res.setCharacterEncoding("UTF-8");
    	res.setContentType("text/html");
    	
    	try
    	{
    		TodoDto dto = new TodoDto();
    		
    	  	String title = (String)req.getParameter("title");
        	String name = (String)req.getParameter("name");
        	System.out.println("form data : " + title);
        	System.out.println("form data : " + name);
        	int sequence = Integer.parseInt(req.getParameter("sequence"));
        	
        	
        	dto.setTitle(title);
        	dto.setEmail(name);
        	dto.setSequence(sequence);
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		dto.setRegdate(dateFormat.format(new Date()));
    		dto.setType("todo");
    		
        	TodoDao dao = new TodoDao();
           	if( dao.addTodo(dto) == TodoDao.SUCCESS )
        	{
           		res.sendRedirect("./main.jsp");
       
        		
        	}
        	else
        	{
         		res.sendRedirect("./todoForm.jsp");
         		
        	}
        	
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
  
    	
    	
    
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
