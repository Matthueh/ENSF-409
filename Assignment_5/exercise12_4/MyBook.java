/** 
	@author Matthew Ho <a href = "mailto:matthew.ho1@ucalgary.ca">
		matthew.ho1@ucalgary.ca</a>
	@version 1.0
	@since 1.0
	*/

public class MyBook{
	
	/**	@param args can be used for testing the class.
	*	main function can be used to test all the classes.
	*/
	
	public static void main(String [] args){

	}
	
}

/** Class Book is abstract and can not be called. It contains a string which has an isbn, the publication year which is an integer
*	and it also has a publication year which is as well, an integer.
*/

abstract class Book{
	private String isbn;      
	private int publicationYear;
	private int pages;
	
	/** @param isbn is a String that will be used as part of the arguments of the constructor.
	*	@param pages is a String that will be used as part of the arguments of the constructor.
	*	This is a constructor in book.
	*/
	public Book(String isbn, int pages){
		setIsbn(isbn);
		setPages(pages);
		setPublicationYear(0);
	}
	
	/** This is a default constructor that will be used in book.
	*/
	public Book(){
		setIsbn("");
		setPages(0);
		setPublicationYear(0);
	}
	
	/** @param isbn will be used as an argument that will then be used by the setter method.
	*	setIsbn will then be used as a setter method that can then be used by the constructors to set the isbn.
	*/		
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	/**	@param year will be used as an argument that will then be used by the setter method.
	*	setPublicationYear will then be used as a setter method that can then be used by the constructors to set the  publication year.
	*/
	public void setPublicationYear(int year){
		this.publicationYear = publicationYear;
	}
	/** @param pages will be used as an argument that will then be used by the setter method.
	*	setPages will then be used as a setter method that can then be used by the constructors to set the pages.	
	*/
	public void setPages(int pages){
		this.pages = pages;
	}
	/**	getIsbn will be used as a getter method to get isbn.
	*	@return this method will then be used to return isbn as a string.
	*/
	public String getIsbn(){
		return this.isbn;
	}
	
	/** getPublicationYear will be used as a getter method to get Publication Year.
	*	@return this method will then return Publication Year as an integer
	*/
	public int getPublicationYear(){
		return this.publicationYear;
	}
	
	/** getPages will be used as a getter method to get the number of pages.
	*	@return this method will then return the number of pages as an integer.
	*/
	public int getPages(){
		return this.pages;
	}
}

/** Hardcover is an abstract and extended class of Book.
* 	It describes the characteristics of Book.
*/
abstract class Hardcover extends Book{
	
	/** Binding is method that that does not return anything or take any parameters.
	** 	It will print out a message.
	*/
	abstract public void binding();
}

/**	Classic is a class that is an extention of Hardcover.
*	It describes the characteristics of the book as well.
*	It contains 3 locals which include the original publication year,
*	the author, and the publisher. The author and the publisher are arrays due
*	their cardinality.
*/

class Classic extends Hardcover{
	private int origPubYear = 1860;
	private Author [] theAuthor;
	private Publisher [] bookPublisher; 
	
	/**	@param this.origPubYear is an integer arguement used in this setter method to set origPubYear.
	*/
	public void setOrigPubYear(int origPubYear){
		this.origPubYear = origPubYear;
	}
	
	/** @return this.origPubYear is an integer that gets returned by this getter method.
	*/
	
	public int getOrigPubYear(){
		return this.origPubYear;
	}
	
	/**	@param theAuthor is a parameter that will be used to set the authors in the setter method 
	*/

	public void setTheAuthor(Author [] theAuthor){ // this is a shallow copy
		this.theAuthor = new Author[10];
		for(int i = 0; i < 10; i++){
			this.theAuthor[i] = theAuthor[i];
		}
	}
	
	/**	@return this.theAuthor is a parameter that will be used to set the authors in the local theAuthors.
	*/
	public Author [] getTheAuthor(){
		return this.theAuthor;
	}
	
	/** @param bookPublisher is a parameter that will be used to set the publishers in the local bookPublishers
	*/
	public void setPublisher(Publisher [] bookPublisher){ //this is also a shallow copy
		this.bookPublisher = new Publisher[10];
		if(bookPublisher[0] == null){ //1...*
			return;
		}
		else{
			for( int i = 0; i < 10; i++){	
				this.bookPublisher[i] = bookPublisher[i];
			}
		}
	}
	
	/** @return this.bookPublisher, this method will be used to get bookPublisher
	*/
	public Publisher[] getPublisher(){
		return this.bookPublisher;
	}
	
	/** This method returns the String indicating that it has been executed
	*/
	public String createNotes(){
		return "Method createNotes called from Classic";
	}
	
	/** This method prints a message indicating that it is working
	*/
	
	public void binding(){
		System.out.println("Method binding called from Classic");
	}
}

/** Publisher class will be used to characterize the publishers.
*	It contains a variable known as a name, which is a string. It also contains
*	address which is a string. And it also contains the classics Catalog which is 
*	an array of classic objects.
*/


