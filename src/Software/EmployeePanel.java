package Software;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import People.Employee;
import People.Person;

public class EmployeePanel extends JPanel implements ActionListener{
	// general program stuff
	private GroceryStoreProgramGUI top;
	private JButton exitButton; //Button to exit
	private JLabel welcomeBanner;
	
	// inventory stuff
	private JButton stockFunction;
	private JLabel InventoryBanner;
	private JTextField iIncreaseStock;
	private JTextField iRemoveStock;
	private JButton stockIncrease;
	private JButton stockRemove;
	
	// employment years
	private JLabel YearBanner;
	private JTextField setYears;
	private JButton changeYears;
	
	// in-person checkout
	private JButton inPersonCheckout;
	
	public EmployeePanel(GroceryStoreProgramGUI aTop) {
		top = aTop;
		setLayout(null);
		setPreferredSize(new Dimension(900,700));
		//general page stuff creation
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		
		welcomeBanner = new JLabel("Welcome " + GroceryStoreProgramGUI.currentEmployeeUser.getName());
		welcomeBanner.setFont(new Font("Calibri", Font.BOLD, 40));
		add(welcomeBanner);
		
		//general page stuff alignment
		exitButton.setBounds(850,600,100,100);
		welcomeBanner.setBounds(200, 50, 500, 50);
		
		
		//adding stuff to page
		add(exitButton);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitButton) {
			top.runLogin();
		}
		
		
	}
}