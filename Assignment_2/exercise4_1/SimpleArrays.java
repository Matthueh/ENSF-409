/** 
	@author Matthew Ho <a href = "mailto:matthew.ho1@ucalgary.ca">
		matthew.ho1@ucalgary.ca</a>
	@version 1.0
	@since 1.0
	*/


import java.util.Arrays;

public class SimpleArrays{ 
	
	//This is the array containing a maximum of 4 
	private String[] multiStringArray = new String[4];
	//This is the length of the array
	private int length;
	//We will be returning a full string. This just makes it much clearer on what exactly we are returning.
	private String final_String;
	
	//This is a constructor when there is one argument.
	/** @param str is an array that contains four strings that we will use for all methods in the program. */

	public SimpleArrays(String str){ 
		length = 4;
		Arrays.fill(multiStringArray, str);
		final_String = "";
	}
	
	//This is an overloaded constructor when there are no arguments.
	public SimpleArrays(){ 
		length = 4;
		final_String = "";
		Arrays.fill(multiStringArray, "Hello,ENSF 409");
		
	}
	
	//When the user enters in an index, this will concat from index 0 to whatever the index arguement is.
	//This will return one very large string containing values that are in.
	/**@param index is an integer value in which we will concatenate to, from the index 0.
	*  @return arrayCrop(0, index) returns a string after calling the function arrayCrop. arrayCrop will return a
	*   string and was used for code reusability.
	*/
	public String arrayConcat(int index){ //
		
		final_String = "";
		if( index > length || index < 0 ){
			System.out.println("IndexOutofBoundsException error");
		}
		
		return arrayCrop(0, index);
	}
	
	//Overloaded method when the user does not enter an argument in.
	//By Default this will return whatever is in the array at index 0.
	/** @return multiStringArray[0] this will by default, return string in the index of 0 if the user does not enter an argument. */
	public String arrayConcat(){  
		return multiStringArray[0];
	}
	
	//This method contains two arguments, the starting index and the ending index which will concatenate the elements
	//of the array in between the starting indices to the ending indices.
	//This will return a final string of the concatenated indices listed in the comment above.
	/** @param start_ind This will handle the starting indices on wherever on the array the user wants to start the concatenation.
	*   @param end_ind This will handle the ending indices on whereever on the array the user wants to end the concatenation.
	*   @return final_String This is one large string seperated by a # and will contain everything inbetween start_ind and end_ind.
	*			"Fail" This value will be returned if either of the parameter indices is it out of range of the index of the array.
	*           "Match" This value will be returned if both the parameter indices are equal to each other.
	*/
	public String arrayCrop(int start_ind, int end_ind){
		
		final_String = "";
		
		if( start_ind > end_ind){
			int temp = start_ind;
			start_ind = end_ind;
			end_ind = temp;
		}
		
		if(start_ind > length || end_ind > length || 
		    end_ind < 0 || start_ind < 0){
				return "Fail";				
		}
		
		if(start_ind == end_ind){
			return "Match";
		}
		int i;
		
		for(i = start_ind; i < end_ind; i++){
			final_String = final_String.concat(multiStringArray[i]).concat("#");
		}
		final_String = final_String.concat(multiStringArray[i]);
		return final_String;
	}

	//This will contain some testing in order to see if the program is working or not.
	/**
	@param args Handles command-line argument
	*/
	public static void main(String args[]){
	

		SimpleArrays new_array = new SimpleArrays("four");
		System.out.println(new_array.arrayConcat(5));
		System.out.println(new_array.arrayCrop(2,3));
	}		
	
}