package main.framework;

import java.util.Timer;
import java.util.TimerTask;

public class Time extends TimerTask {
	
	public static Timer t = new Timer();
	private int timeInMSeconds = 0;
	private int timeInSeconds = 0;
	private int timeInMinutes = 0;
	private int timeInHours = 0;
	
	public Time() { }
	
	public void start() {
		t.scheduleAtFixedRate(this, 0, 1); // runs this every 1 millisecond to keep internal time
	}
	
	@Override
	public void run() {
		timeInMSeconds++;
		if(timeInMSeconds % 1000 == 0) { 
			timeInSeconds++;
			if(timeInSeconds % 60 == 0) {
				timeInMinutes++;
				if(timeInMinutes % 60 == 0) {
					timeInHours++;
				}
			}
		}
	}
	
	public String getTime() {
		String timeH = timeInHours + "";
		String timeM = timeInMinutes + "";
		String timeS = timeInSeconds + "";
		if(timeInHours < 10) {
			timeH = "0" + timeInHours;
		}
		if(timeInMinutes < 10) {
			timeM = "0" + timeInMinutes;
		}
		if(timeInSeconds < 10) {
			timeS = "0" + timeInSeconds;
		}
		return timeH + ":" + timeM + ":" + timeS;
	}
	
	public int getTimeInMSeconds() {
		return timeInMSeconds + timeInSeconds * 1000 + timeInMinutes * 60000 + timeInHours * 3600000;
	}
	

}
