package com.hackerhank.daysofcodehackerhank.day_18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
	
	Queue<Character> queue;
	Stack<Character> stack;
	
	public Palindrome() {
		queue = new LinkedList<>();
		stack = new Stack<>();
	}

	public void pushCharacter(char ch) {
		stack.push(ch);
	}
	
	public void enqueueCharacter(char ch) {
		queue.add(ch);
	}
	
	public char popCharacter() {
		return stack.pop();	
	}
	
	public char dequeueCharacter() {
		 return queue.poll();
	}
}
