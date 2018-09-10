package main;

import javax.swing.JFrame;

public class Frame {

	
	private static JFrame javaFrame = new JFrame("FriendBiz"); // The actual frame
	public static Frame frame = new Frame(javaFrame); // Only frame that will be used throughout the program
	private JFrame jf;
	
	public Frame(JFrame jFrame) { // Creates the one and only frame this program will use
		jf = jFrame;
		jf.setBounds(400, 150, 800, 600); // TODO change this later
		jf.setDefaultCloseOperation(1); // Closes the window
		//jf.setIconImage(image); // TODO add icon
		
	}
	
	public JFrame getFrame() {
		return this.jf;
	}
	
	public static Frame getWindow() { // I like to call them windows not frames!
		return frame;
	}
	
	public static void main(String[] args) {
		System.out.println("Showing screen...");
		getWindow().jf.setVisible(true);
		
	}
	
}
