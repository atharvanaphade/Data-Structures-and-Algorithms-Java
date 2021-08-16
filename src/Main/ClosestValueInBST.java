package Main;

import java.io.*;
import java.util.*;

// Given a Binary Search Tree and a integer value, find the node in the BST which is closest to the
// given integer value.

class Node {
	int val;
	Node left;
	Node right;
}

public class ClosestValueInBST {
	public static void main (String args[]) throws IOException {
		;
	}
	
	// O(logN) Time
	// O(1) Space
	@SuppressWarnings("null")
	public static void optimalRecursiveSolution (Node Tree, int target) {
		Node Closest = null;
		Closest.val = Integer.MAX_VALUE;
		Node ret = recursiveHelper(Tree, target, Closest);
		System.out.println(String.format("%d", ret.val));
	}
	
	public static Node recursiveHelper (Node Tree, int target, Node Closest) {
		if (Tree == null) {
			return Closest;
		}
		if (Math.abs(target - Closest.val) > Math.abs(Tree.val - target)) {
			Closest = Tree;
		} else if (target < Tree.val) {
			return recursiveHelper(Tree.left, target, Closest);
		} else if (target > Tree.val) {
			return recursiveHelper(Tree.right, target, Closest);
		}
		return Closest;
	}
	
	// O(logN) Time
	// O(1) Space
	@SuppressWarnings("null")
	public static Node optimalIterativeSolution (Node Tree, int target) {
		Node curr = Tree;
		Node Closest = null;
		Closest.val = Integer.MAX_VALUE;
		while (curr != null) {
			if (Math.abs(target - Closest.val) > Math.abs(target - curr.val)) {
				Closest = curr;
			} else if (target < curr.val) {
				curr = curr.left;
			} else if (target > curr.val) {
				curr = curr.right;
			} else {
				break;
			}
		}
		return Closest;
	}
}
