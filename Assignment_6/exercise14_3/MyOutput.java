import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;

/**
  * FormattedOutput is an interface
  */
interface FormattedOutput{
	String getFormatted();
}
/**
  * Actions is an ENUM full of actions that could be pulled out by the user.
  */
enum Actions{ 
	END,
	ENABLE,
	START,
	TEST,
	DISABLE
}

/**
  *  Months is an ENUM that contains all of the specified months in a year
  */
enum Months{
	JAN("Jan", 1, "January"),
	FEB("Feb", 2, "Febuary"),
	MAR("Mar", 3, "March"),
	APR("Apr", 4, "April"),
	MAY("May", 5, "May"),
	JUN("Jun", 6, "Jun"),
	JUL("Jul", 7, "July"),
	AUG("Aug", 8, "August"),
	SEP("Sep", 9, "September"),
	OCT("Oct", 10, "October"),
	NOV("Nov", 11, "Novemeber"),
	DEC("Dec", 12, "December");
	
	private String toLogString;
	private int toInteger = 0;
	private String toStr;
	
	/**
	 * @param string this gives toLogString a string that is required to return another string from toLog() method.
	 * @param i	this gives an integer to the value of toInteger that is required to return an integer from the toInt() method.
	 * @param string2 this give toStr a string that is required to return another string from toString() method. 
	 */
	Months(String string, int i, String string2) { 
		toLogString = string;
		toInteger = i;
		toStr = string2; 
	}
	
	/**
	 * 
	 * @return returns the toLogString String for the log style string.
	 */
	public String toLog() {
		// TODO Auto-generated method stub
		return toLogString;
	}
	/**
	 * 
	 * @return returns the toInteger as a integer.
	 */
	
	public int toInt() {
		return toInteger;
	}
	
	/**
	 * @return returns the toStr String for the log style string.
	 */
	public String toString() {
		return toStr;	
	}

}

/**
 * 
 * Class DateTime Handles the date in the log.
 *
 */

class DateTime implements FormattedOutput{
	
	private int DAY = 0;
	private int MONTH = 0;
	private int YEAR = 0;
	private int HOUR = 0;
	private int MINUTE = 0;
	private int SECOND = 0;
	private String REGEX = "\\[([0-9]{1,2})/([a-zA-Z]{3})/([0-9]{4}):([0-9]{1,2}):([0-9]{2}):([0-9]{2})\\]"; //this one should be good
	private Pattern PATTERN = Pattern.compile(REGEX);
	
	public DateTime(String datetime){ //this should be done asside from month.
		Matcher isMatching = PATTERN.matcher(datetime);
		isMatching.matches();
		if(isMatching.find()) {
			this.DAY = Integer.parseInt(isMatching.group(1));
			Months enumMonth = Months.valueOf(isMatching.group(2).toUpperCase());
			this.MONTH = enumMonth.toInt();
			this.YEAR = Integer.parseInt(isMatching.group(3));
			this.HOUR = Integer.parseInt(isMatching.group(4));
			this.MINUTE = Integer.parseInt(isMatching.group(5));
			this.SECOND = Integer.parseInt(isMatching.group(6));
		}
	}
	
	/**
	 * 
	 * @return returns the formatted string in the specified way that they wanted it to be
	 */
	
	@Override
	public String getFormatted() {
		// TODO Auto-generated method stub
		return "Day: " + this.DAY + ", Month: " + monthToString() + ", Year: " + this.YEAR + ", Hour: " +
				this.HOUR + ", Minute: " + this.MINUTE + ", Second: " + this.SECOND;
	}

	/**
	 * 
	 * @return returns a string with the specified month wanted.
	 */
	
