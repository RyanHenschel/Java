/**
 * Calculator class does simple math operations of 2 variables
 */
public class Calculator 
{
	//RYAN HENSCHEL
	//HW2
	//January 20, 2015
	//updated 1/21/15

	//two operands
	private int x=0;
	private int y=0;

	/**
	 * initializes variables x and y to 0
	 */
	public Calculator (){
		x=0;
		y=0;
	}
	/**
	 * initializes variables to values other than 0
	 * @param newx sets a new value for x
	 * @param newy sets a new value for y
	 */
	public Calculator(int newx, int newy){
		x = newx;
		y = newy;
	}
	
	/**
	 * adds x and y
	 * @return returns x+y
	 */
	public int add()
	{return x+y;}

	/**
	 * subtracts x and y
	 * @return returns x-y
	 */
	public int sub()
	{return x-y;}

	/**
	 * multiplies x and y
	 * @return returns x*y
	 */
	public int mult()
	{return x*y;}

	/**
	 * divides x/y
	 * @return returns x/y
	 */
	public int div()
	{return x/y;}

	/**
	 * sets a new value for x and y
	 * @param newx sets a new value for x
	 * @param newy sets a new value for y
	 */
	public void setXnY(int newx, int newy)
	{x = newx;
	 y = newy;}

	/**
	 * gets x
	 * @return returns x value
	 */
	public int getX()
	{return x;}

	/**
	 * gets y
	 * @return returns y value
	 */
	public int getY()
	{return y;}
}

