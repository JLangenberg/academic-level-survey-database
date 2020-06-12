package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import grade.Grade;
import people.Student;
import people.Teacher;
import subject.Exam;
import subject.Subject;
/**
 * The main class where the user interaction and most of the program take place.
 * @author Julius Langenberg
 *
 */
public class UI {
	/**
	 * Main method that is run when the program starts.
	 * @param args 
	 */
	public static void main(String[] args) {
		
		// Initialize all of the objects and variables needed for this database
		ArrayList<Subject> subjects = new ArrayList<>();
		ArrayList<Teacher> teachers = new ArrayList<>();
		ArrayList<Grade> grades = new ArrayList<>();
		ArrayList<Exam> exams = new ArrayList<>();
		
		// Stores the name of the file that is going to be created. Contains a default.
		String fileName = "standardFileName";

		// Initialize an instance of UI to be able to access it's methods
		UI ui = new UI();
		
		// Get the wanted file name from the user.
		fileName = ui.setup(subjects, teachers, grades, exams);
				
		// Starts the menu
		ui.menu(subjects, teachers, grades, fileName, exams);		
	}
	
	/**
	 * Method that contains everything needed to run time so the program works.
	 * It is tasked with filling ArrayLists, get Scores (or not) for the exams
	 * and get a file name.
	 * @param subjects Is being filled with informations.
	 * @param teachers Is being filled with informations.
	 * @param grades Is being filled with informations.
	 * @param exams Is being filled with informations and scores.
	 * @return Returns a string that contains the name the files are supposed to
	 * 		   be saved under.
	 */
	private String setup(ArrayList<Subject> subjects, ArrayList<Teacher> teachers, 
			  			 ArrayList<Grade> grades, ArrayList<Exam> exams) {
		
		UI ui = new UI();
		
		// Fill the ArrayLists with objects and fill those with the right information
		ui.startFilling(subjects, teachers, grades, exams);
		// Decide whether or not to set scores and use presets or get them by user input
		ui.fillScoresMain(subjects, grades, exams);
		// Get the name for the files that are being created and return it in one go.
		return ui.getFileName();
	}
	
	/**
	 * Runs the menu loop. Here the user enters what information he wants and how he
	 * wants it printed. Then it is printed and saved in a file.
	 * @param subjects ArrayList containing informations.
	 * @param teachers ArrayList containing informations.
	 * @param grades ArrayList containing informations.
	 * @param fileName The name the file is supposed to be saved under.
	 */
	private void menu(ArrayList<Subject> subjects, ArrayList<Teacher> teachers, 
					  ArrayList<Grade> grades, String fileName, ArrayList<Exam> exams)	{
		
		// Construct an UI object to be able to use UI methods
		UI ui = new UI();
		
		// Stores the menu choice.
		int menuChoice = 0;
		
		// Create a boolean for the while loop.
		boolean validChoice = false;
		
		// Cycles through the menu. Gives options and executes what the user chooses.
		do {
			// Give the user an overview of the possibilities.
			ui.printMenuChoices();
			
			// Boolean that indicates whether or not a valid choice has been made
			validChoice = false;
			
			// Runs until a valid choice has been made
			while (validChoice == false)	{
				
				// Gets the choice from user input
				menuChoice = ui.getInputInt();
				
				// Determines whether or not the value of menuChoice is legal or not
				if ((menuChoice >= 0) || (menuChoice <= 3))	{
					validChoice = true;
				}	else	{
					validChoice = false;
				}
			}
			
			// Executes the method that has been chosen.
			switch (menuChoice)	{
			
				case 1:
					// Method that prints information like shown in task 1.
					ui.printStandard(subjects, teachers, grades, fileName, exams);
					break;
				case 2:
					// Prints the information from the array in the console to make it readable
					ui.printFormatedText(subjects, teachers, grades, fileName, exams);
					break;
				case 3:
					// Prints a overview. Contains all teachers, students and their grades.
					ui.printOverview(subjects, teachers, grades, fileName);
					break;
				case 0:
					// Prints a goodbye message.
					System.out.println("Tschau.");
					break;
				default :
					// Prints an error message and indicating a wrong input.
					System.out.println("\nUngueltige Eingabe. Bitte versuchen sie es noch einmal.");
			}
		}	while (menuChoice != 0);
	}

