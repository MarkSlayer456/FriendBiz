package main;

import javax.swing.JFrame;

public class Frame {

	
	private static JFrame javaFrame = new JFrame("FriendBiz"); // The actual frame
	public static Frame frame = new Frame(javaFrame); // Only frame that will be used throughout the program
	private JFrame jf;
	//TODO get screen size and adjust frame size to it
	
	
	@SuppressWarnings("static-access") //TODO Can run without this but an error was annoying so it's here
	public Frame(JFrame jFrame) { // Creates the one and only frame this program will use
		jf = jFrame;
		jf.setBounds(400, 150, 800, 600); // TODO change this later
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE); // Closes the window
		//jf.setIconImage(image); // TODO add icon
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
	
	public static void main(String[] args) {
		Time time = new Time();
		time.start();
		System.out.println("Showing screen..."); //TODO remove this
		getWindow().jf.setVisible(true); //TODO move to setup method in main
		Thread main = new Thread(Main.main);
		main.start();
		
		
	}
	
}
