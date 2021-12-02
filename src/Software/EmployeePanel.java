package Software;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import People.Employee;
import People.Person;
import Tangibles.GroceryStore;
import Tangibles.InventoryItem;

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
	private JScrollPane InventoryScroll;
	
	// employment years
	private JLabel YearBanner;
	private JTextField setYears;
	private JButton changeYears;
	private String years = "0";
	
	// in-person checkout
	private JButton inPersonCheckout;
	
	public EmployeePanel(GroceryStoreProgramGUI aTop) {
		top = aTop;
		setLayout(null);
		
		//general page stuff creation
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		
		welcomeBanner = new JLabel("Welcome " + GroceryStoreProgramGUI.currentEmployeeUser.getName());
		welcomeBanner.setFont(new Font("Calibri", Font.BOLD, 45));
		add(welcomeBanner);
		
		YearBanner = new JLabel("Employed for : " + years + " years");
		YearBanner.setFont(new Font("Calibri", Font.BOLD, 40));
		setYears = new JTextField("Years");
		changeYears = new JButton("Change years");
		add(YearBanner); add(setYears); add(changeYears);
		
		InventoryBanner = new JLabel("List of Inventory:");
		InventoryBanner.setFont(new Font("Calibri", Font.BOLD, 40));
		InventoryScroll = new JScrollPane(ListFromArrayInventory(GroceryStore.InventoryList));
		add(InventoryBanner); add(InventoryScroll);
		
		//general page stuff alignment
		exitButton.setBounds(850,600,100,100);
		welcomeBanner.setBounds(200, 50, 500, 50);
		YearBanner.setBounds(200, 110, 500, 50);
		setYears.setBounds(200, 150, 250, 35);
		changeYears.setBounds(600, 150, 250, 35);
		InventoryBanner.setBounds(200, 200, 350, 40);
		InventoryScroll.setBounds(200, 245, 250, 75);
		
		
		//adding stuff to page
		add(exitButton);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitButton) {
			top.runLogin();
		}
		
		// Needs fixing
		if (e.getSource() == changeYears) {
			years = setYears.getText();
			remove(YearBanner);
			add(YearBanner);
		}
		
		
	}
	
	public JList ListFromArrayInventory(ArrayList<InventoryItem> aList) {
		DefaultListModel temp = new DefaultListModel();
		
		for(int i = 0; i < aList.size(); i++) {
			temp.addElement(aList.get(i).getName());
		}
		
		JList lTemp = new JList(temp);
		return(lTemp);
	}
	
}