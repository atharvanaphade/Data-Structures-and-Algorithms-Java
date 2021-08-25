package Main;

import java.io.*;
import java.util.*;

// You are given an array and a target value, the array contains the denominations
// which you can use to sum up to the target value, and you have infinite
// number of coins of all denominations.

public class NumberOfWaysToMakeChange {
	public static void main (String[] args) throws IOException {
		int t = 10;
		int[] a = { 1, 5, 10, 25 };
		Solution(a, t);
	}
	
	// O(N ^ 2) Time
	// O(N) Space
	public static void Solution (int[] coins, int target) {
		int[] count = new int[target + 1];
		count[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < count.length; j++) {
				if (coins[i] <= j) {
					count[j] += count[j - coins[i]];
				}
			}
		}
		System.out.println(count[target]);
	}
}
