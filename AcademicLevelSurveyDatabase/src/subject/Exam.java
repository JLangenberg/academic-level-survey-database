package subject;

import java.util.ArrayList;
/**
 * Represents an exam. Contains scores, the subject it belongs to, the supervising
 * teacher, the class taking it and if it was taken yet.
 * @author Julius Langenberg
 *
 */
public class Exam {
	
	// Unique Int that contains the ID of the grade that has this teacher
	private int teacherID;
	// ID of this exam.
	private int examID;
	// ID of the subject the exam belongs to.
	private int subjectID;
	// Unique Int that contains the ID of the grade that has this subject
	private int gradeID;
	// Boolean that shows whether or not the exam of this subject has already
	// been taken
	private boolean examTaken;
	
	// ArrayList that stores all of the scores for the exam belonging to this subject.
	private ArrayList<Integer> score = new ArrayList<>();
	
	// Small method that adds a single score to the array list.
	public void addScore(int scoreIn)	{
		score.add(scoreIn);
	}
	
	// GETTERS AND SETTERS \\
	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}


	public boolean isExamTaken() {
		return examTaken;
	}

	public void setExamTaken(boolean examTaken) {
		this.examTaken = examTaken;
	}

	public int getGradeID() {
		return gradeID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}

	public ArrayList<Integer> getScore() {
		return score;
	}

	public void setScore(ArrayList<Integer> score) {
		this.score = score;
	}

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}
	
}
