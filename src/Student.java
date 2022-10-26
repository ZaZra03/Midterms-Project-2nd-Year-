/**
 * <h1>Midterm Project OOP</h1>
 * This program implements a Class Association, mainly Aggregation, 
 * because Student and Subject classes are associated with each other 
 * and one can exist without the other independently. The multiplicity
 * of this program is zero-to-many. This is a menu-driven program that
 * performs the relationship between the Student and Subject, the program
 * can create a student and subject object, it can enlist a subject to a
 * student, it can remove a subject from a student, display the details of
 * student/s, and display all student details enlisted in a selected subject.
 * 
 *
 * @class Student
 * 
 * @author Alimagno, Rio Myca P.
 * @author Asan, Jayvee L.
 * @author Autos, Eugene Lawrence H.
 * @author Banagan, Mark Christian L.
 * @author Castillo, Sean Wilson P.
 * @author Cereno, Jessie T.
 * @author Dimaunahan, John Jomar G.
 * @author Elomina, Marc Ryzon S.
 * @author Emnacin, Hans Neil L.
 * @author Malsi, Ezra Micah
 * @see Main
 * @see Subject
 */
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

	/*
	* Parameterized Constructor
	*
	* @param String firstName This is the first parameter
	* @param String lastName This is the second parameter
	* @param String course This is the last parameter
	*/
	public Student(String firstName, String lastName, String course) {
		this.id = idCounter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		idCounter++;
	}

	// Methods
	//Return a string containing the full name of the Student object
	public String GetFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	//Adds the subject into the listSubject list of the student.
	public void AddSubject(Subject objSubject) {
		this.listSubjects.add(objSubject);
	}
	
	/*
	* Adds a subject to the student.
	* It checks first if the subject is already enlisted into the student.
	* If it does, the subject wont be enlisted into the student.
	*
	* @param Subject objStudent.
	* @throws Exception.
	* @return Nothing.
	*/
	public void EnlistSubject(Subject objSubject) throws Exception {
		for (Subject subject : this.listSubjects) {
			if (subject.getId() == objSubject.getId()) {
				throw new Exception("\nThis Subject is already enlisted to this Student");
			}
		}
		this.AddSubject(objSubject);
		objSubject.AddStudent(this);
	} //Hans End
	/*
	* Loops through the listSubjects of the student object to find and remove the selected subject by matching the subjectId.
	* If it is not found, a prompt will be shown.
	*
	* @param int subjectId
	* @throws Exception.
	* @return Nothing.
	*/
	public void RemoveSubject(int subjectId) throws Exception { //Jessie Start
		for (int i = 0; i < this.listSubjects.size(); i++) {
			if (this.listSubjects.get(i).getId() == subjectId) {
				this.listSubjects.remove(i);
				return;
			}
		}
		throw new Exception("\nSubject ID not found on this Student's Enlisted Subjects");
	}
	/*
	* Displays the details of the student.
	*
	* @return Nothing.
	*/
	public void DisplayStudentDetails() {
		System.out.println("\nSTUDENT ID : " + this.id);
		System.out.println("FIRST NAME : " + this.firstName);
		System.out.println("LAST NAME : " + this.lastName);
		System.out.println("COURSE : " + this.course);
	}
	/*
	* Displays the enslited subjects of the Student object.
	* If the listSubjects is not empty, the enlisted subjects of the student object will be shown.
	*
	* @return Nothing.
	*/
	public void DisplayEnlistedSubjects() {
		if (this.listSubjects.size() == 0) {
			System.out.println("\nNO SUBJECT ENLISTED\n");
		} else {
			for (Subject subject : this.listSubjects) {
				System.out.println(subject.getId() + " - " + subject.getSubjectName());
			}
		}
	}
	/*
	* Displays the full details of the student including all of the enlisted subjects.
	* If the student has no subjects enlisted, a prompt will instead be shown.
	*
	* @return Nothing.
	*/
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
