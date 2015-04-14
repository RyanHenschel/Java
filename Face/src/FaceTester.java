import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import java.util.Scanner;


/**
 * @author Ryan Henschel
 * Date: 2/3/2015
 * Course: CS 220
 * Assignment: Lab 1
 */

public class FaceTester {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Please enter \"surprised\" for a surprised face and enter \"bored\" for a bored face: ");
		String mouth = in.next();
		System.out.println("Please enter a \"0\" for blue eyes and a \"1\" for cyan eyes: ");
		Color eyeColor;
		if (in.nextInt()==0){
			eyeColor = Color.BLUE; 
		}
		else{
			eyeColor = Color.CYAN;
		}
		System.out.println("Please enter a \"0\" for a red mouth and a \"1\" for a pink mouth: ");
		Color mouthColor;
		if (in.nextInt()==0){
			mouthColor = Color.RED;
		}
		else{
			mouthColor = Color.PINK;
		}
		System.out.println("Please enter a \"0\" for a magenta greeting color and a \"1\" for a green greeting color: ");
		Color greetingColor;
		if (in.nextInt()==0){
			greetingColor = Color.MAGENTA;
		}
		else{
			greetingColor = Color.GREEN;
		}

		in.close();

		int numberOfFaces = 3; // The number of faces you wish to display
		int faceSize = 400; // The width and height of each face in pixels

		//Get info from the user about face1
		//Get info from the user about face2

		// Create new face objects here
		Face face1 = new Face();
		Face face2 = new Face(mouth, eyeColor, mouthColor, greetingColor);


		// Create and set up the window
		JFrame window = new JFrame("Face tester");
		setUpFrame(window, numberOfFaces, faceSize);

		// Add your faces to the window
		window.add(face1);
		window.add(face2);

	}

	/**
	 * Sets up our window so that we may begin adding Face objects.
	 * 
	 * @param frame - the frame for the graphics components to be displayed on
	 * @param numberOfFaces - the number of faces that will be added to the frame
	 * @param faceSize - the size of each face being created
	 */
	private static void setUpFrame(JFrame frame, int numberOfFaces, int faceSize) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(faceSize * numberOfFaces, faceSize);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(1, numberOfFaces));
	}
}