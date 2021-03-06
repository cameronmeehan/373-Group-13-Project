package Software;
import Tangibles.GroceryStore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JPanel implements ActionListener{

	private JButton loginButton; //Button to login
	private JButton makeNewAcount; //Button to make new acount
	private JTextField username;
	private JTextField password;
	private JLabel heading;
	private GroceryStoreProgramGUI top;

	public Login(GroceryStoreProgramGUI aTop) {
		
		//needed to make page scrollable
		setPreferredSize(new Dimension(900,700));
		setLayout(null);
		
		
		
		
		top = aTop;
		heading = new JLabel("Welcome to the Grocery Store Program");
		loginButton = new JButton("Login");
		makeNewAcount = new JButton("Make New Customer Acount");
		username = new JTextField("Username");
		password = new JTextField("Password");
		
		//heading font adjust
		heading.setFont(new Font("Calibri", Font.BOLD, 40 ));
		
		//setting button and text fields listeners
		loginButton.addActionListener(this);
		makeNewAcount.addActionListener(this);
		
		//setBounds is (x, y, width, height)
		heading.setBounds(150,10,800, 50);
		loginButton.setBounds(400,300,200,40);
		makeNewAcount.setBounds(400,340,200,40);
		username.setBounds(350,100,300,40);
		password.setBounds(350,200,300,40);
		
		//add(stuff to panel)
		add(username);
		add(password);
		add(heading);
		add(loginButton);
		add(makeNewAcount);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		boolean loggedin = false;
		
		
		if(e.getSource() == loginButton) {
			
			//checking username and password
			for(int i = 0; i < GroceryStore.CustomerList.size(); i++) {
				if(GroceryStore.CustomerList.get(i).getUsername().equals(username.getText()) &&
						GroceryStore.CustomerList.get(i).getPassword().equals(password.getText()) ) {
						
						loggedin = true;
						GroceryStoreProgramGUI.currentCustomerUser = GroceryStore.CustomerList.get(i);
						top.runCheckout();
					}
			}
			for(int i = 0; i < GroceryStore.EmployeeList.size(); i++) {
				if(GroceryStore.EmployeeList.get(i).getUsername().equals(username.getText()) &&
						GroceryStore.EmployeeList.get(i).getPassword().equals(password.getText()) ) {
						
						loggedin = true;
						GroceryStoreProgramGUI.currentEmployeeUser = GroceryStore.EmployeeList.get(i);
						top.runEmployeePanel();
					}
				}
			for(int i = 0; i < GroceryStore.AdminList.size(); i++) {
				if(GroceryStore.AdminList.get(i).getUsername().equals(username.getText()) &&
						GroceryStore.AdminList.get(i).getPassword().equals(password.getText()) ) {
						
						loggedin = true;
						GroceryStoreProgramGUI.currentAdminUser = GroceryStore.AdminList.get(i);
						top.runAdmin(GroceryStore.AdminList.get(i));
					}
				}
			if(loggedin != true) {
				JOptionPane.showMessageDialog(null, "Incorrect Username Or Password");

			}
		}
		
		if(e.getSource() == makeNewAcount) {
			
			top.runMakeAcount();
		}
		return;
	}
}
