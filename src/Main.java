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
 * @class Main
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
 * @see Subject
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static List<Student> listStudents = new ArrayList<Student>();
	static List<Subject> listSubjects = new ArrayList<Subject>();
	
	/** 
	 * This is the main method which makes use of calling the other methods in 
	 * the program. The main method is also use to display the kinds of operation 
	 * available in the program so that the user will be aware of what number 
	 * will be inputed. Each operations has its own designated method
	 * 
	 * @param args Unused.
	 * @return Nothing.
	 */

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
				
				//Input Checking
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
	}
	
	/** 
	 * This is the CreateStudentRecord method which makes use of
	 * creating a new student object that will be added to the ArrayList
	 * of the Main class named listStudents. The method simple asks 
	 * the user for its Name and Course. If the user's input is
	 * approved by the program then it will be successfully added to
	 * the list. 
	 * 
	 * @throws Exception.
	 * @return Nothing.
	 */
	
	private static void CreateStudentRecord() throws Exception {
		System.out.println("\nCreating New Student...");
		System.out.print("Enter Student's First Name: ");
		String firstName = in.readLine();
		System.out.print("Enter Student's Last Name: ");
		String lastName = in.readLine();
		System.out.print("Enter Student's Course: ");
		String course = in.readLine();
		
		//Input Checking
		if (firstName.isBlank() || lastName.isBlank() || course.isBlank()) {
			throw new Exception("\nOne or more input is left empty. Operation Unsuccessful");
		}
		
		//Traverse all objects in the list to check duplicate objects
		for (Student student : listStudents) {
			if (student.GetFullName().equals(firstName + " " + lastName)) {
				throw new Exception("\nThis Student is already on the list. Operation Unsuccessful");
			}
		}
		Student objStudent = new Student(firstName, lastName, course);
		listStudents.add(objStudent);

		System.out.println("\nSuccessfully created a new Student Record");
	}
	
	/** 
	 * This is the CreateSubjectRecord method which makes use of
	 * creating a new subject object that will be added to the ArrayList
	 * of the Main class named listSubjects. The method simple asks 
	 * the user for the Subject Name and Number of units. If the user's input is
	 * approved by the program then it will be successfully added to
	 * the list. 
	 * 
	 * @throws Exception.
	 * @return Nothing.
	 */
	
	private static void CreateSubjectRecord() throws Exception { 
		System.out.println("\nCreating New Subject...");
		System.out.print("Enter the Subject Name: ");
		String subjectName = in.readLine();
		System.out.print("Enter the Number of Units: ");
		int units;
		
		//Uses try-catch for input checking
		try {
			units = Integer.parseInt(in.readLine());
			if (subjectName.isBlank() || units < 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception("\none or more input is left empty or is invalid. Operation Unsuccessful");
		}
		
		//Traverse all objects in the list to check duplicate objects
		for (Subject subject : listSubjects) {
			if (subject.getSubjectName().equals(subjectName)) {
				throw new Exception("\nThis Subject is already on the list. Operation Unsuccessful");
			}
		}
		Subject objSubject = new Subject(subjectName, units);
		listSubjects.add(objSubject);

		System.out.println("\nSuccessfully created a new Subject Record");
	}
	
	/** 
	 * This is the EnlistSubjectToStudent method which allow the user to enter a 
	 * valid Student id to search for the specific student to enlist a subject 
	 * based from the list of subjects available, it uses the id of the subject 
	 * for selecting the subject to be enlisted in the selected student by
	 * allowing the user to enter the valid Subject id, the selected subject
	 * will be stored in the List of Enlisted Subjects of the selected student.
	 * 
	 * @throws Exception.
	 * @return Nothing.
	 */
	
	private static void EnlistSubjectToStudent() throws Exception { 
		System.out.println("\nEnlisting a Subject to a Student...");
		int subjectId;
		int studentId;
		
		//Uses try-catch for input checking
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
		/*
		 * Code for searching the Student and Subject objects using the user's entered
		 * id for each (studentId and subjectId). Then use the EnlistSubject() Method of
		 * the selected student to enlist the subject to them. Then use the EnlistStudent() 
		 * Method of the selected subject to enlist the student to them.
		 */
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
	}

	/** 
	 * This is the RemoveSubjectFromStudent method which allow the user to
	 * enter a valid Student id to search for the specific student to remove 
	 * a subject based from the List of Enlisted Subjects, it uses the id of 
	 * the subject for selecting the subject to be removed in the selected 
	 * student by allowing the user to enter the valid Subject id.
	 * 
	 * @throws Exception.
	 * @return Nothing.
	 */
	
	private static void RemoveSubjectFromStudent() throws Exception {
		System.out.println("\nRemoving a Subject from a Student...");
		int studentId;
		int subjectId;
		
		//Uses try-catch for input checking
		try {
			//Display all available students  for selection
			System.out.println("Select a Student ID");
			for (Student student : listStudents) {
				System.out.println(student.getId() + " - " + student.GetFullName());
			}

			System.out.print(">> ");
			studentId = Integer.parseInt(in.readLine());
			
			//Display all available subjects  for selection
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
		/*
		 * First it will traverse all objects in the listStudents of the Main class
		 * if one object matches the inputed student id, then it will traverse all
		 * objects present in the listSubjects of the Main class, if one object 
		 * matches the inputed subject id, then it will call RemoveStudent method
		 * with the parameter of studentId from Subject class and RemoveSubject method
		 * with the parameter of subjectId from Student class. If the given conditions is not
		 * met, then it will throw an Exception.
		 */
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
	}
	
	/** 
	 * This is the DisplayDetailsOfStudent method which allow the user to enter 
	 * a valid Student id to search for the specific student and display all its 
	 * details including all of its subjects enlisted.
	 * 
	 * @throws Exception.
	 * @return Nothing.
	 */
	
	private static void DisplayDetailsOfStudent() throws Exception {
		if (listStudents.size() == 0) {
			throw new Exception("\nThe current list of Students is empty. Please add some first.\n");
		} else if (listStudents.size() == 1) {
			System.out.println("\nThe List has only one Student. Displaying the Student's Information...");
			listStudents.get(0).DisplayFullDetails();
		} else {
			System.out.println("\nDisplaying a Student's Information...");
			int studentId;
			
			//Uses try-catch for input checking
			try {
				//Display all available students  for selection
				System.out.println("Select a Student ID");
				for (Student student : listStudents) {
					System.out.println(student.getId() + " - " + student.GetFullName());
				}

				System.out.print(">> ");
				studentId = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				throw new Exception("\nInvalid Input. Operation Unsuccessful");
			}
			
			/*  
			 * Traverse all objects in the listStudents of Main class, if the inputed
			 * student id matches the object's id in the list then it will call the
			 * DisplayFullDetails method from the Student class. 
			 */
			for (Student student : listStudents) {
				if (student.getId() == studentId) {
					student.DisplayFullDetails();
					return;
				}
			}
			throw new Exception("\nThere are no Students found with an id: " + studentId + " in the list");
		}
	}
	
	/** 
	 * This is the DisplayDetailsOfStudents method which makes use of displaying
	 * all details of the Students in the list with their own enlisted subject details.
	 * 
	 * @throws Exception.
	 * @return Nothing.
	 */
	
	private static void DisplayDetailsOfStudents() throws Exception {
		if (listStudents.size() == 0) {
			throw new Exception("\nThe current list of Students is empty. Please add some first.\n");
		} else if (listStudents.size() == 1) {
			System.out.println("\nThe List has only one Student. Displaying the Student's Information...");
			listStudents.get(0).DisplayFullDetails();
		} else {
			/*
			 * Display the details of all student objects in the listStudents through 
			 * DisplayFullDetails method from the student class.
			 */
			System.out.println("Displaying the Students Information...");
			for (Student student : listStudents) {
				student.DisplayFullDetails();
			}
		}
	}
	
	/** 
	 * This is the DisplayStudentDetailsInSubject method which makes use of displaying
	 * all the details of the Students according to a selected subject through a valid 
	 * Subject id entered by the user.
	 * 
	 * @throws Exception.
	 * @return Nothing.
	 */
	
	private static void DisplayStudentDetailsInSubject() throws Exception {
		if (listSubjects.size() == 0) {
			throw new Exception("\nThe current list of Subjects is empty. Please add some first.\n");
		} else if (listSubjects.size() == 1) {
			System.out.println("\nThe List has only one Subject. Displaying the Subject's Information...");
			listSubjects.get(0).DisplayFullDetails();
		} else {
			System.out.println("\nDisplaying a Subject's Information...");
			int subjectId;
			
			//Uses try-catch for input checking
			try {
				//Display all available subjects  for selection
				System.out.println("Select a Subject ID");
				for (Subject subject : listSubjects) {
					System.out.println(subject.getId() + " - " + subject.getSubjectName());
				}

				System.out.print(">> ");
				subjectId = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				throw new Exception("\nInvalid Input. Operation Unsuccessful");
			}
			
			/*  
			 * Traverse all objects in the listSubjects of Main class, if the inputed
			 * subject id matches the object's id in the list then it will call the
			 * DisplayFullDetails method from the Subject class. 
			 */
			for (Subject subject : listSubjects) {
				if (subject.getId() == subjectId) {
					subject.DisplayFullDetails();
					return;
				}
			}
			throw new Exception("\nThere are no Subjects found with an id: " + subjectId + " in the list");
		}
	}
}