	/**
	 * Starts the process of filling the arrays with both objects and information.
	 * @param subjects Getting filled with objects and information.
	 * @param teachers Getting filled with objects and information.
	 * @param grades Getting filled with objects and information.
	 */
	private void startFilling(ArrayList<Subject> subjects, ArrayList<Teacher> teachers, ArrayList<Grade> grades, ArrayList<Exam> exams) {
		
		// Constructs objects in the arrays for later use
		fillArrays(subjects, teachers, grades, exams);
		// Fills the objects in the arrays to make it accessible for later
		fillData(subjects, teachers, grades, exams);

	}

	/**
	 * Construct object for all of the arrays
	 * @param subjects Getting filled with objects.
	 * @param teachers Getting filled with objects.
	 * @param grades Getting filled with objects.
	 */
	private void fillArrays(ArrayList<Subject> subjects, ArrayList<Teacher> teachers, ArrayList<Grade> grades, ArrayList<Exam> exams) {
		// These values have to be customized by hand. They have to be as big
		// as the fillData method requires.
		int subjectStartAmount = 5;
		for (int i = 0; i < subjectStartAmount; i++)	{
			subjects.add(new Subject());
		}
		for (int i = 0; i < subjectStartAmount; i++)	{
			exams.add(new Exam());
		}
		int teachersStartAmount = 4;
		for (int i = 0; i < teachersStartAmount; i++)	{
			teachers.add(new Teacher());
		}	
		int gradesStartAmount = 4;
		for (int i = 0; i < gradesStartAmount; i++)	{
			grades.add(new Grade());
		}	

	}

