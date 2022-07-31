package Main;

import java.io.*;
import java.util.*;

/*
 * QuickSelect is an algorithm to find the Kth something in an array,
 * 
 */

public class QuickSelect {
	
	int[] unique;
	Map<Integer, Integer> count;
	
	public static void main (String[] args) throws IOException {
//		Solution();
	}
	
	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public int Partition(int left, int right, int pivot_idx) {
		int pivot_freq = count.get(unique[pivot_idx]);
		swap(pivot_idx, right);
		int store_idx = left;
		
		for (int i = left; i <= right; i++) {
			if (count.get(unique[i]) < pivot_freq) {
				swap(store_idx, i);
				store_idx++;
			}
		}
		
		swap(store_idx, right);
		
		return store_idx;
	}
	
	public void QuickSelect(int left, int right, int k_smallest) {
		if (left == right) return;
		
		Random rand_num = new Random();
		int pivot_idx = left + rand_num.nextInt(right - left);
		
		pivot_idx = Partition(left, right, pivot_idx);

        if (k_smallest == pivot_idx) {
            return;    
        } else if (k_smallest < pivot_idx) {
            QuickSelect(left, pivot_idx - 1, k_smallest);     
        } else {
            QuickSelect(pivot_idx + 1, right, k_smallest);  
        }
	}
	
	public int[] Solution(int[] nums, int k) {
		count = new HashMap<>();
		
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}
		
		int n = count.size();
		unique = new int[n];
		int i = 0;
		
		for (int num : count.keySet()) {
			unique[i] = num;
			i++;
		}
		
		QuickSelect(0, n - 1, n - k);
		
		return Arrays.copyOfRange(unique, n - k, n);
	}
}
