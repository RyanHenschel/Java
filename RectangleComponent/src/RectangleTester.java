import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class RectangleTester {
	public static void main(String[] args)
	{		 
			// Construct a rectangle and draw it
			Rectangle box = new Rectangle(5, 10, 20, 30);
			g2.draw(box);
			// Move rectangle 15 units to the right and 25 units down
			box.translate(15, 25);

			// Draw moved rectangle
			g2.draw(box);
		}
	}
}