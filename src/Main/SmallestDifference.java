package Main;

import java.io.*;
import java.util.*;

// Given two arrays find two numbers from both arrays, whose difference is the least.
// Given two arrays find two numbers which are closest to each other.

public class SmallestDifference {
	public static void main (String[] args) throws IOException {
		int[] a = {1, 2, 4, 6, 7};
		int[] b = {3, 10, 33, 44};
		Naive(a, b);
		Optimal(a, b);
	}
	
	// O(N^2) Time
	// O(1) Space
	public static void Naive(int[] a, int[] b) {
		int p = 0, q = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (Math.abs(a[i] - b[j]) < diff) {
					p = a[i];
					q = b[j];
					diff = Math.abs(a[i] - b[j]);
				}
			}
		}
		System.out.println(p + " " + q);
	}
	
	// O(NlogN) Time
	// O(1) Space
	public static void Optimal(int[] a, int[] b) {
		int[] ret = new int[2];
		ret[0] = 1;
		ret[1] = 1;
		int p = 0, q = 0, diff = Integer.MAX_VALUE;
		Arrays.sort(a);
		Arrays.sort(b);
		while (p < a.length && q < b.length) {
			if (a[p] < b[q] && !(Math.abs(a[p] - b[q]) > diff) && p < a.length) {
				ret[0] = a[p];
				ret[1] = b[q];
				diff = Math.abs(a[p] - b[q]);
				p++;
			} else if (b[q] < a[p] && !(Math.abs(a[p] - b[q]) > diff) && q < b.length) {
				ret[0] = a[p];
				ret[1] = b[q];
				diff = Math.abs(a[p] - b[q]);
				q++;
			} else if (a[p] == b[q]){
				ret[0] = a[p];
				ret[1] = b[q];
				break;
			} else {
				break;
			}
		}
		for (int z : ret) {
			System.out.print(z + " ");
		}
	}
}
