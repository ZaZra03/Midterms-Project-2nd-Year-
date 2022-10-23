import java.util.ArrayList;
import java.util.List;

public class Subject {
	// class fields
	private int id;
	private String subjectName;
	private int units;
	private static int idCounter = 1;
	private List<Student> listStudent = new ArrayList<Student>();

	public int getId() {
		return this.id;
	}
	public int getUnits() {
		return this.units;
	}
	
	public String getSubjectName() {
		return this.subjectName;
	}

	public List<Student> getListStudent() {
		return this.listStudent;
	}

	// constructor
	public Subject(String subjectName, int units) {
		this.id = idCounter;
		this.subjectName = subjectName;
		this.units = units;
		idCounter++;
	}

	// methods
	public void EnlistStudent(Student objStudent) {
		boolean isStudentEnlisted = false;
		for(int i = 0; i < listStudent.size(); i++) {
			if(listStudent.get(i) == objStudent) {
				isStudentEnlisted = true;
				break;
			}
		}
		if(isStudentEnlisted == false) this.listStudent.add(objStudent);
	}

	public void RemoveStudent(int studentId) {
		listStudent.remove(studentId);
	}

	public void DisplayDetails() {
		System.out.println("\nSUBJECT ID : " + this.id);
		System.out.println("SUBJECT NAME : " + this.subjectName);
		System.out.println("NUMBER OF UNITS : " + this.units);
	}
}
