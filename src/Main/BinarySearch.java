package Main;

import java.io.*;
import java.util.*;

/**
 * <h1>Binary Search</h1>
 * 
 * <p>Bin Search is a searching algorithm which finds a element in a sorted array in O(logN) time.</p>
 * 
 * @author atharvanaphade
 *
 */

public class BinarySearch {
	public static void main (String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 1; i < 9; i++) {
			a.add(i);
		}
		int t = 11;
		BinSearch(a, t);
	}
	/**
	 * Divide and Conquer, VERY IMPORTANT to understand the difference between O(N) and O(logN) time complexity.
	 * 
	 * @param a
	 * @param target
	 */
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
