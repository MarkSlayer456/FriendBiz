package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Timer;

import main.framework.Frame;
import main.framework.Time;
import main.ui.Button;
import main.ui.Menu;

public class Main implements Runnable {

	/**
	 * Main file of the entire program
	 */
	
	public static Main main = new Main(); // This is only used in Frame.java not for use elsewhere
	public static Time time = new Time(); // Creating a time object
	private BufferStrategy buffStr; // Buffer strategy object
	private Graphics g; // Graphics
	private double endingTime;
	private double startingTime;
	Timer logic = new Timer();
	
	public static void main(String[] args) { // Frame becoming visible has to come before starting the main method
		Frame.getWindow().getFrame().setVisible(true); 
		time.start();
		Thread main = new Thread(Main.main);
		main.start();
		// Put all setup methods in here
		// make sure button.setup(); is before menu.setup();
		Button.setup(); 
		Menu.setup();
	}
	
	private boolean running = false; // Is the draw loop running
	
	public Main() {} // DO NOT USE
	
	private void setup() {
		if(!running) { // If the loop isn't running
			running = true;
			draw();
		}
		while(running) { // Continuously run the loop
			
			
			double oneFrameInterval = 16.6666667; // This caps the program at 60fps
			System.out.println("One Frame Interval : " + (endingTime - startingTime));
			if(endingTime - startingTime >= oneFrameInterval) {
				doLogic();
			} else {
				try {
					System.out.println("sleeping for " + (long) (oneFrameInterval - (endingTime - startingTime)));
					Thread.sleep((long) (oneFrameInterval - (endingTime - startingTime)));
					doLogic();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}
	int i = 0;
	public void doLogic() {
		startingTime = time.getTimeInMSeconds(); // Keep this at the start
		//TODO 
		draw(); // Keep this at the end
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
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Frame.getWindow().getFrame().getWidth(), Frame.getWindow().getFrame().getHeight());
			///// draw menus /////
			Menu activeMenu = Menu.getActiveMenu();
			for(int i = 0; i < activeMenu.getButtons().size(); i++) {
				Button button = activeMenu.getButtons().get(i);
				g.setColor(Color.CYAN); //TODO Add a text for the buttons later
				g.drawRect(button.getRect().x, button.getRect().y, button.getRect().width, button.getRect().height);
			}
			
			
			
			
			
			
			//TODO just testing here
			g.drawString(time.getTime(), 700, 50); // Shows the programs current time
			//
			
			
			////////////////////////////////////////////////
			g.dispose();
			buffStr.show();
			endingTime = time.getTimeInMSeconds(); // Keep this at the end
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("An error occured while drawing...");
		}
	}
	
	
	
	
	
	
	@Override
	public void run() { // The program has started
		setup();
		draw();
		doLogic();
		System.out.println("The main class is loading..."); //TODO remove this
	}
}
