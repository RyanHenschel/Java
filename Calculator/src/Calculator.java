
public class Calculator 
	{
		//two operands
		int x=0;
		int y=0;
		
		//add x and y, then return
		public int add()
		{
			return x+y;
		}
		
		//subtract y from x, then return
		public int sub()
		{
			return x-y;
		}
		
		//multiply x and y, then return
		public int mult()
		{
			return x*y;
		}
		
		//divide x by y, then return
		public int div()
		{
			return x/y;
		}
		
		//set x and y
		public void setXnY(int new x, int new y)
		{
			x = new x;
			y = new y;
		}
	}
