package edu.ucalgary.ensf409;

public class StringProcessor{
    
    private final String storedString;
    /**
     * @param input handles the private storedString
     */
    public StringProcessor(String input){
        this.storedString = new String(input);
    }
    
	/**
	*	@param inputString handles the string parameter that gets added to the storedString
	*	@return combined is the final string that we return that contains lowercases and is flipped
	*/
    public String addTogetherMirror(String inputString) { 
    	String stored = this.storedString.stripLeading();
    	inputString = inputString.stripTrailing();
        String combined = stored + inputString;
        for(int i = 0; i < combined.length()/2 ; i++) {
        	combined = combined.substring(0, i) + combined.charAt(combined.length() - i - 1) + combined.substring(i+1,combined.length() -i -1) 
        	+ combined.charAt(i) + combined.substring(combined.length() - i, combined.length());
        }
		
		combined = combined.toLowerCase();
        System.out.println(combined);
        return combined;
    }
	/**
	*	@param firstName deals with the first name of the client.
	*	@param lastName deals with the last name of the client.
	*	@param petName deals with the petname.
	*	@param year deals with the year that the pet is born in.
	*	@return petID returns a string that contains information about the client, pet, and year it was born.
	*/
    public static String idProces(String firstName, String lastName, String petName, int year) {
       
    	if(firstName.charAt(0) < 65 || firstName.charAt(0)> 90 ) {
    		throw new IllegalArgumentException("The first name of the client must start with a capital letter.");
    	}    	
    	if(firstName.length() < 2 || firstName.length() > 26) {
    		throw new IllegalArgumentException("The first name of the client must be between 2 and 26 letters.");
    	}
    	if(lastName.charAt(0) < 65 || lastName.charAt(0) > 90 ) {
    		throw new IllegalArgumentException("The last name of the client must start with a capital letter.");
    	}
    	if(lastName.length() < 2 || lastName.length()>26 ) {
    		throw new IllegalArgumentException("The last name of the client must be between 2 and 26 letters.");
    	}
    	if(petName.charAt(0) < 65 || petName.charAt(0) > 90) {
    		throw new IllegalArgumentException("The pet name must start with a captial letter.");
    	}
    	if(petName.length() < 2 || petName.length() > 26) {
    		throw new IllegalArgumentException("The pet name must be between 2 and 26 letters.");
    	}
    	if(year > 2021) {
    		throw new IllegalArgumentException("The identifier can not be provided if the year is after 2021.");
    	}
    	
        String petID = new String(String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0)) + String.valueOf(petName.charAt(0)) + String.valueOf(year));
        return petID;
    }
	/**	@param offset deals with the off set to create a secretCode.
	*	@return encodedString returns a code of what the original string is.
	*/
    public String secretCode(int offset) {

        String encodedString = new String();
        
        for (int i = 0; i < storedString.length(); i++){
            int newUnicode = storedString.charAt(i) + offset%26;
            if((storedString.charAt(i) >= 65 && storedString.charAt(i) <= 90) && newUnicode > 90) {
            	newUnicode = 65 + (newUnicode - 90 - 1);
            }
            else if((storedString.charAt(i) >= 97 && storedString.charAt(i) <= 122) && newUnicode > 122) {
            	newUnicode = 97 + (newUnicode - 122 - 1);
            }
            else if( (storedString.charAt(i) > 90 && storedString.charAt(i) < 97) || (storedString.charAt(i) < 65) || (storedString.charAt(i) > 122) ) {
            	newUnicode = storedString.charAt(i);
            }
        	encodedString = encodedString + (char)newUnicode;
        }
        System.out.println(encodedString);
        return encodedString;
    }
 
	/**	@return this is a getter method.
	*
	*/
    public String getStoredString(){
        return this.storedString;
    }
	/**
	*	@param deals with the args in command line.
	*/
	public static void main(String [] args){
	}

}
