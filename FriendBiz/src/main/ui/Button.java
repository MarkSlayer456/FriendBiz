package main.ui;

import java.awt.Rectangle;
import java.util.ArrayList;

import main.framework.Frame;
import main.ui.Menu.MenuName;

public class Button {
	
	protected static ArrayList<Button> loginButtons;
	protected static ArrayList<Button> mainButtons;
	protected static ArrayList<Button> calendarButtons;
	protected static ArrayList<Button> friendsListButtons;
	protected static ArrayList<Button> groupsButtons;
	protected static ArrayList<Button> quitButtons = null; // this will end the program
	//TODO remove this line ^
	
	
	private String title;
	private boolean active; //TODO might not be needed
	private Rectangle rect;
	private MenuName currLoc;
	private MenuName des;
	
	public Button(String t, boolean a, Rectangle r, MenuName cl, MenuName d) {
		this.setTitle(t);
		this.setActive(a);
		this.setRect(r);
		this.setCurrLoc(cl);
		this.setDes(d);
	}
	
	public static void setup() { // All buttons will be created here
		Rectangle rectS = new Rectangle(50, 50, 150, 50); // Default rectangle for testing
		///// Login /////
		Rectangle loginR = new Rectangle((Frame.frame.getFrame().getWidth() / 2) - 100 - 75, (Frame.frame.getFrame().getHeight() / 2) + 175 - 25, 150, 50);
		Rectangle cancelR = new Rectangle((Frame.frame.getFrame().getWidth() / 2) + 75, (Frame.frame.getFrame().getHeight() / 2) + 175 - 25, 150, 50);
		//The +75 and +25 at the end of each argument is half the width and or height
		Button login = new Button("login", false, loginR, MenuName.LOGIN, MenuName.MAIN); // Login button
		Button cancel = new Button("cancel", false, cancelR, MenuName.LOGIN, MenuName.QUIT); // Cancel button (closes program)
		loginButtons = new ArrayList<Button>();
		loginButtons.add(login);
		loginButtons.add(cancel);
		
	}

	
	// Methods that say what they do
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public MenuName getCurrLoc() {
		return currLoc;
	}

	public void setCurrLoc(MenuName currLoc) {
		this.currLoc = currLoc;
	}

	public MenuName getDes() {
		return des;
	}

	public void setDes(MenuName des) {
		this.des = des;
	}

}
