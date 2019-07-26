package com.hackerhank.daysofcodehackerhank.day_13;

public class MyBook extends Book {
	
	public int price = 0;
	
	MyBook(String title, String author, int price) {
		super(title, author);
		this.price = price;
	}

	@Override
    void display() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
    }
}
