

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

### Day 14 - Scope
Complete the Difference class by writing the following:
- A class constructor that takes an array of integers as a parameter and saves it to the **elements** instance variable.
- A computeDifference method that finds the maximum absolute difference between any **2** numbers in **N**  and stores it in the **maximumDifference** instance variable.  

##### Solution:
```java
public class Difference {

	private int[] elements;
	public int maximumDifference;

	public Difference(int[] elements) {
		this.elements = elements;
		this.maximumDifference = 0;
	}

	public void computeDifference() {
		int n = elements.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				int difference = calculateDifference(elements[i], elements[j]);
				if(difference > maximumDifference)
					maximumDifference = difference;
			}
		}
	}
	
	private int calculateDifference(int i, int j) {
		return i > j ? i - j : j - i;
	}
}
```
### Day 15 - Linked List
Complete the insert function in your editor so that it creates a new Node (pass **data** as the Node constructor argument) and inserts it at the tail of the linked list referenced by the **head** parameter. Once the new node is added, return the reference to the **head** node.

**Note**: If the  argument passed to the insert function is null, then the initial list is empty.

##### Solution:
```java
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
```
### Day 16 - Exceptions - String to Integer
Read a string, **S** , and print its integer value; if **S** cannot be converted to an integer, print Bad String.

**Note:** You must use the String-to-Integer and exception handling constructs built into your submission language. If you attempt to use loops/conditional statements, you will get a **0** score.

##### Solution:
```java
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String S = in.next();
	in.close();
	try {
		int number = Integer.parseInt(S);
		System.out.println(number);
	} catch (NumberFormatException nfe) {
		System.out.println("Bad String.");
	}
}
```

### Day 17 - More Exceptions
Write a Calculator class with a single method: int power(int,int). The power method takes two integers, **n** and **p** , as parameters and returns the integer result of <svg xmlns:xlink="http://www.w3.org/1999/xlink" width="2.454ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 1056.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M21 287Q22 293 24 303T36 341T56 388T89 425T135 442Q171 442 195 424T225 390T231 369Q231 367 232 367L243 378Q304 442 382 442Q436 442 469 415T503 336T465 179T427 52Q427 26 444 26Q450 26 453 27Q482 32 505 65T540 145Q542 153 560 153Q580 153 580 145Q580 144 576 130Q568 101 554 73T508 17T439 -10Q392 -10 371 17T350 73Q350 92 386 193T423 345Q423 404 379 404H374Q288 404 229 303L222 291L189 157Q156 26 151 16Q138 -11 108 -11Q95 -11 87 -5T76 7T74 17Q74 30 112 180T152 343Q153 348 153 366Q153 405 129 405Q91 405 66 305Q60 285 60 284Q58 278 41 278H27Q21 284 21 287Z"></path><g transform="translate(600,362)"><path stroke-width="1" transform="scale(0.707)" d="M23 287Q24 290 25 295T30 317T40 348T55 381T75 411T101 433T134 442Q209 442 230 378L240 387Q302 442 358 442Q423 442 460 395T497 281Q497 173 421 82T249 -10Q227 -10 210 -4Q199 1 187 11T168 28L161 36Q160 35 139 -51T118 -138Q118 -144 126 -145T163 -148H188Q194 -155 194 -157T191 -175Q188 -187 185 -190T172 -194Q170 -194 161 -194T127 -193T65 -192Q-5 -192 -24 -194H-32Q-39 -187 -39 -183Q-37 -156 -26 -148H-6Q28 -147 33 -136Q36 -130 94 103T155 350Q156 355 156 364Q156 405 131 405Q109 405 94 377T71 316T59 280Q57 278 43 278H29Q23 284 23 287ZM178 102Q200 26 252 26Q282 26 310 49T356 107Q374 141 392 215T411 325V331Q411 405 350 405Q339 405 328 402T306 393T286 380T269 365T254 350T243 336T235 326L232 322Q232 321 229 308T218 264T204 212Q178 106 178 102Z"></path></g></g></svg>
. If either **n** or **p**  is negative, then the method must throw an exception with the message:**n and p should be non-negative.**


