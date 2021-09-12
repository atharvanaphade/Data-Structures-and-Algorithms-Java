package Main;

import java.io.*;
import java.util.*;

/**
 * <h1>Balanced Brackets</h1>
 * 
 * <p>Given a string of different type of brackets, a bracket sequence is balanced if a closing bracket exists for every opening bracket. You have to determine if the string is balanced.</p>
 * 
 * @author atharvanaphade
 *
 */

public class BalancedBrackets {
	public static void main (String[] args) throws IOException {
		String a = "((([]{})))";
		Solution(a);
	}
	/**
	 * Use stack to push the opening brackets and check for closing brackets in the string by traversing the string, if the cycle is broken the sequence is not balanced.
	 * 
	 * @param s
	 */
	public static void Solution (String s) {
		Stack<Character> st = new Stack<>();
		boolean ret = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				st.push(s.charAt(i));
			} else {
				Character tmp = st.pop();
				if (tmp == '{' && s.charAt(i) != '}') {
					ret = false;
				} else if (tmp == '(' && s.charAt(i) != ')') {
					ret = false;
				} else if (tmp == '[' && s.charAt(i) != ']') {
					ret = false;
				}
			}
		}
		if (!st.isEmpty()) ret = false;
		if (ret) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}
	}
}
