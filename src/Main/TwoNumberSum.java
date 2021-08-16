package Main;

import java.io.*;
import java.util.*;

// Given a Array of distinct integers and a target, find the two numbers in the array
// which add up to the number target.
//
//
// Sample Test Case :
//
// Input :
//
// [ 3, 5, -4, 8, 11, 1, -1, 6 ] Tagret = 10
//
// Output : 
//
// [ 4, 6 ]


public class TwoNumberSum {
	public static void main (String args[]) throws IOException {
		int[] a = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int target = 13;
		optimalSolution(a, target);
		subOptimalSolution(a, target);
		naive(a, target);
	}
	
	// Hash Table
	// O(N) Time
	// O(N) Space
	public static void optimalSolution (int[] a, int target) {
		long start = System.currentTimeMillis();
		HashMap<Integer, Boolean> hashh = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int y = target - a[i];
			if (hashh.containsKey(y)) {
				System.out.println(String.format("[ %d, %d ]", y, a[i]));
				long end = System.currentTimeMillis(); 
				System.out.println("Elapsed Time in milli seconds: "+ (end - start));
				return;
			} else {
				hashh.put(a[i], true);
			}
		}
		return;
	}
	
	// Two Pointers
	// O(NlogN) Time
	// O(1) Space
	public static void subOptimalSolution (int[] a, int target) {
		long start = System.currentTimeMillis();
		int l = 0, r = (a.length - 1);
		Arrays.sort(a);
		while (l <= r) {
			int curr_sum = a[r] + a[l];
			if (curr_sum == target) {
				System.out.println(String.format("[ %d, %d ]", a[r], a[l]));
				long end = System.currentTimeMillis(); 
				System.out.println("Elapsed Time in milli seconds: "+ (end - start));
				return;
			} else if (curr_sum > target) {
				r--;
			} else if (curr_sum < target){
				l++;
			}
		}
		return;
	}
	
	// Naive Solution
	// O(N^2) Time
	// O(1) Space
	public static void naive (int[] a, int target) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] + a[j] == target) {
					System.out.println(String.format("[ %d, %d ]", a[i], a[j]));
					long end = System.currentTimeMillis(); 
					System.out.println("Elapsed Time in milli seconds: "+ (end - start));
					return;
				}
			}
		}
		return;
	}
}
