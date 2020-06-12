package people;
/**
 * A class that represents people. All persons have names.
 * Super class of Student and Teacher
 * @author Julius Langenberg
 */
public class Person {
	
	// Contains the last name of the person.
	private String lastName;
	// Contains the last name of the person.
	private String firstName;
	
	/**
	 * Returns the complete name.
	 * @return firstName + lastName
	 */
	public String getFullName()	{
		return firstName + " " + lastName;
	}
	
	// GETTERS AND SETTERS \\
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
}
