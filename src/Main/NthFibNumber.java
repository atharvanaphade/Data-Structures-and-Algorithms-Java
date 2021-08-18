package Main;

import java.io.*;
import java.util.*;

public class NthFibNumber {
	public static void main (String[] args) throws IOException {
		int n = 13;
		System.out.println(Recursive(n));
		DP(n);
		HashMap<Integer, Integer> a = new HashMap<>();
		a.put(0, 0);
		a.put(1, 1);
		int ret = RecursiveMemoization(n, a);
		System.out.println(ret);
	}
	
	// O(N^2) Time
	// O(N) Space
	public static int Recursive(int n) {
		if (n == 2) {
			return 1;
		} else if (n == 1) {
			return 0;
		} else {
			return Recursive(n - 1) + Recursive(n - 2);
		}
	}
	
	// O(N) Time
	// O(N) Space
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
	
	// O(N) Time
	// O(N) Space
	public static Integer RecursiveMemoization (int n, HashMap<Integer, Integer> Memoization) {
		if (Memoization.containsKey(n)) {
			return n;
		} else {
			Memoization.put((RecursiveMemoization(n - 1, Memoization) + RecursiveMemoization(n - 2, Memoization)), (RecursiveMemoization(n - 1, Memoization) + RecursiveMemoization(n - 2, Memoization)));
			return Memoization.get(n);
		}
	}
}