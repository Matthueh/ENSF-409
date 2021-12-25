/** 
	@author Matthew Ho <a href = "mailto:matthew.ho1@ucalgary.ca">
		matthew.ho1@ucalgary.ca</a>
	@version 1.0
	@since 1.0
	*/

public class JavaStrings{
	
	//This will help make it slightly more clear to what exactly we are returning.
	String str_final = "";
	
	//This function will be discarding the white spaces that are on the outside of both the string arguments.
	//it will then take both the strings and add them together. It will then take the length of the new string.
	/** @param str_one This will be one of the two string arguments that we will be trimming white spaces off the 
	*	               sides and apending to the end of the second string.
	*	@param str_two This will be another one of the two string aruments that we will be trimming white spaces off
	*					the sides and appending to the end of the first string.
	*	@return str_final.length() This will return the number of characters in both of the trimmed arguments.
	*/
	public int addTogether(String str_one, String str_two){
		
		while(str_one.charAt(0) == ' '){
			str_one = str_one.substring(1);
		}
		
		while(str_one.charAt(str_one.length() - 1) == ' '){
			str_one = str_one.substring(0, str_one.length() - 1);
		}
		
		while(str_two.charAt(0) == ' '){
			str_two = str_two.substring(1);
		}
		
		while(str_two.charAt(str_two.length() - 1) == ' '){
			str_two = str_two.substring(0, str_two.length() - 1);
		}

		str_final = str_one + str_two;
		
		return str_final.length();
	
	}
	
	//This function will take in 4 arguments, 3 of the arguments are strings that we will be only needing the first character of.
	//We will then append the first character of the strings with the year and return it as a string.
	/** @param first_name This will take in the first name of the client and then take its first character.
	*   @param last_name This will take in the last name of the client and then take its first character.
	*   @param pet_name This will take in the name of the pet and then take its first character.
	*   @param year This will take in the year to which the pet was born. Convert it into a string and then append it to the end.
	*	@return str This will return a String in which contains the first character of all the strings in their respective 
	*               order and append it to the front of the birth year of the pet.
	*/
	public String idProcessing(String first_name, String last_name, 
		String pet_name, int year){
		
		str_final = "";
		
		str_final = str_final + first_name.charAt(0) + last_name.charAt(0) + pet_name.charAt(0) + String.valueOf(year);
		
		return str_final;
		
	}
	//This function will take in a string and replace all the vowels within the string with a letter z. It will then return this
	//value as a substring containing the first three characters of the original string.
	/** @param str This will be the string argument that the user will enter in.
	*   @return str This will be a substring with 3 characters of the original argument in which the vowels are all replaced with the character z.
	*/
	public String secretCode(String str){
		

		if(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || 
			str.charAt(0) == 'o' || str.charAt(0) == 'u'){
				str = "z" + str.substring(1);
		}
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
				str.charAt(i) == 'o' || str.charAt(i) == 'u'){ 
					str = str.substring(0, i) + "z" + str.substring(i + 1);
			}				
		}

		str = str.substring(0,3);
		return str;
	}
	
	//This is used for testing the program.
	/**
	@param args Handles command-line argument
	*/
	public static void main(String [] args){
		JavaStrings strings = new JavaStrings();
		System.out.println(strings.secretCode("orange"));
		System.out.println(strings.idProcessing("Matthew", "Ho", "Sit", 2000));
		System.out.println(strings.addTogether("  Matthew   ", " Ho   "));
		
	}
}