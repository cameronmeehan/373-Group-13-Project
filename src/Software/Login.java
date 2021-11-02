package Software;
import Tangibles.GroceryStore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JPanel implements ActionListener{


	//private Login login;
	
	//private JPanel loginPanel;
	private JButton loginButton; //Button to login
	private JButton makeNewAcount; //Button to make new acount
	private JTextField username;
	private JTextField password;
	private JLabel heading;
	private JLabel message;
	
	public Login() {
		setLayout(null);
		heading = new JLabel("Welcome to the Grocery Store Program");
		loginButton = new JButton("Login");
		makeNewAcount = new JButton("Make New Acount");
		username = new JTextField("Username");
		password = new JTextField("Password");
		message = new JLabel();
		
		//heading font adjust
		heading.setFont(new Font("Calibri", Font.BOLD, 40 ));
		message.setFont(new Font("Calibri", Font.BOLD, 25 ));
		
		//setting button and text fields listeners
		loginButton.addActionListener(this);
		makeNewAcount.addActionListener(this);
		
		//setBounds is (x, y, width, height)
		heading.setBounds(150,10,800, 50);
		loginButton.setBounds(400,600,200,100);
		makeNewAcount.setBounds(400,800,200,100);
		username.setBounds(350,400,300,40);
		password.setBounds(350,500,300,40);
		message.setBounds(350, 150, 800, 40);
		
		//add(stuff to panel)
		add(username);
		add(password);
		add(heading);
		add(loginButton);
		add(makeNewAcount);
		add(message);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		boolean loggedin = false;
		
		
		if(e.getSource() == loginButton) {
			
			//checking username and password
			for(int i = 0; i < GroceryStore.CustomerList.size(); i++) {
				if(GroceryStore.CustomerList.get(i).getUsername().equals(username.getText()) &&
						GroceryStore.CustomerList.get(i).getPassword().equals(password.getText()) ) {
						
						JOptionPane.showMessageDialog(null, "Customer logged in");
						loggedin = true;
						
						//bring to next page
					}
			}
			for(int i = 0; i < GroceryStore.EmployeeList.size(); i++) {
				if(GroceryStore.EmployeeList.get(i).getUsername().equals(username.getText()) &&
						GroceryStore.EmployeeList.get(i).getPassword().equals(password.getText()) ) {
						
						JOptionPane.showMessageDialog(null, "Employee logged in");
						loggedin = true;
						
						//bring to next page
					}
				}
			for(int i = 0; i < GroceryStore.AdminList.size(); i++) {
				if(GroceryStore.AdminList.get(i).getUsername().equals(username.getText()) &&
						GroceryStore.AdminList.get(i).getPassword().equals(password.getText()) ) {
						
						JOptionPane.showMessageDialog(null, "Admin logged in");
						loggedin = true;
						

						//bring to next page
					}
				}
			if(loggedin != true) {
				JOptionPane.showMessageDialog(null, "Incorrect Username Or Password");
			}
		}
		
		if(e.getSource() == makeNewAcount) {
			
			JOptionPane.showMessageDialog(null, "going to make acount page... work in progress");
		}
	}
}
