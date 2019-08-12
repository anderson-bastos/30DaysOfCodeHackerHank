

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
private static String checkNumber(int number) {
	boolean numberIsPrime = numberIsPrime(number);
	if (numberIsPrime)
		return "Prime";
	return "Not prime";
}

private static boolean numberIsPrime(int number) {
	if (number <= 1)
		return false;
	if (number <= 3)
		return true;
	if (number % 2 == 0 || number % 3 == 0)
		return false;
	for (int i = 5; i * i <= number; i = i + 6)
		if (number % i == 0 || number % (i + 2) == 0)
			return false;
	return true;
}
```
### Day 26 - Nested Logic
Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:
<ol>
<li>If the book is returned on or before the expected return date, no fine will be charged (i.e.: <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-1-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="9.725ex" height="2.843ex" style="vertical-align: -0.838ex;" viewBox="0 -863.1 4187.1 1223.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M118 -162Q120 -162 124 -164T135 -167T147 -168Q160 -168 171 -155T187 -126Q197 -99 221 27T267 267T289 382V385H242Q195 385 192 387Q188 390 188 397L195 425Q197 430 203 430T250 431Q298 431 298 432Q298 434 307 482T319 540Q356 705 465 705Q502 703 526 683T550 630Q550 594 529 578T487 561Q443 561 443 603Q443 622 454 636T478 657L487 662Q471 668 457 668Q445 668 434 658T419 630Q412 601 403 552T387 469T380 433Q380 431 435 431Q480 431 487 430T498 424Q499 420 496 407T491 391Q489 386 482 386T428 385H372L349 263Q301 15 282 -47Q255 -132 212 -173Q175 -205 139 -205Q107 -205 81 -186T55 -132Q55 -95 76 -78T118 -61Q162 -61 162 -103Q162 -122 151 -136T127 -157L118 -162Z"></path><g transform="translate(550,0)"><path stroke-width="1" d="M184 600Q184 624 203 642T247 661Q265 661 277 649T290 619Q290 596 270 577T226 557Q211 557 198 567T184 600ZM21 287Q21 295 30 318T54 369T98 420T158 442Q197 442 223 419T250 357Q250 340 236 301T196 196T154 83Q149 61 149 51Q149 26 166 26Q175 26 185 29T208 43T235 78T260 137Q263 149 265 151T282 153Q302 153 302 143Q302 135 293 112T268 61T223 11T161 -11Q129 -11 102 10T74 74Q74 91 79 106T122 220Q160 321 166 341T173 380Q173 404 156 404H154Q124 404 99 371T61 287Q60 286 59 284T58 281T56 279T53 278T49 278T41 278H27Q21 284 21 287Z"></path></g><g transform="translate(896,0)"><path stroke-width="1" d="M21 287Q22 293 24 303T36 341T56 388T89 425T135 442Q171 442 195 424T225 390T231 369Q231 367 232 367L243 378Q304 442 382 442Q436 442 469 415T503 336T465 179T427 52Q427 26 444 26Q450 26 453 27Q482 32 505 65T540 145Q542 153 560 153Q580 153 580 145Q580 144 576 130Q568 101 554 73T508 17T439 -10Q392 -10 371 17T350 73Q350 92 386 193T423 345Q423 404 379 404H374Q288 404 229 303L222 291L189 157Q156 26 151 16Q138 -11 108 -11Q95 -11 87 -5T76 7T74 17Q74 30 112 180T152 343Q153 348 153 366Q153 405 129 405Q91 405 66 305Q60 285 60 284Q58 278 41 278H27Q21 284 21 287Z"></path></g><g transform="translate(1496,0)"><path stroke-width="1" d="M39 168Q39 225 58 272T107 350T174 402T244 433T307 442H310Q355 442 388 420T421 355Q421 265 310 237Q261 224 176 223Q139 223 138 221Q138 219 132 186T125 128Q125 81 146 54T209 26T302 45T394 111Q403 121 406 121Q410 121 419 112T429 98T420 82T390 55T344 24T281 -1T205 -11Q126 -11 83 42T39 168ZM373 353Q367 405 305 405Q272 405 244 391T199 357T170 316T154 280T149 261Q149 260 169 260Q282 260 327 284T373 353Z"></path></g><g transform="translate(2240,0)"><path stroke-width="1" d="M56 347Q56 360 70 367H707Q722 359 722 347Q722 336 708 328L390 327H72Q56 332 56 347ZM56 153Q56 168 72 173H708Q722 163 722 153Q722 140 707 133H70Q56 140 56 153Z"></path></g><g transform="translate(3297,0)"><path stroke-width="1" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z"></path></g><g transform="translate(3797,0)"><path stroke-width="1" d="M60 749L64 750Q69 750 74 750H86L114 726Q208 641 251 514T294 250Q294 182 284 119T261 12T224 -76T186 -143T145 -194T113 -227T90 -246Q87 -249 86 -250H74Q66 -250 63 -250T58 -247T55 -238Q56 -237 66 -225Q221 -64 221 250T66 725Q56 737 55 738Q55 746 60 749Z"></path></g></g></svg></span>.</li>
<li>If the book is returned after the expected return <em>day</em> but still within the same calendar month and year as the expected return date, <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-2-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="47.147ex" height="2.843ex" style="vertical-align: -0.838ex;" viewBox="0 -863.1 20299.5 1223.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M118 -162Q120 -162 124 -164T135 -167T147 -168Q160 -168 171 -155T187 -126Q197 -99 221 27T267 267T289 382V385H242Q195 385 192 387Q188 390 188 397L195 425Q197 430 203 430T250 431Q298 431 298 432Q298 434 307 482T319 540Q356 705 465 705Q502 703 526 683T550 630Q550 594 529 578T487 561Q443 561 443 603Q443 622 454 636T478 657L487 662Q471 668 457 668Q445 668 434 658T419 630Q412 601 403 552T387 469T380 433Q380 431 435 431Q480 431 487 430T498 424Q499 420 496 407T491 391Q489 386 482 386T428 385H372L349 263Q301 15 282 -47Q255 -132 212 -173Q175 -205 139 -205Q107 -205 81 -186T55 -132Q55 -95 76 -78T118 -61Q162 -61 162 -103Q162 -122 151 -136T127 -157L118 -162Z"></path><g transform="translate(550,0)"><path stroke-width="1" d="M184 600Q184 624 203 642T247 661Q265 661 277 649T290 619Q290 596 270 577T226 557Q211 557 198 567T184 600ZM21 287Q21 295 30 318T54 369T98 420T158 442Q197 442 223 419T250 357Q250 340 236 301T196 196T154 83Q149 61 149 51Q149 26 166 26Q175 26 185 29T208 43T235 78T260 137Q263 149 265 151T282 153Q302 153 302 143Q302 135 293 112T268 61T223 11T161 -11Q129 -11 102 10T74 74Q74 91 79 106T122 220Q160 321 166 341T173 380Q173 404 156 404H154Q124 404 99 371T61 287Q60 286 59 284T58 281T56 279T53 278T49 278T41 278H27Q21 284 21 287Z"></path></g><g transform="translate(896,0)"><path stroke-width="1" d="M21 287Q22 293 24 303T36 341T56 388T89 425T135 442Q171 442 195 424T225 390T231 369Q231 367 232 367L243 378Q304 442 382 442Q436 442 469 415T503 336T465 179T427 52Q427 26 444 26Q450 26 453 27Q482 32 505 65T540 145Q542 153 560 153Q580 153 580 145Q580 144 576 130Q568 101 554 73T508 17T439 -10Q392 -10 371 17T350 73Q350 92 386 193T423 345Q423 404 379 404H374Q288 404 229 303L222 291L189 157Q156 26 151 16Q138 -11 108 -11Q95 -11 87 -5T76 7T74 17Q74 30 112 180T152 343Q153 348 153 366Q153 405 129 405Q91 405 66 305Q60 285 60 284Q58 278 41 278H27Q21 284 21 287Z"></path></g><g transform="translate(1496,0)"><path stroke-width="1" d="M39 168Q39 225 58 272T107 350T174 402T244 433T307 442H310Q355 442 388 420T421 355Q421 265 310 237Q261 224 176 223Q139 223 138 221Q138 219 132 186T125 128Q125 81 146 54T209 26T302 45T394 111Q403 121 406 121Q410 121 419 112T429 98T420 82T390 55T344 24T281 -1T205 -11Q126 -11 83 42T39 168ZM373 353Q367 405 305 405Q272 405 244 391T199 357T170 316T154 280T149 261Q149 260 169 260Q282 260 327 284T373 353Z"></path></g><g transform="translate(2240,0)"><path stroke-width="1" d="M56 347Q56 360 70 367H707Q722 359 722 347Q722 336 708 328L390 327H72Q56 332 56 347ZM56 153Q56 168 72 173H708Q722 163 722 153Q722 140 707 133H70Q56 140 56 153Z"></path></g><g transform="translate(3297,0)"><path stroke-width="1" d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path><path stroke-width="1" d="M164 157Q164 133 148 117T109 101H102Q148 22 224 22Q294 22 326 82Q345 115 345 210Q345 313 318 349Q292 382 260 382H254Q176 382 136 314Q132 307 129 306T114 304Q97 304 95 310Q93 314 93 485V614Q93 664 98 664Q100 666 102 666Q103 666 123 658T178 642T253 634Q324 634 389 662Q397 666 402 666Q410 666 410 648V635Q328 538 205 538Q174 538 149 544L139 546V374Q158 388 169 396T205 412T256 420Q337 420 393 355T449 201Q449 109 385 44T229 -22Q148 -22 99 32T50 154Q50 178 61 192T84 210T107 214Q132 214 148 197T164 157Z" transform="translate(500,0)"></path></g><g transform="translate(4298,0)"><path stroke-width="1" d="M128 622Q121 629 117 631T101 634T58 637H25V683H36Q57 680 180 680Q315 680 324 683H335V637H302Q262 636 251 634T233 622L232 500V378H517V622Q510 629 506 631T490 634T447 637H414V683H425Q446 680 569 680Q704 680 713 683H724V637H691Q651 636 640 634T622 622V61Q628 51 639 49T691 46H724V0H713Q692 3 569 3Q434 3 425 0H414V46H447Q489 47 498 49T517 61V332H232V197L233 61Q239 51 250 49T302 46H335V0H324Q303 3 180 3Q45 3 36 0H25V46H58Q100 47 109 49T128 61V622Z" transform="translate(250,0)"></path><path stroke-width="1" d="M137 305T115 305T78 320T63 359Q63 394 97 421T218 448Q291 448 336 416T396 340Q401 326 401 309T402 194V124Q402 76 407 58T428 40Q443 40 448 56T453 109V145H493V106Q492 66 490 59Q481 29 455 12T400 -6T353 12T329 54V58L327 55Q325 52 322 49T314 40T302 29T287 17T269 6T247 -2T221 -8T190 -11Q130 -11 82 20T34 107Q34 128 41 147T68 188T116 225T194 253T304 268H318V290Q318 324 312 340Q290 411 215 411Q197 411 181 410T156 406T148 403Q170 388 170 359Q170 334 154 320ZM126 106Q126 75 150 51T209 26Q247 26 276 49T315 109Q317 116 318 175Q318 233 317 233Q309 233 296 232T251 223T193 203T147 166T126 106Z" transform="translate(1000,0)"></path><path stroke-width="1" d="M370 305T349 305T313 320T297 358Q297 381 312 396Q317 401 317 402T307 404Q281 408 258 408Q209 408 178 376Q131 329 131 219Q131 137 162 90Q203 29 272 29Q313 29 338 55T374 117Q376 125 379 127T395 129H409Q415 123 415 120Q415 116 411 104T395 71T366 33T318 2T249 -11Q163 -11 99 53T34 214Q34 318 99 383T250 448T370 421T404 357Q404 334 387 320Z" transform="translate(1501,0)"></path><path stroke-width="1" d="M36 46H50Q89 46 97 60V68Q97 77 97 91T97 124T98 167T98 217T98 272T98 329Q98 366 98 407T98 482T98 542T97 586T97 603Q94 622 83 628T38 637H20V660Q20 683 22 683L32 684Q42 685 61 686T98 688Q115 689 135 690T165 693T176 694H179V463L180 233L240 287Q300 341 304 347Q310 356 310 364Q310 383 289 385H284V431H293Q308 428 412 428Q475 428 484 431H489V385H476Q407 380 360 341Q286 278 286 274Q286 273 349 181T420 79Q434 60 451 53T500 46H511V0H505Q496 3 418 3Q322 3 307 0H299V46H306Q330 48 330 65Q330 72 326 79Q323 84 276 153T228 222L176 176V120V84Q176 65 178 59T189 49Q210 46 238 46H254V0H246Q231 3 137 3T28 0H20V46H36Z" transform="translate(1945,0)"></path><path stroke-width="1" d="M28 214Q28 309 93 378T250 448Q340 448 405 380T471 215Q471 120 407 55T250 -10Q153 -10 91 57T28 214ZM250 30Q372 30 372 193V225V250Q372 272 371 288T364 326T348 362T317 390T268 410Q263 411 252 411Q222 411 195 399Q152 377 139 338T126 246V226Q126 130 145 91Q177 30 250 30Z" transform="translate(2474,0)"></path><path stroke-width="1" d="M295 316Q295 356 268 385T190 414Q154 414 128 401Q98 382 98 349Q97 344 98 336T114 312T157 287Q175 282 201 278T245 269T277 256Q294 248 310 236T342 195T359 133Q359 71 321 31T198 -10H190Q138 -10 94 26L86 19L77 10Q71 4 65 -1L54 -11H46H42Q39 -11 33 -5V74V132Q33 153 35 157T45 162H54Q66 162 70 158T75 146T82 119T101 77Q136 26 198 26Q295 26 295 104Q295 133 277 151Q257 175 194 187T111 210Q75 227 54 256T33 318Q33 357 50 384T93 424T143 442T187 447H198Q238 447 268 432L283 424L292 431Q302 440 314 448H322H326Q329 448 335 442V310L329 304H301Q295 310 295 316Z" transform="translate(2974,0)"></path></g><g transform="translate(8139,0)"><path stroke-width="1" d="M630 29Q630 9 609 9Q604 9 587 25T493 118L389 222L284 117Q178 13 175 11Q171 9 168 9Q160 9 154 15T147 29Q147 36 161 51T255 146L359 250L255 354Q174 435 161 449T147 471Q147 480 153 485T168 490Q173 490 175 489Q178 487 284 383L389 278L493 382Q570 459 587 475T609 491Q630 491 630 471Q630 464 620 453T522 355L418 250L522 145Q606 61 618 48T630 29Z"></path></g><g transform="translate(9140,0)"><path stroke-width="1" d="M94 250Q94 319 104 381T127 488T164 576T202 643T244 695T277 729T302 750H315H319Q333 750 333 741Q333 738 316 720T275 667T226 581T184 443T167 250T184 58T225 -81T274 -167T316 -220T333 -241Q333 -250 318 -250H315H302L274 -226Q180 -141 137 -14T94 250Z" transform="translate(250,0)"></path><path stroke-width="1" d="M27 422Q80 426 109 478T141 600V615H181V431H316V385H181V241Q182 116 182 100T189 68Q203 29 238 29Q282 29 292 100Q293 108 293 146V181H333V146V134Q333 57 291 17Q264 -10 221 -10Q187 -10 162 2T124 33T105 68T98 100Q97 107 97 248V385H18V422H27Z" transform="translate(639,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 124T102 167T103 217T103 272T103 329Q103 366 103 407T103 482T102 542T102 586T102 603Q99 622 88 628T43 637H25V660Q25 683 27 683L37 684Q47 685 66 686T103 688Q120 689 140 690T170 693T181 694H184V367Q244 442 328 442Q451 442 463 329Q464 322 464 190V104Q464 66 466 59T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(1029,0)"></path><path stroke-width="1" d="M28 218Q28 273 48 318T98 391T163 433T229 448Q282 448 320 430T378 380T406 316T415 245Q415 238 408 231H126V216Q126 68 226 36Q246 30 270 30Q312 30 342 62Q359 79 369 104L379 128Q382 131 395 131H398Q415 131 415 121Q415 117 412 108Q393 53 349 21T250 -11Q155 -11 92 58T28 218ZM333 275Q322 403 238 411H236Q228 411 220 410T195 402T166 381T143 340T127 274V267H333V275Z" transform="translate(1585,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 122T103 161T103 203Q103 234 103 269T102 328V351Q99 370 88 376T43 385H25V408Q25 431 27 431L37 432Q47 433 65 434T102 436Q119 437 138 438T167 441T178 442H181V402Q181 364 182 364T187 369T199 384T218 402T247 421T285 437Q305 442 336 442Q450 438 463 329Q464 322 464 190V104Q464 66 466 59T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(2280,0)"></path><path stroke-width="1" d="M383 58Q327 -10 256 -10H249Q124 -10 105 89Q104 96 103 226Q102 335 102 348T96 369Q86 385 36 385H25V408Q25 431 27 431L38 432Q48 433 67 434T105 436Q122 437 142 438T172 441T184 442H187V261Q188 77 190 64Q193 49 204 40Q224 26 264 26Q290 26 311 35T343 58T363 90T375 120T379 144Q379 145 379 161T380 201T380 248V315Q380 361 370 372T320 385H302V431Q304 431 378 436T457 442H464V264Q464 84 465 81Q468 61 479 55T524 46H542V0Q540 0 467 -5T390 -11H383V58Z" transform="translate(2836,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 122T103 161T103 203Q103 234 103 269T102 328V351Q99 370 88 376T43 385H25V408Q25 431 27 431L37 432Q47 433 65 434T102 436Q119 437 138 438T167 441T178 442H181V402Q181 364 182 364T187 369T199 384T218 402T247 421T285 437Q305 442 336 442Q351 442 364 440T387 434T406 426T421 417T432 406T441 395T448 384T452 374T455 366L457 361L460 365Q463 369 466 373T475 384T488 397T503 410T523 422T546 432T572 439T603 442Q729 442 740 329Q741 322 741 190V104Q741 66 743 59T754 49Q775 46 803 46H819V0H811L788 1Q764 2 737 2T699 3Q596 3 587 0H579V46H595Q656 46 656 62Q657 64 657 200Q656 335 655 343Q649 371 635 385T611 402T585 404Q540 404 506 370Q479 343 472 315T464 232V168V108Q464 78 465 68T468 55T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(3393,0)"></path><path stroke-width="1" d="M307 -11Q234 -11 168 55L158 37Q156 34 153 28T147 17T143 10L138 1L118 0H98V298Q98 599 97 603Q94 622 83 628T38 637H20V660Q20 683 22 683L32 684Q42 685 61 686T98 688Q115 689 135 690T165 693T176 694H179V543Q179 391 180 391L183 394Q186 397 192 401T207 411T228 421T254 431T286 439T323 442Q401 442 461 379T522 216Q522 115 458 52T307 -11ZM182 98Q182 97 187 90T196 79T206 67T218 55T233 44T250 35T271 29T295 26Q330 26 363 46T412 113Q424 148 424 212Q424 287 412 323Q385 405 300 405Q270 405 239 390T188 347L182 339V98Z" transform="translate(4226,0)"></path><path stroke-width="1" d="M28 218Q28 273 48 318T98 391T163 433T229 448Q282 448 320 430T378 380T406 316T415 245Q415 238 408 231H126V216Q126 68 226 36Q246 30 270 30Q312 30 342 62Q359 79 369 104L379 128Q382 131 395 131H398Q415 131 415 121Q415 117 412 108Q393 53 349 21T250 -11Q155 -11 92 58T28 218ZM333 275Q322 403 238 411H236Q228 411 220 410T195 402T166 381T143 340T127 274V267H333V275Z" transform="translate(4783,0)"></path><path stroke-width="1" d="M36 46H50Q89 46 97 60V68Q97 77 97 91T98 122T98 161T98 203Q98 234 98 269T98 328L97 351Q94 370 83 376T38 385H20V408Q20 431 22 431L32 432Q42 433 60 434T96 436Q112 437 131 438T160 441T171 442H174V373Q213 441 271 441H277Q322 441 343 419T364 373Q364 352 351 337T313 322Q288 322 276 338T263 372Q263 381 265 388T270 400T273 405Q271 407 250 401Q234 393 226 386Q179 341 179 207V154Q179 141 179 127T179 101T180 81T180 66V61Q181 59 183 57T188 54T193 51T200 49T207 48T216 47T225 47T235 46T245 46H276V0H267Q249 3 140 3Q37 3 28 0H20V46H36Z" transform="translate(5227,0)"></path><path stroke-width="1" d="M28 214Q28 309 93 378T250 448Q340 448 405 380T471 215Q471 120 407 55T250 -10Q153 -10 91 57T28 214ZM250 30Q372 30 372 193V225V250Q372 272 371 288T364 326T348 362T317 390T268 410Q263 411 252 411Q222 411 195 399Q152 377 139 338T126 246V226Q126 130 145 91Q177 30 250 30Z" transform="translate(5870,0)"></path><path stroke-width="1" d="M273 0Q255 3 146 3Q43 3 34 0H26V46H42Q70 46 91 49Q99 52 103 60Q104 62 104 224V385H33V431H104V497L105 564L107 574Q126 639 171 668T266 704Q267 704 275 704T289 705Q330 702 351 679T372 627Q372 604 358 590T321 576T284 590T270 627Q270 647 288 667H284Q280 668 273 668Q245 668 223 647T189 592Q183 572 182 497V431H293V385H185V225Q185 63 186 61T189 57T194 54T199 51T206 49T213 48T222 47T231 47T241 46T251 46H282V0H273Z" transform="translate(6370,0)"></path><path stroke-width="1" d="M376 495Q376 511 376 535T377 568Q377 613 367 624T316 637H298V660Q298 683 300 683L310 684Q320 685 339 686T376 688Q393 689 413 690T443 693T454 694H457V390Q457 84 458 81Q461 61 472 55T517 46H535V0Q533 0 459 -5T380 -11H373V44L365 37Q307 -11 235 -11Q158 -11 96 50T34 215Q34 315 97 378T244 442Q319 442 376 393V495ZM373 342Q328 405 260 405Q211 405 173 369Q146 341 139 305T131 211Q131 155 138 120T173 59Q203 26 251 26Q322 26 373 103V342Z" transform="translate(6927,0)"></path><path stroke-width="1" d="M137 305T115 305T78 320T63 359Q63 394 97 421T218 448Q291 448 336 416T396 340Q401 326 401 309T402 194V124Q402 76 407 58T428 40Q443 40 448 56T453 109V145H493V106Q492 66 490 59Q481 29 455 12T400 -6T353 12T329 54V58L327 55Q325 52 322 49T314 40T302 29T287 17T269 6T247 -2T221 -8T190 -11Q130 -11 82 20T34 107Q34 128 41 147T68 188T116 225T194 253T304 268H318V290Q318 324 312 340Q290 411 215 411Q197 411 181 410T156 406T148 403Q170 388 170 359Q170 334 154 320ZM126 106Q126 75 150 51T209 26Q247 26 276 49T315 109Q317 116 318 175Q318 233 317 233Q309 233 296 232T251 223T193 203T147 166T126 106Z" transform="translate(7483,0)"></path><path stroke-width="1" d="M69 -66Q91 -66 104 -80T118 -116Q118 -134 109 -145T91 -160Q84 -163 97 -166Q104 -168 111 -168Q131 -168 148 -159T175 -138T197 -106T213 -75T225 -43L242 0L170 183Q150 233 125 297Q101 358 96 368T80 381Q79 382 78 382Q66 385 34 385H19V431H26L46 430Q65 430 88 429T122 428Q129 428 142 428T171 429T200 430T224 430L233 431H241V385H232Q183 385 185 366L286 112Q286 113 332 227L376 341V350Q376 365 366 373T348 383T334 385H331V431H337H344Q351 431 361 431T382 430T405 429T422 429Q477 429 503 431H508V385H497Q441 380 422 345Q420 343 378 235T289 9T227 -131Q180 -204 113 -204Q69 -204 44 -177T19 -116Q19 -89 35 -78T69 -66Z" transform="translate(7984,0)"></path><path stroke-width="1" d="M295 316Q295 356 268 385T190 414Q154 414 128 401Q98 382 98 349Q97 344 98 336T114 312T157 287Q175 282 201 278T245 269T277 256Q294 248 310 236T342 195T359 133Q359 71 321 31T198 -10H190Q138 -10 94 26L86 19L77 10Q71 4 65 -1L54 -11H46H42Q39 -11 33 -5V74V132Q33 153 35 157T45 162H54Q66 162 70 158T75 146T82 119T101 77Q136 26 198 26Q295 26 295 104Q295 133 277 151Q257 175 194 187T111 210Q75 227 54 256T33 318Q33 357 50 384T93 424T143 442T187 447H198Q238 447 268 432L283 424L292 431Q302 440 314 448H322H326Q329 448 335 442V310L329 304H301Q295 310 295 316Z" transform="translate(8512,0)"></path><path stroke-width="1" d="M42 46H56Q95 46 103 60V68Q103 77 103 91T103 124T104 167T104 217T104 272T104 329Q104 366 104 407T104 482T104 542T103 586T103 603Q100 622 89 628T44 637H26V660Q26 683 28 683L38 684Q48 685 67 686T104 688Q121 689 141 690T171 693T182 694H185V379Q185 62 186 60Q190 52 198 49Q219 46 247 46H263V0H255L232 1Q209 2 183 2T145 3T107 3T57 1L34 0H26V46H42Z" transform="translate(9157,0)"></path><path stroke-width="1" d="M137 305T115 305T78 320T63 359Q63 394 97 421T218 448Q291 448 336 416T396 340Q401 326 401 309T402 194V124Q402 76 407 58T428 40Q443 40 448 56T453 109V145H493V106Q492 66 490 59Q481 29 455 12T400 -6T353 12T329 54V58L327 55Q325 52 322 49T314 40T302 29T287 17T269 6T247 -2T221 -8T190 -11Q130 -11 82 20T34 107Q34 128 41 147T68 188T116 225T194 253T304 268H318V290Q318 324 312 340Q290 411 215 411Q197 411 181 410T156 406T148 403Q170 388 170 359Q170 334 154 320ZM126 106Q126 75 150 51T209 26Q247 26 276 49T315 109Q317 116 318 175Q318 233 317 233Q309 233 296 232T251 223T193 203T147 166T126 106Z" transform="translate(9435,0)"></path><path stroke-width="1" d="M27 422Q80 426 109 478T141 600V615H181V431H316V385H181V241Q182 116 182 100T189 68Q203 29 238 29Q282 29 292 100Q293 108 293 146V181H333V146V134Q333 57 291 17Q264 -10 221 -10Q187 -10 162 2T124 33T105 68T98 100Q97 107 97 248V385H18V422H27Z" transform="translate(9936,0)"></path><path stroke-width="1" d="M28 218Q28 273 48 318T98 391T163 433T229 448Q282 448 320 430T378 380T406 316T415 245Q415 238 408 231H126V216Q126 68 226 36Q246 30 270 30Q312 30 342 62Q359 79 369 104L379 128Q382 131 395 131H398Q415 131 415 121Q415 117 412 108Q393 53 349 21T250 -11Q155 -11 92 58T28 218ZM333 275Q322 403 238 411H236Q228 411 220 410T195 402T166 381T143 340T127 274V267H333V275Z" transform="translate(10325,0)"></path><path stroke-width="1" d="M60 749L64 750Q69 750 74 750H86L114 726Q208 641 251 514T294 250Q294 182 284 119T261 12T224 -76T186 -143T145 -194T113 -227T90 -246Q87 -249 86 -250H74Q66 -250 63 -250T58 -247T55 -238Q56 -237 66 -225Q221 -64 221 250T66 725Q56 737 55 738Q55 746 60 749Z" transform="translate(10770,0)"></path></g></g></svg></span>. </li>
<li>If the book is returned after the expected return <em>month</em> but still within the same calendar year as the expected return date, the <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-3-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="51.215ex" height="2.843ex" style="vertical-align: -0.838ex;" viewBox="0 -863.1 22051 1223.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M118 -162Q120 -162 124 -164T135 -167T147 -168Q160 -168 171 -155T187 -126Q197 -99 221 27T267 267T289 382V385H242Q195 385 192 387Q188 390 188 397L195 425Q197 430 203 430T250 431Q298 431 298 432Q298 434 307 482T319 540Q356 705 465 705Q502 703 526 683T550 630Q550 594 529 578T487 561Q443 561 443 603Q443 622 454 636T478 657L487 662Q471 668 457 668Q445 668 434 658T419 630Q412 601 403 552T387 469T380 433Q380 431 435 431Q480 431 487 430T498 424Q499 420 496 407T491 391Q489 386 482 386T428 385H372L349 263Q301 15 282 -47Q255 -132 212 -173Q175 -205 139 -205Q107 -205 81 -186T55 -132Q55 -95 76 -78T118 -61Q162 -61 162 -103Q162 -122 151 -136T127 -157L118 -162Z"></path><g transform="translate(550,0)"><path stroke-width="1" d="M184 600Q184 624 203 642T247 661Q265 661 277 649T290 619Q290 596 270 577T226 557Q211 557 198 567T184 600ZM21 287Q21 295 30 318T54 369T98 420T158 442Q197 442 223 419T250 357Q250 340 236 301T196 196T154 83Q149 61 149 51Q149 26 166 26Q175 26 185 29T208 43T235 78T260 137Q263 149 265 151T282 153Q302 153 302 143Q302 135 293 112T268 61T223 11T161 -11Q129 -11 102 10T74 74Q74 91 79 106T122 220Q160 321 166 341T173 380Q173 404 156 404H154Q124 404 99 371T61 287Q60 286 59 284T58 281T56 279T53 278T49 278T41 278H27Q21 284 21 287Z"></path></g><g transform="translate(896,0)"><path stroke-width="1" d="M21 287Q22 293 24 303T36 341T56 388T89 425T135 442Q171 442 195 424T225 390T231 369Q231 367 232 367L243 378Q304 442 382 442Q436 442 469 415T503 336T465 179T427 52Q427 26 444 26Q450 26 453 27Q482 32 505 65T540 145Q542 153 560 153Q580 153 580 145Q580 144 576 130Q568 101 554 73T508 17T439 -10Q392 -10 371 17T350 73Q350 92 386 193T423 345Q423 404 379 404H374Q288 404 229 303L222 291L189 157Q156 26 151 16Q138 -11 108 -11Q95 -11 87 -5T76 7T74 17Q74 30 112 180T152 343Q153 348 153 366Q153 405 129 405Q91 405 66 305Q60 285 60 284Q58 278 41 278H27Q21 284 21 287Z"></path></g><g transform="translate(1496,0)"><path stroke-width="1" d="M39 168Q39 225 58 272T107 350T174 402T244 433T307 442H310Q355 442 388 420T421 355Q421 265 310 237Q261 224 176 223Q139 223 138 221Q138 219 132 186T125 128Q125 81 146 54T209 26T302 45T394 111Q403 121 406 121Q410 121 419 112T429 98T420 82T390 55T344 24T281 -1T205 -11Q126 -11 83 42T39 168ZM373 353Q367 405 305 405Q272 405 244 391T199 357T170 316T154 280T149 261Q149 260 169 260Q282 260 327 284T373 353Z"></path></g><g transform="translate(2240,0)"><path stroke-width="1" d="M56 347Q56 360 70 367H707Q722 359 722 347Q722 336 708 328L390 327H72Q56 332 56 347ZM56 153Q56 168 72 173H708Q722 163 722 153Q722 140 707 133H70Q56 140 56 153Z"></path></g><g transform="translate(3297,0)"><path stroke-width="1" d="M164 157Q164 133 148 117T109 101H102Q148 22 224 22Q294 22 326 82Q345 115 345 210Q345 313 318 349Q292 382 260 382H254Q176 382 136 314Q132 307 129 306T114 304Q97 304 95 310Q93 314 93 485V614Q93 664 98 664Q100 666 102 666Q103 666 123 658T178 642T253 634Q324 634 389 662Q397 666 402 666Q410 666 410 648V635Q328 538 205 538Q174 538 149 544L139 546V374Q158 388 169 396T205 412T256 420Q337 420 393 355T449 201Q449 109 385 44T229 -22Q148 -22 99 32T50 154Q50 178 61 192T84 210T107 214Q132 214 148 197T164 157Z"></path><path stroke-width="1" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z" transform="translate(500,0)"></path><path stroke-width="1" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z" transform="translate(1001,0)"></path></g><g transform="translate(4798,0)"><path stroke-width="1" d="M128 622Q121 629 117 631T101 634T58 637H25V683H36Q57 680 180 680Q315 680 324 683H335V637H302Q262 636 251 634T233 622L232 500V378H517V622Q510 629 506 631T490 634T447 637H414V683H425Q446 680 569 680Q704 680 713 683H724V637H691Q651 636 640 634T622 622V61Q628 51 639 49T691 46H724V0H713Q692 3 569 3Q434 3 425 0H414V46H447Q489 47 498 49T517 61V332H232V197L233 61Q239 51 250 49T302 46H335V0H324Q303 3 180 3Q45 3 36 0H25V46H58Q100 47 109 49T128 61V622Z" transform="translate(250,0)"></path><path stroke-width="1" d="M137 305T115 305T78 320T63 359Q63 394 97 421T218 448Q291 448 336 416T396 340Q401 326 401 309T402 194V124Q402 76 407 58T428 40Q443 40 448 56T453 109V145H493V106Q492 66 490 59Q481 29 455 12T400 -6T353 12T329 54V58L327 55Q325 52 322 49T314 40T302 29T287 17T269 6T247 -2T221 -8T190 -11Q130 -11 82 20T34 107Q34 128 41 147T68 188T116 225T194 253T304 268H318V290Q318 324 312 340Q290 411 215 411Q197 411 181 410T156 406T148 403Q170 388 170 359Q170 334 154 320ZM126 106Q126 75 150 51T209 26Q247 26 276 49T315 109Q317 116 318 175Q318 233 317 233Q309 233 296 232T251 223T193 203T147 166T126 106Z" transform="translate(1000,0)"></path><path stroke-width="1" d="M370 305T349 305T313 320T297 358Q297 381 312 396Q317 401 317 402T307 404Q281 408 258 408Q209 408 178 376Q131 329 131 219Q131 137 162 90Q203 29 272 29Q313 29 338 55T374 117Q376 125 379 127T395 129H409Q415 123 415 120Q415 116 411 104T395 71T366 33T318 2T249 -11Q163 -11 99 53T34 214Q34 318 99 383T250 448T370 421T404 357Q404 334 387 320Z" transform="translate(1501,0)"></path><path stroke-width="1" d="M36 46H50Q89 46 97 60V68Q97 77 97 91T97 124T98 167T98 217T98 272T98 329Q98 366 98 407T98 482T98 542T97 586T97 603Q94 622 83 628T38 637H20V660Q20 683 22 683L32 684Q42 685 61 686T98 688Q115 689 135 690T165 693T176 694H179V463L180 233L240 287Q300 341 304 347Q310 356 310 364Q310 383 289 385H284V431H293Q308 428 412 428Q475 428 484 431H489V385H476Q407 380 360 341Q286 278 286 274Q286 273 349 181T420 79Q434 60 451 53T500 46H511V0H505Q496 3 418 3Q322 3 307 0H299V46H306Q330 48 330 65Q330 72 326 79Q323 84 276 153T228 222L176 176V120V84Q176 65 178 59T189 49Q210 46 238 46H254V0H246Q231 3 137 3T28 0H20V46H36Z" transform="translate(1945,0)"></path><path stroke-width="1" d="M28 214Q28 309 93 378T250 448Q340 448 405 380T471 215Q471 120 407 55T250 -10Q153 -10 91 57T28 214ZM250 30Q372 30 372 193V225V250Q372 272 371 288T364 326T348 362T317 390T268 410Q263 411 252 411Q222 411 195 399Q152 377 139 338T126 246V226Q126 130 145 91Q177 30 250 30Z" transform="translate(2474,0)"></path><path stroke-width="1" d="M295 316Q295 356 268 385T190 414Q154 414 128 401Q98 382 98 349Q97 344 98 336T114 312T157 287Q175 282 201 278T245 269T277 256Q294 248 310 236T342 195T359 133Q359 71 321 31T198 -10H190Q138 -10 94 26L86 19L77 10Q71 4 65 -1L54 -11H46H42Q39 -11 33 -5V74V132Q33 153 35 157T45 162H54Q66 162 70 158T75 146T82 119T101 77Q136 26 198 26Q295 26 295 104Q295 133 277 151Q257 175 194 187T111 210Q75 227 54 256T33 318Q33 357 50 384T93 424T143 442T187 447H198Q238 447 268 432L283 424L292 431Q302 440 314 448H322H326Q329 448 335 442V310L329 304H301Q295 310 295 316Z" transform="translate(2974,0)"></path></g><g transform="translate(8639,0)"><path stroke-width="1" d="M630 29Q630 9 609 9Q604 9 587 25T493 118L389 222L284 117Q178 13 175 11Q171 9 168 9Q160 9 154 15T147 29Q147 36 161 51T255 146L359 250L255 354Q174 435 161 449T147 471Q147 480 153 485T168 490Q173 490 175 489Q178 487 284 383L389 278L493 382Q570 459 587 475T609 491Q630 491 630 471Q630 464 620 453T522 355L418 250L522 145Q606 61 618 48T630 29Z"></path></g><g transform="translate(9640,0)"><path stroke-width="1" d="M94 250Q94 319 104 381T127 488T164 576T202 643T244 695T277 729T302 750H315H319Q333 750 333 741Q333 738 316 720T275 667T226 581T184 443T167 250T184 58T225 -81T274 -167T316 -220T333 -241Q333 -250 318 -250H315H302L274 -226Q180 -141 137 -14T94 250Z" transform="translate(250,0)"></path><path stroke-width="1" d="M27 422Q80 426 109 478T141 600V615H181V431H316V385H181V241Q182 116 182 100T189 68Q203 29 238 29Q282 29 292 100Q293 108 293 146V181H333V146V134Q333 57 291 17Q264 -10 221 -10Q187 -10 162 2T124 33T105 68T98 100Q97 107 97 248V385H18V422H27Z" transform="translate(639,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 124T102 167T103 217T103 272T103 329Q103 366 103 407T103 482T102 542T102 586T102 603Q99 622 88 628T43 637H25V660Q25 683 27 683L37 684Q47 685 66 686T103 688Q120 689 140 690T170 693T181 694H184V367Q244 442 328 442Q451 442 463 329Q464 322 464 190V104Q464 66 466 59T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(1029,0)"></path><path stroke-width="1" d="M28 218Q28 273 48 318T98 391T163 433T229 448Q282 448 320 430T378 380T406 316T415 245Q415 238 408 231H126V216Q126 68 226 36Q246 30 270 30Q312 30 342 62Q359 79 369 104L379 128Q382 131 395 131H398Q415 131 415 121Q415 117 412 108Q393 53 349 21T250 -11Q155 -11 92 58T28 218ZM333 275Q322 403 238 411H236Q228 411 220 410T195 402T166 381T143 340T127 274V267H333V275Z" transform="translate(1585,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 122T103 161T103 203Q103 234 103 269T102 328V351Q99 370 88 376T43 385H25V408Q25 431 27 431L37 432Q47 433 65 434T102 436Q119 437 138 438T167 441T178 442H181V402Q181 364 182 364T187 369T199 384T218 402T247 421T285 437Q305 442 336 442Q450 438 463 329Q464 322 464 190V104Q464 66 466 59T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(2280,0)"></path><path stroke-width="1" d="M383 58Q327 -10 256 -10H249Q124 -10 105 89Q104 96 103 226Q102 335 102 348T96 369Q86 385 36 385H25V408Q25 431 27 431L38 432Q48 433 67 434T105 436Q122 437 142 438T172 441T184 442H187V261Q188 77 190 64Q193 49 204 40Q224 26 264 26Q290 26 311 35T343 58T363 90T375 120T379 144Q379 145 379 161T380 201T380 248V315Q380 361 370 372T320 385H302V431Q304 431 378 436T457 442H464V264Q464 84 465 81Q468 61 479 55T524 46H542V0Q540 0 467 -5T390 -11H383V58Z" transform="translate(2836,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 122T103 161T103 203Q103 234 103 269T102 328V351Q99 370 88 376T43 385H25V408Q25 431 27 431L37 432Q47 433 65 434T102 436Q119 437 138 438T167 441T178 442H181V402Q181 364 182 364T187 369T199 384T218 402T247 421T285 437Q305 442 336 442Q351 442 364 440T387 434T406 426T421 417T432 406T441 395T448 384T452 374T455 366L457 361L460 365Q463 369 466 373T475 384T488 397T503 410T523 422T546 432T572 439T603 442Q729 442 740 329Q741 322 741 190V104Q741 66 743 59T754 49Q775 46 803 46H819V0H811L788 1Q764 2 737 2T699 3Q596 3 587 0H579V46H595Q656 46 656 62Q657 64 657 200Q656 335 655 343Q649 371 635 385T611 402T585 404Q540 404 506 370Q479 343 472 315T464 232V168V108Q464 78 465 68T468 55T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(3393,0)"></path><path stroke-width="1" d="M307 -11Q234 -11 168 55L158 37Q156 34 153 28T147 17T143 10L138 1L118 0H98V298Q98 599 97 603Q94 622 83 628T38 637H20V660Q20 683 22 683L32 684Q42 685 61 686T98 688Q115 689 135 690T165 693T176 694H179V543Q179 391 180 391L183 394Q186 397 192 401T207 411T228 421T254 431T286 439T323 442Q401 442 461 379T522 216Q522 115 458 52T307 -11ZM182 98Q182 97 187 90T196 79T206 67T218 55T233 44T250 35T271 29T295 26Q330 26 363 46T412 113Q424 148 424 212Q424 287 412 323Q385 405 300 405Q270 405 239 390T188 347L182 339V98Z" transform="translate(4226,0)"></path><path stroke-width="1" d="M28 218Q28 273 48 318T98 391T163 433T229 448Q282 448 320 430T378 380T406 316T415 245Q415 238 408 231H126V216Q126 68 226 36Q246 30 270 30Q312 30 342 62Q359 79 369 104L379 128Q382 131 395 131H398Q415 131 415 121Q415 117 412 108Q393 53 349 21T250 -11Q155 -11 92 58T28 218ZM333 275Q322 403 238 411H236Q228 411 220 410T195 402T166 381T143 340T127 274V267H333V275Z" transform="translate(4783,0)"></path><path stroke-width="1" d="M36 46H50Q89 46 97 60V68Q97 77 97 91T98 122T98 161T98 203Q98 234 98 269T98 328L97 351Q94 370 83 376T38 385H20V408Q20 431 22 431L32 432Q42 433 60 434T96 436Q112 437 131 438T160 441T171 442H174V373Q213 441 271 441H277Q322 441 343 419T364 373Q364 352 351 337T313 322Q288 322 276 338T263 372Q263 381 265 388T270 400T273 405Q271 407 250 401Q234 393 226 386Q179 341 179 207V154Q179 141 179 127T179 101T180 81T180 66V61Q181 59 183 57T188 54T193 51T200 49T207 48T216 47T225 47T235 46T245 46H276V0H267Q249 3 140 3Q37 3 28 0H20V46H36Z" transform="translate(5227,0)"></path><path stroke-width="1" d="M28 214Q28 309 93 378T250 448Q340 448 405 380T471 215Q471 120 407 55T250 -10Q153 -10 91 57T28 214ZM250 30Q372 30 372 193V225V250Q372 272 371 288T364 326T348 362T317 390T268 410Q263 411 252 411Q222 411 195 399Q152 377 139 338T126 246V226Q126 130 145 91Q177 30 250 30Z" transform="translate(5870,0)"></path><path stroke-width="1" d="M273 0Q255 3 146 3Q43 3 34 0H26V46H42Q70 46 91 49Q99 52 103 60Q104 62 104 224V385H33V431H104V497L105 564L107 574Q126 639 171 668T266 704Q267 704 275 704T289 705Q330 702 351 679T372 627Q372 604 358 590T321 576T284 590T270 627Q270 647 288 667H284Q280 668 273 668Q245 668 223 647T189 592Q183 572 182 497V431H293V385H185V225Q185 63 186 61T189 57T194 54T199 51T206 49T213 48T222 47T231 47T241 46T251 46H282V0H273Z" transform="translate(6370,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 122T103 161T103 203Q103 234 103 269T102 328V351Q99 370 88 376T43 385H25V408Q25 431 27 431L37 432Q47 433 65 434T102 436Q119 437 138 438T167 441T178 442H181V402Q181 364 182 364T187 369T199 384T218 402T247 421T285 437Q305 442 336 442Q351 442 364 440T387 434T406 426T421 417T432 406T441 395T448 384T452 374T455 366L457 361L460 365Q463 369 466 373T475 384T488 397T503 410T523 422T546 432T572 439T603 442Q729 442 740 329Q741 322 741 190V104Q741 66 743 59T754 49Q775 46 803 46H819V0H811L788 1Q764 2 737 2T699 3Q596 3 587 0H579V46H595Q656 46 656 62Q657 64 657 200Q656 335 655 343Q649 371 635 385T611 402T585 404Q540 404 506 370Q479 343 472 315T464 232V168V108Q464 78 465 68T468 55T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(6927,0)"></path><path stroke-width="1" d="M28 214Q28 309 93 378T250 448Q340 448 405 380T471 215Q471 120 407 55T250 -10Q153 -10 91 57T28 214ZM250 30Q372 30 372 193V225V250Q372 272 371 288T364 326T348 362T317 390T268 410Q263 411 252 411Q222 411 195 399Q152 377 139 338T126 246V226Q126 130 145 91Q177 30 250 30Z" transform="translate(7760,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 122T103 161T103 203Q103 234 103 269T102 328V351Q99 370 88 376T43 385H25V408Q25 431 27 431L37 432Q47 433 65 434T102 436Q119 437 138 438T167 441T178 442H181V402Q181 364 182 364T187 369T199 384T218 402T247 421T285 437Q305 442 336 442Q450 438 463 329Q464 322 464 190V104Q464 66 466 59T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(8261,0)"></path><path stroke-width="1" d="M27 422Q80 426 109 478T141 600V615H181V431H316V385H181V241Q182 116 182 100T189 68Q203 29 238 29Q282 29 292 100Q293 108 293 146V181H333V146V134Q333 57 291 17Q264 -10 221 -10Q187 -10 162 2T124 33T105 68T98 100Q97 107 97 248V385H18V422H27Z" transform="translate(8817,0)"></path><path stroke-width="1" d="M41 46H55Q94 46 102 60V68Q102 77 102 91T102 124T102 167T103 217T103 272T103 329Q103 366 103 407T103 482T102 542T102 586T102 603Q99 622 88 628T43 637H25V660Q25 683 27 683L37 684Q47 685 66 686T103 688Q120 689 140 690T170 693T181 694H184V367Q244 442 328 442Q451 442 463 329Q464 322 464 190V104Q464 66 466 59T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z" transform="translate(9207,0)"></path><path stroke-width="1" d="M295 316Q295 356 268 385T190 414Q154 414 128 401Q98 382 98 349Q97 344 98 336T114 312T157 287Q175 282 201 278T245 269T277 256Q294 248 310 236T342 195T359 133Q359 71 321 31T198 -10H190Q138 -10 94 26L86 19L77 10Q71 4 65 -1L54 -11H46H42Q39 -11 33 -5V74V132Q33 153 35 157T45 162H54Q66 162 70 158T75 146T82 119T101 77Q136 26 198 26Q295 26 295 104Q295 133 277 151Q257 175 194 187T111 210Q75 227 54 256T33 318Q33 357 50 384T93 424T143 442T187 447H198Q238 447 268 432L283 424L292 431Q302 440 314 448H322H326Q329 448 335 442V310L329 304H301Q295 310 295 316Z" transform="translate(9763,0)"></path><path stroke-width="1" d="M42 46H56Q95 46 103 60V68Q103 77 103 91T103 124T104 167T104 217T104 272T104 329Q104 366 104 407T104 482T104 542T103 586T103 603Q100 622 89 628T44 637H26V660Q26 683 28 683L38 684Q48 685 67 686T104 688Q121 689 141 690T171 693T182 694H185V379Q185 62 186 60Q190 52 198 49Q219 46 247 46H263V0H255L232 1Q209 2 183 2T145 3T107 3T57 1L34 0H26V46H42Z" transform="translate(10408,0)"></path><path stroke-width="1" d="M137 305T115 305T78 320T63 359Q63 394 97 421T218 448Q291 448 336 416T396 340Q401 326 401 309T402 194V124Q402 76 407 58T428 40Q443 40 448 56T453 109V145H493V106Q492 66 490 59Q481 29 455 12T400 -6T353 12T329 54V58L327 55Q325 52 322 49T314 40T302 29T287 17T269 6T247 -2T221 -8T190 -11Q130 -11 82 20T34 107Q34 128 41 147T68 188T116 225T194 253T304 268H318V290Q318 324 312 340Q290 411 215 411Q197 411 181 410T156 406T148 403Q170 388 170 359Q170 334 154 320ZM126 106Q126 75 150 51T209 26Q247 26 276 49T315 109Q317 116 318 175Q318 233 317 233Q309 233 296 232T251 223T193 203T147 166T126 106Z" transform="translate(10686,0)"></path><path stroke-width="1" d="M27 422Q80 426 109 478T141 600V615H181V431H316V385H181V241Q182 116 182 100T189 68Q203 29 238 29Q282 29 292 100Q293 108 293 146V181H333V146V134Q333 57 291 17Q264 -10 221 -10Q187 -10 162 2T124 33T105 68T98 100Q97 107 97 248V385H18V422H27Z" transform="translate(11187,0)"></path><path stroke-width="1" d="M28 218Q28 273 48 318T98 391T163 433T229 448Q282 448 320 430T378 380T406 316T415 245Q415 238 408 231H126V216Q126 68 226 36Q246 30 270 30Q312 30 342 62Q359 79 369 104L379 128Q382 131 395 131H398Q415 131 415 121Q415 117 412 108Q393 53 349 21T250 -11Q155 -11 92 58T28 218ZM333 275Q322 403 238 411H236Q228 411 220 410T195 402T166 381T143 340T127 274V267H333V275Z" transform="translate(11576,0)"></path><path stroke-width="1" d="M60 749L64 750Q69 750 74 750H86L114 726Q208 641 251 514T294 250Q294 182 284 119T261 12T224 -76T186 -143T145 -194T113 -227T90 -246Q87 -249 86 -250H74Q66 -250 63 -250T58 -247T55 -238Q56 -237 66 -225Q221 -64 221 250T66 725Q56 737 55 738Q55 746 60 749Z" transform="translate(12021,0)"></path></g></g></svg></span>.   </li>
<li>If the book is returned after the calendar <em>year</em> in which it was expected, there is a fixed fine of <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-4-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="13.637ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 5871.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path><path stroke-width="1" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z" transform="translate(500,0)"></path><path stroke-width="1" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z" transform="translate(1001,0)"></path><path stroke-width="1" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z" transform="translate(1501,0)"></path><path stroke-width="1" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z" transform="translate(2002,0)"></path><g transform="translate(2502,0)"><path stroke-width="1" d="M128 622Q121 629 117 631T101 634T58 637H25V683H36Q57 680 180 680Q315 680 324 683H335V637H302Q262 636 251 634T233 622L232 500V378H517V622Q510 629 506 631T490 634T447 637H414V683H425Q446 680 569 680Q704 680 713 683H724V637H691Q651 636 640 634T622 622V61Q628 51 639 49T691 46H724V0H713Q692 3 569 3Q434 3 425 0H414V46H447Q489 47 498 49T517 61V332H232V197L233 61Q239 51 250 49T302 46H335V0H324Q303 3 180 3Q45 3 36 0H25V46H58Q100 47 109 49T128 61V622Z" transform="translate(250,0)"></path><path stroke-width="1" d="M137 305T115 305T78 320T63 359Q63 394 97 421T218 448Q291 448 336 416T396 340Q401 326 401 309T402 194V124Q402 76 407 58T428 40Q443 40 448 56T453 109V145H493V106Q492 66 490 59Q481 29 455 12T400 -6T353 12T329 54V58L327 55Q325 52 322 49T314 40T302 29T287 17T269 6T247 -2T221 -8T190 -11Q130 -11 82 20T34 107Q34 128 41 147T68 188T116 225T194 253T304 268H318V290Q318 324 312 340Q290 411 215 411Q197 411 181 410T156 406T148 403Q170 388 170 359Q170 334 154 320ZM126 106Q126 75 150 51T209 26Q247 26 276 49T315 109Q317 116 318 175Q318 233 317 233Q309 233 296 232T251 223T193 203T147 166T126 106Z" transform="translate(1000,0)"></path><path stroke-width="1" d="M370 305T349 305T313 320T297 358Q297 381 312 396Q317 401 317 402T307 404Q281 408 258 408Q209 408 178 376Q131 329 131 219Q131 137 162 90Q203 29 272 29Q313 29 338 55T374 117Q376 125 379 127T395 129H409Q415 123 415 120Q415 116 411 104T395 71T366 33T318 2T249 -11Q163 -11 99 53T34 214Q34 318 99 383T250 448T370 421T404 357Q404 334 387 320Z" transform="translate(1501,0)"></path><path stroke-width="1" d="M36 46H50Q89 46 97 60V68Q97 77 97 91T97 124T98 167T98 217T98 272T98 329Q98 366 98 407T98 482T98 542T97 586T97 603Q94 622 83 628T38 637H20V660Q20 683 22 683L32 684Q42 685 61 686T98 688Q115 689 135 690T165 693T176 694H179V463L180 233L240 287Q300 341 304 347Q310 356 310 364Q310 383 289 385H284V431H293Q308 428 412 428Q475 428 484 431H489V385H476Q407 380 360 341Q286 278 286 274Q286 273 349 181T420 79Q434 60 451 53T500 46H511V0H505Q496 3 418 3Q322 3 307 0H299V46H306Q330 48 330 65Q330 72 326 79Q323 84 276 153T228 222L176 176V120V84Q176 65 178 59T189 49Q210 46 238 46H254V0H246Q231 3 137 3T28 0H20V46H36Z" transform="translate(1945,0)"></path><path stroke-width="1" d="M28 214Q28 309 93 378T250 448Q340 448 405 380T471 215Q471 120 407 55T250 -10Q153 -10 91 57T28 214ZM250 30Q372 30 372 193V225V250Q372 272 371 288T364 326T348 362T317 390T268 410Q263 411 252 411Q222 411 195 399Q152 377 139 338T126 246V226Q126 130 145 91Q177 30 250 30Z" transform="translate(2474,0)"></path><path stroke-width="1" d="M295 316Q295 356 268 385T190 414Q154 414 128 401Q98 382 98 349Q97 344 98 336T114 312T157 287Q175 282 201 278T245 269T277 256Q294 248 310 236T342 195T359 133Q359 71 321 31T198 -10H190Q138 -10 94 26L86 19L77 10Q71 4 65 -1L54 -11H46H42Q39 -11 33 -5V74V132Q33 153 35 157T45 162H54Q66 162 70 158T75 146T82 119T101 77Q136 26 198 26Q295 26 295 104Q295 133 277 151Q257 175 194 187T111 210Q75 227 54 256T33 318Q33 357 50 384T93 424T143 442T187 447H198Q238 447 268 432L283 424L292 431Q302 440 314 448H322H326Q329 448 335 442V310L329 304H301Q295 310 295 316Z" transform="translate(2974,0)"></path></g></g></svg></span>.</li>
</ol>

##### Solution:
```java
public static int getHackosByDateReceived(LocalDate dateExpected, LocalDate dateReceived) {
	if (dateExpected.compareTo(dateReceived) > 0)
		return 0;

	int yearDiff = dateReceived.getYear() - dateExpected.getYear();
	if (yearDiff > 0)
		return 10000;

	int monthDiff = dateReceived.getMonthValue() - dateExpected.getMonthValue();
	if (monthDiff > 0)
		return 500 * monthDiff;

	int dayDiff = dateReceived.getDayOfMonth() - dateExpected.getDayOfMonth();
	if (dayDiff > 0)
		return 15 * dayDiff;
	return dayDiff;
}
```

### Day 27 - Testing
Your company needs a function that meets the following requirements:

<ul>
<li>For a given array of <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-1-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.395ex" height="1.676ex" style="vertical-align: -0.338ex;" viewBox="0 -576.1 600.5 721.6" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M21 287Q22 293 24 303T36 341T56 388T89 425T135 442Q171 442 195 424T225 390T231 369Q231 367 232 367L243 378Q304 442 382 442Q436 442 469 415T503 336T465 179T427 52Q427 26 444 26Q450 26 453 27Q482 32 505 65T540 145Q542 153 560 153Q580 153 580 145Q580 144 576 130Q568 101 554 73T508 17T439 -10Q392 -10 371 17T350 73Q350 92 386 193T423 345Q423 404 379 404H374Q288 404 229 303L222 291L189 157Q156 26 151 16Q138 -11 108 -11Q95 -11 87 -5T76 7T74 17Q74 30 112 180T152 343Q153 348 153 366Q153 405 129 405Q91 405 66 305Q60 285 60 284Q58 278 41 278H27Q21 284 21 287Z"></path></g></svg></span> integers, the function returns the index of the element with the minimum value in the array. If there is more than one element with the minimum value, the returned index should be the smallest one.</li>
<li>If an empty array is passed to the function, it should raise an Exception.</li>
</ul>

<p>Note: The arrays are indexed from <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-2-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.162ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 500.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z"></path></g></svg></span>.</p>
<p>Another co-worker has prepared functions that will perform the testing and validate returned results with expectations. Your task is to implement <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-4-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.162ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 500.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M127 463Q100 463 85 480T69 524Q69 579 117 622T233 665Q268 665 277 664Q351 652 390 611T430 522Q430 470 396 421T302 350L299 348Q299 347 308 345T337 336T375 315Q457 262 457 175Q457 96 395 37T238 -22Q158 -22 100 21T42 130Q42 158 60 175T105 193Q133 193 151 175T169 130Q169 119 166 110T159 94T148 82T136 74T126 70T118 67L114 66Q165 21 238 21Q293 21 321 74Q338 107 338 175V195Q338 290 274 322Q259 328 213 329L171 330L168 332Q166 335 166 348Q166 366 174 366Q202 366 232 371Q266 376 294 413T322 525V533Q322 590 287 612Q265 626 240 626Q208 626 181 615T143 592T132 580H135Q138 579 143 578T153 573T165 566T175 555T183 540T186 520Q186 498 172 481T127 463Z"></path></g></svg></span> classes that will produce test data and the expected results for the testing functions. More specifically:
function <code>get_array()</code> in <code>TestDataEmptyArray</code> class and functions <code>get_array()</code> and <code>get_expected_result()</code> in classes <code>TestDataUniqueValues</code> and <code>TestDataExactlyTwoDifferentMinimums</code> following the below specifications:</p>

<ul>
<li><code>get_array()</code> method in class <code>TestDataEmptyArray</code> has to return an empty array.</li>
<li><code>get_array()</code> method in class <code>TestDataUniqueValues</code> has to return an array of size at least 2 with all unique elements, while method <code>get_expected_result()</code> of this class has to return the expected minimum value index for this array.</li>
<li><code>get_array()</code> method in class <code>TestDataExactlyTwoDifferentMinimums</code> has to return an array where there are exactly two different minimum values, while method <code>get_expected_result()</code> of this class has to return the expected minimum value index for this array.</li>
</ul>

##### Solution:
```java
static class TestDataEmptyArray {
    public static int[] get_array() {                        
        return new int[] {};
    }
}

