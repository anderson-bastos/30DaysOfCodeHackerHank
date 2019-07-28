package com.hackerhank.daysofcodehackerhank.day_15;

public class LinkedList {
	
	public static Node insert(Node head, int data) {
		if (head == null)
			return new Node(data);
		
		if(head.next == null) {
			head.next = new Node(data);
		} else {
			Node current = head.next;
			while(current.next != null)
				current = current.next;
			current.next = new Node(data);
		}
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String[] args) {
		Node head = null;
		int[] list = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < list.length; i++) {
			head = insert(head, list[i]);
		}
		display(head);
	}
}
