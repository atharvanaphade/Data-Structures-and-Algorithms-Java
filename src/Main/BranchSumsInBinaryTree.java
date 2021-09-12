package Main;

import java.io.*;
import java.util.*;

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
 * val (int)
 * left (Node)
 * right (Node)
 * 
 * @author atharvanaphade
 *
 */
class Node {
	int val;
	Node left;
	Node right;
}

public class BranchSumsInBinaryTree {
	
	public static ArrayList<Integer> ret = new ArrayList<>();
	
	public static void main (String[] args) throws IOException {
		Node a = new Node();
		a.val = 1;
		Node b = new Node();
		b.val = 2;
		a.left = b;
		Node c = new Node();
		c.val = 3;
		Node d = new Node();
		d.val = 4;
		Node e = new Node();
		e.val = 5;
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
	 * @param Tree
	 */
	public static void naive (Node Tree) {
		RecursiveHelper(Tree, 0);
	}
	
	public static void RecursiveHelper (Node curr, int sum) {
		if (curr == null) return;
		sum += curr.val;
		if (curr.left == null && curr.right == null) {
			ret.add(sum);
		} 
		RecursiveHelper(curr.left, sum);
		RecursiveHelper(curr.right, sum);
	}
}