static class TestDataUniqueValues {
    public static int[] get_array() {                        
        return new int[] {1, 2, 3, 4};
    }

    public static int get_expected_result() {           
        return 0;
    }
}

static class TestDataExactlyTwoDifferentMinimums {
    public static int[] get_array() {
        return new int[]{ 1, 2, 1 };
    }

    public static int get_expected_result() {
       return 0;
    }
}
```
### Day 28 - RegEx, Patterns, and Intro to Databases
Consider a database table, <em>Emails</em>, which has the attributes <em>First Name</em> and <em>Email ID</em>. Given <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-1-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="2.064ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 888.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M234 637Q231 637 226 637Q201 637 196 638T191 649Q191 676 202 682Q204 683 299 683Q376 683 387 683T401 677Q612 181 616 168L670 381Q723 592 723 606Q723 633 659 637Q635 637 635 648Q635 650 637 660Q641 676 643 679T653 683Q656 683 684 682T767 680Q817 680 843 681T873 682Q888 682 888 672Q888 650 880 642Q878 637 858 637Q787 633 769 597L620 7Q618 0 599 0Q585 0 582 2Q579 5 453 305L326 604L261 344Q196 88 196 79Q201 46 268 46H278Q284 41 284 38T282 19Q278 6 272 0H259Q228 2 151 2Q123 2 100 2T63 2T46 1Q31 1 31 10Q31 14 34 26T39 40Q41 46 62 46Q130 49 150 85Q154 91 221 362L289 634Q287 635 234 637Z"></path></g></svg></span> rows of data simulating the <em>Emails</em> table, print an alphabetically-ordered list of people whose email address ends in <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-2-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="12.203ex" height="2.509ex" style="vertical-align: -0.671ex;" viewBox="0 -791.3 5254 1080.4" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M198 250Q198 155 248 91T394 26Q514 26 640 80L650 84H675H683Q709 84 709 76Q709 73 708 71Q706 64 660 45T534 8T383 -11T260 24T181 115Q152 168 152 248Q152 410 268 552Q303 590 324 608Q439 705 551 705Q611 705 658 683T733 623T775 543T789 454Q789 380 766 304T720 192Q677 125 617 125Q591 125 573 137T548 160T541 176Q541 178 540 178L534 173Q527 168 515 160T488 144T454 131T417 125Q361 125 320 166T279 284Q279 393 356 481T523 569Q570 569 603 537Q623 515 632 490L637 480L657 479Q684 479 684 470Q684 465 650 333L617 199V185Q616 162 628 162Q677 162 712 278Q743 381 743 442Q743 555 687 611T553 668Q467 668 385 608T250 450T198 250ZM598 445Q598 453 594 470T569 510T518 532Q463 532 410 448T356 271Q356 220 374 191T423 162Q482 162 552 255L575 348Q598 440 598 445Z"></path><path stroke-width="1" d="M103 163Q106 263 173 347T320 441Q322 441 329 441T341 442Q387 439 419 398Q420 399 420 400Q421 402 425 406T440 416T464 422Q476 421 485 413T494 396Q494 386 465 268T407 38T377 -77Q365 -123 310 -164T179 -205Q46 -205 46 -139Q46 -114 64 -97T106 -79Q127 -79 136 -91T146 -115Q146 -127 141 -138T130 -155T124 -162T125 -163Q133 -166 170 -168Q200 -168 217 -162Q242 -153 264 -130T297 -78Q298 -74 305 -46T320 10T327 38Q326 38 317 31T291 15T256 2Q249 1 231 1Q182 1 143 38T103 163ZM398 324Q398 330 395 346T375 383T332 405Q330 405 326 405T320 404Q291 396 263 365Q230 324 208 239T185 115Q185 38 238 38Q258 38 279 50T312 77T336 106L348 122Q349 125 373 223T398 324Z" transform="translate(767,0)"></path><path stroke-width="1" d="M81 278Q75 284 75 289Q77 299 89 338Q101 373 114 396T142 428T166 439T186 442H189Q225 440 251 417Q266 401 271 384L275 374L286 386Q342 442 414 442Q428 442 440 440T461 435T479 427T493 418T503 407T511 397T516 387T520 378T523 370L524 366Q546 395 583 418T667 442Q729 442 755 411T782 338Q782 290 743 178T704 45Q704 26 720 26Q773 26 802 136Q805 148 807 150T822 153H828Q838 153 841 153T848 150T851 143Q851 137 843 115T821 63T778 12T715 -10Q671 -10 652 16T632 71Q632 88 668 191T704 349Q704 367 703 372Q693 405 664 405Q637 405 613 393T571 360T547 329T534 309Q523 290 518 274T487 151Q455 24 452 16Q438 -11 408 -11T376 18Q376 26 411 167T447 314Q449 325 449 346Q449 372 444 384Q431 405 408 405Q334 405 276 305Q266 289 262 273T231 151Q199 24 196 16Q182 -11 152 -11T120 18Q120 26 159 182T200 347Q202 361 202 372Q202 405 181 405Q168 405 159 391Q145 374 132 328T117 280T98 278H81Z" transform="translate(1228,0)"></path><path stroke-width="1" d="M418 53Q418 26 438 26Q466 26 494 131Q500 151 504 152Q507 153 516 153H521Q531 153 534 153T540 150T543 144Q543 141 540 126T529 88T509 43T477 5T434 -11Q404 -11 383 3T354 30T347 48H346Q345 47 342 45T337 40Q282 -11 228 -11Q172 -11 137 34T101 146Q101 260 177 351T333 442Q343 442 352 441T369 437T382 431T393 425T402 417T409 410T414 402T419 396Q423 406 436 414T461 422Q475 422 484 413T494 395Q494 384 459 244T420 88Q418 80 418 58V53ZM397 323Q397 344 382 374T333 405Q302 405 271 372Q249 349 235 316T203 215Q184 135 184 108V100V94Q184 54 207 35Q218 26 235 26Q279 26 330 91Q343 109 346 118T372 217Q397 317 397 323Z" transform="translate(2046,0)"></path><path stroke-width="1" d="M234 599Q234 620 251 638T292 656Q306 656 319 647T332 617Q332 594 313 577T273 560Q260 560 247 569T234 599ZM75 287Q75 292 82 313T103 362T142 413T196 441H214Q248 441 270 419T293 357Q292 338 289 330T245 208Q193 72 193 46Q193 26 209 26Q228 26 247 43Q273 71 292 136Q295 148 297 150T311 153H317Q327 153 330 153T337 150T340 143Q340 133 330 105T292 41T228 -8Q220 -10 204 -10Q160 -10 141 15T122 71Q122 98 171 227T221 384Q221 396 218 400T203 405Q175 403 156 374T128 312T116 279Q115 278 97 278H81Q75 284 75 287Z" transform="translate(2558,0)"></path><path stroke-width="1" d="M162 61Q162 26 183 26Q211 26 239 131Q245 151 249 152Q252 153 261 153H266H271Q288 153 288 144Q288 143 286 129Q276 91 266 65T232 14T179 -11Q144 -11 116 12T87 81Q87 96 88 102L216 616Q216 629 209 632T170 637H149Q143 643 143 645T145 664Q150 683 158 683Q163 683 223 688T300 694Q312 694 312 686Q312 676 240 389L164 86Q162 74 162 61Z" transform="translate(2865,0)"></path><path stroke-width="1" d="M107 50Q107 76 129 98T181 121Q203 121 217 108T231 72Q231 47 210 24T156 0Q135 0 121 13T107 50Z" transform="translate(3122,0)"></path><path stroke-width="1" d="M257 -10Q183 -10 143 37T103 155Q103 257 173 341T337 440Q341 441 348 441H358Q421 441 445 415T469 356Q469 320 450 305T410 289Q392 289 381 299T370 325Q370 362 404 378L414 383Q392 402 365 405Q322 405 285 375T227 294Q217 271 202 213T187 119Q187 27 263 27Q299 27 330 40Q361 51 386 71T424 106T440 121Q444 121 455 110T466 96Q466 92 458 81T432 54T390 24T331 0T257 -10Z" transform="translate(3429,0)"></path><path stroke-width="1" d="M103 155Q103 266 185 354T366 442Q435 442 476 394T517 275Q517 169 436 79T255 -11Q194 -11 149 32T103 155ZM187 119Q187 67 209 47T260 26Q290 26 321 47Q354 68 380 113T426 260Q432 291 432 315Q432 361 408 385Q388 405 358 405Q319 405 283 374T227 294Q217 271 202 213T187 119Z" transform="translate(3890,0)"></path><path stroke-width="1" d="M81 278Q75 284 75 289Q77 299 89 338Q101 373 114 396T142 428T166 439T186 442H189Q225 440 251 417Q266 401 271 384L275 374L286 386Q342 442 414 442Q428 442 440 440T461 435T479 427T493 418T503 407T511 397T516 387T520 378T523 370L524 366Q546 395 583 418T667 442Q729 442 755 411T782 338Q782 290 743 178T704 45Q704 26 720 26Q773 26 802 136Q805 148 807 150T822 153H828Q838 153 841 153T848 150T851 143Q851 137 843 115T821 63T778 12T715 -10Q671 -10 652 16T632 71Q632 88 668 191T704 349Q704 367 703 372Q693 405 664 405Q637 405 613 393T571 360T547 329T534 309Q523 290 518 274T487 151Q455 24 452 16Q438 -11 408 -11T376 18Q376 26 411 167T447 314Q449 325 449 346Q449 372 444 384Q431 405 408 405Q334 405 276 305Q266 289 262 273T231 151Q199 24 196 16Q182 -11 152 -11T120 18Q120 26 159 182T200 347Q202 361 202 372Q202 405 181 405Q168 405 159 391Q145 374 132 328T117 280T98 278H81Z" transform="translate(4401,0)"></path></g></svg></span>.

##### Solution:
```java

