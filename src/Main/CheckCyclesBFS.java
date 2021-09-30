package Main;

import java.io.*;
import java.util.*;

/**
 * Check cycles in a undirected graph using bfs
 * 
 * @author atharvanaphade
 *
 */

public class CheckCyclesBFS {
	static class Node {
		int first;
		int second;
		public Node(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	static boolean checkForCycle (ArrayList<ArrayList<Integer>> graph, int i, boolean[] vis, int[] parent) {
		Queue<Node> q = new LinkedList<>();
		q.add(new CheckCyclesBFS.Node(i, -1));
		vis[i] = true;
		
		while (!q.isEmpty()) {
			int node = q.peek().first;
			int par = q.peek().second;
			q.remove();
			for (Integer it : graph.get(node)) {
				if (vis[it] == false) {
					q.add(new CheckCyclesBFS.Node(it, node));
					vis[it] = true;
				} else if (par != it) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void Solution (int V, ArrayList<ArrayList<Integer>> graph) {
		boolean[] vis = new boolean[V];
		Arrays.fill(vis, false);
		int[] parent = new int[V];
		Arrays.fill(parent, -1);
		for (int i = 0; i <= V; i++) {
			if (vis[i] == false) {
				if (checkForCycle(graph, i, vis, parent)) {
					System.out.println("Cycle Exists");
					return;
				}
			}
		}
		System.out.println("Cycle does not exist");
	}
}