class Publisher{ 
	private String name;  				//Each publisher will have a name
	private String address;				//Each publisher will have an address
	private Classic[] classicsCatalog; 	//Each publisher will have a series of classic catalogs
	
	/** This is a constructor.
	*/
	public Publisher(String name, String address){
		setName(name);
		setAddress(address);
	}
	/** @param name Sets the name for the publisher.
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/** @param address Sets the address for the publisher.
	*/
	
	public void setAddress(String address){
		this.address = address;
	}
	
	/**	@param classicsCatalog contains a catalog of classics that the publisher published.
	*/
	
	public void setClassicsCatalog(Classic [] classicsCatalog){
		this.classicsCatalog = new Classic[10];
		for(int i = 0; i < 10; i++){
			this.classicsCatalog[i] = classicsCatalog[i];
		}
	}
	
	/**	@return this.classicsCatalog returns the classic catalog that the publisheer produced.
	*/
	public Classic [] getClassicsCatalog(){
		return this.classicsCatalog;
	}
	/** @return this.name which is the name of the publisher.
	*/
	public String getName(){
		return this.name;
	}
	/** @return this.address which is the adress to which the publisher is located.
	*/
	
	public String getAddress(){
		return this.address;
	}
	
	/** @return String will be returned by this method. No further instructions are given.
	*/
	public String printLetterhead(){
		return "Method printLetterhead called from Publisher";
	}	
}

/** class Author has three variables. The name of the author, the address of the author, and the age of the author.
*	This class is an embodiment of an author.
*/

class Author{
	private String name = "Unknown";	//Every Author has a name
	private String address;				//Every Author has a address
	private int age;					//Every Author has a age
	
	/** This is a constructor for the class Author.
	* @param name will take in the name of the author
	* @param address will take in the address of the author
	* @param age will take in the age of the author
	*/
	public Author(String name, String address, int age){
		setName(name);
		setAddress(address);
		setAge(age);
	}
	/** This is a default constructor that takes in no arguments.
	*/
	
	public Author(){
		setName("Unknown");
		setAddress("Unknown");
		setAge(0);
	}
	
	/** @param name will set the name of Author
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**	@param address will set the address of the author
	*/
	public void setAddress(String address){
		this.address = address;
	}
	/**	@param age will take in the age of the author
	*/
	public void setAge(int age){
		this.age = age;
	}
	/**	@return this.name will return the name of the author
	*/
	public String getName(){
		return this.name;
	}
	/** @return this.address will return the address of the author
	*/
	public String getAddress(){
		return this.address;
	}
	/**@return this.age will return the address of the author
	*/
	public int getAge(){
		return this.age;
	}
	
	/** @return String will return a string indicating that it has been executed.
	*/
	public String write(){
		return "Method write called from Author";
	}
}

/**	class Contract contains three variables. The date the contract was issued, the publishers info, and the authors Info.
*	This is an optional class that can be implemented.
*/

class Contract{
	private String date;				//The contract needs a date	
	private Publisher publisherInfo;	//The contract needs the publishers info
	private Author [] authorInfo;		//The contract needs the authors or author info
	
	/** There is one constructor for this class.
	*	@param date will need to set the date for the contract
	*	@param publisherInfo will be the publisher information
	*	@param authorInfo will be the authors information
	*/	
	public Contract(String date, Publisher publisherInfo, Author [] authorInfo){
		setDate(date);
		setPublisher(publisherInfo);
		setAuthor(authorInfo);
	}
	/**	@param date will set the date of the contract
	*/
	public void setDate(String date){
		this.date = date;
	}
	/**@return this.date will return the date of the contract
	*/
	public String getDate(){
		return this.date;
	}
	/**@param publisherInfo will set the publisherInfo into the object
	*/
	public void setPublisher(Publisher publisherInfo){
		this.publisherInfo = publisherInfo;
	}
	/**@return this.publisherInfo will get the publishers info issued in the contract
	*/
	public Publisher getPublisherInfo(){
		return this.publisherInfo;
	}
	/**@param authorInfo this will set the author or authors info
	*/
	public void setAuthor(Author [] authorInfo){
		this.authorInfo = authorInfo;
	}
	/**@return this.authorInfo this will return the authors info
	*/
	public Author [] getAuthorInfo(){
		return authorInfo;
	}
	
	/**@return String will return a string indicating that it has been executed.
	*/
	public String printContract(){
		return "Method printContract called from Contract"; 
	}
	
}

/**	The class story is a class that holds the story that the authors wrote.
*/

class Story{
	private Author [] theAuthor; //A story always needs an author.
	/**@return String will return a string indicating that it has been executed.
	*/
	public String plot(){
		return "Method plot called from Story";
	}
	
	/** @param theAuthor will set the authors into an array depending on how many wrote the story.
	*/
	public void setTheAuthor(Author [] theAuthor){
		this.theAuthor = new Author[10];
		if( theAuthor[0] == null){
			System.out.println("\nThere are no authors to this story");
			return;
		}
		else{
			for(int i = 0; i < 10; i++){
				this.theAuthor = theAuthor;
			}
		}
	}
	/**@return this.theAuthor will return the author or authors resposible in writing the novel.
	*/
	public Author [] getTheAuthor(){ //you can get the whole list of authors
		return this.theAuthor;
	}
	
}

