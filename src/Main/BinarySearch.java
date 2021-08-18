package Main;

import java.io.*;
import java.util.*;

// Binary Search is a searching algorithm which finds an element in a sorted array in O(logN) time 
// This algo can be applied in many scenarios for ex. Searching a number closest to a given 
// number i.e lower bound or upper bound in array.

public class BinarySearch {
	public static void main (String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 1; i < 9; i++) {
			a.add(i);
		}
		int t = 11;
		BinSearch(a, t);
	}
	
	public static void BinSearch (ArrayList<Integer> a, int target) {
		int n = a.size();
		int l = 0, r = n - 1;
		int ret = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (a.get(mid) == target) {
				ret = mid + 1;
				break;
			} else if (a.get(mid) < target) {
				l = mid;
			} else if (a.get(mid) > target) {
				r = mid;
			} 
		}
		System.out.println(ret + " ");
	}
}
