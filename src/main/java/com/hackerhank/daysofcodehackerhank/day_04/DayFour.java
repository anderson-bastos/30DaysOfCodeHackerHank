package com.hackerhank.daysofcodehackerhank.day_04;

import java.util.function.IntFunction;

/**
 * Person Class
 * @author Anderson Bastos
 *
 */
public class DayFour {

	private int age;

	public static final String YOUNG = "You are young.";
	public static final String TEENAGER = "You are a teenager.";
	public static final String OLD = "You are old.";
	
	private static IntFunction<String> youngFunction = x -> x >= 13 && x < 18 ? TEENAGER : OLD;
	private static IntFunction<String> ageFunction = x -> x < 13 ? YOUNG : youngFunction.apply(x);
	
	public DayFour(int initialAge) {		
		if(initialAge < 0) {
			this.age = 0;
			System.out.println("Age is not valid, setting age to 0.");
		}
		this.age = initialAge;
	}
	
	public String checkamIOld() {
		return ageFunction.apply(this.age);
	}
	
	public void amIOld() {		
		System.out.println(checkamIOld());
	}	

	public void yearPasses() {
		this.age++;
	}
	
	public static void main(String[] args) {
		DayFour dayFour = new DayFour(10);	
		dayFour.amIOld();
	}
}
