import java.util.ArrayList;
import java.util.List;

public class Student {
	
	
	//Classfields
		private int studentId;
		private String firstName;
		private String lastName;
		private String course;
		private  static int idCounter = 1;
		
		List<Student> listStudent = new ArrayList<Student>();
		
		public Student(String firstName, String lastName, String course) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.course = course;
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
		
		//Setters
		public void setId(int studentId) {
			this.studentId = studentId;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public void setCourse(String course) {
			this.course = course;
		}
	  
    //methods na walang laman
		public void EnlistStudent() {
			
		}
		
		public void RemoveSubject() {
			
		}
		public void DisplayDetails() {
			
		}
		

}