	/**
	 * Method that fills all of the objects with the information from the project
	 * paper.
	 * 
	 * @param subjects Array that is intended to store information related to it and
	 *                 will be filled
	 * @param teachers Array that is intended to store information related to it and
	 *                 will be filled
	 * @param grades   Array that is intended to store information related to it and
	 *                 will be filled. Also stores the students which will also be
	 *                 filled with information.
	 */
	private void fillData(ArrayList<Subject> subjects, ArrayList<Teacher> teachers, ArrayList<Grade> grades, ArrayList<Exam> exams) {
		//TODO: Make this prettier, maybe read from a .txt
		
		// Set 1:
		// Set the subjects data
		subjects.get(0).setSubjectName("Physik");
		subjects.get(0).setSubjectID(314159);	
		//Set the exams data
		exams.get(0).setSubjectID(314159);	// The exam belongs to this subject
		exams.get(0).setTeacherID(0);	// This teacher supervises it
		exams.get(0).setExamTaken(false);	// It has not been taken yet - no scores
		exams.get(0).setExamID(0);	// Set its ID to be able to identify it.
		exams.get(0).setGradeID(0);	// This grade will have to take the exam.
		// Set the teachers name
		teachers.get(0).setFirstName("Isaac");
		teachers.get(0).setLastName("Newton");
		teachers.get(0).setTeacherID(0);
		// Set the grade informations
		// Students
		grades.get(0).setGradeID(0);
		grades.get(0).addStudent("Albert", "Einstein");
		grades.get(0).addStudent("Stephen", "Hawking");
		grades.get(0).addStudent("Werner", "Heisenberg");
		grades.get(0).addStudent("Nils", "Bohr");
		// Grade
		grades.get(0).setGradeLetter('a');
		grades.get(0).setGradeLevel(10);
		grades.get(0).setGradeID(0);

		// Set 2:
		// Set the subjects data
		subjects.get(1).setSubjectName("Technik");
		subjects.get(1).setSubjectID(4711);
		//Set the exams data
		exams.get(1).setSubjectID(4711);	// The exam belongs to this subject
		exams.get(1).setTeacherID(1);	// This teacher supervises it
		exams.get(1).setExamTaken(false);	// It has not been taken yet - no scores
		exams.get(1).setExamID(1);	// Set its ID to be able to identify it.
		exams.get(1).setGradeID(1);	// This grade will have to take the exam.
		// Set the teachers name
		teachers.get(1).setFirstName("Gallileo");
		teachers.get(1).setLastName("Gallile");
		teachers.get(1).setTeacherID(1);
		// Set the grade informations
		// Students
		grades.get(1).setGradeID(1);
		grades.get(1).addStudent("Marie", "Curie");
		grades.get(1).addStudent("Ada", "Lovelace");
		grades.get(1).addStudent("Lise", "Meitner");
		
		// Grade
		grades.get(1).setGradeLetter('b');
		grades.get(1).setGradeLevel(10);

		// Set 3:
		// Set the subjects data
		subjects.get(2).setSubjectName("Mathematik");
		subjects.get(2).setSubjectID(42);
		//Set the exams data
		exams.get(2).setSubjectID(42);	// The exam belongs to this subject
		exams.get(2).setTeacherID(2);	// This teacher supervises it
		exams.get(2).setExamTaken(false);	// It has not been taken yet - no scores
		exams.get(2).setExamID(2);	// Set its ID to be able to identify it.
		exams.get(2).setGradeID(2);	// This grade will have to take the exam.
		// Set the teachers name
		teachers.get(2).setFirstName("Pythagoras");
		teachers.get(2).setLastName("von Samos");
		teachers.get(2).setTeacherID(2);
		// Set the grade informations
		// Students
		grades.get(2).setGradeID(2);
		grades.get(2).addStudent("Carl Friedrich", "Gauss");
		grades.get(2).addStudent("Leonardo", "Fibonacci");
		grades.get(2).addStudent("Pierre de", "Fermat");
		// Grade
		grades.get(2).setGradeLetter('c');
		grades.get(2).setGradeLevel(10);
		
		// Set 4:
		//Set the subjects data
		subjects.get(3).setSubjectName("Starcraft 2");
		subjects.get(3).setSubjectID(777);
		//Set the exams data
		exams.get(3).setSubjectID(777);	// The exam belongs to this subject
		exams.get(3).setTeacherID(3);	// This teacher supervises it
		exams.get(3).setExamTaken(false);	// It has not been taken yet - no scores
		exams.get(3).setExamID(3);	// Set its ID to be able to identify it.
		exams.get(3).setGradeID(3);	// This grade will have to take the exam.
		// Set the teachers name
		teachers.get(3).setFirstName("WinterStarcraft");
		teachers.get(3).setLastName("on Twitch");
		teachers.get(3).setTeacherID(3);
		// Set the grade informations
		// Students
		grades.get(3).setGradeID(3);
		grades.get(3).addStudent( "Maru", "aka Terran God");
		grades.get(3).addStudent("Scarlett", "aka Queen of Blades");
		grades.get(3).addStudent("Puck", "aka so cheesy he could be Swiss");
		grades.get(3).addStudent("Suilui", "aka Bronze is to hard");
		
		// Grade
		grades.get(3).setGradeLetter('c');
		grades.get(3).setGradeLevel(65);
		
		/*
		 * Set 5:
		 * Set 4 & 5 are (obviously) custom made and supposed to show that one teacher
		 * can teach multiple classes, and one grade can take several exams.
		 * 
		 * Set the subjects data
		 */
		subjects.get(4).setSubjectName("Twitch Streaming");
		subjects.get(4).setSubjectID(420);
		//Set the exams data
		exams.get(4).setSubjectID(420);	// The exam belongs to this subject
		exams.get(4).setTeacherID(3);	// This teacher supervises it
		exams.get(4).setExamTaken(false);	// It has not been taken yet - no scores
		exams.get(4).setExamID(4);	// Set its ID to be able to identify it.
		exams.get(4).setGradeID(3);	// This grade will have to take the exam.
	}
	
	/**
	 * Method that determines how scores should be handled, being able to use preset scores,
	 * user generated scores or not use scores at all. The user decides what should be done by input.
	 * @param subjects ArrayList containing informations.
	 * @param grades ArrayList containing informations.
	 * @param exams ArrayList containing informations.
	 */
	private void fillScoresMain(ArrayList<Subject> subjects, ArrayList<Grade> grades, ArrayList<Exam> exams) {
		
		UI ui = new UI();
		// Get the user choice
		int choice = ui.chooseIfFillScore();
		
		// Decide what to do according to user choice
		switch (choice) {
		case 0:
			// Fill the objects with preset scores.
			ui.fillScoresPreset(exams, grades);
			break;
		case 1:
			// Let the user enter the scores.
			ui.fillScoresUserInput(subjects, grades, exams);
			break;
		case 2:
			// Continue without scores at all.
			System.out.println("Fahre ohne Noten fort.");
		};
	}
	
