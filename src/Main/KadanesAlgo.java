package Main;

import java.io.*;
import java.util.*;

// To solve maximum sum sub array.
// maxSum = max (prevSum, currNum)

public class KadanesAlgo {
	public static void main (String[] args) throws IOException {
		int[] arr = { 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4 };
		Solution(arr);
	}
	
	// O(N) Time
	// O(1) Space
	public static void Solution (int[] arr) {
		int ret = arr[0], maxSoFar = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxSoFar = Math.max (arr[i], maxSoFar + arr[i]);
			ret = Math.max(ret, maxSoFar);
		}
		System.out.println(ret);
	}
}
