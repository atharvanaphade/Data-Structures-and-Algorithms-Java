package Main;

import java.io.*;
import java.util.*;

// You are given a array and a target value, you have to find the minimum
// number of coins needed to reach the target value by sums of denominations
// of the coins in the array.
// count array = amount to reach array of size target + 1
// count[i] = min (count[i], count[coins[i] - count[i]] + 1)

public class MinNumberOfCoinsForChange {
	public static void main (String[] args) throws IOException {
		int[] arr = { 1, 2, 4 };
		int target = 6;
		Solution(arr, target);
	}
	
	public static void Solution (int[] arr, int target) {
		int[] count = new int[target + 1];
		for (int i = 0; i < count.length; i++) {
			count[i] = Integer.MAX_VALUE;
		}
		count[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < count.length; j++) {
				if (arr[i] <= j) {
					count[j] = Math.min(count[j], count[j - arr[i]] + 1);
				}
			}
		}
		System.out.println(count[target]);
	}
}
