package proj4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Converter class reads in a token, identifies which token it is,
 * makes a new Token type from it, and calls the item's handle() method.
 * Repeats until all tokens have been processed.
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */
public class Converter {
	
	private Scanner myReader;

	/**
	 * non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
    public Converter(String infile)
    {
		try {
            myReader = new Scanner(new File(infile)); 
    	} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	/**
	 * Converts an infix string in file to the postfix string
	 */
	public void convert() {
		Stack<Token> s = new Stack<Token>();

		while (myReader.hasNext()) {
			String nextExpression = myReader.next();

			String infix = nextExpression.substring(0, nextExpression.length() - 1);
			String postFix = "";

			for(char c: nextExpression.toCharArray()){
				Token t = whichToken(c);
				if(t != null){
					postFix += t.handle(s);
				}else{
					postFix += c;
				}
			}
			System.out.println(infix + " --> " + postFix);
		}
	}


	private Token whichToken(char c){
		switch (c){
			case '(':
				return new LeftParen();
			case ')':
				return new RightParen();
			case '^':
				return new Exponent();
			case '*':
				return new Multiply();
			case '/':
				return new Divide();
			case '+':
				return new Plus();
			case '-':
				return new Minus();
			case ';':
				return new Semicolon();
			default: //OPERAND
				return null;
		}
	}
}
