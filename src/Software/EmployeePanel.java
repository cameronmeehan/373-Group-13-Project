package Software;
import java.awt.Dimension;

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
	private JLabel stockFunction;
	private JLabel InventoryBanner;
	//private JTextField iIncreaseStock;
	//private JTextField iRemoveStock;
	//private JButton stockIncrease;
	//private JButton stockRemove;
	private JScrollPane InventoryScroll;
	private JLabel checkQuantity;
	private JTextField checkInventory;
	private JButton quantityButton;
	private JButton changeStock;
	private JLabel quantity;
	
	// Stock pop up
	private JDialog stockPopUp;
	
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
		welcomeBanner.setFont(new Font("Calibri", Font.BOLD, 45));
		add(welcomeBanner);
		
		InventoryBanner = new JLabel("List of Inventory:");
		InventoryBanner.setFont(new Font("Calibri", Font.BOLD, 40));
		InventoryScroll = new JScrollPane(ListFromArrayInventory(GroceryStore.InventoryList));
		stockFunction = new JLabel("Stock Inventory");
		stockFunction.setFont(new Font("Calibri", Font.BOLD, 40));
		checkQuantity = new JLabel("Please enter an invetory item to check or change stock:");
		checkInventory = new JTextField("Inventory");
		quantityButton = new JButton("Check Stock");
		changeStock = new JButton("Change Stock");
		quantityButton.addActionListener(this);
		changeStock.addActionListener(this);
		quantity = new JLabel();
		
		add(InventoryBanner); add(InventoryScroll); add(stockFunction);
		add(checkQuantity); add(checkInventory); add(quantityButton); add(changeStock); 
		add(quantity);

		//general page stuff alignment
		exitButton.setBounds(850,600,100,100);
		welcomeBanner.setBounds(200, 50, 500, 50);
		InventoryBanner.setBounds(200, 200, 350, 40);
		InventoryScroll.setBounds(200, 245, 250, 75);
		stockFunction.setBounds(200, 350, 350, 50);
		checkQuantity.setBounds(200, 405, 300, 50);
		checkInventory.setBounds(200, 460, 250, 50);
		quantityButton.setBounds(455, 460, 200, 50);
		changeStock.setBounds(660, 460, 200, 50);
		quantity.setBounds(200, 515, 250, 50);
		
		
		//adding stuff to page
		add(exitButton);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitButton) {
			top.runLogin();
		}
		
		if (e.getSource() == quantityButton) {
			for(int i = 0; i < GroceryStore.InventoryList.size(); i ++) {
				if(GroceryStore.InventoryList.get(i).getName().equals(checkInventory.getText())){

					quantity.setText(GroceryStore.InventoryList.get(i).getName() + ": "
							+ GroceryStore.InventoryList.get(i).getStock());
					
					remove(quantity);
					add(quantity);
				}
			}
		}
		
		if (e.getSource() == changeStock) {
			stockPopUpWindow();
		}
		
		//if (e.getSource() == iIncreaseStock) {
			//for(int i = 0; i < GroceryStore.InventoryList.size(); i++) {
				//if(GroceryStore.InventoryList.get(i).getName().equals(checkInventory.getText())) {
					
				//}
			//}
		//}
		
				
	}
	
	public JList ListFromArrayInventory(ArrayList<InventoryItem> aList) {
		DefaultListModel temp = new DefaultListModel();
		
		for(int i = 0; i < aList.size(); i++) {
			temp.addElement(aList.get(i).getName());
		}
		
		JList lTemp = new JList(temp);
		return(lTemp);
	}
	
	public void stockPopUpWindow() {
		stockPopUp = new JDialog();
		stockPopUp.setTitle(checkInventory.getText() + " Stock");
		stockPopUp.setSize(700,700);
		stockPopUp.setLayout(null);
		stockPopUp.setVisible(true);
		
		JLabel stockBanner = new JLabel("Please enter an amount to increase or remove stock");
		stockBanner.setFont(new Font("Calibri", Font.BOLD, 20));
		stockBanner.setBounds(100, 100, 450, 50);
		stockPopUp.add(stockBanner);
		
		JTextField amount = new JTextField("Amount");
		amount.setBounds(100, 155, 200, 50);
		stockPopUp.add(amount);
		
		JButton iIncreaseStock = new JButton("Increase");
		JButton iRemoveStock = new JButton("Remove");
		iIncreaseStock.setBounds(305, 155, 150, 50);
		iRemoveStock.setBounds(460, 155, 150, 50);
		iIncreaseStock.addActionListener(this);
		iRemoveStock.addActionListener(this);
		stockPopUp.add(iIncreaseStock);
		stockPopUp.add(iRemoveStock);
		
	}
	
}