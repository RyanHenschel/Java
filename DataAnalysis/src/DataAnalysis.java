import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Ryan Henschel
 * CS 220
 * LAB 5 DataAnalysis
 * 4/15/15
 * This class provides all of the methods for all
 * of the data analysis for a list of grades
 * that is pulled from a file and put into an array
 */
public class DataAnalysis {
	String line;
	String numbers;
	private int a=0;
	private int b=0;
	private int c=0;
	private int d=0;
	private int f=0;
	private int average;
	private int minimum;
	private int median;
	private int maximum;
	private int range;
	private double standardDeviation;
	private int quartile1;
	private int quartile3;
	public final int MAX_ARRAY_SIZE = 20;
	private int[] gradeList = new int[MAX_ARRAY_SIZE];
	private int numberOfGrades;

	/**
	 * This method reads the file given by the user
	 * 
	 * @param in calls the scanner in that is
	 *    initialized in DataAnalysisProgram
	 * @throws FileNotFoundException checks to
	 *    see if the file is found
	 */
	public void reader(Scanner in) throws FileNotFoundException {
		System.out.print("Input file (0 for grades or 1 for grades1): ");
		int choice = in.nextInt();
		String inputFileName;

		if (choice == 0)
			inputFileName = "grades.txt";
		else if (choice == 1)
			inputFileName = "grades1.txt";
		else
			throw new IllegalArgumentException("That's an invalid number.");

		File inputFile = new File(inputFileName);
		Scanner input = new Scanner(inputFile);
		line = input.nextLine();
		input.close();
	}

	/**
	 * This method computes that number of grades
	 * that was in the file
	 * 
	 * @return returns the number of grades
	 */
	public int numberOfGrades() {
		for (int i=0; i<line.length(); i++)
			numberOfGrades++;

		numberOfGrades = (numberOfGrades + 1)/3;
		return numberOfGrades;
	}

	/**
	 * This accessor method gets the number of grades
	 */
	public void getNumberOfGrades() {
		System.out.println("The number of grades entered is " + numberOfGrades + ".");
	}

	/**
	 * This method creates the array of grades
	 */
	public void createArray() {
		int numbers1;
		int n = numberOfGrades*3;
		int i=0;
		int k=0;

		while (i<n)
		{ 
			numbers = line.substring(i, i+2);
			try {
				numbers1 = Integer.parseInt(numbers);
				gradeList[k] = numbers1;
				i=i+3;
				k++;
			}
			catch (NumberFormatException exception) {
				System.out.println("String contained non-integers.");
			}
		}	
	}

	/**
	 * This method prints the array
	 */
	public void printArray() {
		for (int i=0; i<numberOfGrades; i++)
			System.out.print(gradeList[i] + " ");
	}

	/**
	 * This method sorts the numbers in the array
	 */
	public void numberSorter() {
		for (int i=0; i<gradeList.length -1; i++)
		{
			int minPos = minimumPosition(i);
			swap(minPos, i);
		}
	}

	/**
	 * This method keeps track of the minimum position
	 * 
	 * @param from is an integer that keeps track of 
	 *    the position where the minimum number is
	 * @return returns the minimum position
	 */
	private int minimumPosition(int from) {
		int minPos = from;

		for (int i=from+1; i<gradeList.length; i++)
			if (gradeList[i] < gradeList[minPos])
				minPos = i;

		return minPos;
	}

	/**
	 * This method swaps two numbers if one is 
	 *    smaller than the other
	 *    
	 * @param i used to swap the two numbers
	 * @param j used to swap the two numbers
	 */
	private void swap(int i, int j) {
		int temporary = gradeList[i];
		gradeList[i] = gradeList[j];
		gradeList[j] = temporary;
	}

	/**
	 * This method computes the average of all
	 * of the grades
	 * 
	 * @return returns the average
	 */
	public int average() {
		int total = 0;

		for (int i=0; i<gradeList.length-1; i++)
			total = total + gradeList[i];

		average = total/numberOfGrades;
		return average;		
	}

	/**
	 * This accessor method gets the average
	 */
	public void getAverage() {
		System.out.println("The average of the grades is " + average + ".");
	}

	/**
	 * This method computes the median of the grades
	 * @return returns the median
	 */
	public int median() {
		if (numberOfGrades%2 == 1)
		{
			int half = gradeList.length/2;
			median = gradeList[half];
			return median;
		}
		else
		{
			int half = gradeList.length/2;
			int middle1 = gradeList[half - 1];
			int middle2 = gradeList[half];
			median = (middle1+middle2)/2;
			return median;
		}
	}

