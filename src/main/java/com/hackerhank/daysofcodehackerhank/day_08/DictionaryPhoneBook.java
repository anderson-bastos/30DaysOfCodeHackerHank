package com.hackerhank.daysofcodehackerhank.day_08;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class DictionaryPhoneBook {

	static Dictionary<String, Integer> phoneBook = new Hashtable<>();

	public static void insertContact(String name, int phone) {
		phoneBook.put(name, phone);
	}
	
	private static String findContact(String s) {
		String result = "Not found";
		Integer phone = phoneBook.get(s);
		if(phone != null) 
			result = String.format("%s=%d", s, phone);
		return result; 
	}

	public static void main(String []argh){
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