	public String monthToString(){
		if(this.MONTH == 1) {
			return "January";
		}
		else if(this.MONTH == 2) {
			return "Febuary";
		}
		else if(this.MONTH == 3) { 
			return "March";
		}
		else if(this.MONTH == 4) {
			return "April";
		}
		else if(this.MONTH == 5) {
			return "May";
		}
		else if(this.MONTH == 6) {
			return "June";
		}
		else if(this.MONTH == 7) {
			return "July";
		}
		else if(this.MONTH == 8) {
			return "August";
		}
		else if(this.MONTH == 9) {
			return "September";
		}
		else if(this.MONTH == 10) {
			return "October";
		}
		else if(this.MONTH == 11) {
			return "November";
		}
		else {
			return "December";
		}
		
	}
	
	/**
	 * 
	 * @return getter for this.Day
	 */

	public int getDay() {
		return this.DAY;
	}
	/**
	 * 
	 * @return getter for Month
	 */
	
	public int getMonth() {
		return this.MONTH;
	}
	/**
	 * 
	 * @return getter for Year
	 */
	
	public int getYear() {
		return this.YEAR;
	}
	/**
	 * 
	 * @return getter for hour;
	 */
	
	public int getHour() {
		return this.HOUR;
	}
	/**
	 * 
	 * @return getter for minute
	 */
	
	public int getMinute() {
		return this.MINUTE;
	}
	/**
	 * 
	 * @return getter for second
	 */
	
	public int getSecond() {
		return this.SECOND;
	}
	/**
	 * 
	 * @return getter for regex
	 */
	
	public String getRegex() {
		return this.REGEX;
	}

}

/**
 * 
 * Class IPv4 handles the IP address
 *
 */

class IPv4 implements FormattedOutput{ //this should be good to go

	private String IP;
	private String REGEX = "([0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3})";
	private Pattern PATTERN = Pattern.compile(REGEX);
	
	/**
	 * 
	 * @param ip will be parsed as a string
	 */
	public IPv4(String ip) {
		Matcher isMatching = PATTERN.matcher(ip);
		if(isMatching.find()) {
			this.IP = isMatching.group(0);
		}
		else {
			this.IP = null;
		}
	}
	/**
	 * @return returns a String in the format that they want it to be.
	 */
	
	@Override
	public String getFormatted() {
		// TODO Auto-generated method stub
		return "IPv4: " + this.IP;
	}
	/**
	 * 
	 * @return getter for IP string
	 */
	
	public String getIP() {
		return this.IP;
	}
	
	/**
	 * 
	 * @return getter for Regex
	 */
	public String getRegex() {
		return this.REGEX;
	}
	
}

/**
 * 
 * Class Action handles the action arguments specified in enum
 *
 */

class Action implements FormattedOutput{
	private String ACTION;
	private String REGEX = "([A-Z]{3,7})"; 
	private Pattern PATTERN = Pattern.compile(REGEX);
	
	/**
	 * 
	 * @param action This is a string that will be passed onto the data member ACTION.
	 */
	public Action(String action) {
		Matcher isMatching = PATTERN.matcher(action);
		isMatching.matches();
		if(isMatching.find()){
			this.ACTION = isMatching.group(0);
		}
		else {
			this.ACTION = null;
		}
	}
	
	/**
	 * @return String used to format to the way that they wanted
	 */
	@Override
	public String getFormatted() {
		// TODO Auto-generated method stub
		return "Action: " + this.ACTION;
	}
	
	/**
	 * 
	 * @return getter method to return action
	 */
	public String getAction() {
		return this.ACTION;
	}
	/**
	 * 
	 * @return getter method used to return regex
	 */
	
	public String getRegex() {
		return this.REGEX;
	}

}
/**
 * 
 * Class Device handles the devices in a string
 *
 */

class Device implements FormattedOutput{

	private String DEVICE;
	private String REGEX = "\\ ([a-zA-Z\\ ]*)\\(";
	private Pattern PATTERN = Pattern.compile(REGEX);
	/**
	 * 
	 * @param device String will be placed inside of the DEVICE in order to be manipulated.
	 */
	
