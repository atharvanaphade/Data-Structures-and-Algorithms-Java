package Main;

import java.io.*;
import java.util.*;

// Check the max length of a palindrome substring in a string.

public class LongestPalindromicSubstring {
	public static void main (String[] args) throws IOException {
		String a = "sabbasc";
		Solution(a);
	}
	
	public static void Solution (String s) {
		int m = s.length();
		int[][] dp = new int[m + 1][m + 1];
		int ret = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = m; j > 0; j--) {
				if (s.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][m - j + 1] = dp[i - 1][m - j] + 1;
					ret = Math.max(dp[i][m - j + 1], ret);
				} else {
					dp[i][m - j + 1] = dp[i - 1][m - j];
				}
			}
		}
		System.out.println(ret);
	}
}
