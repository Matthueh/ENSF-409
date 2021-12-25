package edu.ucalgary.ensf409;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.Scanner;
import java.io.File;

public class Translator {
	
	private String REGEX = "([a-zA-Z]{2}\\-[a-zA-Z]{2})";
	private Pattern PATTERN = Pattern.compile(REGEX);
	private Scanner input;
	private File inFile;
	private String nameOfFile = "";
	private String translated = "";
	private TranslationText translation = null;
	
	/**
	 * 
	 * @param  langCode this handles the text file names
	 * @throws IOException this handles input exceptions
	 * @throws ClassNotFoundException this makes sure that if the class is not found then it will return an error
	 * @throws ArgFileNotFoundException 
	 */
	
	public Translator(String langCode) throws IOException, ClassNotFoundException, ArgFileNotFoundException { //this should be good to go
		//nameOfFile = langCode; //this creates a place for the name of the file to be stored.
		this.nameOfFile = langCode;
		this.inFile = new File(langCode);
		this.input = new Scanner(inFile, "UTF-8");
		
		Matcher isMatching = PATTERN.matcher(langCode);	//this will check whether it is in the right format.
		if(isMatching.find()) {							//this will check whether it is in the right format.
			importTranslation(); //this calls import translation.	
		}
		else {
			throw new IllegalArgumentException("This two-letter language code, dash, and two-letter region code is not in the correct format.");
		}	
	}

	/**
	 * 
	 * @return translated string as a getter method.
	 */

	
	public String getTranslation(){ //this should be good to go
		return this.translated;
	}	
	
	/**
	 * 
	 * @param monthNum deals with the month number.
	 * @param dayNum deals with the day number.
	 * @param year deals with the year.
	 * @return a formatted string illustrating the month, day and year.
	 */
	
	public String translate(int monthNum, int dayNum, int year) { //this should be good to go
		
		if(monthNum > 12 || monthNum < 0 ) {
			throw new IllegalArgumentException("The month needs to be between the values of 0 and 12.");
		}
		
		if( dayNum < 0 || dayNum > 31) {
			throw new IllegalArgumentException("The day needs to be between the values of 0 and 31.");
		}
		
		String translatedString = "";
		String month = "";
		String day = "";
		String yearNeeded = String.valueOf(year);
		String dayRegex = "\\%[1]{1}\\$[s]{1}";
		String monthRegex = "\\%[2]{1}\\$[s]{1}";
		String yearRegex = "\\%[3]{1}\\$[d]{1}";


		month = this.translation.months[monthNum - 1];
		day = this.translation.days[dayNum - 1];
		translatedString = this.translation.sentence;

		
		translatedString = translatedString.replaceAll(dayRegex, day);
		translatedString = translatedString.replaceAll(monthRegex, month);
		translatedString = translatedString.replaceAll(yearRegex, yearNeeded);
		this.translated = translatedString;
		return translatedString;
	}
	
	
	/**
	 * 
	 * @throws FileNotFoundException Makes sure that the file is found, if not it will return an error.
	 * @throws IOException makes sure that the Input and output files are found. If not it will throw an error.
	 * @throws ClassNotFoundException makes sure that the class is real. If not it will throw an error.
	 * @throws ArgFileNotFoundException 
	 */
	
	private void importTranslation() throws FileNotFoundException, IOException, ClassNotFoundException, ArgFileNotFoundException { 
		//This will call deserialize if the file is an ser file.
		//This will call serialize if the file is a txt file.
		if(this.inFile.exists() && this.nameOfFile.contains(".ser")) {
			deserialize();
		}
		else {
			importFromText();
		}
		
	}
	
	/**
	 * 
	 * @throws FileNotFoundException will throw an error if the file is not available to the users.
	 * @throws ArgFileNotFoundException 
	 */
	
	public void importFromText() throws FileNotFoundException, ArgFileNotFoundException { //this should be good to go
		
		if(this.inFile == null) {
			throw new ArgFileNotFoundException();
		}
		
		String [] months = new String[12];
		String [] days = new String[31];
		String sentence = "";
		
		for(int i = 0; i < 12; i++) {
			months[i] = input.nextLine();
			//System.out.println(months[i]); //this checks if months have been properly filled up.
		}
		for(int i = 0; i < 31; i++) {
			days[i] = input.nextLine();
			//System.out.println(days[i]); //this checks if days have been properly filled up.
		}
		sentence = input.nextLine();
		//System.out.println(sentence); //this checks if sentence has been properly filled up.
		
		translation = new TranslationText(months, days, sentence); //instantiates a new object;
		
		
	}
	
	/**
	 * 
	 * @throws FileNotFoundException will throw an error if the file is not available to the users.
	 * @throws IOException will throw an error if the input file and output file are not found.
	 */
	
	public void serialize() throws FileNotFoundException, IOException {
		this.nameOfFile = this.nameOfFile.replaceAll("(\\.[t]{1}[x]{1}[t]{1})", ".ser");
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream(new File(nameOfFile)));
		}
		
		catch(IOException e) {
			System.err.println("Error opening file");
			System.exit(1);
		}
		try {
			output.writeObject(this.translation); //must be an object in here or it just doesn't work
		}
		
		catch(Exception e) {
			System.err.println("Generic error handler");
			e.printStackTrace();
		}
		finally {
			try {
					if(output != null) {
						output.close();
					}
			}
			catch(IOException e){
				System.err.println("Error closing file.");
				System.exit(1);
			}
		}

	}
	
		/**
		 * 
		 * @throws FileNotFoundException will throw an error if the file is not found.
		 * @throws IOException will throw an error if the input file or the output file is not found. 
		 * @throws ClassNotFoundException will throw an error if the class is not found.
		 */
	
	
	public void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		//Needs to read the object as a serialized file
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(new FileInputStream(nameOfFile));
		}
		catch(IOException e) {
			System.err.println("Error openign file");
			System.exit(1);
		}
		try {
			translation  = (TranslationText) input.readObject();
		}
		catch(IOException e) {
			System.err.println("Generic error handler");
			e.printStackTrace();
		}
		finally {
			try {
					if(input != null) {
						input.close();
					}
			}
			catch(IOException e) {
				System.err.println("Error closing file.");
				System.exit(1);;
			}
		}
		
	}
}

