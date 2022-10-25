import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {//Marc Start
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static List<Student> listStudents = new ArrayList<Student>();
	static List<Subject> listSubjects = new ArrayList<Subject>();

	public static void main(String[] args) {
		while (true) {
			try {
				System.out.println("\nWelcome. Please select an operation...");
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
					throw new NumberFormatException();
				}
				if (response > 2 && response < 8 && listStudents.size() == 0) {
					throw new Exception("\nThe current list of Students is empty. Please add some first.");
				}
				if (((response > 2 && response < 5) || response == 7) && listSubjects.size() == 0) {
					throw new Exception("\nThe current list of Subjects is empty. Please add some first.");
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
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid input. Please try again.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	} //Marc End

	private static void CreateStudentRecord() throws Exception { //Dimaunahan Start
		System.out.println("\nCreating New Student...");
		System.out.print("Enter Student's First Name: ");
		String firstName = in.readLine();
		System.out.print("Enter Student's Last Name: ");
		String lastName = in.readLine();
		System.out.print("Enter Student's Course: ");
		String course = in.readLine();

		if (firstName.isBlank() || lastName.isBlank() || course.isBlank()) {
			throw new Exception("\nOne or more input is left empty. Operation Unsuccessful");
		}

		for (Student student : listStudents) {
			if (student.GetFullName().equals(firstName + " " + lastName)) {
				throw new Exception("\nThis Student is already on the list. Operation Unsuccessful");
			}
		}
		Student objStudent = new Student(firstName, lastName, course);
		listStudents.add(objStudent);

		System.out.println("\nSuccessfully created a new Student Record");
	}

	private static void CreateSubjectRecord() throws Exception { 
		System.out.println("\nCreating New Subject...");
		System.out.print("Enter the Subject Name: ");
		String subjectName = in.readLine();
		System.out.print("Enter the Number of Units: ");
		int units;
		try {
			units = Integer.parseInt(in.readLine());
			if (subjectName.isBlank() || units < 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception("\nOne or more input is left empty or is invalid. Operation Unsuccessful");
		}

		for (Subject subject : listSubjects) {
			if (subject.getSubjectName().equals(subjectName)) {
				throw new Exception("\nThis Subject is already on the list. Operation Unsuccessful");
			}
		}
		Subject objSubject = new Subject(subjectName, units);
		listSubjects.add(objSubject);

		System.out.println("\nSuccessfully created a new Subject Record");
	} //Dimaunahan End

	private static void EnlistSubjectToStudent() throws Exception { // Banagan Start
		System.out.println("\nEnlisting a Subject to a Student...");
		int subjectId;
		int studentId;
		try {
			System.out.println("Select a Subject ID to be enlisted to a Student");
			for (Subject subject : listSubjects) {
				System.out.println(subject.getId() + " - " + subject.getSubjectName());
			}

			System.out.print(">> ");
			subjectId = Integer.parseInt(in.readLine());

			System.out.println("\nSelect a Student ID to enlist the Subject into");
			for (Student student : listStudents) {
				System.out.println(student.getId() + " - " + student.GetFullName());
			}

			System.out.print(">> ");
			studentId = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			throw new Exception("\nInvalid Input. Operation Unsuccessful");
		}
		// Code for searching the Student and Subject objects using the user's entered
		// id for each (studentId and subjectId). Then use the EnlistSubject() Method of
		// the selected student to enlist the subject to them. Then use the
		// EnlistStudent() Method of the selected subject to enlist the student to them.
		for (Student student : listStudents) {
			if (student.getId() == studentId) {
				for (Subject subject : listSubjects) {
					if (subject.getId() == subjectId) {
						student.EnlistSubject(subject);
						System.out.println("\nSuccessfully Enlisted the Subject to the Student");
						return;
					}
				}
				throw new Exception("\nThere are no Subjects found with an id: " + subjectId + " in the list");
			}
		}
		throw new Exception("\nThere are no Students found with an id: " + studentId + " in the list");
	} // Banagan End

	private static void RemoveSubjectFromStudent() throws Exception {//Name4 Start
		System.out.println("\nRemoving a Subject from a Student...");
		int studentId;
		int subjectId;
		try {
			System.out.println("Select a Student ID");
			for (Student student : listStudents) {
				System.out.println(student.getId() + " - " + student.GetFullName());
			}

			System.out.print(">> ");
			studentId = Integer.parseInt(in.readLine());

			System.out.println("\nSelect a Subject ID to be removed");
			for (Student student : listStudents) {
				if (student.getId() == studentId) {
					student.DisplayEnlistedSubjects();
					break;
				}
			}

			System.out.print(">> ");
			subjectId = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			throw new Exception("\nInvalid Input. Operation Unsuccessful");
		}

		// Remove Logic (RemoveSubject() Method)
		for (Student student : listStudents) {
			if (student.getId() == studentId) {
				for (Subject subject : listSubjects) {
					if (subject.getId() == subjectId) {
						subject.RemoveStudent(studentId);
						student.RemoveSubject(subjectId);
						System.out.println("\nSuccessfully removed Subject " + subject.getSubjectName() + " from Student " + student.GetFullName());
						return;
					}
				}
				throw new Exception("\nThere are no Subjects found with an id: " + subjectId + " in the list");
			}
		}
		throw new Exception("\nThere are no Students found with an id: " + studentId + " in the list");
	} //Name4 End

	private static void DisplayDetailsOfStudent() throws Exception { //Name5 Start
		if (listStudents.size() == 0) {
			throw new Exception("\nThe current list of Students is empty. Please add some first.\n");
		} else if (listStudents.size() == 1) {
			System.out.println("\nThe List has only one Student. Displaying the Student's Information...");
			listStudents.get(0).DisplayFullDetails();
		} else {
			System.out.println("\nDisplaying a Student's Information...");
			int studentId;
			try {
				System.out.println("Select a Student ID");
				for (Student student : listStudents) {
					System.out.println(student.getId() + " - " + student.GetFullName());
				}

				System.out.print(">> ");
				studentId = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				throw new Exception("\nInvalid Input. Operation Unsuccessful");
			}

			for (Student student : listStudents) {
				if (student.getId() == studentId) {
					student.DisplayFullDetails();
					return;
				}
			}
			throw new Exception("\nThere are no Students found with an id: " + studentId + " in the list");
		}
	} //Name5 End

	private static void DisplayDetailsOfStudents() throws Exception { //Name6 Start
		if (listStudents.size() == 0) {
			throw new Exception("\nThe current list of Students is empty. Please add some first.\n");
		} else if (listStudents.size() == 1) {
			System.out.println("\nThe List has only one Student. Displaying the Student's Information...");
			listStudents.get(0).DisplayFullDetails();
		} else {
			System.out.println("Displaying the Students Information...");
			for (Student student : listStudents) {
				student.DisplayFullDetails();
			}
		}
	}

	private static void DisplayStudentDetailsInSubject() throws Exception {
		if (listSubjects.size() == 0) {
			throw new Exception("\nThe current list of Subjects is empty. Please add some first.\n");
		} else if (listSubjects.size() == 1) {
			System.out.println("\nThe List has only one Subject. Displaying the Subject's Information...");
			listSubjects.get(0).DisplayFullDetails();
		} else {
			System.out.println("\nDisplaying a Subject's Information...");
			int subjectId;
			try {
				System.out.println("Select a Subject ID");
				for (Subject subject : listSubjects) {
					System.out.println(subject.getId() + " - " + subject.getSubjectName());
				}

				System.out.print(">> ");
				subjectId = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				throw new Exception("\nInvalid Input. Operation Unsuccessful");
			}

			for (Subject subject : listSubjects) {
				if (subject.getId() == subjectId) {
					subject.DisplayFullDetails();
					return;
				}
			}
			throw new Exception("\nThere are no Subjects found with an id: " + subjectId + " in the list");
		}
	} //Name6 End
}
