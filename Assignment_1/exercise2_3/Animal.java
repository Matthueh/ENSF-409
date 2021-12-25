
	/** 
	@author Matthew Ho <a href = "mailto:matthew.ho1@ucalgary.ca">
		matthew.ho1@ucalgary.ca</a>
	@version 1.0
	@since 1.0
	*/
	
public class Animal {
	
	private String color;
	private int legs;
	
	/** @param str Handles the color argument.
	 *  @param n Handles the number of legs argument.
	*/ 

	public Animal(String str, int n){ 
		this.color = str;
		this.legs = n;
	}
	
	/** @param str handles the color argument.*/
	
	public Animal(String str){
		this.color = str;
		this.legs = 0;
	}
	
	/**@return legs returns the amount of legs the Animal object has.*/ 
	
	public int getLegs(){
		return this.legs;
	}
	
	/**@param n sets the amount of legs the animal object has. */
	
	public void setLegs(int n){
		this.legs = n;
	}
	
	/**@return color returns the color of the animal.*/
	
	public String getColor(){
		return this.color;
	}
	
	/** @param str sets the color of the object being created.*/
	
	public void setColor(String str){
		this.color = str;
	}
	
	/**
	@param args Handles command-line argument
	*/
	
	public static void main(String[] args){
		Animal myAnimal = new Animal("Blue");
		myAnimal.setColor("Yellow");
		System.out.println("The color of the animal is: " + myAnimal.getColor());
		myAnimal.setLegs(4);
		System.out.println("The number of legs the animal has is: " + myAnimal.getLegs());
	}
}
	
	
