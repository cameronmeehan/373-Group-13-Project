package Software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import People.Employee;
import People.Person;

public class EmployeePanel extends JPanel implements ActionListener{
	// general program stuff
	private GroceryStoreProgramGUI top;
	private JButton exitButton; //Button to exit
	
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
		
		//general page stuff creation
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		
		
		
		//general page stuff allignment
		exitButton.setBounds(850,850,100,100);
		
		
		//adding stuff to page
		add(exitButton);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitButton) {
			top.runLogin();
		}
		
		
	}
}