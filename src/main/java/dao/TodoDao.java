package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.TodoDto;

public class TodoDao {
	final static String URL = "jdbc:mysql://localhost:3306/connectdb?autoReconnect=true&useSSL=false";
	final static String ID = "root";
	final static String PASSWARD = "dkagh1234.";
	public final static int SUCCESS = 1;
	public final static int FAILED = 0;
	 
	
	public int addTodo(TodoDto data) {
		int result = 0;
		String sql = "INSERT INTO todo(title,name,sequence) VALUES(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try( Connection JDBCConnection = DriverManager.getConnection(URL, ID, PASSWARD);
					PreparedStatement ps = JDBCConnection.prepareStatement(sql);
					){
				
				ps.setString(1, data.getTodoTitle());
				ps.setString(2, data.getTodoName());
				ps.setInt(3, data.getTodoSequence());
				
				result = ps.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<TodoDto> getTodos() {
		
		ArrayList<TodoDto> Listdate = new ArrayList<TodoDto>(); 
		ResultSet rs;
		String sql = "SELECT tile,name,type,regdate FROM todo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try( Connection JDBCConnection = DriverManager.getConnection(URL, ID, PASSWARD);
					PreparedStatement ps = JDBCConnection.prepareStatement(sql);
					){
						rs = ps.executeQuery();
						
						while( rs.next()) {
							
							TodoDto dto = new TodoDto();
							
							dto.setTodoTitle(rs.getString(1));
							dto.setTodoName(rs.getString(2));
							dto.setTodoType(rs.getString(3));
							dto.setTodoRegdate(rs.getString(4));
							
							Listdate.add(dto);
						}
						
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return Listdate;
		
	}
	public int updateTodo() {
		int result = 0;
		String sql = "UPDATE todo set type=? where id=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try( Connection JDBCConnection = DriverManager.getConnection(URL, ID, PASSWARD);
					PreparedStatement ps = JDBCConnection.prepareStatement(sql);
					){
								
				ps.setString(1, "test");
				ps.setInt(2, 1);
					
				result = ps.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
