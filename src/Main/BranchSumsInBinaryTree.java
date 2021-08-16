package Main;

import java.io.*;
import java.util.*;

// Given a root node of a Binary Tree, return all the branch sums of the tree. Branch Sums are 
// the sum of all nodes from the root node to the leaf node.

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
	
	// O(N) Time
	// O(N) Space
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
