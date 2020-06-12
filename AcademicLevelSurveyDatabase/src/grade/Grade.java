package grade;

import java.util.ArrayList;

import people.Student;
/**
 * Class that represents a grade. It contains informations about its own name
 * and contains the student objects that belong to this grade.
 * @author Julius Langenberg
 *
 */
public class Grade {
	
	// Unique identifier of the grade object
	private int gradeID;
	
	// What grade the Class is in. 
	private int gradeLevel;
	
	// The letter coming after the grade, e.g. 10 'c'
	// The c would be the gradeLetter
	private char gradeLetter;
	
	// Array that contains all the Students
	private ArrayList<Student> students = new ArrayList<>();
	
	// ADVANCED GETTERS AND SETTERS \\
	/**
	 * Method that merges the Grade attributes for more readable Syntax.
	 * @return gradeLevel + gradeLetter as String
	 */
	public String getFullGradeName()	{
		return Integer.toString(gradeLevel) + Character.toString(gradeLetter);
	}

	/**
	 * Method that adds a single student to the ArrayLis
	 * @param firstNameIn The first Name of the student
	 * @param lastNameIn Last name of the student.
	 */
	public void addStudent(String firstNameIn, String lastNameIn)	{
		this.students.add( new Student());
		// Set the students id
		this.students.get(students.size()-1).setStudentID(students.size()-1);
		// Set its complete name
		this.students.get(students.size()-1).setFirstName(firstNameIn);
		this.students.get(students.size()-1).setLastName(lastNameIn);
	}
	
	// GETTERS AND SETTERS \\
	public int getGradeID() {
		return gradeID;
	}
	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}
	public int getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public char getGradeLetter() {
		return gradeLetter;
	}
	public void setGradeLetter(char gradeLetter) {
		this.gradeLetter = gradeLetter;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
}
