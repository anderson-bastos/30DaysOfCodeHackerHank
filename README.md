

# 30 Days of Code 
Every day for 30 days, you will receive an email posing a challenge for you to code, solve, and submit the solution.


### Day 0 - Hello, World.
To complete this challenge, you must save a line of input from stdin to a variable, print Hello, World. on a single line, and finally print the value of your variable on a second line.

### Day 1 - Data Types
Complete the code in the editor below. The variables **i**,**d**, and **s**  are already declared and initialized for you. You must:

1.  Declare **3** variables: one of type int, one of type double, and one of type String.
2.  Read **3** lines of input from stdin (according to the sequence given in the Input Format section below) and initialize your variables.
3.  Use the + operator to perform the following operations: 
   -  Print the sum of  plus your int variable on a new line.
   -   Print the sum of  plus your double variable to a scale of one decimal place on a new line.
  -   Concatenate  with the string you read as input and print the result on a new line.
  
##### Solution:
```java
int i = 4;
double d = 4.0;
String s = "HackerRank ";

Scanner scan = new Scanner(System.in);
/* Declare second integer, double, and String variables. */
 int secondInteger = 0;
double secondDouble = 0;
 String secondString = ""; 

 /* Read and save an integer, double, and String to your variables.*/
 // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.        
 secondInteger = Integer.parseInt(scan.nextLine().trim());
 secondDouble = Double.parseDouble(scan.nextLine().trim());
 secondString = scan.nextLine();

/* Print the sum of both integer variables on a new line. */
System.out.println(i+secondInteger);

/* Print the sum of the double variables on a new line. */
System.out.println(d+secondDouble);

/* Concatenate and print the String variables on a new line; 
the 's' variable above should be printed first. */
System.out.println(s+secondString);
scan.close();
```	

### Day 2 - Operators
Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip), and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost.

**Note:** Be sure to use precise valuaes for your calculations, or you may end up with an incorrectly rounded result!

##### Solution:
```java
public static double totalCoast(double mealCost, int tipPercent, int taxPercent) {
	double tip = calculatePercentage(mealCost, tipPercent);
	double tax = calculatePercentage(mealCost, taxPercent);		
	return Math.round((mealCost + tip + tax));
}

private static double calculatePercentage(double mealCost, int valuePercentage) {
	return mealCost * (valuePercentage/100.0);
}
```

### Day 3 - Intro to Conditional Statements

Given an integer, **n**, perform the following conditional actions:

  * If **n** is odd, print **Weird**
  * If **n** is even and in the inclusive range of **2** to **5** , print **Not Weird**
  * If **n** is even and in the inclusive range of **6** to **20** , print **Weird**
  * If **n** is even and greater than **20** , print **Not Weird**
Complete the stub code provided in your editor to print whether or not **n** is weird.

##### Solution:
```java
public static final String WEIRD = "Weird";
public static final String NOT_WEIRD = "Not Weird";

private static boolean isOddNumber(int number) {
	return number % 2 != 0;
}

private static boolean contains(IntStream rangeInterval, final int key) {     
	return rangeInterval.anyMatch(x -> x == key);
}

public static String checkIfWeirdNumber(int number) {
	Boolean isOddNumber = isOddNumber(number);		
	if(isOddNumber)
		return WEIRD;
	
	if(contains(IntStream.range(2, 6), number))
		return NOT_WEIRD;
	
	if(contains(IntStream.range(6, 21), number))
		return WEIRD;
	
	return NOT_WEIRD;
}
```

### Day 4 - Arrays
Write a Person class with an instance variable, **age** , and a constructor that takes an integer, **initialAge** , as a parameter. The constructor must assign  to  after confirming the argument passed as **initialAge** is not negative; if a negative argument is passed as **initialAge** , the constructor should set **age**  to **0** and print **Age is not valid, setting age to 0.**. In addition, you must write the following instance methods:

1. yearPasses() should increase the **age** instance variable by **1**.
2. amIOld() should perform the following conditional actions:
- If age < 13, print You are young..
- If age >= 13  and age < 18 , print You are a teenager..
- Otherwise, print You are old..
To help you learn by example and complete this challenge, much of the code is provided for you, but you'll be writing everything in the future. The code that creates each instance of your Person class is in the main method. Don't worry if you don't understand it all quite yet!

##### Solution:
```java
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
```

### Day 5 - Loops
Given an integer, **n** , print its first **10** multiples. Each multiple **n** x **i** (where 1 <= i <= 10 ) should be printed on a new line in the form: n x i = result.

##### Solution:
```java
public static void loopMultiples(int number) {
	IntStream.range(1, 11).forEach(x -> System.out.printf("%d x %d = %d %n", number, x, number*x));
}
```

### Day 6 - Let's Review
Given a string, **S** , of length **N**  that is indexed from **0** to **N-1**, print its even-indexed and odd-indexed characters as  **2** space-separated strings on a single line (see the Sample below for more detail).

**Note:**  is considered to be an even index.

##### Solution:
```java
public static void formatSringArr(String[] text) {
	Arrays.stream(text).forEach(x -> System.out.println(formatSring(x)));
}

public static String formatSring(String text) {
	StringBuilder evenText = new StringBuilder();
	StringBuilder oddText = new StringBuilder();
	int textLength = text.length();

	for (int i = 0; i < textLength; i++) {
		if (i % 2 == 0)
			evenText.append(text.charAt(i));
		else
			oddText.append(text.charAt(i));
	}
	return String.format("%s %s", evenText.toString(), oddText.toString());
}

private static final Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
	int llistCount = scanner.nextInt();
	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	String[] arr = new String[llistCount];
	for (int i = 0; i < llistCount; i++) {
		String element = scanner.nextLine();
		arr[i] = element;
	}
	formatSringArr(arr);
}
```

