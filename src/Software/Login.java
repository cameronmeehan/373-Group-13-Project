package Software;
import Tangibles.GroceryStore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JPanel implements ActionListener{

	//private JPanel loginPanel;
	private JButton loginButton; //Button to login
	private JButton makeNewAcount; //Button to make new acount
	private JTextField username;
	private JTextField password;
	private JLabel heading;
	private GroceryStoreProgramGUI top;
	
	public Login(GroceryStoreProgramGUI aTop) {
		top = aTop;
		setLayout(null);
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
		loginButton.setBounds(400,600,200,100);
		makeNewAcount.setBounds(400,800,200,100);
		username.setBounds(350,400,300,40);
		password.setBounds(350,500,300,40);
		
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
						
						JOptionPane.showMessageDialog(null, "test.. Customer logged in");
						loggedin = true;
						
						//top.runCustomeer;
					}
			}
			for(int i = 0; i < GroceryStore.EmployeeList.size(); i++) {
				if(GroceryStore.EmployeeList.get(i).getUsername().equals(username.getText()) &&
						GroceryStore.EmployeeList.get(i).getPassword().equals(password.getText()) ) {
						
						JOptionPane.showMessageDialog(null, "test.. Employee logged in");
						loggedin = true;
						
						//top.runEmployee;
					}
				}
			for(int i = 0; i < GroceryStore.AdminList.size(); i++) {
				if(GroceryStore.AdminList.get(i).getUsername().equals(username.getText()) &&
						GroceryStore.AdminList.get(i).getPassword().equals(password.getText()) ) {
						
						JOptionPane.showMessageDialog(null, "test.. Admin logged in");
						loggedin = true;
						
						//top.runAdmin
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
