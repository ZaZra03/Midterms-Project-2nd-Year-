import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static List<Student> listStudents = new ArrayList<Student>();
	static List<Subject> listSubjects = new ArrayList<Subject>();

	public static void main(String[] args) {
		while (true) {
			try {
				System.out.println("Welcome. Please select an operation...");
				System.out.println("1. Create new Student Record");
				System.out.println("2. Create new Subject Record");
				System.out.println("3. Enlist a Subject to a Student");
				System.out.println("4. Remove a Subject from a Student");
				System.out.println("5. Display details of a Student");
				System.out.println("6. Display all details of all Students");
				System.out.println("7. Display all Student details enlisted in a selected subject");
				System.out.println("8. Exit");
				System.out.print(">> ");
				int response = Integer.parseInt(in.readLine());

				if (response > 8 || response < 1) {
					throw new Exception();
				}
				if (response > 2 && response < 8 && listStudents.size() == 0) {
					throw new Exception("\nThe current list of Students is empty. Please add some first.\n");
				}
				if (((response > 2 && response < 5) || response == 7) && listSubjects.size() == 0) {
					throw new Exception("\nThe current list of Subjects is empty. Please add some first.\n");
				}

				switch (response) {
				case 1:
					CreateStudentRecord();
					break;
				case 2:
					CreateSubjectRecord();
					break;
				case 3:
					EnlistSubjectToStudent();
					break;
				case 4:
					RemoveSubjectFromStudent();
					break;
				case 5:
					DisplayDetailsOfStudent();
					break;
				case 6:
					DisplayDetailsOfStudents();
					break;
				case 7:
					DisplayStudentDetailsInSubject();
					break;
				case 8:
					System.out.println("\nClosing Program...");
					System.exit(0);
				}
			} catch (Exception e) {
				if (e.getMessage() == null) {
					System.out.println("\nInvalid input. Please try again.\n");
				} else {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	private static void CreateStudentRecord() {
		System.out.println("\nCreating New Student...");
		while (true) {
			try {
				System.out.print("Enter Student's First Name: ");
				String firstName = in.readLine();
				System.out.print("Enter Student's Last Name: ");
				String lastName = in.readLine();
				System.out.println("Enter Student's Course: ");
				String course = in.readLine();

				if (firstName.isBlank() || lastName.isBlank() || course.isBlank()) {
					throw new Exception();
				}

				// Code for creating a new Student object and adding it to the List listStudent
				// (Initialization) Use firstName lastName course as parameters
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.\n");
			}
		}
	}

	private static void CreateSubjectRecord() {
		System.out.println("\nCreating New Subject...");
		while (true) {
			try {
				System.out.print("Enter the Subject Name: ");
				String subjectName = in.readLine();
				System.out.print("Enter the Number of Units: ");
				int units = Integer.parseInt(in.readLine());

				if (subjectName.isBlank() || units < 1) {
					throw new Exception();
				}

				// Code for creating a new Subject object and adding it to the List listSubject
				// (Initialization) Use subjectName and units as parameter
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.\n");
			}
		}
	}

	private static void EnlistSubjectToStudent() {
		System.out.println("\nEnlisting a Subject to a Student...");
		System.out.println("Select a Subject ID to be enlisted to a Student");
		for (int i = 0; i < listSubjects.size(); i++) {
//			System.out.println(listSubjects.get(i).getId() + " - " + listSubjects.get(i).getSubjectName);
		}

		int studentId;
		while (true) {
			try {
				System.out.print(">> ");
				studentId = Integer.parseInt(in.readLine());
				break;
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.\n");
			}
		}

		System.out.println("Select a Student ID to enlist the Subject into");
		for (int i = 0; i < listStudents.size(); i++) {
//			System.out.println(listStudents.get(i).getId() + " - " + listStudents.get(i).GetFullName());
		}

		int subjectId;
		while (true) {
			try {
				System.out.print(">> ");
				subjectId = Integer.parseInt(in.readLine());
				break;
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.\n");
			}
		}

		// Code for searching the Student and Subject objects using the user's entered
		// id for each (studentId and subjectId). Then use the EnlistSubject() Method of
		// the selected student to enlist the subject to them. Then use the
		// EnlistStudent() Method of the selected subject to enlist the student to them.
	}

	private static void RemoveSubjectFromStudent() {
		while (true) {
			try {
				
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.\n");
			}
		}
	}

	private static void DisplayDetailsOfStudent() {
		while (true) {
			try {

			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.\n");
			}
		}
	}

	private static void DisplayDetailsOfStudents() throws Exception {
		if (listStudents.size() == 0) {
			throw new Exception("\nThe current list of Students is empty. Please add some first.\n");
		} else {
			System.out.println("\nInvalid input. Please try again.");
		}
	}

	private static void DisplayStudentDetailsInSubject() {
		while (true) {
			try {

			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.\n");
			}
		}
	}
}
