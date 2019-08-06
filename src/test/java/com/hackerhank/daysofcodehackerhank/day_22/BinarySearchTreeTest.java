package com.hackerhank.daysofcodehackerhank.day_22;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.hackerhank.daysofcodehackerhank.day_22.BinarySearchTree;
import com.hackerhank.daysofcodehackerhank.day_22.Node;
import com.hackerhank.daysofcodehackerhank.util.FileTestCaseUtil;

@TestMethodOrder(OrderAnnotation.class)
public class BinarySearchTreeTest {

	@Test
	@Order(0)
	public void getHeightTestZero() {
		Node input = loadFileInput("input00.txt");
		int expected = loadFileOutput("output00.txt");
		
		int actual = BinarySearchTree.getHeight(input);
		Assertions.assertEquals(expected, actual);		
	}
	
	@Test
	@Order(1)
	public void getHeightTestOne() {
		Node input = loadFileInput("input01.txt");
		int expected = loadFileOutput("output01.txt");
		
		int actual = BinarySearchTree.getHeight(input);
		Assertions.assertEquals(expected, actual);		
	}
	
	@Test
	@Order(2)
	public void getHeightTestTwo() {
		Node input = loadFileInput("input02.txt");
		int expected = loadFileOutput("output02.txt");
		
		int actual = BinarySearchTree.getHeight(input);
		Assertions.assertEquals(expected, actual);		
	}

	private static Node loadFileInput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_22/input/" + fileName);
		int T = scanner.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = scanner.nextInt();
			root = BinarySearchTree.insert(root, data);
		}
		scanner.close();
		return root;
	}

	private static int loadFileOutput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_22/output/" + fileName);
		int height = scanner.nextInt();
		scanner.close();
		return height;
	}
}
