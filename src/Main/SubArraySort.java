package Main;

import java.io.*;
import java.util.*;

// Sort minimum lenght subarray to make the array sorted.

public class SubArraySort {
	public static void main (String[] args) {
		int[] arr = {1, 2, 4, 7, 11, 7, 12, -2, 7, -1, 18, 19};
		Solution(arr);
	}
	
	public static void Solution (int[] arr) {
		int[] ret = new int[2];
		int p = 0, q = arr.length - 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				p = i;
				break;
			}
		}
		for (int i = arr.length - 1; i >= p; i--) {
			if (arr[i] < arr[i - 1]) {
				q = i;
				break;
			}
		}
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = p; i <= q; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(min + " " + max);
		System.out.println(p + " " + q);
		for (int i = 0; i < q; i++) {
			if (arr[i] > min) {
				ret[0] = i;
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				ret[1] = i - 1;
				break;
			}
		}
		System.out.println(ret[0] + " " + ret[1]);
	}

}
