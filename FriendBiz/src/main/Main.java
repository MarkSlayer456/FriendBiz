package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import main.framework.Frame;
import main.framework.Time;

public class Main extends TimerTask implements Runnable {

	/**
	 * Main file of the entire program
	 */
	
	public static Main main = new Main(); // This is only used in Frame.java not for use elsewhere
	public static Time time = new Time(); // Creating a time object
	private BufferStrategy buffStr; // Buffer strategy object
	private Graphics g; // Graphics
	Timer logic = new Timer();
	
	public static void main(String[] args) { // Frame becoming visible has to come before starting the main method
		Frame.getWindow().getFrame().setVisible(true); 
		time.start();
		Thread main = new Thread(Main.main);
		main.start();
		System.out.println("Showing screen..."); //TODO remove this
		
	}
	
	private boolean running = false; // Is the draw loop running
	
	public Main() {} // DO NOT USE
	
	private void setup() {
		if(!running) { // If the loop isn't running
			running = true;
			logic.schedule(this, 0, 1000/60); // once every 60th of a second
			return;
		}
		while(running) { // Continuously run the loop
			draw(); // Want this to run as often as possible but maybe cap it at like 144fps	
		}
	}
	
	public void doLogic() {
		//TODO 
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
			// This isn't appearing everytime
			g.setColor(Color.RED);
			g.fillRect(100, 0, 100, 100);
			g.drawString(time.getTime(), 700, 50); // Shows the programs current time
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
		doLogic();
		System.out.println("The main class is loading..."); //TODO remove this
	}
}