	/**
	 * Checks how many students take how many exams and then generate scores and
	 * save them in the corresponding exam object.
	 * @param exams Exams that the scores are being saved in.
	 * @param grades Grades containing the students taking the exams.
	 */
	private void fillScoresPreset(ArrayList<Exam> exams, ArrayList<Grade> grades) {
		
		UI ui = new UI();
		// Cycle through all of the exams.
		for(int i = 0; i < exams.size(); i++)	{
			// Sets the exam as 'taken' or 'done'
			exams.get(i).setExamTaken(true);
			// Get how many Students there are in the grade belonging to this exam.
			int gradeSize = ui.getStudentCountInGrade(ui.getGradeByID(grades, exams.get(i).getGradeID()));
			// Add scores equal to the amount of students a grade has.
			for (int j = 0; j < gradeSize; j++)	{
				// Add the default score to the scores
				exams.get(i).addScore(3);
			}
		}
	}
	
	/**
	 * Lets the user choose as many scores as needed on a scale of 1-6 for each
	 * exam.
	 * @param subjects Needed to give tell the user what he/she is currently filling
	 * 		  informations in for.
	 * @param grades The grades with the students. Needed to know how many 
	 * 		  scores an exam needs.
	 * @param exams The exams that contain the scores.
	 */
	private void fillScoresUserInput(ArrayList<Subject> subjects, 
									 ArrayList<Grade> grades, ArrayList<Exam> exams) {
		UI ui = new UI();
		// Cycle through all of the exams.
		for(int i = 0; i < exams.size(); i++)	{
			System.out.println("Bitte Noten für das Fach " +
								ui.getSubjectNameOfExam(exams.get(i), subjects) + ","
								+ " Exam Nr." + exams.get(i).getExamID() + " eingeben.");
			// Set the exam as 'taken' or 'done'
			exams.get(i).setExamTaken(true);
			// Get how many Students there are in the grade belonging to this exam.
			int gradeSize = ui.getStudentCountInGrade(ui.getGradeByID(grades, exams.get(i).getGradeID()));
			// Add scores equal to the amount of students a grade has
			for (int j = 0; j < gradeSize; j++)	{
				// User feedback
				System.out.println("Bitte geben sie eine Note ein.");
				// Int that will store the entered score until it is found to valid.
				int tempScore = 0;
				// Continue until the entered score is legal.
				do	{
				System.out.println("Noten müssen zwischen 1 und 6 sein.");
				// Get the user generated score
				tempScore = ui.getInputInt();
				}	while ((tempScore > 6) || (tempScore < 1));
				// Add the entered score to the ArrayList.
				exams.get(i).addScore(tempScore);
			}
		}	
	}

	/**
	 * Method from task 2 that prints the stored information.
	 * @param subjects Subject related data that is going to be printed.
	 * @param teachers Teacher related data that is going to be printed.
	 * @param grades Grade related data that is going to be printed.
	 * @param fileName name of the file data is going to be saved as.
	 * @param exams Exam related data that is going to be printed.
	 */
	private void printStandard(ArrayList<Subject> subjects, ArrayList<Teacher> teachers,
							   ArrayList<Grade> grades, String fileName, ArrayList<Exam> exams) {

		// String that is used to assemble all of the text before printing it onto
		// the console and writing it into a file.
		String puzzleString = "";

		// String array that contains the two strings that show the
		// user whether or not the exam has taken place.
		String[] pruefungStatus = { "Nein", "Ja" };

		// Construct an UI object to be able to use UI methods.
		UI ui = new UI();

		// Cycle to the Exams with according students and teachers
		for (int i = 0; i < exams.size(); i++) {
			
			// Construct objects to fill them later
			Teacher teacher = new Teacher();
			Grade grade = new Grade();
			
			// Fill the objects with the information belonging to that subject by using the IDs
			// stored inside of the subject object.
			teacher = ui.getTeacherByID(teachers ,exams.get(i).getTeacherID());
			grade = ui.getGradeByID(grades, exams.get(i).getGradeID());
			// Add all information into one big string
			puzzleString += "Fach: " + ui.getSubjectNameOfExam(exams.get(i), subjects) + "\n";
			puzzleString += "Fach ID: " + 
							 ui.getSubjectByID(subjects, 
									 		   exams.get(i).getSubjectID()).getSubjectID()
							 + "\n";
			puzzleString += "Prüfungs ID: " + exams.get(i).getExamID() + "\n";
			puzzleString += "Prüfung durchgeführt: "
							+ ui.booleanToStringFromArray(pruefungStatus, 
														  exams.get(i).isExamTaken())
							+ "\n";
			puzzleString += "Lehrer: " + teacher.getFullName() + "\n";
			puzzleString += "Klasse: " + grade.getFullGradeName() + "\n";
			puzzleString += "Schüler: " + "\n";
			
			// Cycle through the students of a grade and get their information
			for (int j = 0; j < grade.getStudents().size(); j++) {
				Student student = grade.getStudents().get(j);
				puzzleString += student.getFullName();
				puzzleString += "\n";
			}
			puzzleString += "\n";
		}

		// Print all of the information
		System.out.println(puzzleString);

		// Write all of the information into two files. One containing all
		// console output, the other one containing just this piece of text.
		ui.writeFile(fileName, "Standard.txt", puzzleString);
	}

