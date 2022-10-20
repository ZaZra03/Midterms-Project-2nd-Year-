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
					System.out.println("Closing Program...");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.");
			}
		}
	}

	private static void CreateStudentRecord() {
		while (true) {
			try {
				
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.");
			}
		}
	}

	private static void CreateSubjectRecord() {
		while (true) {
			try {
				
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.");
			}
		}
	}

	private static void EnlistSubjectToStudent() {
		while (true) {
			try {
				
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.");
			}
		}
	}

	private static void RemoveSubjectFromStudent() {
		while (true) {
			try {
				
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.");
			}
		}
	}

	private static void DisplayDetailsOfStudent() {
		while (true) {
			try {
				
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.");
			}
		}
	}

	private static void DisplayDetailsOfStudents() {
		while (true) {
			try {
				
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.");
			}
		}
	}
	
	private static void DisplayStudentDetailsInSubject() {
		while (true) {
			try {
				
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.");
			}
		}
	}
}
