import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class DataAnalysisProgram {

	public static void main(String[] args) throws FileNotFoundException {
		

		    {
		        // Prompt for the input and output file names
		        
		        
		       // System.out.print("Output file: ");
		        //String outputFileName = console.next();

		        // Construct the Scanner and PrintWriter objects for reading and writing
		        
		        //PrintWriter out = new PrintWriter(outputFileName);

		        DataAnalysis data1 = new DataAnalysis();
		        data1.reader();
		        data1.numberOfGrades();
		        int n = data1.numberOfGrades();
		        data1.createArray(n);

		       // while (input.hasNextLine())
		       // {
		         //   String line = input.nextLine();
		           // out.println("/* " + lineNumber + " */ " + line);
		            //lineNumber++;
		       // }

		        //input.close();
		        //out.close();
		    }
		}

}
