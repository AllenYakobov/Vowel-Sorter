package project3;

import java.util.regex.Pattern;

public class Word implements Comparable <Word> {

	private String word;
	
	public Word(String w) throws IllegalWordException {
		if (Pattern.matches("[A-Za-z]+,|[A-Za-z]+", w)) { // regular expression for only letters, not digits
			setWord(w);                                   // setWord method is called
		}
		else {                                      // otherwise, if digits are in the word
			throw new IllegalWordException("");     // throw an illegal word exception
		}
	}
	
	public void setWord(String w) { // setWord method
		this.word = w;              // sets word to parameter w
	}
	
	public String getWord() { // getWord method
		return this.word;     // return word
	}
	
	public int compareTo(Word other) { // compareTo method
		int lengthCheck = this.word.compareTo(other.word); // compares current to other 
		return lengthCheck;                                // returns lengthCheck
	}
}