	public Device(String device) {
		Matcher isMatching = PATTERN.matcher(device);
	
		isMatching.matches();
		if(isMatching.find()) {
			this.DEVICE = isMatching.group(0);
			this.DEVICE = this.DEVICE.substring(1, this.DEVICE.length() - 1);
		}
		else {
			this.DEVICE = null;
		}
	}
	
	/**
	 * @return String is returned in a format that is required.
	 */
	@Override
	public String getFormatted() {
		// TODO Auto-generated method stub
		return "Device: " + this.DEVICE;
	}
	
	/**
	 * 
	 * @return getter method for DEVICE.
	 */
	public String getDevice() {
		return this.DEVICE;
	}
	
	/**
	 * 
	 * @return getter method for Regex.
	 */
	public String getRegex() {
		return this.REGEX;
	}
	
}

/**
 * 
 * Class location handles the location argument. 
 *
 */
class Location implements FormattedOutput{

	private String ROOM;
	private String BUILDING;
	private String REGEX = "(\\([a-zA-Z\\ ]*\\-)([a-zA-Z\\ ]*\\))";
	private Pattern PATTERN = Pattern.compile(REGEX);
	
	/**
	 * 
	 * @param location will be placed inside of ROOM and BUILDING.
	 */
	public Location(String location) {
		Matcher isMatching = PATTERN.matcher(location);
		isMatching.matches();
		if(isMatching.find()) {	
			this.ROOM = isMatching.group(1);
			this.ROOM = this.ROOM.substring(1, this.ROOM.length() - 2);
			this.BUILDING = isMatching.group(2);
			this.BUILDING = this.BUILDING.substring(1, this.BUILDING.length() - 1);
		}
		else {
			this.ROOM = null;
			this.BUILDING = null;
		}
	}
	/**
	 * @return formats it in the way that it is required.
	 */
	@Override
	public String getFormatted() {
		// TODO Auto-generated method stub
		return "Room: " + this.ROOM + ", Building: " + this.BUILDING;
	}
	/**
	 * 
	 * @return getter function used to get ROOM.
	 */
	public String getRoom(){
		return this.ROOM;
	}
	/**
	 * 
	 * @return getter function used to get ROOM.
	 */
	public String getBuilding() {
		return this.BUILDING;
	}
	
	/**
	 * 
	 * @return getter function used to get ROOM.
	 */
	public String getRegex() {
		return this.REGEX;
	}
	
}

/**
 * 
 * Class ParseLine will be used to deal with all the data memebers.
 *
 */

class ParseLine{
	private String LOGLINE;
	private Location LOCATION;
	private Device DEVICE;
	private Action ACTION;
	private DateTime DATETIME;
	private IPv4 IPV4;
	/**
	 * 
	 * @param line will be a string that will contain all the data members required for this class
	 */
	public ParseLine(String line){
		this.LOGLINE = line;
		this.LOCATION= new Location(line);
		this.DEVICE = new Device(line);
		this.ACTION = new Action(line);
		this.DATETIME = new DateTime(line);
		this.IPV4 = new IPv4(line);	
	}
	/**
	 * 
	 * @return getter will return the IP address
	 */
	
	public IPv4 getIPv4() {
		return this.IPV4;
	}
	/**
	 * 
	 * @return getter will return the LOGLINE 
	 */
	public String getLogLine() {
		return this.LOGLINE;
	}
	
	/**
	 * 
	 * @return getter will return the LOCATION
	 */
	public Location getLocation() {
		return this.LOCATION;
	}
	/**
	 * 
	 * @return getter will return the DEVICE
	 */
	public Device getDevice() {
		return this.DEVICE;
	}
	/**
	 * 
	 * @return getter will return the ACTION.
	 */
	public Action getAction() {
		return this.ACTION;
	}
	/**
	 * 
	 * @return getter will return the DATETIME.
	 */
	public DateTime getDateTime() {
		return this.DATETIME;
	}

}

