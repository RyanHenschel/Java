/**
 * @author Ryan Henschel
 * CS 220
 * LAB 3 Vending Machine
 * 3/23/15
 */

public class VenMachBaseball extends VendingMachine {
	private final double DOLLARS = 1.00;
	private final double QUARTERS = 0.25;
	private double dollarValue;
	private double quarterValue;
	private double moneyGiven;
	private double totalMoney;
	private static double totCompMon = 0;
	private double moneyOwed;
	private static double moneyOwed2 = 0;
	private static double expenses = 0;
	private int count = 0;

	/**
	 * This method tells the customer how much each product is
	 * @param r the row of the vending machine
	 */
	public void productCost(int r) {
		if (r-1 == 0) {
			moneyOwed = 1.00;
			moneyOwed2 = 1.00;
			System.out.println("This product costs $" + moneyOwed);
		}
		else if (r-1 == 1 || r-1 == 2) {
			moneyOwed = 1.25;
			moneyOwed2 = 1.25;
			System.out.println("This product costs $" + moneyOwed);
		}
		else {
			moneyOwed = 1.50;
			moneyOwed2 = 1.50;
			System.out.println("This product costs $" + moneyOwed);
		}
	}

	/**
	 * This method takes the money from the customer
	 * @param dollars the number of dollars given
	 * @param quarters the number of quarters given
	 */
	public void takeMoney(int dollars, int quarters) {
		dollarValue = dollars*DOLLARS;
		quarterValue = quarters*QUARTERS;
		moneyGiven = dollarValue + quarterValue;	
	}

	/**
	 * This method gives the customer change
	 */
	public void giveChange() {
		if (moneyGiven < moneyOwed)
			System.out.println("Not enough money.");
		else {
			double change = moneyGiven - moneyOwed;
			System.out.println("Your change is $" + change);		
		}
	}

	/**
	 * This method calculates the profit for the specified machine
	 */
	public void machineProfit() {
		totalMoney = totalMoney + moneyOwed;
		System.out.println("The total money for this machine is $" + totalMoney);
	}

	/**
	 * This static method calculates the total company profit
	 */
	public static void totalProfit() {
		totCompMon = totCompMon + moneyOwed2;
		System.out.println("The total money for the company is $" + totCompMon);
	}

	/**
	 * This method calculates the total expenses
	 */
	public static void expenses() {
		expenses = expenses + .5;
		System.out.println("The total number of expenses is $" + expenses);
		
	}

	/**
	 * This method takes an inventory of a certain row and column of the vending machine
	 * @param r row of the vending machine
	 * @param c column of the vending machine
	 */
	public void inventory(int r, int c) {
		int[] slot = machine[r-1][c-1];
		for (int i = 0; i < slot.length; i++)
			if (slot[i] == 1)
				count++;
		System.out.println("There are " + count + "baseballs in this space.");
	}

	/**
	 * @return a string representation of this vending machine object
	 */
	public String toString() {
		return "The dollar amount is " + DOLLARS + ". " + "The quarter amount is " + QUARTERS + ". " + "The dollar value is " + dollarValue + ". "
				+ "The quarter value is " + quarterValue + ". " + "The money paid is " + moneyGiven + ". " + "The total machine money earned is " + totalMoney + ". "
				+ "The total company money earned is " + totCompMon + ". " + "The cost of the product is " + moneyOwed + ". " + "The money to be added to the total company money is " + moneyOwed2 + ". "
				+ "The total expenses are " + expenses + ". " + "The inventory count is " + count + ". "; 
	}
}

