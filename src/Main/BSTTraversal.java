package Main;

import java.io.*;
import java.util.*;

// Inorder -> left -> root -> right
// Preorder -> root -> left -> right
// Postrder -> left -> right -> root

public class BSTTraversal {
	static class Node {
		int val;
		Node left;
		Node right;
	}
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	// Recursive
	// O(N) Time
	// O(N) Space
	public static ArrayList<Integer> InOrder (Node root, ArrayList<Integer> arr) {
		if (root != null) {
			arr = InOrder(root.left, arr);
			arr.add(root.val);
			arr = InOrder(root.right, arr);
		}
		return arr;
	}
	
	// Recursive
	// O(N) Time
	// O(N) Space
	public static ArrayList<Integer> PreOrder (Node root, ArrayList<Integer> arr) {
		if (root != null) {
			arr.add(root.val);
			arr = PreOrder(root.left, arr);
			arr = PreOrder(root.right, arr);
		}
		return arr;
	}
	
	// Recursive
	// O(N) Time
	// O(N) Space
	public static ArrayList<Integer> PostOrder (Node root, ArrayList<Integer> arr) {
		if (root != null) {
			arr = PostOrder(root.left, arr);
			arr = PostOrder(root.right, arr);
			arr.add(root.val);
		}
		return arr;
	}
}
