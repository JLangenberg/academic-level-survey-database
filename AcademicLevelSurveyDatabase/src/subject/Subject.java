package subject;

/**
 * Class that stores the name and ID of a subject. Does not contain things
 * related to exams except for the subject name/type.
 * @author Julius Langenberg
 *
 */
public class Subject {
	
	// Unique Integer that contains the ID of the subject
	private int subjectID;

	// Name of the subject
	private String subjectName = "";
	
	// GETTERS AND SETTER \\
	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}