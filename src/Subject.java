import java.util.ArrayList;
import java.util.List;

public class Subject { //Autos
	// Class Fields
	private int id;
	private String subjectName;
	private int units;
	private static int idCounter = 6500;
	private List<Student> listStudents = new ArrayList<Student>();

	// Getters
	public int getId() {
		return this.id;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	/*
	*Parameterized Constructor
	*
	*@param Strint subjectName, int units
	*/
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
	/*
	*Adds a student into the subject.
	*It checks first if the student is already enlisted into the subject.
	*If it does, it won't be added and a prompt will be shown.
	*
	*@throws Exception.
	*@return Nothing.
	*@param Student objStudent
	*/
	public void EnlistStudent(Student objStudent) throws Exception {
		for (Student student : this.listStudents) {
			if (student.getId() == objStudent.getId()) {
				throw new Exception("\nThis Student is already enlisted to this Subject");
			}
		}
		this.AddStudent(objStudent);
		objStudent.AddSubject(this);
	} //Autos End
	/*
	*Removes a student from the subject object by looping through the listStudents 
	*and finding the match of the student id input of the user.
	*If the id of the student does not exist, a prompt will be shown.
	*
	*@throws Exception.
	*@return Nothing.
	@param int studentId
	*/
	public void RemoveStudent(int studentId) throws Exception { //Sean Start
		for (int i = 0; i < this.listStudents.size(); i++) {
			if (this.listStudents.get(i).getId() == studentId) {
				this.listStudents.remove(i);
				return;
			}
		}
		throw new Exception("\nStudent ID not found on this Subject's Enlisted Students");
	}
	//Displays the information of the Subject object
	public void DisplaySubjectDetails() {
		System.out.println("\nSUBJECT ID : " + this.id);
		System.out.println("SUBJECT NAME : " + this.subjectName);
		System.out.println("NUMBER OF UNITS : " + this.units);
	}
	/*
	*Displays the enlisted Students into the Subject object by looping through the listStudent list.
	*A promt will be shown if there are no students enlisted yet into the Subject object.
	*/
	public void DisplayEnlistedStudents() {
		if (this.listStudents.size() == 0) {
			System.out.println("\nNO STUDENTS ENLISTED\n");
		} else {
			for (Student student : this.listStudents) {
				System.out.println(student.getId() + " - " + student.GetFullName());
			}
		}
	}
	/*
	*Displays the full details of the Student object.
	*Including the students enlisted into the Student object, if there are some.
	*If there are not students enlisted, a prompt will be shown.
	*/
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
	} //Sean End
}
