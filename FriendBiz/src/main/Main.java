package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Main implements Runnable {

	/**
	 * Main file of the entire program
	 */
	
	public static Main main = new Main(); // This is only used in Frame.java not for use elsewhere
	private BufferStrategy buffStr; // Buffer strategy object
	private Graphics g; // Graphics
	
	
	
	public Main() {} // DO NOT USE
	
	private void setup() {
		for(int i = 0; i < 100; i++) { //TODO this is just temporary to test drawing
		draw();
		}
	}
	
	private void draw() {
		try { // Try to create a buffer strategy if needed
			buffStr = Frame.getWindow().getFrame().getBufferStrategy();
			if(buffStr == null) {
				Frame.getWindow().getFrame().createBufferStrategy(3);
				return;
			}
			g = buffStr.getDrawGraphics();
			////////////////////////////////////////////
			g.clearRect(0, 0, Frame.getWindow().getFrame().getWidth(), Frame.getWindow().getFrame().getHeight()); // Clears the screen for each new frame
			
			//TODO just testing here
			g.setColor(Color.RED);
			g.fillRect(100, 0, 100, 100);
			//
			
			
			
			////////////////////////////////////////////////
			g.dispose();
			buffStr.show();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("An error occured while drawing...");
		}
	}
	
	
	
	
	
	
	@Override
	public void run() { // The program has started
		setup();
		System.out.println("The main class is loading..."); //TODO remove this
	}
}
