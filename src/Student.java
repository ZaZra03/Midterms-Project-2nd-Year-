import java.util.ArrayList;
import java.util.List;

public class Student { //Hans Start

	// Class fields
	private int id;
	private String firstName;
	private String lastName;
	private String course;
	private static int idCounter = 1900000;
	private List<Subject> listSubjects = new ArrayList<Subject>();

	// Getters
	public int getId() {
		return this.id;
	}

	// Parameterized Constructor
	public Student(String firstName, String lastName, String course) {
		this.id = idCounter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		idCounter++;
	}

	// Methods
	public String GetFullName() {
		return this.firstName + " " + this.lastName;
	}

	public void AddSubject(Subject objSubject) {
		this.listSubjects.add(objSubject);
	}

	public void EnlistSubject(Subject objSubject) throws Exception {
		for (Subject subject : this.listSubjects) {
			if (subject.getId() == objSubject.getId()) {
				throw new Exception("\nThis Subject is already enlisted to this Student");
			}
		}
		this.AddSubject(objSubject);
		objSubject.AddStudent(this);
	} //Hans End

	public void RemoveSubject(int subjectId) throws Exception { //Jessie Start
		for (int i = 0; i < this.listSubjects.size(); i++) {
			if (this.listSubjects.get(i).getId() == subjectId) {
				this.listSubjects.remove(i);
				return;
			}
		}
		throw new Exception("\nSubject ID not found on this Student's Enlisted Subjects");
	}

	public void DisplayStudentDetails() {
		System.out.println("\nSTUDENT ID : " + this.id);
		System.out.println("FIRST NAME : " + this.firstName);
		System.out.println("LAST NAME : " + this.lastName);
		System.out.println("COURSE : " + this.course);
	}

	public void DisplayEnlistedSubjects() {
		if (this.listSubjects.size() == 0) {
			System.out.println("\nNO SUBJECT ENLISTED\n");
		} else {
			for (Subject subject : this.listSubjects) {
				System.out.println(subject.getId() + " - " + subject.getSubjectName());
			}
		}
	}

	public void DisplayFullDetails() {
		System.out.println("\n==================================");
		System.out.println("STUDENT ID : " + this.id);
		System.out.println("STUDENT NAME : " + this.GetFullName());
		System.out.println("STUDENT COURSE : " + this.course);
		System.out.println("\nSUBJECTS ENLISTED");
		if (this.listSubjects.size() == 0) {
			System.out.println("\nNO SUBJECT ENLISTED\n");
		} else {
			for (Subject subject : this.listSubjects) {
				subject.DisplaySubjectDetails();
			}
		}
		System.out.println("==================================");
	} //Jessie End
}
