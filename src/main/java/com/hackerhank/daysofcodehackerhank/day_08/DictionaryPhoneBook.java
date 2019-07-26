package com.hackerhank.daysofcodehackerhank.day_08;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryPhoneBook {

	static HashMap<String, Integer> phoneBook = new HashMap<>();

	public static void insertContact(String name, int phone) {
		phoneBook.put(name, phone);
	}
	
	public static String findContact(String s) {
		String result = "Not found";
		Integer phone = phoneBook.get(s);
		if(phone != null) 
			result = String.format("%s=%d", s, phone);
		return result; 
	}
	
	public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();        
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            insertContact(name, phone);
        }
        
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            System.out.println(findContact(s));
        }
        in.close();
    }

}
