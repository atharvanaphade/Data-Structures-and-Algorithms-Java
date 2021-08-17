package Main;

import java.io.*;
import java.util.*;

public class NthFibNumber {
	public static void main (String[] args) throws IOException {
		int n = 13;
		System.out.println(Recursive(n));
		DP(n);
		DPOptimized(n);
	}
	
	public static int Recursive(int n) {
		if (n == 2) {
			return 1;
		} else if (n == 1) {
			return 0;
		} else {
			return Recursive(n - 1) + Recursive(n - 2);
		}
	}
	
	public static void DP (int n) {
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 0;
		}
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		for (Object i : dp) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
	
	public static void DPOptimized(int n) {
		int one = 0;
		int two = 1;
		int curr = 0;
		for (int i = 2; i < n; i++) {
			curr = one + two;
			two = curr;
			one = two;
		}
		System.out.println(curr);
	}
}
