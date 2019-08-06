package com.hackerhank.daysofcodehackerhank.day_22;

public class BinarySearchTree {

	private BinarySearchTree() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Dat 22
	 * 
	 * @param root
	 * @return
	 */
	public static int getHeight(Node root) {
		if (root == null)
			return -1;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
}
