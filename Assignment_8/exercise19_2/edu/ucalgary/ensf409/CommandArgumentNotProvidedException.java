package edu.ucalgary.ensf409;

class  CommandArgumentNotProvidedException extends Exception{
	public  CommandArgumentNotProvidedException() {
		super("No arguments were provided in the command line.");
	}
}