/** This an abstract class used to classify a paperback.
*/

abstract class Paperback extends Book{
	/** 
	*	@return String will return a a string the indicates if the function has been executed.
	*/
	public String coverArt(){
		return "Method coverArt called from Paperback";
	}
}

/** This is a nonfiction class that is an extention of the class Paperback.
*/

class Nonfiction extends Paperback{
	
	private Category deweyClassification; //local variable used as a classification of a story.
	
	/** @param deweyClassification will set this.deweyClassification 
	*/
	
	public void setDeweyClassification(Category deweyClassification){
		this.deweyClassification = deweyClassification;
	}
	
	/**	@return this.deweyClassification will return the deweyClassification*/
	public Category getDeweyClassification(){
		return this.deweyClassification;
	}

	/** @return String will indicate that the method has been executed.
	*/
	public String topic(){
		return "Method topic called from Nonfiction";
	}
}

/** Category is a class that contains 3 local variables. A sub category, A super category, and a category. 
*/

class Category{ 
	private Category subCategory;
	private Category superCategory;
	private String category;
	
	/** @param category will set the category for the setter method
	*/
	public void setCategory(String category){
		this.category = category;
	}
	/**	@return this.category will get the category
	*/
	public String getCategory(){
		return this.category;
	}
	/** @param subCategory will set the subCategory
	*/
	public void setSubCategory(Category subCategory){
		this.subCategory = subCategory;
	}
	/**	@return subCategory will get the subCategory
	*/
	public Category getSubCategory(){
		return this.subCategory;
	}
	/**@param superCategory will set the superCategory
	*/
	public void setSuperCategory(Category superCategory){
		this.superCategory = superCategory;
	}
	/** @return this.superCategory will get the superCategory
	*/
	public Category getSuperCategory(){
		return this.superCategory;
	}
	
	/**@return String will return a string that will indicate that it has been executed properly
	*/
	public String sort(){
		return "Method sort called from Category";
	}	
}
/** Fiction is a abstract class that will be used in order to classify paperback.
*/

abstract class Fiction extends Paperback{
	abstract public String coverArt();
	/** @return String that will indicate whether the the function has been executed.
	*/ 
	public String genre(){
		return "Method genre called from Fiction";
	}
	
}

/** Anthology is a class that contains 5 or more stories.
*/
class Anthology extends Fiction{
	private Story[] story;
	
	/** @param story is an argument that needs 5 or more stories in order to be an anthology this function will set story.
	*/
	
	public void setStory( Story [] story){
		this.story = new Story[10];
		if(story[4] == null){
			System.out.println("\nThis is not an anthology if there is not 5 stories");
			return;
		}
		else{
			for(int i = 0; i < 10; i++){
				this.story[i] = story[i];
			}
		}
	}
	/**@return this.story will get the anthology array*/
	
	public Story [] getStory(){
		return this.story;
	}

	/** @return String will return if the method has been executed properly.
	*/
	
	public String coverArt(){
		return "Method coverArt called from Anthology"; 
	}
	/**@return String will return if the method has been executed properly
	*/
	
	public String storyOrder(){
		return "Method storyOrder called from Anthology";
	}
	
}

/** Class novel contains information about the author and the series.
*/
class Novel extends Fiction{
	private Author [] theAuthor;
	private Series mySeries;
	
	/** @param theAuthor is an arguement used to set the amount of authors that wrote the story.
	*/

	public void setTheAuthor(Author [] theAuthor){
		this.theAuthor = new Author[10];
		if( theAuthor[0] == null){
			System.out.println("\nThis novel does not have an author");
			return;
		}
		else{
			for( int i = 0; i < 10; i++){
				this.theAuthor[i] = theAuthor[i];
			}
		}
	}
	/**@param mySeries is an argument used to set the series to a group of novels
	*/
	public void setMySeries(Series mySeries){
		this.mySeries = mySeries;
		
	}
	/**@return this.mySeries is an argument that is used to get the series that is associated with a particular novel
	*/
	
	public Series getMySeries(){
		return this.mySeries;
	}
	/** @return this.theAuthor will get the authors that are involved with the novel.
	*/
	public Author [] getTheAuthor(){
		return this.theAuthor;
	}

	
	/** @return String will return if the method has been executed properly.
	*/
	public String coverArt(){
		return "Method coverArt called from Novel";
	}
	/** @return String will return if the method has been executed properly.
	*/
	public String theme(){
		return "Method theme called from Novel";
	}
}

/** Class series contains the series name in which the novel is associated with.
*/
class Series{
	private String seriesName;
	/** @param seriesName will set the series name to whatever is desired.
	*/
	public void setSeriesName(String seriesName){
		this.seriesName = seriesName;
	}
	/** @return this.seriesName will get the series name*/
	public String getSeriesName(){
		return this.seriesName;
	}
	/** @return String will return a string indicating that it has been executed correctly.
	*/
	public String theme(){
		return "Method theme called from Series";
	}
}