class Contact {

	public String name;
	public String email;

	public Contact(String name, String email) {
		this.name = name;
		this.email = email;
	}
}

static final String PATTERN_GMAIL = "\\w+@gmail.com$";

public static List<String> checkWithGmail(Contact[] contacts) {
	ArrayList<String> gmailContacts = new ArrayList<>();
	for (int i = 0; i < contacts.length; i++) {
		if(matchEmail(contacts[i].email))
			gmailContacts.add(contacts[i].name);
	}
	Collections.sort(gmailContacts);
    return gmailContacts;
}

private static boolean matchEmail(String email) {
	  return Pattern
			  .compile(PATTERN_GMAIL)
			  .matcher(email)
			  .find();
}
```

### Day 29 - Bitwise AND
Given set <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-1-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="19.72ex" height="2.843ex" style="vertical-align: -0.838ex;" viewBox="0 -863.1 8490.4 1223.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M308 24Q367 24 416 76T466 197Q466 260 414 284Q308 311 278 321T236 341Q176 383 176 462Q176 523 208 573T273 648Q302 673 343 688T407 704H418H425Q521 704 564 640Q565 640 577 653T603 682T623 704Q624 704 627 704T632 705Q645 705 645 698T617 577T585 459T569 456Q549 456 549 465Q549 471 550 475Q550 478 551 494T553 520Q553 554 544 579T526 616T501 641Q465 662 419 662Q362 662 313 616T263 510Q263 480 278 458T319 427Q323 425 389 408T456 390Q490 379 522 342T554 242Q554 216 546 186Q541 164 528 137T492 78T426 18T332 -20Q320 -22 298 -22Q199 -22 144 33L134 44L106 13Q83 -14 78 -18T65 -22Q52 -22 52 -14Q52 -11 110 221Q112 227 130 227H143Q149 221 149 216Q149 214 148 207T144 186T142 153Q144 114 160 87T203 47T255 29T308 24Z"></path><g transform="translate(923,0)"><path stroke-width="1" d="M56 347Q56 360 70 367H707Q722 359 722 347Q722 336 708 328L390 327H72Q56 332 56 347ZM56 153Q56 168 72 173H708Q722 163 722 153Q722 140 707 133H70Q56 140 56 153Z"></path></g><g transform="translate(1979,0)"><path stroke-width="1" d="M434 -231Q434 -244 428 -250H410Q281 -250 230 -184Q225 -177 222 -172T217 -161T213 -148T211 -133T210 -111T209 -84T209 -47T209 0Q209 21 209 53Q208 142 204 153Q203 154 203 155Q189 191 153 211T82 231Q71 231 68 234T65 250T68 266T82 269Q116 269 152 289T203 345Q208 356 208 377T209 529V579Q209 634 215 656T244 698Q270 724 324 740Q361 748 377 749Q379 749 390 749T408 750H428Q434 744 434 732Q434 719 431 716Q429 713 415 713Q362 710 332 689T296 647Q291 634 291 499V417Q291 370 288 353T271 314Q240 271 184 255L170 250L184 245Q202 239 220 230T262 196T290 137Q291 131 291 1Q291 -134 296 -147Q306 -174 339 -192T415 -213Q429 -213 431 -216Q434 -219 434 -231Z"></path></g><g transform="translate(2480,0)"><path stroke-width="1" d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path></g><g transform="translate(2980,0)"><path stroke-width="1" d="M78 35T78 60T94 103T137 121Q165 121 187 96T210 8Q210 -27 201 -60T180 -117T154 -158T130 -185T117 -194Q113 -194 104 -185T95 -172Q95 -168 106 -156T131 -126T157 -76T173 -3V9L172 8Q170 7 167 6T161 3T152 1T140 0Q113 0 96 17Z"></path></g><g transform="translate(3425,0)"><path stroke-width="1" d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z"></path></g><g transform="translate(3926,0)"><path stroke-width="1" d="M78 35T78 60T94 103T137 121Q165 121 187 96T210 8Q210 -27 201 -60T180 -117T154 -158T130 -185T117 -194Q113 -194 104 -185T95 -172Q95 -168 106 -156T131 -126T157 -76T173 -3V9L172 8Q170 7 167 6T161 3T152 1T140 0Q113 0 96 17Z"></path></g><g transform="translate(4371,0)"><path stroke-width="1" d="M127 463Q100 463 85 480T69 524Q69 579 117 622T233 665Q268 665 277 664Q351 652 390 611T430 522Q430 470 396 421T302 350L299 348Q299 347 308 345T337 336T375 315Q457 262 457 175Q457 96 395 37T238 -22Q158 -22 100 21T42 130Q42 158 60 175T105 193Q133 193 151 175T169 130Q169 119 166 110T159 94T148 82T136 74T126 70T118 67L114 66Q165 21 238 21Q293 21 321 74Q338 107 338 175V195Q338 290 274 322Q259 328 213 329L171 330L168 332Q166 335 166 348Q166 366 174 366Q202 366 232 371Q266 376 294 413T322 525V533Q322 590 287 612Q265 626 240 626Q208 626 181 615T143 592T132 580H135Q138 579 143 578T153 573T165 566T175 555T183 540T186 520Q186 498 172 481T127 463Z"></path></g><g transform="translate(4871,0)"><path stroke-width="1" d="M78 35T78 60T94 103T137 121Q165 121 187 96T210 8Q210 -27 201 -60T180 -117T154 -158T130 -185T117 -194Q113 -194 104 -185T95 -172Q95 -168 106 -156T131 -126T157 -76T173 -3V9L172 8Q170 7 167 6T161 3T152 1T140 0Q113 0 96 17Z"></path></g><g transform="translate(5317,0)"><path stroke-width="1" d="M78 60Q78 84 95 102T138 120Q162 120 180 104T199 61Q199 36 182 18T139 0T96 17T78 60ZM525 60Q525 84 542 102T585 120Q609 120 627 104T646 61Q646 36 629 18T586 0T543 17T525 60ZM972 60Q972 84 989 102T1032 120Q1056 120 1074 104T1093 61Q1093 36 1076 18T1033 0T990 17T972 60Z"></path></g><g transform="translate(6656,0)"><path stroke-width="1" d="M78 35T78 60T94 103T137 121Q165 121 187 96T210 8Q210 -27 201 -60T180 -117T154 -158T130 -185T117 -194Q113 -194 104 -185T95 -172Q95 -168 106 -156T131 -126T157 -76T173 -3V9L172 8Q170 7 167 6T161 3T152 1T140 0Q113 0 96 17Z"></path></g><g transform="translate(7101,0)"><path stroke-width="1" d="M234 637Q231 637 226 637Q201 637 196 638T191 649Q191 676 202 682Q204 683 299 683Q376 683 387 683T401 677Q612 181 616 168L670 381Q723 592 723 606Q723 633 659 637Q635 637 635 648Q635 650 637 660Q641 676 643 679T653 683Q656 683 684 682T767 680Q817 680 843 681T873 682Q888 682 888 672Q888 650 880 642Q878 637 858 637Q787 633 769 597L620 7Q618 0 599 0Q585 0 582 2Q579 5 453 305L326 604L261 344Q196 88 196 79Q201 46 268 46H278Q284 41 284 38T282 19Q278 6 272 0H259Q228 2 151 2Q123 2 100 2T63 2T46 1Q31 1 31 10Q31 14 34 26T39 40Q41 46 62 46Q130 49 150 85Q154 91 221 362L289 634Q287 635 234 637Z"></path></g><g transform="translate(7989,0)"><path stroke-width="1" d="M65 731Q65 745 68 747T88 750Q171 750 216 725T279 670Q288 649 289 635T291 501Q292 362 293 357Q306 312 345 291T417 269Q428 269 431 266T434 250T431 234T417 231Q380 231 345 210T298 157Q293 143 292 121T291 -28V-79Q291 -134 285 -156T256 -198Q202 -250 89 -250Q71 -250 68 -247T65 -230Q65 -224 65 -223T66 -218T69 -214T77 -213Q91 -213 108 -210T146 -200T183 -177T207 -139Q208 -134 209 3L210 139Q223 196 280 230Q315 247 330 250Q305 257 280 270Q225 304 212 352L210 362L209 498Q208 635 207 640Q195 680 154 696T77 713Q68 713 67 716T65 731Z"></path></g></g></svg></span>. Find two integers, <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-2-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.743ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 750.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M208 74Q208 50 254 46Q272 46 272 35Q272 34 270 22Q267 8 264 4T251 0Q249 0 239 0T205 1T141 2Q70 2 50 0H42Q35 7 35 11Q37 38 48 46H62Q132 49 164 96Q170 102 345 401T523 704Q530 716 547 716H555H572Q578 707 578 706L606 383Q634 60 636 57Q641 46 701 46Q726 46 726 36Q726 34 723 22Q720 7 718 4T704 0Q701 0 690 0T651 1T578 2Q484 2 455 0H443Q437 6 437 9T439 27Q443 40 445 43L449 46H469Q523 49 533 63L521 213H283L249 155Q208 86 208 74ZM516 260Q516 271 504 416T490 562L463 519Q447 492 400 412L310 260L413 259Q516 259 516 260Z"></path></g></svg></span> and <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-3-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.764ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 759.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M231 637Q204 637 199 638T194 649Q194 676 205 682Q206 683 335 683Q594 683 608 681Q671 671 713 636T756 544Q756 480 698 429T565 360L555 357Q619 348 660 311T702 219Q702 146 630 78T453 1Q446 0 242 0Q42 0 39 2Q35 5 35 10Q35 17 37 24Q42 43 47 45Q51 46 62 46H68Q95 46 128 49Q142 52 147 61Q150 65 219 339T288 628Q288 635 231 637ZM649 544Q649 574 634 600T585 634Q578 636 493 637Q473 637 451 637T416 636H403Q388 635 384 626Q382 622 352 506Q352 503 351 500L320 374H401Q482 374 494 376Q554 386 601 434T649 544ZM595 229Q595 273 572 302T512 336Q506 337 429 337Q311 337 310 336Q310 334 293 263T258 122L240 52Q240 48 252 48T333 46Q422 46 429 47Q491 54 543 105T595 229Z"></path></g></svg></span> (where <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-4-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="6.606ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 2844.1 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M208 74Q208 50 254 46Q272 46 272 35Q272 34 270 22Q267 8 264 4T251 0Q249 0 239 0T205 1T141 2Q70 2 50 0H42Q35 7 35 11Q37 38 48 46H62Q132 49 164 96Q170 102 345 401T523 704Q530 716 547 716H555H572Q578 707 578 706L606 383Q634 60 636 57Q641 46 701 46Q726 46 726 36Q726 34 723 22Q720 7 718 4T704 0Q701 0 690 0T651 1T578 2Q484 2 455 0H443Q437 6 437 9T439 27Q443 40 445 43L449 46H469Q523 49 533 63L521 213H283L249 155Q208 86 208 74ZM516 260Q516 271 504 416T490 562L463 519Q447 492 400 412L310 260L413 259Q516 259 516 260Z"></path><g transform="translate(1028,0)"><path stroke-width="1" d="M694 -11T694 -19T688 -33T678 -40Q671 -40 524 29T234 166L90 235Q83 240 83 250Q83 261 91 266Q664 540 678 540Q681 540 687 534T694 519T687 505Q686 504 417 376L151 250L417 124Q686 -4 687 -5Q694 -11 694 -19Z"></path></g><g transform="translate(2084,0)"><path stroke-width="1" d="M231 637Q204 637 199 638T194 649Q194 676 205 682Q206 683 335 683Q594 683 608 681Q671 671 713 636T756 544Q756 480 698 429T565 360L555 357Q619 348 660 311T702 219Q702 146 630 78T453 1Q446 0 242 0Q42 0 39 2Q35 5 35 10Q35 17 37 24Q42 43 47 45Q51 46 62 46H68Q95 46 128 49Q142 52 147 61Q150 65 219 339T288 628Q288 635 231 637ZM649 544Q649 574 634 600T585 634Q578 636 493 637Q473 637 451 637T416 636H403Q388 635 384 626Q382 622 352 506Q352 503 351 500L320 374H401Q482 374 494 376Q554 386 601 434T649 544ZM595 229Q595 273 572 302T512 336Q506 337 429 337Q311 337 310 336Q310 334 293 263T258 122L240 52Q240 48 252 48T333 46Q422 46 429 47Q491 54 543 105T595 229Z"></path></g></g></svg></span>), from set <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-5-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.499ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 645.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M308 24Q367 24 416 76T466 197Q466 260 414 284Q308 311 278 321T236 341Q176 383 176 462Q176 523 208 573T273 648Q302 673 343 688T407 704H418H425Q521 704 564 640Q565 640 577 653T603 682T623 704Q624 704 627 704T632 705Q645 705 645 698T617 577T585 459T569 456Q549 456 549 465Q549 471 550 475Q550 478 551 494T553 520Q553 554 544 579T526 616T501 641Q465 662 419 662Q362 662 313 616T263 510Q263 480 278 458T319 427Q323 425 389 408T456 390Q490 379 522 342T554 242Q554 216 546 186Q541 164 528 137T492 78T426 18T332 -20Q320 -22 298 -22Q199 -22 144 33L134 44L106 13Q83 -14 78 -18T65 -22Q52 -22 52 -14Q52 -11 110 221Q112 227 130 227H143Q149 221 149 216Q149 214 148 207T144 186T142 153Q144 114 160 87T203 47T255 29T308 24Z"></path></g></svg></span> such that the value of <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-6-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="5.315ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 2288.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M208 74Q208 50 254 46Q272 46 272 35Q272 34 270 22Q267 8 264 4T251 0Q249 0 239 0T205 1T141 2Q70 2 50 0H42Q35 7 35 11Q37 38 48 46H62Q132 49 164 96Q170 102 345 401T523 704Q530 716 547 716H555H572Q578 707 578 706L606 383Q634 60 636 57Q641 46 701 46Q726 46 726 36Q726 34 723 22Q720 7 718 4T704 0Q701 0 690 0T651 1T578 2Q484 2 455 0H443Q437 6 437 9T439 27Q443 40 445 43L449 46H469Q523 49 533 63L521 213H283L249 155Q208 86 208 74ZM516 260Q516 271 504 416T490 562L463 519Q447 492 400 412L310 260L413 259Q516 259 516 260Z"></path><g transform="translate(750,0)"><path stroke-width="1" d="M156 540Q156 620 201 668T302 716Q354 716 377 671T401 578Q401 505 287 386L274 373Q309 285 416 148L429 132L437 142Q474 191 543 309L562 341V349Q562 368 541 376T498 385H493V431H502L626 428Q709 428 721 431H727V385H712Q688 384 669 379T639 369T618 354T603 337T591 316T578 295Q537 223 506 176T464 117T454 104Q454 102 471 85T497 62Q543 24 585 24Q618 24 648 48T682 113V121H722V112Q721 94 714 75T692 32T646 -7T574 -22Q491 -19 414 42L402 51L391 42Q312 -22 224 -22Q144 -22 93 25T42 135Q42 153 46 169T55 197T74 225T96 249T125 278T156 308L195 347L190 360Q185 372 182 382T174 411T165 448T159 491T156 540ZM361 576Q361 613 348 646T305 679Q272 679 252 649T232 572Q232 497 255 426L259 411L267 420Q361 519 361 576ZM140 164Q140 103 167 64T240 24Q271 24 304 36T356 61T374 77Q295 156 235 262L220 292L210 310L193 293Q177 277 169 268T151 229T140 164Z"></path></g><g transform="translate(1529,0)"><path stroke-width="1" d="M231 637Q204 637 199 638T194 649Q194 676 205 682Q206 683 335 683Q594 683 608 681Q671 671 713 636T756 544Q756 480 698 429T565 360L555 357Q619 348 660 311T702 219Q702 146 630 78T453 1Q446 0 242 0Q42 0 39 2Q35 5 35 10Q35 17 37 24Q42 43 47 45Q51 46 62 46H68Q95 46 128 49Q142 52 147 61Q150 65 219 339T288 628Q288 635 231 637ZM649 544Q649 574 634 600T585 634Q578 636 493 637Q473 637 451 637T416 636H403Q388 635 384 626Q382 622 352 506Q352 503 351 500L320 374H401Q482 374 494 376Q554 386 601 434T649 544ZM595 229Q595 273 572 302T512 336Q506 337 429 337Q311 337 310 336Q310 334 293 263T258 122L240 52Q240 48 252 48T333 46Q422 46 429 47Q491 54 543 105T595 229Z"></path></g></g></svg></span> is the maximum possible <em>and also less than a given integer, <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-7-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="2.066ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 889.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M285 628Q285 635 228 637Q205 637 198 638T191 647Q191 649 193 661Q199 681 203 682Q205 683 214 683H219Q260 681 355 681Q389 681 418 681T463 682T483 682Q500 682 500 674Q500 669 497 660Q496 658 496 654T495 648T493 644T490 641T486 639T479 638T470 637T456 637Q416 636 405 634T387 623L306 305Q307 305 490 449T678 597Q692 611 692 620Q692 635 667 637Q651 637 651 648Q651 650 654 662T659 677Q662 682 676 682Q680 682 711 681T791 680Q814 680 839 681T869 682Q889 682 889 672Q889 650 881 642Q878 637 862 637Q787 632 726 586Q710 576 656 534T556 455L509 418L518 396Q527 374 546 329T581 244Q656 67 661 61Q663 59 666 57Q680 47 717 46H738Q744 38 744 37T741 19Q737 6 731 0H720Q680 3 625 3Q503 3 488 0H478Q472 6 472 9T474 27Q478 40 480 43T491 46H494Q544 46 544 71Q544 75 517 141T485 216L427 354L359 301L291 248L268 155Q245 63 245 58Q245 51 253 49T303 46H334Q340 37 340 35Q340 19 333 5Q328 0 317 0Q314 0 280 1T180 2Q118 2 85 2T49 1Q31 1 31 11Q31 13 34 25Q38 41 42 43T65 46Q92 46 125 49Q139 52 144 61Q147 65 216 339T285 628Z"></path></g></svg></span></em>. In this case, <span style="font-size: 100%; display: inline-block;" class="MathJax_SVG" id="MathJax-Element-8-Frame"><svg xmlns:xlink="http://www.w3.org/1999/xlink" width="1.808ex" height="2.176ex" style="vertical-align: -0.338ex;" viewBox="0 -791.3 778.5 936.9" role="img" focusable="false"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><path stroke-width="1" d="M156 540Q156 620 201 668T302 716Q354 716 377 671T401 578Q401 505 287 386L274 373Q309 285 416 148L429 132L437 142Q474 191 543 309L562 341V349Q562 368 541 376T498 385H493V431H502L626 428Q709 428 721 431H727V385H712Q688 384 669 379T639 369T618 354T603 337T591 316T578 295Q537 223 506 176T464 117T454 104Q454 102 471 85T497 62Q543 24 585 24Q618 24 648 48T682 113V121H722V112Q721 94 714 75T692 32T646 -7T574 -22Q491 -19 414 42L402 51L391 42Q312 -22 224 -22Q144 -22 93 25T42 135Q42 153 46 169T55 197T74 225T96 249T125 278T156 308L195 347L190 360Q185 372 182 382T174 411T165 448T159 491T156 540ZM361 576Q361 613 348 646T305 679Q272 679 252 649T232 572Q232 497 255 426L259 411L267 420Q361 519 361 576ZM140 164Q140 103 167 64T240 24Q271 24 304 36T356 61T374 77Q295 156 235 262L220 292L210 310L193 293Q177 277 169 268T151 229T140 164Z"></path></g></svg></span> represents the <em>bitwise AND</em> operator.
##### Solution:
```java
public static int getMaximumPossible(int n, int k) {
	 if(((k-1)|k) > n && k%2==0)
	     return k-2;
	 return k-1;
}
```


