package Main;

import java.io.*;
import java.util.*;

// Search in a 2D sorted array. Bin Search

public class SearchSortedMatrix {
	public static void main (String[] args) throws IOException {
		;
	}
	
	// O(N + M) Time
	// O(1) Space
	public static void Solution (int[][] arr, int target) {
		int r = 0, c = arr[0].length - 1;
		while (r < arr.length && c >= 0) {
			if (arr[r][c] > target) {
				c--;
			} else if (arr[r][c] < target) {
				r++;
			} else if (arr[r][c] == target) {
				break;
			}
		}
		System.out.println("Row : " + r + " Col : " + c);
	}
}
