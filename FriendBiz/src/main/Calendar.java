package main;

import java.util.ArrayList;

import main.manage.Event;

public class Calendar {
	
	
	
	private ArrayList<Event> events = null;
	
	public Calendar(ArrayList<Event> e) { // Each person will have a calendar
		this.events = e;
	}
	
	public ArrayList<Event> getEvents() {
		return this.events;
	}

}
