package edu.ucalgary.ensf409;

class ArgFileNotFoundException extends Exception{
	public  ArgFileNotFoundException() {
		super("The argument file that was found in the command line cannot be found.");
	}
}