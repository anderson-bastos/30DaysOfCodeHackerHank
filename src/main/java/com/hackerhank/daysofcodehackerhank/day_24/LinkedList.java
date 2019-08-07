package com.hackerhank.daysofcodehackerhank.day_24;

public class LinkedList {

	private LinkedList() {
		throw new IllegalStateException("Utility class");
	}

	public static Node removeDuplicates(Node head) {
		Node previus = head;
		Node current = null;		
        while (previus != null && previus.next != null) {
            current = previus;
            while (current.next != null) {
                if (previus.data == current.next.data) {
                    current.next = current.next.next;
                } else { 
                	current = current.next;                    
                } 
            } 
            previus = previus.next;            
        } 
		return head;
	}

	public static Node insert(Node head, int data) {
		Node p = new Node(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

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
}
