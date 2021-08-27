package Main;

import java.io.*;
import java.util.*;

// Given a array of integers, the numbers represent how many elements to jump, you have to find 
// if there exists a cycle in the array, a cycle is visiting the same element more than once without 
// completely traversing the whole array.

public class SingleCycleCheck {
	public static void main (String[] args) throws IOException {
		int[] arr = { 2, 3, -2, -4, -4, 2 };
		Solution(arr);
	}
	
	// O(N) Time
	// O(1) Space
	public static void Solution (int[] arr) {
		int n = arr.length;
		int numElementsVisited = 0, currIdx = 0;
		while (numElementsVisited < n) {
			if (numElementsVisited > 0 && currIdx == 0) {
				System.out.println("Cycle Detected");
				return;
			}
			numElementsVisited += 1;
			currIdx = getNextIdx(currIdx, arr);
		}
		if (currIdx == 0) {
			System.out.println("No Cycle");
			return;
		} else {
			System.out.println("Cycle Detected");
			return;
		}
	}
	
	public static int getNextIdx (int curr, int[] arr) {
		int jump = arr[curr];
		int nextIdx = (curr + jump) % arr.length;
		return nextIdx >= 0 ? nextIdx : nextIdx + arr.length;
	}
}