	/**
	 * This accessor method gets the median
	 */
	public void getMedian() {
		System.out.println("The median grade is " + median + ".");
	}

	/**
	 * This method finds the maximum grade at the end
	 * of the sorted array
	 * 
	 * @return returns the maximum grade
	 */
	public int maximum() {
		maximum = gradeList[gradeList.length-1];
		return maximum;
	}

	/**
	 * This accessor method gets the maximum grade
	 */
	public void getMaximum() {
		System.out.println("The maximum grade is " + maximum + ".");
	}

	/**
	 * This method finds the minimum grade at the
	 * beginning of the sorted array
	 * 
	 * @return returns the minimum grade
	 */
	public int minimum() {
		minimum = gradeList[0];
		return minimum;
	}

	/**
	 * This accessor method gets the minimum grade
	 */
	public void getMinimum() {
		System.out.println("The minimum grade is " + minimum + ".");
	}

	/**
	 * This method computes the range of the grades
	 * 
	 * @return returns the range
	 */
	public int range() {
		range = maximum-minimum;
		return range;
	}

	/**
	 * This accessor method gets the grade range
	 */
	public void getRange() {
		System.out.println("The grade range is " + range + ".");
	}

	/**
	 * This method computes the standard deviation
	 * of the grades
	 * 
	 * @return returns the standard deviation
	 */
	public int standardDeviation() {
		double sd1;
		double sd2;
		double sd3 = 0;
		double sd4;

		for (int i=0; i<gradeList.length; i++)
		{
			sd1 = gradeList[i] - average;
			sd2 = sd1*sd1;
			sd3 = sd3 + sd2;
		}

		sd4 = sd3/numberOfGrades;
		standardDeviation = (int) Math.sqrt(sd4);
		return (int) standardDeviation;
	}

	/**
	 * This accessor method gets the standard deviation
	 */
	public void getStandardDeviation() {
		System.out.println("The standard deviation of the grades is " + standardDeviation + ".");
	}

	/**
	 * This method computes the quartiles and prints
	 * out the five number summary
	 */
	public void fiveNumberSummary() {
		quartile1 = ((median-minimum)/2) + minimum;
		quartile3 = ((maximum-median))/2 + median;
		System.out.println("The five number summary for the grades is: " + minimum + 
				", " + quartile1 + ", " + median + ", " + quartile3 + ", " + maximum);
	}

	/**
	 * This method checks the array for certain
	 * numbers and keeps count of how many of 
	 * certain grades there were
	 */
	public void letterGrades() {

		for (int i=0; i<gradeList.length; i++)
		{
			if (gradeList[i] >= 90)
				a++;
			else if (gradeList[i] >= 80)
				b++;
			else if (gradeList[i] >= 70)
				c++;
			else if (gradeList[i] >= 60)
				d++;
			else
				f++;
		}

	}

	/**
	 * This accessor method gets the letter grades
	 */
	public void getLetterGrades() {
		System.out.println("The number of A's is " + a + ".");
		System.out.println("The number of B's is " + b + ".");
		System.out.println("The number of C's is " + c + ".");
		System.out.println("The number of D's is " + d + ".");
		System.out.println("The number of F's is " + f + ".");
	}

	/**
	 * This method searches the array for a grade
	 * entered by the user
	 * 
	 * @param check is the number the user enters
	 *    that they want to check the array for
	 */
	public void findGrade(int check) {
		int j = 0;

		for (int i=0; i<gradeList.length-1; i++)
		{
			if (check == gradeList[i])
				j++;
		}

		System.out.println("The grade " + check + " was found " + j + " time(s).");
	}

	/**
	 * This method prints out a histogram of the
	 * different letter grades
	 */
	public void histogram() {
		String title = "Histogram of Grades: ";
		String textA = "     A's (above 90): ";
		String textB = "     B's  (80 - 89): ";
		String textC = "     C's  (70 - 79): ";
		String textD = "     D's  (60 - 69): ";
		String textF = "     F's (below 60): ";
		String x =" x";

		System.out.println(title);

		System.out.print(textA);
		for (int j=0; j<a; j++)
			System.out.print(x);
		System.out.println();

		System.out.print(textB);
		for (int j=0; j<b; j++)
			System.out.print(x);
		System.out.println();

		System.out.print(textC);
		for (int j=0; j<c; j++)
			System.out.print(x);
		System.out.println();

		System.out.print(textD);
		for (int j=0; j<d; j++)
			System.out.print(x);
		System.out.println();

		System.out.print(textF);
		for (int j=0; j<f; j++)
			System.out.print(x);
		System.out.println();
	}
}
