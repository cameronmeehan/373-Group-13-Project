package Software;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import People.Admin;
import People.Customer;
import People.Employee;
import People.Person;
import Tangibles.Dairy;
import Tangibles.DryGoods;
import Tangibles.GroceryStore;
import Tangibles.InventoryItem;
import Tangibles.Meat;
import Tangibles.Produce;

//will need to change methods to implement method in Admin class compared to implement here
public class AdminPanel extends JPanel implements ActionListener{

	//general program stuff
	private JScrollBar PageScrollBar;
	private GroceryStoreProgramGUI top;
	private JList Employees; //list of employees
	private JScrollPane EmployeeScroll; //scroll the employee list
	private JLabel ListBanner;
	private JLabel IListBanner;
	private JList Inventories; //list of inventor items
	private JScrollPane InventoryScroll;
	private JButton exit;
	
	//hiring employee stuff
	private JButton HireEmployee; //Button hire employee, have fields already entered
	private JLabel HireBanner ;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phoneNum;
	private JTextField payRate;
	
	//fire employee stuff
	private JLabel fireBanner;
	private JTextField fireName;
	private JButton fireButton;
	
	//managing an employees wages stuff
	private JLabel wageBanner;
	private JTextField chooseName;
	private JButton viewEmployee;
	private JButton wageChange;
	private JLabel employeeInfo;
	private JTextField newPayRate;
	
	//inventory modify stuff
	private JLabel inventoryBanner;
	private JTextField iChangeName;
	private JTextField iChangeNewPrice;
	private JButton iChangePrice;
	private JLabel iChangedLabel;
	private JButton iViewPrice;
	
	//inventory remove stuff
	private JLabel iRemoveLabel;
	private JTextField iRemoveName;
	private JButton iRemoveButton;
	
	//inventory add stuff
	private JLabel inventoryAddBanner;
	private JRadioButton inventoryTypeDairy;
	private JRadioButton inventoryTypeMeat;
	private JRadioButton inventoryTypeDryGood;
	private JRadioButton inventoryTypeProduce;
	private ButtonGroup inventoryButtonGroup;
	private JButton IAddButton;
	private JRadioButton iAdd1; // these buttons are options for the type of inventory item,
	private JRadioButton iAdd2; // ie meat, then iAdd chooses beef, pork, chicken, fish
	private JRadioButton iAdd3;
	private JRadioButton iAdd4;
	private ButtonGroup iAddGroup;
	private JTextField iname;// these are the text fields to enter info for new item
	private JTextField istock;
	private JTextField iaisle;
	private JTextField ibarcode;
	private JTextField iprice;
	
	//sales anyalist stuff
	private JDialog analysisPopUp;
	private JButton analysisPopUpButton;
	private JButton invCheck;
	private JLabel invView;
	private JScrollPane SalesInventoryScroll;
	
