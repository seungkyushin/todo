package dto;

public class TodoDto {

	long todoId;
	String todoTitle;
	String todoName;
	int todoSequence; 
	String todoType;
	String todoRegdate;
	
	public long getTodoId() {
		return todoId;
	}
	public void setTodoId(long todoId) {
		this.todoId = todoId;
	}
	public String getTodoTitle() {
		return todoTitle;
	}
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	public String getTodoName() {
		return todoName;
	}
	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	public int getTodoSequence() {
		return todoSequence;
	}
	public void setTodoSequence(int todoSequence) {
		this.todoSequence = todoSequence;
	}
	public String getTodoType() {
		return todoType;
	}
	public void setTodoType(String todoType) {
		this.todoType = todoType;
	}
	public String getTodoRegdate() {
		return todoRegdate;
	}
	public void setTodoRegdate(String todoRegdate) {
		this.todoRegdate = todoRegdate;
	}
	
	@Override
	public String toString() {
		return "TodoDto [todoId=" + todoId + ", todoTitle=" + todoTitle + ", todoName=" + todoName + ", todoSequence="
				+ todoSequence + ", todoType=" + todoType + ", todoRegdate=" + todoRegdate + "]";
	}
	
}
