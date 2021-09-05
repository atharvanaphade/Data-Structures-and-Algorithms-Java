package Main;

import java.io.*;
import java.util.*;

// Check if one string contains another string. (Pattern Matching)
// Intuition : -
//
// To identify patterns in the string to check for in the bigger string.
// This works for larger Strings better.

public class KMP {
	public static void main (String[] args) throws IOException {
		;
	}
	
	public static int[] BuildPattern (String t) {
		int[] ret = new int[t.length()];
		for (int i = 0; i < t.length(); i++) {
			ret[i] = -1;
		}
		int j = 0, i = 1;
		while (i < t.length()) {
			if (t.charAt(i) == t.charAt(j)) {
				ret[i] = j;
				i++;
				j++;
			} else if (j > 0) {
				j = ret[j - 1] + 1;
			} else {
				i++;
			}
		}
		return ret;
	}
	
	public static boolean DoesMatch (String s, String t, int[] pattern) {
		int i = 0, j = 0;
		while (i + t.length() - j <= s.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				if (j == t.length() - 1) {
					return true;
				}
				i++;
				j++;
			} else if (j > 0) {
				j = pattern[j - 1] + 1;
			} else {
				i++;
			}
		}
		return false;
	}
	
	public static void Solution (String s, String t) {
		int[] pattern = BuildPattern(t);
		if (DoesMatch(s, t, pattern)) {
			System.out.println("Matches");
		} else {
			System.out.println("Does not Match");
		}
	}
}
