package people;
/**
 * A class that represents students and stores information about them.
 * Subclass of Person.
 * @author Julius Langenberg
 *
 */
public class Student extends Person	{
	
	// ID of the student.
	private int studentID;

	// GETTERS AND SETTERS \\
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
}
