import java.util.ArrayList;
import java.util.List;

public class Subject { //Name9 Start
	// Class Fields
	private int id;
	private String subjectName;
	private int units;
	private static int idCounter = 6500;
	private List<Student> listStudents = new ArrayList<Student>();

	// Getters
	public int getId() {
		return id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	// Parameterized Constructor
	public Subject(String subjectName, int units) {
		this.id = idCounter;
		this.subjectName = subjectName;
		this.units = units;
		idCounter++;
	}

	// Methods
	public void AddStudent(Student objStudent) {
		this.listStudents.add(objStudent);
	}

	public void EnlistStudent(Student objStudent) throws Exception {
		for (Student student : this.listStudents) {
			if (student.getId() == objStudent.getId()) {
				throw new Exception("\nThis Student is already enlisted to this Subject");
			}
		}
		this.AddStudent(objStudent);
		objStudent.AddSubject(this);
	} //Name9 End

	public void RemoveStudent(int studentId) throws Exception { //Name10 Start
		for (int i = 0; i < this.listStudents.size(); i++) {
			if (this.listStudents.get(i).getId() == studentId) {
				this.listStudents.remove(i);
				return;
			}
		}
		throw new Exception("\nStudent ID not found on this Subject's Enlisted Students");
	}

	public void DisplaySubjectDetails() {
		System.out.println("\nSUBJECT ID : " + this.id);
		System.out.println("SUBJECT NAME : " + this.subjectName);
		System.out.println("NUMBER OF UNITS : " + this.units);
	}

	public void DisplayEnlistedStudents() {
		if (this.listStudents.size() == 0) {
			System.out.println("\nNO STUDENTS ENLISTED\n");
		} else {
			for (Student student : this.listStudents) {
				System.out.println(student.getId() + " - " + student.GetFullName());
			}
		}
	}

	public void DisplayFullDetails() {
		System.out.println("\n==================================");
		System.out.println("\nSUBJECT ID : " + this.id);
		System.out.println("SUBJECT NAME : " + this.subjectName);
		System.out.println("NUMBER OF UNITS : " + this.units);
		System.out.println("\nSTUDENTS ENLISTED");
		if (this.listStudents.size() == 0) {
			System.out.println("\nNO STUDENTS ENLISTED\n");
		} else {
			for (Student student : this.listStudents) {
				student.DisplayStudentDetails();
			}
		}
		System.out.println("==================================");
	} //Name10 End
}
