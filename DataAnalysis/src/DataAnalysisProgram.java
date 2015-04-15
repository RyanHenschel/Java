import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * @author Ryan Henschel
 * CS 220
 * LAB 5 DataAnalysis
 * 4/15/15
 * This class allows the user to choose different ways to
 * analyze the data. It can show the user different and
 * multiple data analysis of the grades
 */
public class DataAnalysisProgram {
	/**
	 * This is the main method that interacts with the user
	 * 
	 * @param args is a parameter used with String to print
	 * @throws Exception is used in case the user inputs
	 *    the incorrect type
	 */
	public static void main(String[] args) throws Exception {
		DataAnalysis data1 = new DataAnalysis();
		Scanner in = new Scanner(System.in);
		data1.reader(in);
		data1.numberOfGrades();
		data1.createArray();
		data1.numberSorter();

		boolean program = true;
	
		System.out.println("Enter one of the numbers below for the type of analysis:");
		System.out.println("0 - to quit");
		System.out.println("1 - show the grades");
		System.out.println("2 - show minimum grade");
		System.out.println("3 - show median grade");
		System.out.println("4 - show maximum grade");
		System.out.println("5 - show the 5-number summary");
		System.out.println("6 - show the average of the grades");
		System.out.println("7 - show the standard deviation of the grades");
		System.out.println("8 - show the grade range");
		System.out.println("9 - show the letter grades");
		System.out.println("10 - show the histogram analysis");
		System.out.println("11 - check for a number");	
		
		data1.minimum();
		data1.median();
		data1.maximum();
		data1.average();
		data1.range();
		data1.standardDeviation();
		data1.average();
		data1.letterGrades();

		while (program)
		{
			System.out.println();
			System.out.print("What would you like to check? ");
			int z;
			
			if (in.hasNextInt())
				z = in.nextInt();	 
			else
				z = 0;

			if (z>11 || z<0)
			{
				z = z%11;
				throw new IllegalArgumentException("That's an invalid number.");
			}
				
			else if (z == 1)
			{
				data1.printArray();
				System.out.println();
			}
			else if (z == 2)
				data1.getMinimum();
			
			else if (z == 3)
				data1.getMedian();
			
			else if (z == 4)
				data1.getMaximum();
			
			else if (z == 5)
				data1.fiveNumberSummary();
			
			else if (z == 6)
				data1.getAverage();
			
			else if (z == 7)
				data1.getStandardDeviation();
			
			else if (z == 8)
				data1.getRange();
			
			else if (z == 9)
				data1.getLetterGrades();
			
			else if (z == 10)
				data1.histogram();
			
			else if (z == 11)
			{
				System.out.print("Which grade do you want to search for? ");
				int check = in.nextInt();
				data1.findGrade(check);
			}
			else
			{
				System.out.println("You chose to close the program. Thank you!");
				program = false;
			}			
		}
		in.close();
	}
}
