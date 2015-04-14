import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * @author Ryan Henschel
 * CS 220
 * LAB 4 Suduko
 * 4/9/15
 * This class contains methods to create a suduko
 * puzzle and check and change boxes, if allowed
 */
public class Suduko {
	final static int ROWS = 9;
	final static int COLUMNS = 9;
	final static int maxVal = 9;
	final static int minVal = 1;
	int[][] board;

	/**
	 * This method is the default constructor
	 */
	public Suduko() 
	{
		board = new int[ROWS][COLUMNS];

		for (int i=0; i<ROWS; i++)
			for (int j=0; j<COLUMNS; j++)
				board[i][j] = 0;
	}

	/**
	 * This method is a constructor that sets board
	 * with a set of predetermined numbers loaded 
	 * from a file given by the user
	 * 
	 * @param inputFileName is the file either given
	 *    by the user or defaulted by the programmer
	 */
	public Suduko(String inputFileName) 
	{
		Scanner in = new Scanner(System.in); 
		board = new int[ROWS][COLUMNS];
		String line = in.nextLine();
		int k = 0;
		for (int i=0; i<ROWS; i++)
			for (int j=0; j<COLUMNS; j++)
			{
				if (!Character.isDigit(line.charAt(k)))
				{
					char ch = line.charAt(k);
					board[i][j] = ch;	
				}
				else
					board[i][j] = 0;
				k++;
			}
		in.close();
	}

	/**
	 * This method prints every element of the board
	 * array and places a '|' between every number
	 */
	public void printMySuduko() 
	{
		for (int i=0; i<9; i++)
		{
			System.out.print(" | ");
			for (int j=0; j<9; j++)
				System.out.print(board[i][j] + " | ");
			System.out.println();
		}		
	}

	/**
	 * This method checks to see whether or not a value can be
	 * inserted at a specific place and then inserts it if it can
	 * 
	 * @param r is the row value given by the user
	 * @param c is the column value given by the user
	 * @param val is the new value given by the user
	 * @return returns false if not able to change value
	 *         and true if able to change value
	 */
	public boolean insertVal(int r, int c, int val) 
	{
		if (checkRow(r, c, val) == false)
		{
			System.out.println("Not okay to insert value in this row.");
			return false;
		}
		else if (checkCol(r, c, val) == false)
		{
			System.out.println("Not okay to insert value in this column.");
			return false;
		}
		else if (checkBox(r, c, val) == false)
		{
			System.out.println("Not okay to insert value in this box.");
			return false;
		}
		else
		{
			board[r-1][c-1] = val;
			return true;
		}
	}

	/**
	 * This method removes a value from the board
	 * 
	 * @param r is the row value given by the user
	 * @param c is the column value given by the user
	 * @param val is the new value given by the user
	 */
	public void removeVal(int r, int c, int val) 
	{
		board[r-1][c-1] = 0;
	}

	/**
	 * This method checks to see if the new value is in
	 * the same row as the parameter r
	 * 
	 * @param r is the row value given by the user
	 * @param c is the column value given by the user
	 * @param val is the new value given by the user
	 * @return returns false if the value given is in 
	 *         the same row, returns true otherwise
	 */
	private boolean checkRow(int r, int c, int val) 
	{

		for(int i=0; i<COLUMNS; i++)
		{
			if (val == board[r][i])
				return false;
		}
		return true;
	}

	/**
	 * This method checks to see if the new value is in
	 * the same column as the parameter c
	 * 
	 * @param r is the row value given by the user
	 * @param c is the column value given by the user
	 * @param val is the new value given by the user
	 * @return returns false if the value given is in 
	 *         the same column, returns true otherwise
	 */
	private boolean checkCol(int r, int c, int val) 
	{
		for(int i=0; i<ROWS; i++)
		{
			if (val == board[i][c])
				return false;
		}
		return true;
	}

	/**
	 * This method checks to see if the new value is in
	 * a 3x3 box that already has a number
	 * 
	 * @param r is the row value given by the user
	 * @param c is the column value given by the user
	 * @param val is the new value given by the user
	 * @return returns false if the 3x3 box given already 
	 *      has the number in it, returns true otherwise
	 */
	private boolean checkBox(int r, int c, int val)
	{
		for (int i=0; i<ROWS; i+=3)
			for (int j=0; j<COLUMNS; j+=3)
				if (val == board[i][j])
					return false;
		return true;
	}

	/**
	 * This method allows the user to save a game
	 * 
	 * @throws FileNotFoundException closes the scanners
	 *    in the case the game was not able to be saved
	 *    in a file
	 */
	public void saveGame() throws FileNotFoundException 
	{
		Scanner output = new Scanner(System.in);
		String outputFileName = null;
		PrintWriter outputFile = new PrintWriter(outputFileName);
		try
		{
			System.out.print("Output file: ");
			String outputFileName1 = output.next();
			outputFileName = outputFileName1; 
		}
		finally
		{
			System.out.println("Sorry, but the game was not saved.");
			outputFile.close();
			output.close();
		} 
	}
}