##### Solution:
```java
class Calculator {
	
	public int power(int n, int p) {
		if (n < 0 || p < 0)
			throw new IllegalArgumentException("n and p should be non-negative");
		return calculatePower(n, p);
	}

	private int calculatePower(int n, int p) {
		if (p == 0)
			return 1;
		return n * calculatePower(n, p - 1);
	}
}
```

### Day 18 - Queues and Stacks
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards and forwards. Can you determine if a given string, **s** , is a palindrome?

To solve this challenge, we must first take each character in **s**, enqueue it in a queue, and also push that same character onto a stack. Once that's done, we must dequeue the first character from the queue and pop the top character off the stack, then compare the two characters to see if they are the same; as long as the characters match, we continue dequeueing, popping, and comparing each character until our containers are empty (a non-match means **s** isn't a palindrome).


##### Solution:
```java
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
```

### Day 19 - Interfaces
The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.

Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The implementation for the divisorSum(n) method must return the sum of all divisors of **n**.

##### Solution:
```java
interface AdvancedArithmetic{
   int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0)
                sum += i;
        }
        return sum;
    }
}
```
### Day 20 - Sorting
Given an array, **a** , of size **n**  distinct elements, sort the array in _ascending_  order using the  _Bubble Sort_  algorithm above. Once sorted, print the following **3** lines:

1.  Array is sorted in numSwaps swaps.  
    where  is the number of swaps that took place.
2.  First Element: firstElement  
    where  is the  _first_  element in the sorted array.
3.  Last Element: lastElement  
    where  is the  _last_  element in the sorted array.

**Hint:**  To complete this challenge, you will need to add a variable that keeps a running tally of  _all_  swaps that occur during execution.
##### Solution:
```java
public static int getNumberOfSwaps(int[] arr) {
    int n = arr.length;
    int numberTotalOfSwaps = 0;
    for (int i = 0; i < n; i++) {
        int numberOfSwaps = 0;
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int aux = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = aux;
                numberOfSwaps++;
            }
        }
        if (numberOfSwaps == 0)
            break;
        numberTotalOfSwaps += numberOfSwaps;
    }
    return numberTotalOfSwaps;
}
```
### Day 21 - Generics
Write a single generic function named printArray; this function must take an array of generic elements as a parameter (the exception to this is C++, which takes a vector). The locked Solution class in your editor tests your function.

**Note:** You must use generics to solve this challenge. Do not write overloaded functions.

##### Solution:
```java
class Printer <T> {
    void printArray(T[] printer) {
        for (int i = 0; i < printer.length; i++) {
            System.out.println(printer[i]);
        }
    }
}
```
### Day 22 - Binary Search Trees
The height of a binary search tree is the number of edges between the tree's root and its furthest leaf. You are given a pointer, **root** , pointing to the root of a binary search tree. Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.

##### Solution:
```java
public static int getHeight(Node root) {
	if(root == null)
		return -1;
	return 1 + Math.max(getHeight(root.left), getHeight(root.right));
}

```

### Day 23 - BST Level-Order Traversal
A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to right, top to bottom. You are given a pointer, **root** , pointing to the root of a binary search tree. Complete the levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree.

**Hint:** You'll find a queue helpful in completing this challeng

##### Solution:
```java
static void levelOrder(Node root) {
	int h = height(root);
	int i;
	for (i = 1; i <= h; i++)
		printGivenLevel(root, i);
}

static int height(Node root) {
	if (root == null)
		return 0;
	
	int leftHeight = height(root.left);
	int rightHeight = height(root.right);

	if (leftHeight > rightHeight)
		return (leftHeight + 1);			
	return (rightHeight + 1);		
}

static void printGivenLevel(Node root, int level) {
	if (root == null)
		return;
	if (level == 1)
		System.out.print(root.data + " ");
	else if (level > 1) {
		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);
	}
}
```
### Day 24 - More Linked Lists
A Node class is provided for you in the editor. A Node object has an integer data field, **data** , and a Node instance pointer, **next** , pointing to another node (i.e.: the next node in a list).