	public AdminPanel(GroceryStoreProgramGUI aTop) {
		//creating an object of GroceryStorePanelGUI so its methods can be used to change panels
		top = aTop;
		
		
		// needed to set new layouts of buttons, panels, ect... on the page
		setPreferredSize(new Dimension(900,700));
		setLayout(null);
		//general stuff
		PageScrollBar = new JScrollBar();
		PageScrollBar.setVisible(true);
		EmployeeScroll = new JScrollPane(ListFromArrayEmployee(GroceryStore.EmployeeList));
		ListBanner = new JLabel("Employee List:");
		IListBanner = new JLabel("Invetory List:");
		InventoryScroll = new JScrollPane(ListFromArrayInventory(GroceryStore.InventoryList));
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		//employee hire stuff
		HireBanner = new JLabel("Please enter a new Employee's information and press Hire:");
		HireEmployee = new JButton("Hire");
		name = new JTextField("Name");
		username = new JTextField("Username");
		password = new JTextField("Password");
		address = new JTextField("Address");
		phoneNum = new JTextField("Phone Number");
		payRate = new JTextField("Pay Rate");
		HireEmployee.addActionListener(this);
		
		//employee fire stuff
		fireBanner = new JLabel("Please enter a employee Name and press Fire:");
		fireName = new JTextField("Name");
		fireButton = new JButton("Fire");
		fireButton.addActionListener(this);
		
		//wage stuff
		wageBanner = new JLabel("Please enter the Employees Name to view or change thier wage:");
		chooseName = new JTextField("Name");
		viewEmployee = new JButton("View Wage");
		wageChange = new JButton("Set Wage");
		employeeInfo = new JLabel();
		newPayRate = new JTextField("New Pay Rate");
		viewEmployee.addActionListener(this);
		wageChange.addActionListener(this);
		
		//inventory modify price
		iChangedLabel = new JLabel();
		inventoryBanner = new JLabel("Please enter an invetory item to price modify:");
		iChangeName = new JTextField("Name");
		iChangeNewPrice = new JTextField("New Price");
		iChangePrice = new JButton("Set Price");
		iViewPrice = new JButton("View Price");
		iViewPrice.addActionListener(this);
		iChangePrice.addActionListener(this);
		
		//inventory remove
		iRemoveLabel = new JLabel("Please enter an inventory item to remove then press Remove:");
		iRemoveName = new JTextField("Name");
		iRemoveButton = new JButton("Remove");
		iRemoveButton.addActionListener(this);
		
		//inventory add
		inventoryAddBanner = new JLabel("Please enter an inventory items information and press Add:");
		inventoryTypeDairy = new JRadioButton("Dairy");
		inventoryTypeMeat = new JRadioButton("Meat");
		inventoryTypeDryGood = new JRadioButton("Dry Good");
		inventoryTypeProduce = new JRadioButton("Produce");
		inventoryTypeDairy.addActionListener(this);
		inventoryTypeMeat.addActionListener(this);
		inventoryTypeDryGood.addActionListener(this);
		inventoryTypeProduce.addActionListener(this);
		inventoryButtonGroup = new ButtonGroup();
		iAdd1 = new JRadioButton(); 
		iAdd2 = new JRadioButton();
		iAdd3 = new JRadioButton();
		iAdd4 = new JRadioButton();
		iAddGroup = new ButtonGroup();
		IAddButton = new JButton("Add");
		IAddButton.addActionListener(this);
		inventoryButtonGroup.add(inventoryTypeDairy);
		inventoryButtonGroup.add(inventoryTypeMeat);
		inventoryButtonGroup.add(inventoryTypeDryGood);
		inventoryButtonGroup.add(inventoryTypeProduce);
		iAddGroup.add(iAdd1);
		iAddGroup.add(iAdd2);
		iAddGroup.add(iAdd3);
		iAddGroup.add(iAdd4);
		iname = new JTextField("Name");
		istock = new JTextField("Stock Amount");
		iaisle = new JTextField("Aisle");
		ibarcode = new JTextField("Barcode");
		iprice = new JTextField("Price");
		
		//analyst stuff
		analysisPopUpButton = new JButton("Sales Analysis");
		analysisPopUpButton.addActionListener(this);
		
		//setBounds is (x, y, width, height)
		//general
		ListBanner.setBounds(100,0,200,30);
		EmployeeScroll.setBounds(100,25,250,70);
		IListBanner.setBounds(500,0,200,30);
		InventoryScroll.setBounds(500,25,250,70);
		exit.setBounds(820,650,150,100);
		
		//employee hire
		HireBanner.setBounds(100,325,400,40);
		name.setBounds(100,380,300,30);
		username.setBounds(100,410,300,30);
		password.setBounds(100,440,300,30);
		address.setBounds(100,470,300,30);
		phoneNum.setBounds(100,500,300,30);
		payRate.setBounds(100,530,300,30);
		HireEmployee.setBounds(100,600,100,40);
		

		
		//employee fire
		fireBanner.setBounds(100,250,400,40);
		fireName.setBounds(100,285,100,30);
		fireButton.setBounds(300,285,100,40);
		
		//wage
		wageBanner.setBounds(100,90,400,40);
		chooseName.setBounds(100, 125, 150, 30);
		newPayRate.setBounds(300,125,150,30);
		employeeInfo.setBounds(100,150,400,40);
		viewEmployee.setBounds(100,200,100,40);
		wageChange.setBounds(300,200,100,40);
		
		//inventory price modify
		inventoryBanner.setBounds(500,90,400,40);
		iChangedLabel.setBounds(500,150,400,40);
		iChangeName.setBounds(500,125,150,30);
		iChangeNewPrice.setBounds(700,125,150,30);
		iChangePrice.setBounds(700,200,100,40);
		iViewPrice.setBounds(500,200,100,40);
		
		//inventory remove
		iRemoveLabel.setBounds(500,250,400,40);
		iRemoveName.setBounds(500,285,100,30);
		iRemoveButton.setBounds(700,285,100,40);
		
		//inventory add
		inventoryAddBanner.setBounds(500,325,400,40);
		inventoryTypeDairy.setBounds(500,370,100,40);
		inventoryTypeMeat.setBounds(600,370,100,40);
		inventoryTypeDryGood.setBounds(700,370,100,40);
		inventoryTypeProduce.setBounds(800,370,100,40);
		IAddButton.setBounds(500,600,100,40);
		iAdd1.setBounds(800,410,100,40);
		iAdd2.setBounds(800,460,100,40);
		iAdd3.setBounds(800,510,100,40);
		iAdd4.setBounds(800,560,100,40);
		iname.setBounds(500,420,250,30);
		istock.setBounds(500,450,250,30);
		iaisle.setBounds(500,480,250,30);
		ibarcode.setBounds(500,510,250,30);
		iprice.setBounds(500,540,250,30);
		
		//sales analysis 
		analysisPopUpButton.setBounds(650,650,150,100);
		
		//adding stuff to panel
		add(EmployeeScroll); add(ListBanner); add(HireBanner); add(HireEmployee); add(wageBanner);
		add(inventoryBanner); add(IListBanner); add(inventoryAddBanner); add(name);
		add(username); add(password); add(address); add(phoneNum); add(payRate); add(chooseName);
		add(viewEmployee); add(wageChange); add(employeeInfo); add(newPayRate);
		add(InventoryScroll); add(inventoryTypeDairy); add(inventoryTypeMeat); add(inventoryTypeDryGood);
		add(inventoryTypeProduce); add(IAddButton); add(iAdd1); add(iAdd2); add(iAdd3); add(iAdd4);
		add(iname); add(istock); add(iaisle); add(ibarcode); add(exit); add(fireBanner);
		add(fireName); add(fireButton); add(iRemoveLabel); add(iRemoveButton); add(iRemoveName);
		add(iChangedLabel); add(iChangeName); add(iChangeNewPrice); add(iChangePrice); add(iViewPrice);
		add(iprice); add(analysisPopUpButton); add(PageScrollBar);
		
		
		
	}
	
