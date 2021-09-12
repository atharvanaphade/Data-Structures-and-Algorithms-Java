package Main;

import java.io.*;
import java.util.*;

/**
 * <h1>Binary Exponentiation</h1>
 * 
 * <p>Find the powers of any number in O(logN) time.</p>
 * 
 * @author atharvanaphade
 *
 */

public class BinExp {
	public static void main (String args[]) throws IOException {
		System.out.println(Solution (2, 8));
	}
	
	/**
	 * <p>The solution is to split the exponent into its binary form and evaluate the power in multiples of two.</p>
	 * 
	 * @param a - Base
	 * @param b - Index
	 * @return ret - a ^ b
	 */
	public static int Solution (int a, int b) {
		if (b == 0) {
			return 1;
		}
		int res = Solution (a, b / 2);
		if (b % 2 == 1) {
			return res * res * 2;
		} else {
			return res * res;
		}
	}
}
