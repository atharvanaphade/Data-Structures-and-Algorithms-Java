package Main;

import java.io.*;
import java.util.*;

// A BST or Binary Search Tree is a data structure in the form of a tree, where
// all nodes have atmost two children, and all left nodes are smaller than tha root,
// and the right node is strictly greater that the root node.
// Search, Insert and Delete from a BST.
//
// Important Tricks for BST : -
// 
// -> Inorder traversal of a BSt gives a sorted array.

public class BuildBinarySearchTree {
	class Node {
		int val;
		Node left;
		Node right;
	}
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	// O(logN) Time
	// O(1) Space
	public static Node Insert(Node root, Node insert) {
		while(true) {
			if (root.val > insert.val) {
				if (root.left == null) {
					root.left = insert;
					break;
				} else {
					root = root.left;
				}
			}
			if (root.val <= insert.val) {
				if (root.right == null) {
					root.right = insert;
					break;
				} else {
					root = root.right;
				}
			}
		}
		return root;
	}
	
	// O(logN) Time
	// O(1) Space
	public static Boolean Search (Node root, int target) {
		Boolean ret = false;
		while (root != null) {
			if (root.val < target) {
				if (root.right != null) {
					root = root.right;
				} else {
					return false;
				}
			} else if (root.val > target) {
				if (root.left != null) {
					root = root.left;
				} else {
					return false;
				}
			} else if (root.val == target) {
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	public static Node GetMinValue (Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	// O(logN) Time
	// O(1) Space
	public static void Delete (Node root, int target, Node parentNode) {
		while (root != null) {
			if (target < root.val) {
				parentNode = root;
				root = root.left;
			} else if (target > root.val) {
				parentNode = root;
				root = root.left;
			} else {
				if (root.left != null && root.right != null) {
					root.val = GetMinValue(root.right).val;
					Delete(root.right, root.val, root);
				} else if (parentNode == null) {
					if (root.left != null) {
						root.val = root.left.val;
						root.right = root.left.right;
						root.left = root.left.left;
					} else if (root.right != null) {
						root.val = root.right.val;
						root.right = root.right.left;
						root.left = root.right.right;
					} else {
						root.val = 0;
					}
				} else if (parentNode.left == root) {
					parentNode.left = root.left != null ? root.left : root.right;
				} else if (parentNode.right == root) {
					parentNode.right = root.left != null ? root.left : root.right;
				}
				break;
			}
		}
	}
}
