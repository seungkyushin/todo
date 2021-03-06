package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import dao.TodoDao;
import dto.TodoDto;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	res.setCharacterEncoding("UTF-8");
    	res.setContentType("text/html");
       	
    	ArrayList<TodoDto> daolist = new ArrayList<TodoDto>();
    	TodoDao dto = new TodoDao();
    	PrintWriter out = res.getWriter();
    	String email = "";
    	
    	Cookie[] cookies = req.getCookies();
		for(int i = 0 ; i<cookies.length; i++){            
		
			if( "email".equals( cookies[i].getName()) ) {
				email = cookies[i].getValue();
			}
		}
		
		
    	daolist = dto.getTodos(email);
    	        
		//< JSP에서 파싱할 수 있도록 스트링으로 변경
		//<gs.toJson(userList) 하기전에는 객체
    	Gson gs = new Gson();
   		out.println(gs.toJson(daolist));
	   	out.close();
   	
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