### Day 7 - Arrays
Given an array, **A**, of **N**  integers, print **A**'s elements in reverse order as a single line of space-separated numbers.

##### Solution:
```java
public static int[] inverseArray(int[] array) {
	int length = array.length;
	int mid = length / 2;
	for (int i = 0; i < mid; i++) {
		int aux = array[length - 1 - i];
		array[length - 1 - i] = array[i];
		array[i] = aux;
	}
	return array;
}
```

### Day 8 - Dictionaries and Maps
Given **n** names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers. You will then be given an unknown number of names to query your phone book for. For each **name** queried, print the associated entry from your phone book on a new line in the form name=phoneNumber; if an entry for **name** is not found, print Not found instead.

##### Solution:
```java
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
public static void main(String []args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();        
    for(int i = 0; i < n; i++){
        String name = in.next();
        int phone = in.nextInt();
        insertContact(name, phone);
    }        
    while(in.hasNext()){
        String s = in.next();
        System.out.println(findContact(s));
    }
    in.close();
}
```
### Day 9 - Recursion 3
Write a factorial function that takes a positive integer, **N** as a parameter and prints the result **N!** of  (**N** factorial).
##### Solution:
```java
static int factorial(int n) {
  if(n <= 1)
	return 1;
  return n * factorial(n-1);
}
```

### Day 10 - Binary Numbers
Given a base-**10** integer, **n** , convert it to binary (base-**2**). Then find and print the base-**10** integer denoting the maximum number of consecutive **1**'s in **n**'s binary representation.

##### Solution:
```java
public static int calculateConsecutiveOnesBinaryNumber(int number) {
	String binaryNumber = Integer.toBinaryString(number);
	int count = 0;
	int maxOnes = 1;
	for (int i = 0; i < binaryNumber.length(); i++) {
		if(binaryNumber.charAt(i) == '1'){
			++count;
			if(count > maxOnes) 
				maxOnes = count;
			continue;
		}
		count=0;
	}
	return maxOnes;
}
```

### Day 11 - 2D Arrays
Calculate the hourglass sum for every hourglass in **A**, then print the maximum hourglass sum.

##### Solution:
```java
public static int maxArray2D(int[][] arr) {		
	int sumElements = 0;
   	int sumMax = 0;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			sumElements = sumElementsArray(arr, i, j);
            if(sumElements > sumMax || (i==0 && j==0))
            	sumMax = sumElements;
		}			
	}
	return sumMax;
}

private static int sumElementsArray(int[][] arr, int i, int j) {
	return arr[i][j] + arr[i][j+1] + arr[i][j+2]
	        + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1]
	        + arr[i+2][j+2];
}
```

### Day 12 - Inheritance
You are given two classes, Person and Student, where Person is the base class and Student is the derived class. Completed code for Person and a declaration for Student are provided for you in the editor. Observe that Student inherits all the properties of Person.

Complete the Student class by writing the following:
- A Student class constructor, which has **4**  parameters:
     1. A string, **firstName**
	 2. A string, **lastName**
	 3. An integer, **id**
	 4. An integer array (or vector) of test scores, **scores**.
- A char calculate() method that calculates a Student object's average and returns the grade character representative of their calculated average:

![](https://s3.amazonaws.com/hr-challenge-images/17165/1458142706-3073bc9143-Grading.png)

##### Solution:
```java
public class Person {	
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	public Person(String firstName, String lastName, int identification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	public void printPerson() {
		System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
	}
}

public class Student extends Person {	
	private int[] testScores;
	
	public Student(String firstName, String lastName, int identification, int[] testScores) {
		super(firstName, lastName, identification);
		this.testScores = testScores;
	}
	
	private double calculateAveragePoints() {
		int scores = this.testScores.length;
		return Arrays.stream(this.testScores).sum()/scores;
	}

	private char getScale(double averageScores) {
		if(averageScores >= 90 && averageScores <= 100)
			return 'O';
		if(averageScores >= 80 && averageScores <= 90)
			return 'E';
		if(averageScores >= 70 && averageScores <= 80)
			return 'A';
		if(averageScores >= 55 && averageScores <= 70)
			return 'P';
		if(averageScores >= 40 && averageScores <= 55)
			return 'D';		
		return 'T';
	}
	
	public char calculate() {
		double averageScores = calculateAveragePoints();
		return getScale(averageScores);
	}
}
```
### Day 13 - Abstract Classes
Given a Book class and a Solution class, write a MyBook class that does the following:

- Inherits from Book
- Has a parameterized constructor taking these **3** parameters:
  1. string **title**
  2. string **author** 
  3. string **price**
- Implements the _Book_ class' abstract _display()_ method so it prints these lines:
  1. **Title**: a space, and then the current instance's **title**
  2. **Author**: a space, and then the current instance's **author**
  3. **Price**: a space, and then the current instance's **price**
  
  **Note:** Because these classes are being written in the same file, you must not use an access modifier (e.g.: ) when declaring _MyBook_ or your code will not execute.

##### Solution:
```java

public abstract class Book {	
    public String title;
    public String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }    
    abstract void display();
}

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
```
