package Main;

import java.io.*;
import java.util.*;

// Breadth First Search - Recursive and Iterative

public class BreadthFirstSearch {
	class Node {
		int dist;
		ArrayList<Node> adj;
	}
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	// O(N) Time
	// O(N) Space
	public static void Iterative (Node from, Node[] nodes) {
		for (Node nn : nodes) {
			nn.dist = -1;
		}
		from.dist = 0;
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(from);
		while (!q.isEmpty()) {
			Node temp = q.remove();
			for (Node nn : temp.adj) {
				// Search property or query here
				if (nn.dist == -1) {
					nn.dist = nn.dist + 1;
					q.add(nn);
				}
			}
		}
	}
	
	// O(N + M) Time
	// O(N) Space
	public static void Recursive (int n, ArrayList<ArrayList<Integer>> edgesList, ArrayList<Integer> dist, ArrayDeque<Integer> q) {
		for (Integer i : edgesList.get(n)) {
			if (dist.get((int)i) != -1) {
				continue;
			}
			dist.set(i, dist.get(n) + 1);
			q.add(i);
		}
		
		while (!q.isEmpty()) {
			n = q.remove();
			Recursive(n, edgesList, dist, q);
		}
	}
}
