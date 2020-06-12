package people;
/**
 * A class that represents teachers and stores information about them.
 * Subclass of Person
 * @author Julius Langenberg
 *
 */
public class Teacher extends Person {
	
	// ID of this teacher.
	private int teacherID;

	// GETTERS AND SETTERS \\
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
}
