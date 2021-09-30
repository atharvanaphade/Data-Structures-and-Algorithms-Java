package Main;

import java.io.*;
import java.util.*;

/**
 * Strongly Connected Components is a subgraph where in all pairs of vertices in the subgraph are connected.
 * Or if you start at any node, you can reach any other node in the subgraph.
 * kosaraju's algorithm finds all SCCs in a directed graph.
 * 
 * First find the topo sort of the graph.
 * Then find the transpose of the graph.
 * Do a reverse DFS of the transpose to find SCCs.
 * 
 * Time : O(E + V)
 * Space : O(E + V)
 * 
 * @author atharvanaphade
 *
 */

public class KosaRaju {
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	public static void DFS (int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> graph, int[] vis) {
		vis[node] = 1;
		for (Integer it : graph.get(node)) {
			if (vis[it] == 0) {
				DFS(it, st, graph, vis);
			}
		}
		st.push(node);
	}
	
	public static void revDFS (int node, ArrayList<ArrayList<Integer>> graph, int[] vis) {
		vis[node] = 1;
		System.out.print(node + " ");
		for (Integer it : graph.get(node)) {
			if (vis[it] == 0) {
				revDFS (it, graph, vis);
			}
		}
	}
	
	public static void Solution (ArrayList<ArrayList<Integer>> graph, int n) {
		int[] vis = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			if (vis[i] == 0) {
				DFS(i, st, graph, vis);
			}
		}
		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			transpose.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			vis[i] = 0;
			for (Integer it : graph.get(i)) {
				transpose.get(it).add(i);
			}
		}
		while (st.size() > 0) {
			int node = st.peek();
			st.pop();
			if (vis[node] == 0) {
				System.out.print("SCC : ");
				revDFS(node, transpose, vis);
				System.out.println();
			}
		}
	}
}
