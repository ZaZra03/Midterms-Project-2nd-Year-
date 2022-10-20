import java.util.ArrayList;
import java.util.List;

public class Subject {
	//class fields
	private int id;
	private String subjectName;
	private int units;
	private int idCounter = 1;
	
	List<Student> listStudent = new ArrayList<Student>();
	
	//constructor
	public Subject(String subjectName, int units) {
		this.subjectName = subjectName;
		this.units = units;
	}
	
	//methods
	public void EnlistStudent(Student objStudent) {
		
	}
	
	public void RemoveStudent(int studentId) {
		
	}
	
	public void DisplayDetails() {
		
	}
}
