package Main;

import java.util.ArrayList;

/**
 * <h1>Binary Search</h1>
 * 
 * <p>
 * Bin Search is a searching algorithm which finds a element in a sorted array
 * in O(logN) time.
 * </p>
 * 
 * @author atharvanaphade
 *
 */

public class BinarySearch {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 1; i < 9; i++) {
			a.add(i);
		}
		int t = 20;
		binarySearch(a, t);
	}

	/**
	 * Divide and Conquer, VERY IMPORTANT to understand the difference between O(N)
	 * and O(logN) time complexity.
	 * 
	 * @param arr
	 * @param target
	 */
	public static void binarySearch(ArrayList<Integer> arr, int target) {
		int n = arr.size();
		int left = 0, right = n - 1, mid = 0;
		int index = -1;

		while (left <= right) {
			mid = left + (right - left) / 2;
			if (arr.get(mid) == target) {
				index = mid;
				break;
			} else if (arr.get(mid) < target) {
				left = mid + 1;
			} else if (arr.get(mid) > target) {
				right = mid - 1;
			}
		}

		if (index >= 0)
			System.out.printf("Target %d found at index %d\n", target, index);
		else
			System.out.printf("Target %d not present in the array.\n", target);
	}
}