/**
 * 
 * Class ParseLogFile will now parse each log file.
 *
 */

class ParseLogfile{ 
	
	ArrayList <ParseLine> log = new ArrayList<ParseLine>();
	/**
	 * 
	 * @param array this holds all of the logs.
	 */
	public ParseLogfile(String[] array){
		for(int i = 0; i< array.length; i++) {
			this.log.add(new ParseLine(array[i]));
		}
	}
	
	/**
	 * 
	 * @param index specified index for where the log is located
	 * @return returns the log as a string
	 */
	public ParseLine getLine(int index) {
		return log.get(index);
	}
	/**
	 *  
	 * @return getter function that returns log.
	 */
	public ArrayList<ParseLine> getLog() {
		return log;	
	}
}


public class MyOutput {
		public static void main(String args[]) {	
			String[] exampleLog = exampleLog();

			var logfile = new ParseLogfile(exampleLog);
			var line = logfile.getLine(0);
			System.out.println("Log line 0: " + line.getLogLine());

			var ip = line.getIPv4();
			System.out.println("IPv4: "+ip.getIP());
			
			var dt = line.getDateTime();
			System.out.println("Day: "+dt.getDay());
			System.out.println("Month: "+dt.getMonth());
			System.out.println("Month (named): "+dt.monthToString());
			System.out.println("Year: "+dt.getYear());
			System.out.println("Hour: "+dt.getHour());
			System.out.println("Minute: "+dt.getMinute());
			System.out.println("Second: "+dt.getSecond());

			var act = line.getAction();
			System.out.println("Action: "+act.getAction());

			var dev = line.getDevice();
			System.out.println("Device: "+dev.getDevice());

			var loc = line.getLocation();
			System.out.println("Room: "+loc.getRoom());
			System.out.println("Building: "+loc.getBuilding());

			System.out.println();
			line = logfile.getLine(6);
			System.out.println("Log line 6: " + line.getLogLine());
			System.out.println(line.getIPv4().getFormatted());
			System.out.println(line.getDateTime().getFormatted());
			System.out.println(line.getAction().getFormatted());
			System.out.println(line.getDevice().getFormatted());
			System.out.println(line.getLocation().getFormatted());

			System.out.println("\nExample of toLog() output: " + Months.AUG.toLog());
			System.out.println("\nExample regex (for DateTime): "+dt.getRegex());
		}


		// Contains example data 
		public static String[] exampleLog() {
			String[] log = {
	"81.220.24.207 - - [2/Mar/2020:10:05:44] \"END sprinkler (Visitor entrance - Building A B)\"",
	"81.220.24.207 - - [2/Mar/2020:10:05:26] \"ENABLE cooling system (Secured room - Building A)\"",
	"81.220.24.207 - - [2/Mar/2020:10:05:39] \"START heating system (Hall - Central)\"",
	"81.220.24.207 - - [2/Mar/2020:10:05:52] \"ENABLE door lock (Visitor entrance - Building B)\"",
	"81.220.24.207 - - [2/Mar/2020:10:05:21] \"TEST cooling system (Entrance - Building B)\"",
	"66.249.73.135 - - [17/May/2020:01:05:17] \"TEST fan (Secured room - Airport location)\"",
	"46.105.14.53 - - [17/May/2020:11:05:42] \"TEST cooling system heater (Secured room - Airport location)\"",
	"218.30.103.62 - - [17/May/2020:11:05:11] \"START sprinkler (Secured room - Airport location)\"",
	"218.30.103.62 - - [17/May/2020:11:05:46] \"DISABLE fan (Control room - Central)\"",
	"218.30.103.62 - - [17/May/2020:11:05:45] \"START door lock (Secured room - Building A)\"",
	"66.249.73.135 - - [27/Jun/2020:11:05:31] \"TEST sprinkler (Hall - Building B)\""};
			return log;
		}
	}



