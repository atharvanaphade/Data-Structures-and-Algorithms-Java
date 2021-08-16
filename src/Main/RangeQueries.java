package Main;

import java.io.*;
import java.util.*;

// Given an array of integers find a number with a given property in a given range L, R in O(1) 
// time for a certain number of queries.
// 
// Total Complexity : O (NlogN + Q) where Q is the number of queries.

public class RangeQueries {
	
	public static int[][] SparseTable = new int[100000][17];
	public static int[] Logs = new int[100000];
	
	public static void main (String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		while (q --> 0) {
			int L = sc.nextInt(), R = sc.nextInt();
			System.out.println(Queries(L, R));
		}
	}
	
	public static int Queries (int L, int R) {
		int length = R - L + 1;
		int k = Logs[length];
		return (int)Math.min(SparseTable[L][R], SparseTable[(int) (R - (Math.pow(2, k)) + 1)][k]);
	}
	
	public static void BuildRMQ (int[] a) {
		for (int i = 0; i < a.length; i++) {
			SparseTable[i][0] = a[i];
		}
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j + (1 << i) - 1 < a.length; j++) {
				SparseTable[j][i] = Math.min(SparseTable[j][i - 1], SparseTable[j + (1 << (i - 1))][i - 1]);
			}
		}
	}
	
	public static void BuildLogLookup (int n) {
		for (int i = 2; i <= n; i++) {
			Logs[i] = Logs[i / 2] + 1;
		}
	}
}
