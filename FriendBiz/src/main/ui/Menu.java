package main.ui;

import java.util.ArrayList;

public class Menu {
	
	
	public static Menu login;
	public static Menu main;
	public static Menu calendar;
	public static Menu friendsList;
	public static Menu groups;
	public static Menu quit; // Not need this ends the program
	
	//TODO maybe make this a different file just for sake of organization
	public enum MenuName { // List of all current menu names
		LOGIN, // The screen you will always start on
		MAIN, // The main screen where you can choose where you want to go calendar, friends, or groups
		CALENDAR, // Shows all of you and your friends events
		FRIENDSLIST, // Shows all you current friends, as well as lets you search for them
		GROUPS, // Shows all the groups you are currently apart of as well as lets you create one
		QUIT // If this menu is entered the program will end
	}
	private MenuName name; // Defines what menu this menu object will be
	private ArrayList<Button> buttons; // Array of all buttons that are on this menu
	private boolean active;
	/*
	 * Creates a menu
	 * Typically will be created in button.java
	 */
	
	public Menu(MenuName n, ArrayList<Button> b, boolean a) { 
		this.setName(n);
		this.setButtons(b);
		this.setActive(a);
	}
	
	public static void setup() { // Make sure this creates all the menus
		login = new Menu(MenuName.LOGIN, Button.loginButtons, true); // This is the starting screen
		main = new Menu(MenuName.MAIN, Button.mainButtons, false);
		calendar = new Menu(MenuName.CALENDAR, Button.calendarButtons, false);
		friendsList = new Menu(MenuName.FRIENDSLIST, Button.friendsListButtons, false);
		groups = new Menu(MenuName.GROUPS, Button.groupsButtons, false);
		quit = new Menu(MenuName.QUIT, null, false); // this will end the program no need for a button array
	}
	
	public static Menu getActiveMenu() {
		if(login.isActive()) {
			return login;
		} else if(main.isActive()) {
			return main;
		} else if(calendar.isActive()) {
			return calendar;
		} else if(friendsList.isActive()) {
			return friendsList;
		} else if(groups.isActive()) {
			return groups;
		} else if(quit.isActive()) {
			return quit;
		}
		return login;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<Button> buttons) {
		this.buttons = buttons;
	}

	public MenuName getName() {
		return name;
	}

	public void setName(MenuName name) {
		this.name = name;
	}
	
	
	
	

}
