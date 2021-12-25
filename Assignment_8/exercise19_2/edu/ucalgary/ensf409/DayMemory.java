package edu.ucalgary.ensf409;
import java.io.*;
import java.util.Scanner;

public class DayMemory {
	/**
	 * 
	 * @param args handles the command line arguments
	 * @throws Exception 
	 */
	public static void main(String [] args) throws Exception{
		if(args.length == 0) {
			throw new CommandArgumentNotProvidedException();
		}
		else {
			Translator trans = new Translator(args[0]);
			System.out.println(trans.translate(3,8,2021));
		}

	}

}

