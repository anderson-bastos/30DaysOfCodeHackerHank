package com.hackerhank.daysofcodehackerhank.day_13;

public abstract class Book {
	
	public String title;
    public String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    abstract void display();
}
