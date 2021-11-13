package Software;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.JFrame;

import People.Admin;
import People.Customer;
import People.Employee;
import People.Person;

public class GroceryStoreProgramGUI extends JFrame{
	
	private Login login;
	public static Admin currentAdminUser;
	public static Employee currentEmployeeUser;
	public static Customer currentCustomerUser;
	
	//constructs GUI Frame and loads login page
	public GroceryStoreProgramGUI() {
		super("Grocery Store Program");
		
		//setting size of window
		setSize(1000,1000);
		
		//adding close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.runLogin();
		
	}
	
	//loads login
	public void runLogin() {
		//clears last panel
		getContentPane().removeAll();
		
		login = new Login(this);
		add(login);
		setVisible(true);
		
	}
	
	//loads make acount page
	public void runMakeAcount() {
		//clears last panel
		getContentPane().removeAll();
		
		MakeAcount makeacount;
		makeacount = new MakeAcount(this);
		add(makeacount);
		setVisible(true);
	}
	
	//loads admin page
	public void runAdmin(Admin aAdmin) {
		//clears last panel
		getContentPane().removeAll();
		
		AdminPanel adminP;
		adminP = new AdminPanel(this);
		add(adminP);
		setVisible(true);
	}
	
	//loads employee page
	public void runEmployeePanel() {
		//clears last panel
		getContentPane().removeAll();
		
		EmployeePanel ePanel;
		ePanel = new EmployeePanel(this);
		add(ePanel);
		setVisible(true);

		
		
	}
	
	//loads checkout page
	public void runCheckout() {
		//clears last panel
		getContentPane().removeAll();
		
		CheckoutPanel cPanel;
		cPanel = new CheckoutPanel(this);
		add(cPanel);
		setVisible(true);
		
	}
	
	

}
