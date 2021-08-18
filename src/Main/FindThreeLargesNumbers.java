package Main;

import java.io.*;
import java.util.*;

public class FindThreeLargesNumbers {
	public static void main (String[] args) throws IOException {
		int[] a = {12, 34, 55, 667, 34, 34, 43};
		Solution(a);
	}
	
	public static void Solution (int[] a) {
		int n = a.length;
		int[] ret = new int[3];
		ret[0] = a[0];
		ret[1] = a[1];
		ret[2] = a[2];
		for (int i : a) {
			if (i > ret[0]) {
				ret[0] = i;
				continue;
			} else if (i > ret[1]) {
				ret[1] = i;
				continue;
			} else if (i > ret[2]) {
				ret[2] = i;
			}
		}
		Arrays.sort(ret);
		for (int i : ret) {
			System.out.print(i + " ");
		}
	}
}
