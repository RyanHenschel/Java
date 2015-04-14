public class CalcTester {
	//RYAN HENSCHEL
	//HW2
	//January 20, 2015
	//updated 1/21/15
	public static void main(String[] args) {


		Calculator newCalc = new Calculator();
		//Setting new values for x and y
		newCalc.setXnY(351,13);

		Calculator newCalc2 = new Calculator();
		newCalc2.setXnY(12, 3);

		//getting the x-value and y-value
		System.out.println("X-value: " + newCalc.getX());
		System.out.println("Y-value: " + newCalc.getY());

		//calling the addition class; printing the actual sum;
		//printing the expected sum
		int sum = newCalc.add();
		System.out.println("Actual Sum: " + sum);
		System.out.println("Expected Sum: 364");

		//calling the subtraction class; printing the actual difference;
		//printing the expected difference
		int difference = newCalc.sub();
		System.out.println("Actual Difference: " + difference);
		System.out.println("Expected Difference: 338");

		//calling the multiplication class; printing the actual product;
		//printing the expected product
		int product = newCalc.mult();
		System.out.println("Actual Product: " + product);
		System.out.println("Expected Product: 4563");

		//catching if the denominator is 0
		if (newCalc.getY() == 0) 
		{System.out.println("Cannot divide by 0.");}
		//calling the division class; printing the actual quotient (if it's an integer);
		//printing the expected quotient
		else 
		{	int quotient = newCalc.div();
		System.out.println("Actual Quotient: " + quotient);
		System.out.println("Expected Quotient: 27");
		}
	}
}