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
 * @class Subject
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
 * @see Student
 * @see Main
 */

import java.util.ArrayList;
import java.util.List;

public class Subject {
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

	/**
	  * Parameterized Constructor
	  *
	  * @param Strint subjectName
	  * @param int units
	  */
	public Subject(String subjectName, int units) {
		this.id = idCounter;
		this.subjectName = subjectName;
		this.units = units;
		idCounter++;
	}

	// Methods
	/**
	 * Adds a student into the subject.
	 * It checks first if the student is already enlisted into the subject.
	 * If it does, it won't be added and a prompt will be shown.
	 *
	 * @throws Exception.
	 * @return Nothing.
	 * @param Student objStudent
	 */
	public void AddStudent(Student objStudent) {
		this.listStudents.add(objStudent);
	}
	
	/**
	* Removes a student from the subject object by looping through the listStudents 
	* and finding the match of the student id input of the user.
	* If the id of the student does not exist, a prompt will be shown.
	*
	* @param int studentId
	* @throws Exception.
	* @return Nothing.
	*/
	public void RemoveStudent(int studentId) throws Exception {
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
	
	/**
	  * Displays the enlisted Students into the Subject object by looping 
	  * through the listStudent list. A prompt will be shown if there are 
	  * no students enlisted yet into the Subject object.
	  * 
	  * @return Nothing.
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
	
	/**
	  * Displays the full details of the Student object.
	  * Including the students enlisted into the Student object, if there are some.
	  * If there are not students enlisted, a prompt will be shown.
	  * 
	  * @return Nothing.
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
	}
}
