package Main;

import java.io.*;
import java.util.*;

// Given two strings find the minimum number of operations to convert one string
// to another, in one operation, you can either insert or substitute a char.
//
// DP : -
//
// if s1[i] == s2[j] then dp[i][j] = dp[i - 1][j - 1]
// else dp[i][j] = 1 + min (dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1])

public class MinOperationsToConvertString {
	public static void main (String[] args) throws IOException {
		String a = "abc", b = "yabd";
		Solution(a, b);
	}
	
	public static void Solution (String a, String b) {
		int m = a.length(), n = b.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			dp[0][i] = dp[0][i - 1] + 1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
				}
			}
		}
		System.out.println(dp[m][n]);
	}
}
