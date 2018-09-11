package main.framework;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame {

	
	private static JFrame javaFrame = new JFrame("FriendBiz"); // The actual frame
	public static Frame frame = new Frame(javaFrame); // Only frame that will be used throughout the program
	private JFrame jf;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//TODO get screen size and adjust frame size to it
	
	
	@SuppressWarnings("static-access") //TODO Can run without this but an error was annoying so it's here
	public Frame(JFrame jFrame) { // Creates the one and only frame this program will use
		jf = jFrame;
		jf.setSize(screenSize.width, screenSize.height); //TODO change this later
		jf.setResizable(false); // This will be changed later
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE); // Closes the window
		//jf.setIconImage(image); // TODO add icon
	}
	
	public Dimension getScreenSize() {
		return screenSize;
	}
	
	public void quitApp() { // Used to close the application at any time
		jf.dispose();
	}
	
	public JFrame getFrame() { // Gets the JFrame no the frame object I created
		return this.jf;
	}
	
	public static Frame getWindow() { // This gets the frame object I created not the JFrame
		return frame;
	}
}
