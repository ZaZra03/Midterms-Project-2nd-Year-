import java.util.ArrayList;
import java.util.List;

public class Student {
	
	
		//Class fields
		private int studentId;
		private String firstName;
		private String lastName;
		private String course;
		private static int idCounter = 1;
		private List<Subject> listSubjects = new ArrayList<Subject>();
		
		public Student(String firstName, String lastName, String course) {
			this.studentId = idCounter;
			this.firstName = firstName;
			this.lastName = lastName;
			this.course = course;
			idCounter++;
		}
		
		//Getters
		public int getId() {
			return studentId;
		}

		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public String getCourse() {
			return course;
		}

		
		public int getIdCounter() {
			return idCounter;
		}

		//methods na walang laman
		public String GetFullName() {
			return this.firstName + " " + this.lastName;
		}
	
		public void EnlistStudent(Subject objSubject) {
			
		}
		
		public void RemoveSubject(int subjectId) {
			
		}
		public void DisplayDetails() {
			
		}
		

}
