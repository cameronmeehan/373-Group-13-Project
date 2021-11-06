package Software;
import Tangibles.GroceryStore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import People.Customer;


public class MakeAcount extends JPanel implements ActionListener {
	
	private JButton makeAcount; //Button to finish making acount
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField phoneNumber;
	private JTextField creditNum;
	private JLabel heading;
	private JTextField adress;
	private GroceryStoreProgramGUI top;
	private JButton exit;
	
	public MakeAcount(GroceryStoreProgramGUI aTop) {
		top = aTop;
		setLayout(null);
		heading = new JLabel("Please enter your information.");
		makeAcount = new JButton("Make Acount");
		username = new JTextField("Username");
		password = new JTextField("Password");
		creditNum = new JTextField("Credit Card Number");
		name = new JTextField("Name");
		phoneNumber = new JTextField("Phone Number");
		adress = new JTextField("Adress");
		exit = new JButton("Exit");
		
		//heading font adjust
		heading.setFont(new Font("Calibri", Font.BOLD, 20 ));
		
		//setting button and text fields listeners
		makeAcount.addActionListener(this);
		exit.addActionListener(this);
		
		//setBounds is (x, y, width, height)
		heading.setBounds(350,10,800, 50);
		makeAcount.setBounds(400,800,200,100);
		name.setBounds(350,400,300,40);
		username.setBounds(350,450,300,40);
		password.setBounds(350,500,300,40);
		phoneNumber.setBounds(350, 550, 300, 40);
		adress.setBounds(350, 600,300, 40);
		creditNum.setBounds(350, 650, 300, 40);
		exit.setBounds(850,850,100,100);
		
		//add(stuff to panel)
		add(username);
		add(password);
		add(heading);
		add(name);
		add(adress);
		add(makeAcount);
		add(phoneNumber);
		add(creditNum);
		add(exit);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == makeAcount) {
			Customer C = new Customer();
			C.setUsername(username.getText());
			C.setAdress(adress.getText());
			C.setCreditCardNumber(Long.parseLong(creditNum.getText()));
			C.setPassword(password.getText());
			C.setPhoneNumber(Long.parseLong(phoneNumber.getText()));
			
			top.runLogin();
		}
		if(e.getSource() == exit) {
			top.runLogin();
		}
	}

	
	
}