	/**
	 * Method that prints all of the information from the ArrayLists to make it
	 * readable. Made for task 3 and 4.
	 * @param subjects Subject related data that is going to be printed.
	 * @param teachers Teacher related data that is going to be printed.
	 * @param grades Grade related data that is going to be printed.
	 * @param fileName name of the file data is going to be saved as.
	 * @param exams Exam related data that is going to be printed.
	 */
	private void printFormatedText(ArrayList<Subject> subjects, ArrayList<Teacher> teachers,
								   ArrayList<Grade> grades, String fileName, ArrayList<Exam> exams) {

		// Construct an UI object to be able to use UI methods.
		UI ui = new UI();
		
		// String that stores the text that should be printed if the exam has been taken
		// or not. Handed into a method later on. (booleanToStringFromArray)
		String[] examStateOutput = { " steht noch aus!", "OK ! Erledigt !" };

		// Loop that cycles through the different exams and assembles everything into
		// a single string to print it later
		for (int i = 0; i < exams.size(); i++) {
			
			// Puzzle string stores the string that should be printed after every
			// piece of information has been added to it
			String puzzleString = "Information zur Lernstandserhebung im Fach: ";
			
			// Construct objects to fill them later
			Teacher teacher = new Teacher();
			Grade grade = new Grade();
			
			// Fill the objects with the information belonging to that subject by using the IDs
			// stored inside of the subject object.
			teacher = ui.getTeacherByID(teachers ,exams.get(i).getTeacherID());
			grade = ui.getGradeByID(grades, exams.get(i).getGradeID());
			
			// Add the informations and spaces for formatting.
			puzzleString += ui.getSubjectNameOfExam(exams.get(i), subjects);
			puzzleString += " ( Fach ID: " +
							ui.getSubjectByID(subjects,
											  exams.get(i).getSubjectID()).getSubjectID()
							+ ", ";
			puzzleString += "Prüfungs ID: " + exams.get(i).getExamID() + ")";
			puzzleString += "\n	Erhebung im Fach durchgeführt: ==> ";
			puzzleString += booleanToStringFromArray(examStateOutput, 
													 exams.get(i).isExamTaken());
			
			// Only try to print scores when the exam was taken.
			if (exams.get(i).isExamTaken() == true) {
				puzzleString += "\n\t";
				ArrayList<Integer> scores = exams.get(i).getScore();
				// Cycles through all of the students in a grade object and collects
				// their information in puzzleString
				for (int j = 0; j < scores.size(); j++) {
					puzzleString += "N_" + (j + 1) + " = " + scores.get(j) + " | ";
				}
				puzzleString += "\n";
			}
			// Add the teacher and students related informations.
			puzzleString += "Informationen zum Lehrer: ";
			puzzleString += teacher.getFullName();
			puzzleString += "\nInformationen zu Schuelern:";

			// Cycles through all of the students in a grade object and collects
			// their information in puzzleString
			for (int j = 0; j < grade.getStudents().size(); j++) {
				// Store the student object from grade into a new object to
				// make syntax shorter and more readable
				Student student = grade.getStudents().get(j);
				// Formatting
				puzzleString += "\n	";
				// Add its name and grade to the string
				puzzleString += student.getFullName();;
				puzzleString += " ( Klasse: " + grade.getFullGradeName() + " )";
			}
			// Formatting
			puzzleString += "\n	"; 

			// Print the final string related to a single exam.
			System.out.println(puzzleString);
			System.out.println("");

			// Write the output of this method into a file.
			ui.writeFile(fileName, "FormatedVersion.txt", puzzleString);
		}
	}

