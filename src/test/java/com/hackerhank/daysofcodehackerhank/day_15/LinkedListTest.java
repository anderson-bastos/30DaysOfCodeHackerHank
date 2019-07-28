package com.hackerhank.daysofcodehackerhank.day_15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

	@Test
	public void insertTest() {
		int[] elements = { 1, 2, 3, 4, 5 };
		Node head = null;
		for (int i = 0; i < elements.length; i++) {
			head = LinkedList.insert(head, elements[i]);
		}
		
		int[] arrResult = new int[5];
		for (int j = 0; j < arrResult.length; j++) {
			arrResult[j] = head.data;
			head = head.next;
		}	
		Assertions.assertArrayEquals(arrResult, elements);
	}
}
