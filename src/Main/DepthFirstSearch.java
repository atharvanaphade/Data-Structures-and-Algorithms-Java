package Main;

import java.io.*;
import java.util.*;

// A Basic graph/tree traversal algorithm which searches the depths of a graph/tree first,
// ideal searching algo in graphs and trees.

public class DepthFirstSearch {
	
	class Node {
		ArrayList<Node> adj=new ArrayList<>();
		int dist;
	}
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	static void BFSIterative(Node from, Node[] nodes) {
		for (Node nn:nodes) nn.dist=-1;
		from.dist=0;
		ArrayDeque<Node> bfs=new ArrayDeque<>();
		bfs.add(from);
		while (!bfs.isEmpty()) {
			Node next=bfs.remove();
			for (Node nn:next.adj) {
				if (nn.dist==-1) {
					nn.dist=next.dist+1;
					bfs.add(nn);
				}
			}
		}
	}
	
	public static void DFSRecursive(ArrayList<Node> children) {
		;
	}
}
