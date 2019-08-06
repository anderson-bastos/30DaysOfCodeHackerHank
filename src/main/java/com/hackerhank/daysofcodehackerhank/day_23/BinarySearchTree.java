package com.hackerhank.daysofcodehackerhank.day_23;

import com.hackerhank.daysofcodehackerhank.day_22.Node;

public class BinarySearchTree {
	
	private BinarySearchTree() {
		throw new IllegalStateException("Utility class");
	}
	
	static void levelOrder(Node root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	static int height(Node root) {
		if (root == null)
			return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		if (leftHeight > rightHeight)
			return (leftHeight + 1);			
		return (rightHeight + 1);		
	}

	static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
}
