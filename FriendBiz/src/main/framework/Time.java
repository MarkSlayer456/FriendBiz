package main;

import java.util.Timer;
import java.util.TimerTask;

public class Time extends TimerTask {
	
	public static Timer t = new Timer();
	private int timeInSeconds = 0;
	
	public Time() { }
	
	public void start() {
		t.scheduleAtFixedRate(this, 0, 1000); // runs this every 1 second to keep internal time
	}
	
	@Override
	public void run() {
		timeInSeconds++;
		System.out.println(timeInSeconds); //TODO remove this
	}
	

}
