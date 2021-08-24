package Main;

import java.io.*;
import java.util.*;

// 

public class InvertBinaryTree {
	class Node {
		int val;
		Node right;
		Node left;
	}
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	public static void SwapNode (Node i) {
		Node temp = i.left;
		i.left = i.right;
		i.right = temp;
	}
	
	// O(N) Space
	// O(N) Time
	public static void Solution (Node root) {
		ArrayDeque<Node> q = new ArrayDeque<Node>();
		Node curr = root;
		q.add(curr);
		while (!q.isEmpty()) {
			Node temp = q.pop();
			SwapNode(temp);
			if (temp.right != null) {
				q.add(temp.right);
			} 
			if (temp.left != null) {
				q.add(temp.left);
			}
		}
	}
}
