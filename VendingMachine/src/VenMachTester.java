/**
 * @author Ryan Henschel
 * CS 220
 * LAB 3 Vending Machine
 * 3/23/15
 */

import java.util.Scanner;

public class VenMachTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean vend = true;

		VendingMachine vending = new VendingMachine(1);
		VenMachBaseball vending1 = new VenMachBaseball();
		VenMachBaseball vending2 = new VenMachBaseball();
		VenMachBaseball vending3 = new VenMachBaseball();

		while (vend)
		{
			System.out.println("Which vending machine are you at? 1, 2, or 3? ");
			int v = in.nextInt();
			if (v == 1) {
				System.out.print("Row 1: Little League baseballs. Row 2,3: High School baseballs. "
						+ "Row 4,5: College baseballs.");
				System.out.println(" Which row do you want? ");
				int r = in.nextInt();
				System.out.print("Which column do you want? ");
				int c = in.nextInt();
				vending1.productCost(r);
				System.out.print("How many dollars are you entering? ");
				int dollars = in.nextInt();
				System.out.print("How many quarters are you entering? ");
				int quarters = in.nextInt();

				if (dollars + quarters <= 0) {
					System.out.println("Please come back when you have money.");
					vend = false;
				}
				else {
					vending1.takeMoney(dollars, quarters);
					vending1.giveChange();
					vending1.giveProduct(r, c);
					vending1.machineProfit();
					VenMachBaseball.totalProfit();
					vending1.expenses();
				}
			}
			else if (v == 2) {
				System.out.print("Row 1: Little League baseballs. Row 2,3: High School baseballs. "
						+ "Row 4,5: College baseballs.");
				System.out.println(" Which row do you want? ");
				int r = in.nextInt();
				System.out.print("Which column do you want? ");
				int c = in.nextInt();
				vending2.productCost(r);
				System.out.print("How many dollars are you entering? ");
				int dollars = in.nextInt();
				System.out.print("How many quarters are you entering? ");
				int quarters = in.nextInt();

				if (dollars + quarters <= 0) {
					System.out.println("Please come back when you have money.");
					vend = false;
				}
				else {
					vending2.takeMoney(dollars, quarters);
					vending2.giveChange();
					vending2.giveProduct(r, c);
					vending2.machineProfit();
					VenMachBaseball.totalProfit();
					vending2.expenses();
				}
			}
			else if (v == 3) {
				System.out.print("Row 1: Little League baseballs. Row 2,3: High School baseballs. "
						+ "Row 4,5: College baseballs.");
				System.out.println(" Which row do you want? ");
				int r = in.nextInt();
				System.out.print("Which column do you want? ");
				int c = in.nextInt();
				vending3.productCost(r);
				System.out.print("How many dollars are you entering? ");
				int dollars = in.nextInt();
				System.out.print("How many quarters are you entering? ");
				int quarters = in.nextInt();

				if (dollars + quarters <= 0) {
					System.out.println("Please come back when you have money.");
					vend = false;
				}
				else {
					vending3.takeMoney(dollars, quarters);
					vending3.giveChange();
					vending3.giveProduct(r, c);
					vending3.machineProfit();
					VenMachBaseball.totalProfit();
					vending3.expenses();
				}
			}
			else {
				System.out.println("That is not a valid vending machine.");
				vend = false;
			}
		}
		in.close();
	}
}
