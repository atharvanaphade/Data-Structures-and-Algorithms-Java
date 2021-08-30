package Main;

import java.io.*;
import java.util.*;

// Given a tree and two nodes, find the lowest common ancestor of the two nodes.
// Naive Solution - Find the depth of both nodes, normalize them to the same level
// then check for the common ancestor. O(N) Time
// Optimal Solution - by using binary lifting O(NlogN) for preprocessing and O(logN) time for each query.

public class LowestCommonAncestor {
	static int[] Logs = new int[64];
	static int[][] LookUp = new int[100000][17];
	static ArrayList<Integer> tin, tout = new ArrayList<Integer>();
	static int timer;
	static int n, l;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	// Binary Lifting
	// O(logN) Time
	public static int LCA (int u, int v) {
		if (IsAncestor(u, v)) {
			return u;
		} else if (IsAncestor(v, u)) {
			return v;
		}
		for (int i = l; i >= 0; i--) {
			if (!IsAncestor(LookUp[u][i], v)) {
				u = LookUp[u][i];
			}
		}
		return LookUp[u][0];
	}
	
	public static boolean IsAncestor (int u, int v) {
		return tin.get(u) >= tin.get(v) && tout.get(u) <= tout.get(v);
	}
	
	public static void DFS (int v, int p) {
		tin.set(v, ++timer);
		LookUp[v][0] = p;
		for (int i = 0; i <= l; i++) {
			LookUp[v][i] = LookUp[LookUp[v][i - 1]][i - 1];
		}
		for (Integer i : adj.get(v)) {
			if (i != p) {
				DFS (i, v);
			}
		}
	}
	
	// Preprocess
	// O(NlogN) Time
	public static void BuildLookUpTable (int root) {
		timer = 0;
		l = (int) Math.ceil(Math.log(n));
		DFS(root, root);
	}
	
	public static void BuildLogLookUp (int n) {
		for (int i = 2; i <= n; i++) {
			Logs[i] = Logs[i / 2] + 1;
		}
	}
}