A removeDuplicates function is declared in your editor, which takes a pointer to the **head**  node of a linked list as a parameter. Complete removeDuplicates so that it deletes any duplicate nodes from the list and returns the head of the updated list.

**Note:** The **head** pointer may be null, indicating that the list is empty. Be sure to reset your **next** pointer when performing deletions to avoid breaking the list.

##### Solution:
```java
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
```

### Day 25 - Running Time and Complexity
A <em>prime</em> is a natural number greater than <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-1-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.162ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 500.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path></g></svg></span> that has no positive divisors other than <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-2-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.162ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 500.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path></g></svg></span> and itself. Given a number, <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-3-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.395ex" height="1.676ex" style="vertical-align: -0.338ex;" viewBox="0 -576.1 600.5 721.6" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M21 287Q22 293 24 303T36 341T56 388T89 425T135 442Q171 442 195 424T225 390T231 369Q231 367 232 367L243 378Q304 442 382 442Q436 442 469 415T503 336T465 179T427 52Q427 26 444 26Q450 26 453 27Q482 32 505 65T540 145Q542 153 560 153Q580 153 580 145Q580 144 576 130Q568 101 554 73T508 17T439 -10Q392 -10 371 17T350 73Q350 92 386 193T423 345Q423 404 379 404H374Q288 404 229 303L222 291L189 157Q156 26 151 16Q138 -11 108 -11Q95 -11 87 -5T76 7T74 17Q74 30 112 180T152 343Q153 348 153 366Q153 405 129 405Q91 405 66 305Q60 285 60 284Q58 278 41 278H27Q21 284 21 287Z"></path></g></svg></span>, determine and print whether it's <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-4-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="6.103ex" height="2.009ex" style="vertical-align: -0.338ex;" viewBox="0 -719.6 2627.5 865.1" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M41 1Q19 9 19 32V38Q19 63 36 73Q42 76 65 76H89V535H65H55Q38 535 29 543T19 576Q19 603 41 610H49Q57 610 70 610T100 610T136 611T175 611Q190 611 216 611T255 612Q321 612 363 598T441 537Q480 486 480 427V421Q480 354 447 311T378 251Q339 230 275 230H239H173V76H197Q220 76 227 73Q244 62 244 38Q244 10 222 1H41ZM396 421Q396 461 369 491T300 533Q294 534 233 535H173V306H233Q294 307 300 308Q345 319 370 352T396 421Z"></path><path stroke-width="1" d="M327 76Q359 76 369 70T380 38Q380 10 359 1H47Q24 8 24 38Q24 54 28 61T47 76H145V355H96L47 356Q24 363 24 393Q24 409 28 416T47 431H207Q223 419 226 414T229 393V387V369Q297 437 394 437Q436 437 461 417T487 368Q487 347 473 332T438 317Q428 317 420 320T407 327T398 337T393 347T390 356L388 361Q348 356 324 345Q228 299 228 170Q228 161 228 151T229 138V76H293H327Z" transform="translate(525,0)"></path><path stroke-width="1" d="M202 538T202 559T218 596T260 612Q283 612 300 597T317 560Q317 538 300 523T260 507Q235 507 219 522ZM411 76Q441 76 451 69T462 38Q462 29 462 26T460 18T453 9T440 1H94Q72 8 72 33V38Q72 46 72 49T74 58T81 68T94 76H233V355H167L102 356Q80 363 80 393Q80 418 91 425T138 432Q145 432 165 432T200 431H295Q297 429 303 425T310 420T314 415T317 404T317 389T318 363Q318 354 318 314T317 241V76H378H411Z" transform="translate(1051,0)"></path><path stroke-width="1" d="M133 76Q156 74 164 67T172 38Q172 9 151 1H11Q-12 8 -12 38Q-12 61 5 73Q10 75 28 76H45V355H28Q10 356 5 358Q-12 370 -12 393Q-12 419 11 431H52H70Q91 431 100 427T116 405Q163 436 200 436Q255 436 281 390L285 394Q289 398 292 400T301 407T314 415T329 423T346 429T366 434T389 436H392Q425 436 448 411Q469 390 474 360T480 268V232V203V76H497Q520 74 528 67T536 38Q536 9 515 1H396Q374 9 374 32V38Q374 73 402 76H409V191V242Q409 317 404 339T375 361Q343 361 323 332T299 264Q298 258 298 165V76H315Q338 74 346 67T354 38Q354 9 333 1H214Q192 9 192 32V38Q192 73 220 76H227V191V242Q227 317 222 339T193 361Q161 361 141 332T117 264Q116 258 116 165V76H133Z" transform="translate(1576,0)"></path><path stroke-width="1" d="M48 217Q48 295 100 361T248 439L258 440Q268 440 274 440Q329 438 369 416T428 359T456 292T464 228Q464 215 461 208T454 198T442 190L288 189H135L138 179Q153 132 199 102T303 71Q336 71 353 86T380 120T398 143Q404 146 422 146Q453 146 462 126Q464 120 464 116Q464 84 416 39T285 -6Q187 -6 118 59T48 217ZM377 264Q371 291 365 306T341 338T294 362Q288 363 264 363Q225 363 190 336T139 264H377Z" transform="translate(2102,0)"></path></g></svg></span> or <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-5-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="10.984ex" height="2.509ex" style="vertical-align: -0.838ex;" viewBox="0 -719.6 4729 1080.4" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M20 571Q20 598 30 604T73 611H105H136Q152 611 160 611T177 607T189 601T198 587T206 568T217 537T231 497Q354 142 365 95L368 84V535H347H342Q314 535 306 552Q304 556 304 573Q304 586 304 590T310 600T326 611H482Q497 602 500 596T504 573Q504 559 501 551T491 540T478 536T460 535H439V25Q432 7 424 4T389 0H374Q334 0 322 31L293 115Q171 468 159 517L156 528V76H177H183Q195 76 202 75T215 64T221 38Q221 10 199 1H43Q32 5 27 11T22 21T21 38V44Q21 66 37 73Q44 76 64 76H85V535H64Q49 535 42 536T28 545T20 571Z"></path><path stroke-width="1" d="M52 216Q52 318 118 379T261 440Q343 440 407 378T472 216Q472 121 410 58T262 -6Q176 -6 114 58T52 216ZM388 225Q388 281 351 322T261 364Q213 364 175 325T136 225Q136 158 174 114T262 70T350 114T388 225Z" transform="translate(525,0)"></path><path stroke-width="1" d="M25 395Q26 405 26 408T29 416T35 423T48 431H145V481L146 532Q154 547 161 550T184 554H189Q218 554 227 534Q229 529 229 480V431H405Q406 430 411 427T418 422T422 416T426 407T427 393Q427 387 427 382T424 374T421 368T417 363T413 360T408 358L405 356L317 355H229V249Q229 237 229 214T228 179Q228 126 241 98T295 70Q354 70 365 149Q366 167 375 174Q383 182 407 182H415Q438 182 446 166Q448 161 448 148Q448 84 398 39T282 -6Q226 -6 189 29T146 128Q145 134 145 247V355H96H72Q45 355 35 362T25 395Z" transform="translate(1051,0)"></path><path stroke-width="1" d="M89 431Q93 431 104 431T121 432Q173 432 173 401V396L182 402Q237 437 305 437Q376 437 434 378T492 217Q492 146 459 93T382 17T291 -6Q261 -6 232 5T188 26L174 37Q173 37 173 -54V-146H236Q250 -155 254 -162T258 -184Q258 -213 236 -221H27Q4 -214 4 -184Q4 -169 8 -162T27 -146H89V355H58L27 356Q4 363 4 393Q4 408 8 415T27 431H89ZM409 215Q409 269 377 315T283 361Q255 361 224 344T177 297L173 290V167Q189 124 213 97T278 70Q330 70 369 111T409 215Z" transform="translate(2101,0)"></path><path stroke-width="1" d="M327 76Q359 76 369 70T380 38Q380 10 359 1H47Q24 8 24 38Q24 54 28 61T47 76H145V355H96L47 356Q24 363 24 393Q24 409 28 416T47 431H207Q223 419 226 414T229 393V387V369Q297 437 394 437Q436 437 461 417T487 368Q487 347 473 332T438 317Q428 317 420 320T407 327T398 337T393 347T390 356L388 361Q348 356 324 345Q228 299 228 170Q228 161 228 151T229 138V76H293H327Z" transform="translate(2627,0)"></path><path stroke-width="1" d="M202 538T202 559T218 596T260 612Q283 612 300 597T317 560Q317 538 300 523T260 507Q235 507 219 522ZM411 76Q441 76 451 69T462 38Q462 29 462 26T460 18T453 9T440 1H94Q72 8 72 33V38Q72 46 72 49T74 58T81 68T94 76H233V355H167L102 356Q80 363 80 393Q80 418 91 425T138 432Q145 432 165 432T200 431H295Q297 429 303 425T310 420T314 415T317 404T317 389T318 363Q318 354 318 314T317 241V76H378H411Z" transform="translate(3152,0)"></path><path stroke-width="1" d="M133 76Q156 74 164 67T172 38Q172 9 151 1H11Q-12 8 -12 38Q-12 61 5 73Q10 75 28 76H45V355H28Q10 356 5 358Q-12 370 -12 393Q-12 419 11 431H52H70Q91 431 100 427T116 405Q163 436 200 436Q255 436 281 390L285 394Q289 398 292 400T301 407T314 415T329 423T346 429T366 434T389 436H392Q425 436 448 411Q469 390 474 360T480 268V232V203V76H497Q520 74 528 67T536 38Q536 9 515 1H396Q374 9 374 32V38Q374 73 402 76H409V191V242Q409 317 404 339T375 361Q343 361 323 332T299 264Q298 258 298 165V76H315Q338 74 346 67T354 38Q354 9 333 1H214Q192 9 192 32V38Q192 73 220 76H227V191V242Q227 317 222 339T193 361Q161 361 141 332T117 264Q116 258 116 165V76H133Z" transform="translate(3678,0)"></path><path stroke-width="1" d="M48 217Q48 295 100 361T248 439L258 440Q268 440 274 440Q329 438 369 416T428 359T456 292T464 228Q464 215 461 208T454 198T442 190L288 189H135L138 179Q153 132 199 102T303 71Q336 71 353 86T380 120T398 143Q404 146 422 146Q453 146 462 126Q464 120 464 116Q464 84 416 39T285 -6Q187 -6 118 59T48 217ZM377 264Q371 291 365 306T341 338T294 362Q288 363 264 363Q225 363 190 336T139 264H377Z" transform="translate(4203,0)"></path></g></svg></span>. </p>
<p><strong>Note:</strong> If possible, try to come up with a <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-6-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="6.913ex" height="2.843ex" style="vertical-align: -0.838ex;" viewBox="0 -863.1 2976.5 1223.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M740 435Q740 320 676 213T511 42T304 -22Q207 -22 138 35T51 201Q50 209 50 244Q50 346 98 438T227 601Q351 704 476 704Q514 704 524 703Q621 689 680 617T740 435ZM637 476Q637 565 591 615T476 665Q396 665 322 605Q242 542 200 428T157 216Q157 126 200 73T314 19Q404 19 485 98T608 313Q637 408 637 476Z"></path><g transform="translate(763,0)"><path stroke-width="1" d="M94 250Q94 319 104 381T127 488T164 576T202 643T244 695T277 729T302 750H315H319Q333 750 333 741Q333 738 316 720T275 667T226 581T184 443T167 250T184 58T225 -81T274 -167T316 -220T333 -241Q333 -250 318 -250H315H302L274 -226Q180 -141 137 -14T94 250Z"></path></g><g transform="translate(1153,0)"><path stroke-width="1" d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z" transform="translate(0,-78)"></path><rect stroke="none" width="600" height="60" x="833" y="663"></rect><g transform="translate(833,0)"><path stroke-width="1" d="M21 287Q22 293 24 303T36 341T56 388T89 425T135 442Q171 442 195 424T225 390T231 369Q231 367 232 367L243 378Q304 442 382 442Q436 442 469 415T503 336T465 179T427 52Q427 26 444 26Q450 26 453 27Q482 32 505 65T540 145Q542 153 560 153Q580 153 580 145Q580 144 576 130Q568 101 554 73T508 17T439 -10Q392 -10 371 17T350 73Q350 92 386 193T423 345Q423 404 379 404H374Q288 404 229 303L222 291L189 157Q156 26 151 16Q138 -11 108 -11Q95 -11 87 -5T76 7T74 17Q74 30 112 180T152 343Q153 348 153 366Q153 405 129 405Q91 405 66 305Q60 285 60 284Q58 278 41 278H27Q21 284 21 287Z"></path></g></g><g transform="translate(2587,0)"><path stroke-width="1" d="M60 749L64 750Q69 750 74 750H86L114 726Q208 641 251 514T294 250Q294 182 284 119T261 12T224 -76T186 -143T145 -194T113 -227T90 -246Q87 -249 86 -250H74Q66 -250 63 -250T58 -247T55 -238Q56 -237 66 -225Q221 -64 221 250T66 725Q56 737 55 738Q55 746 60 749Z"></path></g></g></svg></span> primality algorithm, or see what sort of optimizations you come up with for an <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-7-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="4.977ex" height="2.843ex" style="vertical-align: -0.838ex;" viewBox="0 -863.1 2143 1223.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M740 435Q740 320 676 213T511 42T304 -22Q207 -22 138 35T51 201Q50 209 50 244Q50 346 98 438T227 601Q351 704 476 704Q514 704 524 703Q621 689 680 617T740 435ZM637 476Q637 565 591 615T476 665Q396 665 322 605Q242 542 200 428T157 216Q157 126 200 73T314 19Q404 19 485 98T608 313Q637 408 637 476Z"></path><g transform="translate(763,0)"><path stroke-width="1" d="M94 250Q94 319 104 381T127 488T164 576T202 643T244 695T277 729T302 750H315H319Q333 750 333 741Q333 738 316 720T275 667T226 581T184 443T167 250T184 58T225 -81T274 -167T316 -220T333 -241Q333 -250 318 -250H315H302L274 -226Q180 -141 137 -14T94 250Z"></path></g><g transform="translate(1153,0)"><path stroke-width="1" d="M21 287Q22 293 24 303T36 341T56 388T89 425T135 442Q171 442 195 424T225 390T231 369Q231 367 232 367L243 378Q304 442 382 442Q436 442 469 415T503 336T465 179T427 52Q427 26 444 26Q450 26 453 27Q482 32 505 65T540 145Q542 153 560 153Q580 153 580 145Q580 144 576 130Q568 101 554 73T508 17T439 -10Q392 -10 371 17T350 73Q350 92 386 193T423 345Q423 404 379 404H374Q288 404 229 303L222 291L189 157Q156 26 151 16Q138 -11 108 -11Q95 -11 87 -5T76 7T74 17Q74 30 112 180T152 343Q153 348 153 366Q153 405 129 405Q91 405 66 305Q60 285 60 284Q58 278 41 278H27Q21 284 21 287Z"></path></g><g transform="translate(1753,0)"><path stroke-width="1" d="M60 749L64 750Q69 750 74 750H86L114 726Q208 641 251 514T294 250Q294 182 284 119T261 12T224 -76T186 -143T145 -194T113 -227T90 -246Q87 -249 86 -250H74Q66 -250 63 -250T58 -247T55 -238Q56 -237 66 -225Q221 -64 221 250T66 725Q56 737 55 738Q55 746 60 749Z"></path></g></g></svg></span> algorithm. Be sure to check out the <em>Editorial</em> after submitting your code!</p>

##### Solution:
```java
```