	//this method decides what to do when button is pressed
	public void actionPerformed(ActionEvent e) {
		//listener to view employee wage
		if(e.getSource() == viewEmployee) {
			for(int i = 0; i < GroceryStore.EmployeeList.size(); i ++) {
				if(GroceryStore.EmployeeList.get(i).getName().equals(chooseName.getText())){
					
					employeeInfo.setText(GroceryStore.EmployeeList.get(i).getName() + ": " +
							GroceryStore.EmployeeList.get(i).getHourlyRate() + "$ per hour");
					
				remove(employeeInfo);
				add(employeeInfo);
				}
			}
		}
		//listener for wage change button
		if(e.getSource() == wageChange) {
			for(int i = 0; i < GroceryStore.EmployeeList.size(); i ++) {
				if(GroceryStore.EmployeeList.get(i).getName().equals(chooseName.getText())){
					
					
					GroceryStore.EmployeeList.get(i).setHourlyRate(Double.parseDouble(newPayRate.getText()));
					
					employeeInfo.setText(GroceryStore.EmployeeList.get(i).getName() + ": " +
							GroceryStore.EmployeeList.get(i).getHourlyRate() + "$ per hour");
					
				remove(employeeInfo);
				add(employeeInfo);
				}
			}
			
		}
		// listener for hire employee button
		if(e.getSource() == HireEmployee) {
			

			//hiring employee
			JOptionPane.showMessageDialog(null,GroceryStoreProgramGUI.currentAdminUser.hireEmployee(name.getText()));
			
			GroceryStore.EmployeeList.get(GroceryStore.EmployeeList.size() - 1).setUsername(username.getText());
			GroceryStore.EmployeeList.get(GroceryStore.EmployeeList.size() - 1).setPassword(password.getText());
			GroceryStore.EmployeeList.get(GroceryStore.EmployeeList.size() - 1).setAddress(address.getText());
			GroceryStore.EmployeeList.get(GroceryStore.EmployeeList.size() - 1).setPhoneNumber(phoneNum.getText());
			GroceryStore.EmployeeList.get(GroceryStore.EmployeeList.size() - 1).setHourlyRate(Double.parseDouble(payRate.getText()));
			
			//Refreshing the Employee Scroll panel
			remove(employeeInfo);
			EmployeeScroll.setViewportView(ListFromArrayEmployee(GroceryStore.EmployeeList));
			add(employeeInfo);
			
		}
		
		// listener for fire employee button
		if(e.getSource() == fireButton) {
			
			
			//firing employee
			JOptionPane.showMessageDialog(null, GroceryStoreProgramGUI.currentAdminUser.fireEmployee(fireName.getText()));
			
			//Refreshing the Employee Scroll panel
			remove(employeeInfo);
			EmployeeScroll.setViewportView(ListFromArrayEmployee(GroceryStore.EmployeeList));
			add(employeeInfo);
			
		}
		
		//listener for inventory remove
		if(e.getSource() == iRemoveButton) {
			
			for(int i = 0; i < GroceryStore.InventoryList.size(); i++){
				if(GroceryStore.InventoryList.get(i).getName().equals(iRemoveName.getText())) {
					
					GroceryStore.InventoryList.remove(i);
					JOptionPane.showMessageDialog(null, iRemoveName.getText() + " will no longer be sold.");
					InventoryScroll.setViewportView(ListFromArrayInventory(GroceryStore.InventoryList));
					
				}
			}
		}
		
		//listener to change inventory add types
		if(e.getSource() == inventoryTypeDairy ) {
			iAdd1.setText("Milk");
			iAdd2.setText("Cheese");
			iAdd3.setText("Yogurt");
			iAdd4.setText("");
		}
		if(e.getSource() == inventoryTypeDryGood ) {
			iAdd1.setText("Grain");
			iAdd2.setText("Snack");
			iAdd3.setText("Household");
			iAdd4.setText("");
		}
		if(e.getSource() == inventoryTypeMeat ) {
			iAdd1.setText("Chicken");
			iAdd2.setText("Beef");
			iAdd3.setText("Pork");
			iAdd4.setText("Fish");
		}
		if(e.getSource() == inventoryTypeProduce ) {
			iAdd1.setText("Vegetable");
			iAdd2.setText("Fruit");
			iAdd3.setText("");
			iAdd4.setText("");
		}
		
		//listener for inventory add button
		if(e.getSource() == IAddButton) {
			
			if(inventoryTypeDairy.isSelected() == true) {
				Dairy I = new Dairy();
				I.setName(iname.getText());
				I.setStock(Integer.parseInt(istock.getText()));
				I.setAisle(Integer.parseInt(iaisle.getText()));
				I.setBarcode(Long.parseLong(ibarcode.getText()));
				I.setPrice(Double.parseDouble(iprice.getText()));
				
				if(iAdd1.isSelected() == true) {
					I.setMilk(true);
				}
				else if(iAdd2.isSelected() == true) {
					I.setCheese(true);
				}
				else if(iAdd3.isSelected() == true) {
					I.setYogurt(true);
				}
					
			}
			if(inventoryTypeMeat.isSelected() == true) {
				Meat I = new Meat();
				I.setName(iname.getText());
				I.setStock(Integer.parseInt(istock.getText()));
				I.setAisle(Integer.parseInt(iaisle.getText()));
				I.setBarcode(Long.parseLong(ibarcode.getText()));
				I.setPrice(Double.parseDouble(iprice.getText()));
				
				if(iAdd1.isSelected() == true) {
					I.setChicken(true);
				}
				else if(iAdd2.isSelected() == true) {
					I.setBeef(true);
				}
				else if(iAdd3.isSelected() == true) {
					I.setPork(true);
				}
				else if(iAdd4.isSelected() == true) {
					I.setFish(true);
				}
					
			}
			if(inventoryTypeDryGood.isSelected() == true) {
				DryGoods I = new DryGoods();
				I.setName(iname.getText());
				I.setStock(Integer.parseInt(istock.getText()));
				I.setAisle(Integer.parseInt(iaisle.getText()));
				I.setBarcode(Long.parseLong(ibarcode.getText()));
				I.setPrice(Double.parseDouble(iprice.getText()));
				
				if(iAdd1.isSelected() == true) {
					I.setGrain(true);
				}
				else if(iAdd2.isSelected() == true) {
					I.setSnack(true);
				}
				else if(iAdd3.isSelected() == true) {
					I.setHousehold(true);
				}
					
			}
			if(inventoryTypeProduce.isSelected() == true) {
				Produce I = new Produce();
				I.setName(iname.getText());
				I.setStock(Integer.parseInt(istock.getText()));
				I.setAisle(Integer.parseInt(iaisle.getText()));
				I.setBarcode(Long.parseLong(ibarcode.getText()));
				I.setPrice(Double.parseDouble(iprice.getText()));
				
				if(iAdd1.isSelected() == true) {
					I.setVegetable(true);
				}
				else if(iAdd2.isSelected() == true) {
					I.setFruit(true);
				}
				
					
			}
			JOptionPane.showMessageDialog(null, iname.getText() + " will now be sold.");
			InventoryScroll.setViewportView(ListFromArrayInventory(GroceryStore.InventoryList));
			
		}
		
		//listener for inventory change price button
		if(e.getSource() == iChangePrice) {
			
			for(int i = 0; i < GroceryStore.InventoryList.size(); i ++) {
				if(GroceryStore.InventoryList.get(i).getName().equals(iChangeName.getText())){
					
					
					GroceryStore.InventoryList.get(i).setPrice(Double.parseDouble(iChangeNewPrice.getText()));
					
					iChangedLabel.setText(GroceryStore.InventoryList.get(i).getName() + ": " +
							GroceryStore.InventoryList.get(i).getPrice() + "$");
					
				remove(iChangedLabel);
				add(iChangedLabel);
				}
			}
		}
		
		//listener for inventory view price button
		if(e.getSource() == iViewPrice) {
			
			for(int i = 0; i < GroceryStore.InventoryList.size(); i ++) {
				if(GroceryStore.InventoryList.get(i).getName().equals(iChangeName.getText())){
					
					iChangedLabel.setText(GroceryStore.InventoryList.get(i).getName() + ": " +
							GroceryStore.InventoryList.get(i).getPrice() + "$");
					
				remove(iChangedLabel);
				add(iChangedLabel);
				}
			}
		}
		
		//listener for exit button
		if(e.getSource() == exit) {
			top.runLogin();
			
		}
		
		//sales analysis listener
		if(e.getSource() == analysisPopUpButton) {
			salesAnalysisWindow();
		}
		
		//Sales JDialog view button
		if(e.getSource() == invCheck) {
			String tempInv;
			tempInv = (String) Inventories.getSelectedValue();
			invView.setText(GroceryStoreProgramGUI.currentAdminUser.getSalesInfo(tempInv));
		}
	}
	
