package main;

import javax.swing.JFrame;

public class Frame {

	
	private static JFrame jFrame = new JFrame("FriendBiz"); // The actual frame
	public static Frame frame = new Frame(jFrame); // Only frame that will be used throughout the program
	
	
	public Frame(JFrame jf) { // Creates the one and only frame this program will use
		jFrame.setBounds(400, 150, 800, 600); // TODO change this later
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(1); // Closes the window
		//jFrame.setIconImage(image); // TODO add icon
		
	}
	
	public static Frame getWindow() { // I like to call them windows not frames!
		return frame;
	}
	
	public static void main(String[] args) {
		return;
	}
	
}
