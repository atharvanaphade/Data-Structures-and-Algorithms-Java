package Main;

import java.io.*;
import java.util.*;

// A min heap is a binary tree which : -
// 		All elements have either two or 0 children
//		Every node's value is smaller than or equal to it's children's values.
//		In the array representation of a min heap, if you are at index i, it's children are at 2i + 1, 2i + 2.
// 		The parent node in the array is given by floor ((i - 1) / 2).

public class MinHeapConstruction {

}

class MinHeap {
	int size;
	int[] Heap = new int[size];
	
	private static void Swap (int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void BuildHeap (int[] arr, int size) {
		
	}
}