	//these turn array lists into lists that can be used by a JScrollPane
	public JList ListFromArrayEmployee(ArrayList<Employee> aList) {
		DefaultListModel temp = new DefaultListModel();
		
		for(int i = 0; i < aList.size(); i++) {
			temp.addElement(aList.get(i).getName());
		}
		
		JList lTemp = new JList(temp);
		return(lTemp);
	}	
	
	public JList ListFromArrayInventory(ArrayList<InventoryItem> aList) {
		DefaultListModel temp = new DefaultListModel();
		
		for(int i = 0; i < aList.size(); i++) {
			temp.addElement(aList.get(i).getName());
		}
		
		JList lTemp = new JList(temp);
		return(lTemp);
	}	
	
	public void salesAnalysisWindow() {
		

	//Item sales check
		Inventories = ListFromArrayInventory(GroceryStore.InventoryList);
		SalesInventoryScroll = new JScrollPane(Inventories);
		invCheck = new JButton();
		invView = new JLabel();
		invCheck.setText("Enter");
		invCheck.addActionListener(this);
	
		JLabel analysisHeading2 = new JLabel("Pick item to view Sales analysis:");
		
		analysisHeading2.setBounds(25,160,400,50);
		SalesInventoryScroll.setBounds(25,200,200,300);
		invCheck.setBounds(100,520,100,30);
		invView.setBounds(250,350,500,30);
		
		
	//top sales list
		//getting top 5 sellers list
		ArrayList<InventoryItem> topSalesList = new ArrayList<InventoryItem>();
		topSalesList = GroceryStoreProgramGUI.currentAdminUser.topSale();
		
		JLabel topFive = new JLabel();
		
		//making top five label
		if(topSalesList.size() == 5) {
		topFive.setText("<html><center>" + GroceryStoreProgramGUI.currentAdminUser.getQuantitySold(topSalesList.get(0)) + " " + topSalesList.get(0).getName() + "s sold at " + topSalesList.get(0).getPrice() + "$ <br>" +
				GroceryStoreProgramGUI.currentAdminUser.getQuantitySold(topSalesList.get(1)) + " " + topSalesList.get(1).getName() + "s sold at " + topSalesList.get(1).getPrice() + "$ <br>" +
				GroceryStoreProgramGUI.currentAdminUser.getQuantitySold(topSalesList.get(2)) + " " + topSalesList.get(2).getName() + "s sold at " + topSalesList.get(2).getPrice() + "$ <br>" +
				GroceryStoreProgramGUI.currentAdminUser.getQuantitySold(topSalesList.get(3)) + " " + topSalesList.get(3).getName() + "s sold at " + topSalesList.get(3).getPrice() + "$ <br>" + 
				GroceryStoreProgramGUI.currentAdminUser.getQuantitySold(topSalesList.get(4)) + " " + topSalesList.get(4).getName() + "s sold at " + topSalesList.get(4).getPrice() + "$ <br>" );
		}
		else {
			topFive.setText("Five items have not been sold yet...");
		}
		topFive.setBounds(25,25,400,150);
		TitledBorder topFiveBorder = new TitledBorder("Top Five Sales:");
		topFive.setBorder(topFiveBorder);
		
		
		
		
	//setting up window
		analysisPopUp = new JDialog();
		analysisPopUp.setTitle("Sales Analysis Page");
		analysisPopUp.setSize(600,600);
		analysisPopUp.setLayout(null);
		
		JScrollPane tPane = new JScrollPane();
		analysisPopUp.add(topFive);
		analysisPopUp.add(analysisHeading2);
		analysisPopUp.add(SalesInventoryScroll);
		analysisPopUp.add(invCheck);
		analysisPopUp.add(invView);
		
		analysisPopUp.setVisible(true);
	}
	
	
	
}