	/**
	 * Prints all of the participating teachers and students in the console. Made
	 * for task 5. Also writes the output into the 'overview' file and the 'complete'
	 * file. 
	 * @param subjects ArrayList whose information is going to be used
	 * @param teachers ArrayList whose information is going to be used
	 * @param grades   ArrayList whose information is going to be used. Also stores
	 *                 its students
	 * @param fileName String that contains the name for the file that is going to be
	 * 				   created.
	 */
	private void printOverview(ArrayList<Subject> subjects, ArrayList<Teacher> teachers, 
							   ArrayList<Grade> grades, String fileName) {
		String puzzleString = "";
		puzzleString += "Liste aller Lehrer: \n";
		// Add all of the teachers into the string
		for (int i = 0; i < teachers.size(); i++) {
			puzzleString += teachers.get(i).getFullName() + "\n";
		}

		puzzleString += "\nListe aller Schueler:\n";
		// Cycle through all of the grades. 
		//TODO: Remove and replace getStudentWithID
		for (int i = 0; i < grades.size(); i++) {
			// Cycle through the students of a grade and print their information
			for (int j = 0; j < grades.get(i).getStudents().size(); j++) {
				Student student = grades.get(i).getStudents().get(j);
				puzzleString += student.getFullName();
				puzzleString += "( Klasse: " + grades.get(i).getFullGradeName() + " )\n";
			}
		}

		// Print all of the information that has been put into the string.
		System.out.println(puzzleString);

		// Create a single file that contains the overview and add to the big complete
		// file.
		UI ui = new UI();
		ui.writeFile(fileName, "Overview.txt", puzzleString);
	}
	
	/**
	 * Simple method that just prints all of the options the user has to the console.
	 */
	private void printMenuChoices()	{
		System.out.println("Bitte geben Sie die gewünschte Ausgabeform an:");
		System.out.println("(1): Ausgabe wie in Aufgabe 1");
		System.out.println("(2): Ausgabe wie in Aufgabe 3 und 4");
		System.out.println("(3): Ausgabe wie in Aufgabe 5");
		System.out.println("(0) Beenden des Programms.");
		System.out.println("Hinweis: Zwischen der Ausgabe von A3 und A4 kann entschieden "
				+ "werden indem man Noten leer lässt oder füllt.");
	}
	
	/**
	 * Gets the name of the file that is going to be created.
	 * @return Returns the entered file name
	 */
	private String getFileName()	{
		// String that stores the name of the file that is to be created.
		String fileName = "";
		// Tell the user what to do.
		System.out.println("Bitte geben sie einen Namen fuer ihre Datei ein."
							+ " Endungen fuer den Datetypen sind nicht notwendig.");
		// Get an input
		fileName = getInputString();	
		// Return the input
		return fileName;
	}
	
	/**
	 * Method that gets a int from the user.
	 * @return The int the user entered.
	 */
	private int getInputInt()	{
		// Construct the object needed for reading user input.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// String that stores user input.
		int input = 0;
		
		try {
			// Get a choice from the user.
			input = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			input = 0;
			System.out.println("Input error. Error at UI, getInputInt()");
		}
		return input;
	}
	
	/**
	 * Method that gets a String input from the user.
	 * @return The String the user entered.
	 */
	private String getInputString()	{
		// String that stores user input.
		String input = "";
		// Construct a BufferedReader to be able to read input later on.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// Try to get a input from the reader, if there is a problem, print a
		// message into the console as notification.
		try	{
			input = reader.readLine();
		}	catch (IOException e)	{
			// Set a default value 
			input = "inputBrokePlsHelp";
			System.out.println("Input error. Error at UI, getInputString()");
		}   
		return input;
	}
	
	/**
	 * Searches the Teacher ArrayList for the teacher with the teacherID handed in
	 * and returns it.
	 * @param teachers ArraylList that is being searched
	 * @param teacherID ID that is being searched for.
	 * @return The teacher object with the 'teacherID' as 'teacherID'
	 */
	private Teacher getTeacherByID(ArrayList<Teacher> teachers, int teacherID)	{
		int index = 0;
			
		for (int i = 0; i < teachers.size(); i++)	{
			if ( teacherID == teachers.get(i).getTeacherID() )	{
				index = i;
				break;
			}
		}
		return teachers.get(index);
	}
	
