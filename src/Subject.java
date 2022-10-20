import java.util.ArrayList;
import java.util.List;

public class Subject {
	//class fields
	private int id;
	private String subjectName;
	private int units;
	private int idCounter = 1;
	private List<Student> listStudent = new ArrayList<Student>();
	
	//constructor
	public Subject(String subjectName, int units) {
		this.id = idCounter;
		this.subjectName = subjectName;
		this.units = units;
		idCounter++;
	}
	
	//methods
	public void EnlistStudent(Student objStudent) {
		
	}
	
	public void RemoveStudent(int studentId) {
		
	}
	
	public void DisplayDetails() {
		
	}
}
