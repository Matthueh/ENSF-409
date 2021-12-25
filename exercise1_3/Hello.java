
	/**
	@author  Matthew Ho <a href = "mailto:matthew.ho1@ucalgary.ca">
		matthew.ho1@ucalgary.ca</a>
	@version 1.3
	@since 1.0
	*/
	
	/*
	Hello is a simple example program which prints the classic message:
	Hello, world
	*/
public class Hello {
	/**
	This prints "Hello, world" to the terminal window. 
	@param args Optional command-line argument
	*/
	public static void main(String[] args) {
		boolean truth = true;
		char character = 'w';
		byte eightBit = 111;
		short smallInteger = 114;
		int integer = 108;
		long longerInteger = 100;
		float floatNum = 33;
		double doubleNum = floatNum; //this is an automatic cast as doubles are larger than floats
		
		System.out.println("Hello, " + character + (char)eightBit + (char)smallInteger + (char)integer +(char)longerInteger + (char)floatNum + (char)doubleNum + truth);
		/* this is several explicit casts as chars are smaller types than the ones listed above*/
	}
} //End of class declaration