import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;


/**
 * @author Ryan Henschel 
 * Date: 1/29/2015, Modified 2/3/2015
 * Course: CS 220
 * Assignment: Lab 1
 */

public class Face extends JComponent {
	Color eyeColor;
	Color mouthColor;
	Color greetingColor;
	String mouth;

	/**
	 * The instance variables are to be initialized to default values here
	 */
	public Face() {
		eyeColor = Color.BLUE;
		mouthColor = Color.RED;
		greetingColor = Color.MAGENTA;
		mouth = "bored";

	}

	/**
	 * The instance variables are to be initialized using parameter values here
	 * 
	 * @param mouth2 gets user input for the type of mouth
	 * @param eyeColor2 gets user input for the eye color
	 * @param mouthColor2 gets user input for the mouth color
	 * @param greetingColor2 gets user input for the greeting color
	 */
	public Face(String mouth2, Color eyeColor2, Color mouthColor2, Color greetingColor2) {
		eyeColor = eyeColor2;
		mouthColor = mouthColor2;
		greetingColor = greetingColor2;
		mouth = mouth2;
	}

	/**
	 * Paint the face using the graphics object
	 * 
	 * @param g - the Graphics object used to paint the face
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;

		//head
		Ellipse2D.Double head = new Ellipse2D.Double(5, 10, 100, 150);
		g2.draw(head);

		//eyes
		g2.setColor(eyeColor);
		Ellipse2D.Double eye = new Ellipse2D.Double(30, 25, 15, 15);
		g2.fill(eye);
		Ellipse2D.Double eye2 = new Ellipse2D.Double(65, 25, 15, 15);
		g2.fill(eye2);

		//mouth
		g2.setColor(mouthColor);
		if(mouth.equalsIgnoreCase("surprised")){
			Ellipse2D.Double mouth2 = new Ellipse2D.Double(40, 90, 30, 50);
			g2.draw(mouth2);
			g2.setColor(greetingColor);
			g2.drawString("Surprised Face", 20, 185);
		} 
		else {
			Line2D.Double mouth = new Line2D.Double(30, 110, 80, 110);
			g2.draw(mouth);
			g2.setColor(greetingColor);
			g2.drawString("Bored Face", 20, 175);
		}




	}

	/**
	 * @return - a String representation of this Face object
	 */
	@Override
	public String toString() {
		return "Eye color is " + eyeColor + "." + "Mouth color is " + mouthColor + "." + "Greeting color is " + greetingColor + ".";
	}
}