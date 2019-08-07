package com.hackerhank.daysofcodehackerhank.day_24;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hackerhank.daysofcodehackerhank.util.FileTestCaseUtil;

public class LinkedListTest {

	@Test
	public void getHeightTestZero() {
		Node input = loadFileInput("input00.txt");
		String expected = loadFileOutput("output00.txt");
		
		Node head = LinkedList.removeDuplicates(input);
		Assertions.assertEquals(expected, display(head));		
	}
	
	public static String display(Node head) {
		Node start = head;
		StringBuilder stringBuilder = new StringBuilder();
		while (start != null) {
			stringBuilder.append(start.data).append(" ");
			start = start.next;
		}
		stringBuilder.setLength(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}

	private static Node loadFileInput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_24/input/" + fileName);
		int T = scanner.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = scanner.nextInt();
			root = LinkedList.insert(root, data);
		}
		scanner.close();
		return root;
	}

	private static String loadFileOutput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_24/output/" + fileName);
		String expected = scanner.nextLine();
		scanner.close();
		return expected;
	}
}
