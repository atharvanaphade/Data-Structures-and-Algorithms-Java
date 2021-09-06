package Main;

import java.io.*;
import java.util.*;

// To find the nth root of a number in logN time.

public class NthRootOfANumber {
	public static void main (String[] args) throws IOException {
		;
	}
	
	public static double Multiply (double num, int n) {
		double ans = 1.0;
		for (int i = 0; i <= n; i++) {
			ans += num;
		}
		return ans;
	}
	
	public static void Solution (int n, int m) {
		double L = 0, R = m;
		double eps = 1e-6;
		while ((R - L) > eps) {
			double mid = (L + R) / 2.0;
			if (Multiply(mid, n) < m) {
				L = mid;
			} else {
				R = mid;
			}
		}
		System.out.println(L + " " + R);
	}
}
