package edu.ucalgary.ensf409;

import java.sql.*;

public class Registration {
	public final String DBURL;
	public final String USERNAME;
	public final String PASSWORD;
	
	private Connection dbConnect;
	private ResultSet results;
	
	
	/**
	 * Registration is a constructor that will be used for this specific path.
	 * @param dbUrl This handles the pathway specified in order to access the data base.
	 * @param username This handles the username you use to log into SQL.
	 * @param password This handles the password you use to log into SQL.
	 */
	public Registration(String dbUrl, String username, String password) {
		this.DBURL = dbUrl;
		this.USERNAME = username;
		this.PASSWORD = password;
	}
	/**
	 * getDBURL is a getter function.
	 * @return this.DBURL is what is returned from a getter function that will return the pathway specified for the table that we are interested.
	 */
	public String getDBURL() {
		return this.DBURL;
	}
	/**
	 * getUSERNAME is a getter function.
	 * @return this.USERNAME is what is returned from a getter function that will return the username of the SQL user.
	 */
	public String getUSERNAME() {
		return this.USERNAME;
	}
	/**
	 * getPASSWORD is a getter function.
	 * @return this.PASSWORD is what is returned from a getter function taht will return the password of the SQL user.
	 */
	public String getPASSWORD() {
		return this.PASSWORD;
	}
	/**
	 *  initializeConnection method will connect with SQL and to the table that will be manipulating.
	 */
	public void initializeConnection() { //this should be good to go
		try {
			dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * selectAllNames will take in the name of the table and return all of the first and last names of the people that are in the table within the database.
	 * @param tableName This handles the argument of which table from the list located in the database to pull values from.
	 * @return allNames This will return a String containing all the names of either the competitors or the teachers located in the database of interest.
	 */
	public String selectAllNames(String tableName) { //this should return a string with whatever is under first name and last name
		
		StringBuffer tableNames = new StringBuffer(); //This allows you to manipulate the string.
		String allNames = "";
		try {
			Statement myStmt = dbConnect.createStatement();
			results = myStmt.executeQuery("SELECT * FROM " + tableName);
			
			//System.out.println("Print results from select all names:\n");
			while(results.next()) {
				//System.out.println(results.getString("LName") + ", " + results.getString("FName") + "\n");
				
				tableNames.append(results.getString("LName") + ", " + results.getString("FName") + "\n");	
			}
			
			myStmt.close();
			allNames = tableNames.toString().trim();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allNames;
	}
	/**
	 * showStudios will show all the names of the studios that exist within table studios in the database.
	 * @return studio is a string that contains the list of studio names that are located within the database.
	 */
	
	public String showStudios() {
		StringBuffer studioNames = new StringBuffer();
		String studio = "";
		try {
			Statement myStmt = dbConnect.createStatement();
			results = myStmt.executeQuery("SELECT * FROM studio");
			
			//System.out.println("Print results from studios:\n");
			while(results.next()) {
				//System.out.println(results.getString("Name"));
				
				studioNames.append(results.getString("Name")+ "\n");
			}
			myStmt.close();
			studio = studioNames.toString().trim();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return studio;
	}
	
	/**
	 * insertNewCompetitor method will take in 6 arguments and add them to the competitor table within the data base if the competitor does not yet exist.
	 * it will also check to see whether the teacher is located in the data base or not. If the teacher is not in the data base the will throw an 
	 * IllegalArgumentException. It will also throw an IllegalArgumentException if the child is not in between 5 and 18.
	 * @param CompetitorID This argument handles the CompetitorID which is a 3 digit string that will be added to the competitor table in the data base.
	 * @param LName This argument handles the Last name of the competitor which will be added to the competitor table in the data base.
	 * @param FName This argument handles the First name of the competitor which will be added to the competitor table in the data base.
	 * @param Age This argument handles the Age of the competitor which will be added to the competitor table in the data base.
	 * @param Instrument This argument handles what type of instrument will be added to the competitor table in the data base.
	 * @param TeacherID This argument handles what teacher each of the students will have and will be added to the competitor table in the data base.
	 */
	public void insertNewCompetitor(String CompetitorID, String LName, String FName, int Age, String Instrument, String TeacherID) {
		
		try {
			boolean isThereATeacher = false;
			Statement myStmtChecker = dbConnect.createStatement();
			results = myStmtChecker.executeQuery("SELECT * FROM teacher");
			
			while(results.next()) {
				if(results.getString("TeacherID").equals(TeacherID)) {
					isThereATeacher = true;
					break;
				}
			}
			
			if(!isThereATeacher) {
				throw new IllegalArgumentException("There is no teacher available with that given ID number.");
			}
			
			if(Age <= 5 || Age >= 18) {
				throw new IllegalArgumentException("The age of the competitor is not a valid age.");
			}
			
			myStmtChecker.close();
			
			String query = "INSERT INTO competitor (CompetitorID, LName, FName, Age, Instrument, TeacherID) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1, CompetitorID);
			myStmt.setString(2, LName);
			myStmt.setString(3, FName);
			myStmt.setInt(4, Age);
			myStmt.setString(5, Instrument);
			myStmt.setString(6, TeacherID);
			
			int rowCount = myStmt.executeUpdate();
			//System.out.println("Rows affected: " + rowCount);
			myStmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * deleteCompetitor Method will take in the parameter CompetitorID, if it matches to any of the competitor id's that are located within the competitor table
	 * within the data base. If it finds a competitor id that matches one in the table, it will delete the competitor id in the data base.
	 * @param CompetitorID This will take in the competitorID and compare it to the competitor id's that are located in the competitor table within the database.
	 */
	
	public void deleteCompetitor(String CompetitorID) {
		try {
			String query = "DELETE FROM competitor WHERE CompetitorID = ?";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1, CompetitorID);
			int rowCount = myStmt.executeUpdate();
			//System.out.println("Rows that were affected: " + rowCount);
			
			myStmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * registerNewTeacher Method will take in 7 parameters, it will then check whether the studio exists or not. If it does not exists then it will create a studio
	 * in the table studio within the database and then assign it to the new teacher. If the studio already exists then it will just assign the teacher to the teacher
	 * table within the database.
	 * @param TeacherID this will handle the teacherID and will assign a teacherID to the teacher table within the data base.
	 * @param LName this will handle the last name of the teacher and will assign a last name to the teacher table within the data base.
	 * @param FName this will handle the first name of the teacher and will assign a first name to the teacher table within the data base.
	 * @param Phone this will handle the Phone number of the teacher and will assign a phone number to the teacher table within the data base.
	 * @param StudioName this will handle the StudioName of the teacher and the studio, if the studio doesn't exist then it will add a new studio to the studio
	 * table and then add the studio to the teacher table within the database.
	 * @param studioPhoneNumber this will handle the studio phone number and will assign a studioPhoneNumber to the studio table within the database if the studio doesn't exist.
	 * @param Address this will handle the studio address and will assign a studioPhoneNumber to the studio table within the database if the studio doesn't exist.
	 */
	public void registerNewTeacher(String TeacherID, String LName, String FName, String Phone, 
									String StudioName, String studioPhoneNumber, String Address) {
		try {
			boolean isThereATeacherAlready = false;

			Statement myStmtChecker = dbConnect.createStatement();
			results = myStmtChecker.executeQuery("SELECT * FROM teacher");
			
			while(results.next()) {
				if(results.getString("TeacherID").equals(TeacherID)) {
					isThereATeacherAlready = true;
					break;
				}
			}
			if(isThereATeacherAlready) {
				throw new IllegalArgumentException("This teacher already exists.");
			}
			
			myStmtChecker.close();
			
			boolean isThereAStudioAlready = false;
			
			myStmtChecker = dbConnect.createStatement();
			results = myStmtChecker.executeQuery("SELECT * FROM studio");
			
			while(results.next()) {
				if(results.getString("Name").equals(StudioName)) {
					isThereAStudioAlready = true;
					break;
				}
			}
			if(!isThereAStudioAlready) {
				String queryOne = "INSERT INTO studio (Name, Phone, Address) VALUES(?, ?, ?)";
				PreparedStatement myStmtStud = dbConnect.prepareStatement(queryOne);
				myStmtStud.setString(1, StudioName);
				myStmtStud.setString(2, studioPhoneNumber);
				myStmtStud.setString(3, Address);
				int rowCountOne = myStmtStud.executeUpdate();
				//System.out.println("Amount of rows updated: " + rowCountOne);
				myStmtStud.close();
			}
			myStmtChecker.close();
			
			String query = "INSERT INTO teacher (TeacherID, LName, FName, Phone, StudioName) VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);

			
			myStmt.setString(1, TeacherID);
			myStmt.setString(2, LName);
			myStmt.setString(3, FName);
			myStmt.setString(4, Phone);
			myStmt.setString(5, StudioName);

			int rowCount = myStmt.executeUpdate();
			//System.out.println("Amount of teacher rows updated: " + rowCount);
			myStmt.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * deleteTeacher Method will take a TeacherID and delete the teacher with the same TeacherID from the teacher database if the teacher exists.
	 * @param TeacherID This parameter will be a Teacher ID that the method will search for in order to delete it from the teacher table if the teacher exists in the data base.
	 */
	public void deleteTeacher(String TeacherID) {
		try {
			String query = "DELETE FROM teacher WHERE TeacherID =?";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1,  TeacherID);
			int rowCount = myStmt.executeUpdate();
			//System.out.println("Rows that were affected: " + rowCount);
			
			myStmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will be used for testing.
	 * @param args will handle the command line arguments if there are any.
	 */
	public static void main(String args []) {
		Registration myReg = new Registration("jdbc:mysql://localhost/competition" ,"matthew", "ensf409");
		myReg.initializeConnection();
		System.out.println(myReg.selectAllNames("competitor"));
		System.out.println(myReg.selectAllNames("teacher"));
		System.out.println(myReg.showStudios());
		myReg.insertNewCompetitor("123", "Smyth", "Ali", 15, "Oboe", "0023");
	    myReg.registerNewTeacher("0987", "Marasco", "Emily", "403-222-5656", "Marasco Music", "587-222-5656", "123 Main Street NW");        
	    myReg.deleteCompetitor("123");
	    myReg.deleteTeacher("0987");
	}
	
	
}
