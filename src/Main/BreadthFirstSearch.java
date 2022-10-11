package Main;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

// Breadth First Search - Recursive and Iterative

public class BreadthFirstSearch {
	class Node {
		int dist;
		ArrayList<Node> adjacentNodes;
	}

	public static void main(String[] args) throws IOException {
		;
	}

	// O(N) Time
	// O(N) Space
	public static void Iterative(Node from, Node[] nodes) {
		for (Node node : nodes) {
			node.dist = -1;
		}
		
		from.dist = 0;
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.add(from);
		
		while (!q.isEmpty()) {
			Node temp = q.remove();
			for (Node adjacentNode : temp.adjacentNodes) {
				
				// Search property or query here
				if (adjacentNode.dist == -1) {
					adjacentNode.dist = adjacentNode.dist + 1;
					q.add(adjacentNode);
				}
			}
		}
	}

	// O(N + M) Time
	// O(N) Space
	public static void recursive(int n, ArrayList<ArrayList<Integer>> edgesList, ArrayList<Integer> dist,
			ArrayDeque<Integer> q) {
		
		
		for (Integer i : edgesList.get(n)) {
			if (dist.get((int) i) != -1) {
				continue;
			}
			dist.set(i, dist.get(n) + 1);
			q.add(i);
		}

		while (!q.isEmpty()) {
			n = q.remove();
			recursive(n, edgesList, dist, q);
		}
	}
}
