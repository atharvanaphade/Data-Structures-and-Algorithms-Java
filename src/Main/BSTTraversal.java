package Main;

import java.io.IOException;
import java.util.ArrayList;

// Inorder -> left -> root -> right
// Preorder -> root -> left -> right
// Postrder -> left -> right -> root
//

public class BSTTraversal {
	class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) throws IOException {
		;
	}

	// Recursive
	// O(N) Time
	// O(N) Space
	public static ArrayList<Integer> inOrderTraversal(Node root, ArrayList<Integer> arr) {
		if (root != null) {
			arr = inOrderTraversal(root.left, arr);
			arr.add(root.val);
			arr = inOrderTraversal(root.right, arr);
		}
		return arr;
	}

	// Recursive
	// O(N) Time
	// O(N) Space
	public static ArrayList<Integer> preOrderTraversal(Node root, ArrayList<Integer> arr) {
		if (root != null) {
			arr.add(root.val);
			arr = preOrderTraversal(root.left, arr);
			arr = preOrderTraversal(root.right, arr);
		}
		return arr;
	}

	// Recursive
	// O(N) Time
	// O(N) Space
	public static ArrayList<Integer> postOrderTraversal(Node root, ArrayList<Integer> arr) {
		if (root != null) {
			arr = postOrderTraversal(root.left, arr);
			arr = postOrderTraversal(root.right, arr);
			arr.add(root.val);
		}
		return arr;
	}
}
// changes done
