package Main;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>Branch Sums of a Binary Tree</h1>
 * 
 * <p>Given the root of a binary tree return all the branch sums of the tree. Branch sum is the sum of all nodes from the root to the leaf node of the binary tree.</p>
 * 
 * @author atharvanaphade
 *
 */

/**
 * <h1>TreeNode Class</h1>
 * 
 * val (int) left (Node) right (Node)
 * 
 * @author atharvanaphade
 *
 */
class Node {
	int val;
	Node left;
	Node right;
	Node(int val){
		this.val = val;
	}
}

public class BranchSumsInBinaryTree {

	public static ArrayList<Integer> ret = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		/*
		 * 			1
		 * 		   / \
		 * 		  2   5
		 * 		 / \
		 *      3   4
		 */
		
		Node a = new Node(1);
		Node b = new Node(2);
		a.left = b;
		
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		
		b.left = c;
		b.right = d;
		a.right = e;

		naive(a);

		for (Integer n : ret) {
			System.out.println(n + " ");
		}
	}

	/**
	 * Recursive solution in O(N) time and Space.<br>
	 * Solution is quite self explanatory :).
	 * 
	 * @param tree
	 */
	public static void naive(Node tree) {
		recursiveHelper(tree, 0);
	}

	public static void recursiveHelper(Node curr, int sum) {
		if (curr == null)
			return;
		
		sum += curr.val;
		
		if (curr.left == null && curr.right == null) {
			ret.add(sum);
		}
		
		recursiveHelper(curr.left, sum);
		recursiveHelper(curr.right, sum);
	}
}
