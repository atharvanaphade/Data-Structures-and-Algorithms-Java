package Main;

import java.io.*;
import java.util.*;

// Given a matrix of 1s and 0s, find the islands of all sizes of 1s. An island is a group of 
// 4 or more than 4 adjacent horizontally or vertically 1s in the matrix.

class Pair {
	public int first;
	public int second;
	Pair(int a, int b) {
		this.first = a;
		this.second = b;
	}
}

public class GraphTraversalIslands {
	public static void main (String[] args) throws IOException {
		;
	}
	
	
	// O(M * N) Time
	// O(N) Space
	public static void Solution (int[][] arr) {
		ArrayList<Integer> sizes = new ArrayList<>();
		int m = arr.length, n = arr[0].length;
		Boolean[][] vis = new Boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (vis[i][j]) {
					continue;
				}
				TraverseNode(i, j, arr, vis, sizes);
			}
		}
		for (int i = 0; i < sizes.size(); i++) {
			System.out.println(sizes.get(i));
		}
	}
	
	public static void TraverseNode (int i, int j, int[][] arr, Boolean[][] vis, ArrayList<Integer> sizes) {
		int currSize = 0;
		Stack<Pair> s = new Stack<>();
		s.push(new Pair(i, j));
		while (!s.isEmpty()) {
			Pair temp = s.pop();
			i = temp.first;
			j = temp.second;
			if (vis[i][j]) {
				continue;
			}
			vis[i][j] = true;
			if (arr[i][j] == 0) {
				continue;
			}
			currSize += 1;
			ArrayList<Pair> Neigh = getNeigh (i, j, arr, vis);
			for (Pair pp : Neigh) {
				s.push(pp);
			}
		}
		if (currSize > 0) {
			sizes.add(currSize);
		}
	}
	
	public static ArrayList<Pair> getNeigh (int i, int j, int[][] arr, Boolean[][] vis) {
		ArrayList<Pair> ret = new ArrayList<>();
		if (i > 0 && !vis[i - 1][j]) {
			ret.add(new Pair(i - 1, j));
		}
		if (i < arr.length - 1 && !vis[i + 1][j]) {
			ret.add(new Pair(i + 1, j));
		}
		if (j > 0 && !vis[i][j - 1]) {
			ret.add(new Pair(i, j - 1));
		}
		if (j < arr.length - 1 && vis[i][j + 1]) {
			ret.add(new Pair(i, j + 1));
		}
		return ret;
	}
}
