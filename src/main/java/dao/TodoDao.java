package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.TodoDto;

public class TodoDao {
	final static String URL = "jdbc:mysql://localhost:3306/todo_db?useUnicode=true&characterEncoding=utf8";
	final static String ID = "root";
	final static String PASSWARD = "dkagh1234.";
	public final static int SUCCESS = 1;
	public final static int FAILED = 0;
	 
	
	public int addTodo(TodoDto data) {
		int result = 0;
		String sql = "INSERT INTO todo(title,email,sequence,regdate,type) VALUES(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try( Connection JDBCConnection = DriverManager.getConnection(URL, ID, PASSWARD);
					PreparedStatement ps = JDBCConnection.prepareStatement(sql);
					){
				
				ps.setString(1, data.getTitle());
				ps.setString(2, data.getEmail());
				ps.setInt(3, data.getSequence());
				ps.setString(4, data.getRegdate());
				ps.setString(5, data.getType());
				
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
	public ArrayList<TodoDto> getTodos(String email) {
		
		ArrayList<TodoDto> Listdate = new ArrayList<TodoDto>(); 
		ResultSet rs;
		String sql = "SELECT id,title,email,sequence,type,regdate FROM todo WHERE email=? ORDER BY regdate desc";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try{
				Connection JDBCConnection = DriverManager.getConnection(URL, ID, PASSWARD);
				PreparedStatement ps = JDBCConnection.prepareStatement(sql);
				ps.setString(1, email);
				
						rs = ps.executeQuery();
						
						while( rs.next()) {
							
							TodoDto dto = new TodoDto();
							
							dto.setId(rs.getInt(1));
							dto.setTitle(rs.getString(2));
							dto.setEmail(rs.getString(3));
							dto.setSequence(rs.getInt(4));
							dto.setType(rs.getString(5));
							dto.setRegdate(rs.getString(6));
							
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
	public int updateTodo(String type, int id) {
		int result = 0;
		String sql = "UPDATE todo set type=? where id=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try( Connection JDBCConnection = DriverManager.getConnection(URL, ID, PASSWARD);
					PreparedStatement ps = JDBCConnection.prepareStatement(sql);
					){
								
				ps.setString(1, type);
				ps.setInt(2, id);
					
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
