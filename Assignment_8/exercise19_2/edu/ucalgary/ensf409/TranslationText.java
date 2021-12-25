
package edu.ucalgary.ensf409;

import java.io.Serializable;

public class TranslationText implements Serializable{

	String months[] = new String[12];
	String days[] = new String[31];
	String sentence = "";
	static final long serialVersionUID = 19;
	
	
/* TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of 19.
 * No method in this class throws an exception.
*/

  /* getSentence()
   * Getter method, returns String
  */
	public String getSentence() {
		return this.sentence;
	}

  /* getMonths()
   * Getter method, returns String[]
  */
	
	public String [] getMonths() {
		return this.months;
	}
	
  /* getDays()
   * Getter method, returns String[]
  */
	
	public String [] getDays() {
		return this.days;
	}
		
  /* getMonth()
   * Accepts an integer 0-11 corresponding to an index in the months array,
   * and returns the value at that index.
  */
	public String getMonth(int i) {
		return this.months[i];
	}

  /* getDay()
   * Accepts an integer 0-30 corresponding to an index in the day array,
   * and returns the value at that index.
  */

	public String getDay(int i) {
		return this.days[i];
	}
  /* Constructor
   * Accepts a String array of months, a String array of days, and a String 
   * containing a sentence with formatting.
  */
	
	public TranslationText(String [] months, String [] days, String sentence) {
		
		this.sentence = sentence;
		
		for(int i = 0; i < 12; i++) {
			this.months[i] = months[i];
		}
		
		for(int i = 0; i < 31; i++) {
			this.days[i] = days[i];
		}
		
	}
	
}
