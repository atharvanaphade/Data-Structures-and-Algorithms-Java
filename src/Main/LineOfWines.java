package Main;

import java.io.*;
import java.util.*;

// You are given a array of wine costs, you have to determine the maximum amount of profit you can
// gain by selling these wines. The wine cost for a particular year is the cost at year 1 multiplied
// by the current year.

public class LineOfWines {
	public static void main (String[] args) throws IOException {
		int[] arr = { 3, 4, 5, 6, 7 };
		Solution(arr);
	}
	
	public static void Solution (int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = arr[i] * 1;
		}
		int i = 0;
		for (int l = n - 2; l > 0; l--) {
			for (int r = l; r < n; r++) {
				dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]) + arr[i] * (l + (n - r));
			}
			i++;
		}
		System.out.println(dp[0][n - 1]);
	}
}
