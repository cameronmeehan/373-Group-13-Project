package Software;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.JFrame;

public class GroceryStoreProgramGUI extends JFrame{
	
	private Login login;
	
	public GroceryStoreProgramGUI() {
		super("Grocery Store Program");
		
		//setting size of window
		setSize(1000,1000);
		
		//adding close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.runLogin();
		
	}
	
	public void runLogin() {
		//clears last panel
		getContentPane().removeAll();
		
		login = new Login(this);
		add(login);
		setVisible(true);
		
	}
	
	public void runMakeAcount() {
		//clears last panel
		getContentPane().removeAll();
		
		MakeAcount makeacount;
		makeacount = new MakeAcount(this);
		add(makeacount);
		
		setVisible(true);
	}
	

}