	/**
	 * Searches the Grade ArrayList for the grade object with the same gradeID 
	 * as the one given to the method. Returns the single object once found.
	 * @param grades The ArrayList that is being searched through.
	 * @param gradeID The ID that is being searched for in the grades ArrayList.
	 * @return A single object that has the same gradeID as the one given to the
	 * 		   method.
	 */
	private Grade getGradeByID(ArrayList<Grade> grades, int gradeID)	{
		int index = 0;
			
		for (int i = 0; i < grades.size(); i++)	{
			if ( gradeID == grades.get(i).getGradeID() )	{
				index = i;
				break;
			}
		}
		return grades.get(index);
	}
	
	/**
	 * Counts the amount of students in the grade and returns the amount as int.
	 * @param grade The grade whose students are to be counted.
	 * @return The amount of students in 'grade' as int.
	 */
	private int getStudentCountInGrade(Grade grade) {
		int gradeSize = 0;
		// Count how many Students are in that Grade,
		for (int i = 0; i < grade.getStudents().size(); i++)	{
			gradeSize++;
		}
		// Return it.
		return gradeSize;
	}
	
	/**
	 * Search through the Subject ArrayList and return the one with the fitting ID.
	 * @param subjects The Subject ArrayList that is being searched through.
	 * @param subjectID The ID of the searched subject.
	 * @return The subject with the 'subjectID' as subjectID.
	 */
	private Subject getSubjectByID(ArrayList<Subject> subjects, int subjectID) {
		int index = 0;
		
		for (int i = 0; i < subjects.size(); i++)	{
			if ( subjectID == subjects.get(i).getSubjectID() )	{
				index = i;
				break;
			}
		}
		return subjects.get(index);
	}
	
	/**
	 * Returns the name of the Subject that the exam belongs to. 
	 * @param exam  The exam with the subjectID needed to identify the right subject
	 * @param subjects All of the subject objects. Is being searched for the subjectID contained in exam.
	 * @return The name of the subject belonging to the exam as string.
	 */
	private String getSubjectNameOfExam(Exam exam, ArrayList<Subject> subjects)	{
		UI ui = new UI();
		// Get the Subject wanted with the ID in the Exam object and the getSubjectByID method,
		// then use the getSubjectName method of the subject to get its name.
		return  ui.getSubjectByID(subjects, exam.getSubjectID()).getSubjectName();
	}

	/**
	 * Method that writes a string into two files. One has a specified ending, the
	 * other one always has the same appendix to achieve a single file that contains
	 * all the Strings that have been written into different files during one
	 * runtime.
	 * 
	 * @param fileName
	 * @param appendix
	 * @param content
	 */
	private void writeFile(String fileName, String appendix, String content) {
	
		try {
			// Write into a specific file.
			Files.write(Paths.get(fileName + appendix), (content + "\n").getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
			// Write into the version that is supposed to contain everything
			Files.write(Paths.get(fileName + "Complete.txt"), (content + "\n").getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Problem with file saving. writeFile();");
			e.printStackTrace();
		}
	}

	/**
	 * Prints the choices the user has in the console, gets and checks input and returns it
	 * @return A int between 0 and 2 that is used to determine the way of handling scores.
	 */
	private int chooseIfFillScore() {
		
		// Construct an UI object to be able to use its methods.
		UI ui = new UI();
	
		// User information
		System.out.println("Was möchten sie tun:\n");
		System.out.println("0: Voreingestellte Noten nutzen.");
		System.out.println("1: Noten selber eingeben.");
		System.out.println("2: Ohne Noten weitermachen.");
		
		// Stores the choice made.
		int scoreChoice = 0;
		
		// Run until a valid number has been entered.
		do {
			// Get an input
			scoreChoice = ui.getInputInt();
			
			// Give feedback if it was not viable.
			if (scoreChoice >= 3 || scoreChoice < 0) {
				System.out.println("Keine aktzeptable Eingabe. Bitter versuchen sie es noch einmal.");
			}
	
		} while ((scoreChoice != 0) && ((scoreChoice != 1) && (scoreChoice != 2)));
		
		// Return the choice.
		return scoreChoice;
	}

	/**
	 * Method that takes in a string array and a boolean and then returns the string
	 * with index 1 if bool = true and the string with index 0 if bool = false.
	 * 
	 * @param options The string array. Should be 2 big.
	 * @param state   The boolean.
	 * @return Either the string with index 0 or 1.
	 */
	private String booleanToStringFromArray(String[] options, Boolean state) {

		if (state == false) {
			return options[0];
		} else {
			return options[1];
		}
	}
}