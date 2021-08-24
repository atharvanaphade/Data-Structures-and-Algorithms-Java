package Main;

import java.io.*;
import java.util.*;

// In an array of only positive integers, find the max sum of numbers which 
// are not adjacent.
//
// DP
// pref[i] = max (pref[i - 1], pref[i - 2] + a[i])

public class MaxSubsetSumNoAdjacent {
	public static void main (String[] args) throws IOException {
		int[] a = { 7, 10, 12, 7, 9, 14 };
		Solution(a);
	}
	
	public static void Solution (int[] a) {
		int n = a.length;
		int[] pref = new int[n];
		pref[0] = a[0];
		pref[1] = a[1];
		for (int i = 2; i < n; i++) {
			pref[i] = Math.max(pref[i - 1], pref[i - 2] + a[i]);
		}
		System.out.println(pref[n - 1]);
	}
}
