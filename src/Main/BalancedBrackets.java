package Main;

import java.io.*;
import java.util.*;

/**
 * <h1>Balanced Brackets</h1>
 * 
 * <p>
 * Given a string of different type of brackets, a bracket sequence is balanced
 * if a closing bracket exists for every opening bracket. You have to determine
 * if the string is balanced.
 * </p>
 * 
 * @author atharvanaphade
 *
 */

public class BalancedBrackets {
	public static void main(String[] args) throws IOException {
		String a = "((([]{})))";
		solution(a);
	}

	/**
	 * Use stack to push the opening brackets and check for closing brackets in the
	 * string by traversing the string, if the cycle is broken the sequence is not
	 * balanced.
	 * 
	 * @param string
	 */
	public static void solution(String s) {
		Stack<Character> st = new Stack<>();
		boolean isBalanced = true;
		char currentChar = ' ';

		for (int i = 0; i < s.length(); i++) {
			currentChar = s.charAt(i);
			
			if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
				st.push(s.charAt(i));
			} else {
				Character tmp = st.pop();
				if (tmp == '{' && currentChar != '}') {
					isBalanced = false;
				} else if (tmp == '(' && currentChar != ')') {
					isBalanced = false;
				} else if (tmp == '[' && currentChar != ']') {
					isBalanced = false;
				}
			}
		}

		if (!st.isEmpty())
			isBalanced = false;
		
		System.out.printf("String %s is %s\n", s, isBalanced? "Balanced" : "Not Balanced");
	}
}
