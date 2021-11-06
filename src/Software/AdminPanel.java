package Software;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import People.Customer;
import People.Employee;
import People.Person;
import Tangibles.GroceryStore;
import Tangibles.InventoryItem;

public class AdminPanel extends JPanel implements ActionListener{

	//general program stuff
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
	private JTextField adress;
	private JTextField phoneNum;
	private JTextField payRate;
	
	//managing an employees wages stuff
	private JLabel wageBanner;
	private JTextField chooseName;
	private JButton viewEmployee;
	private JButton wageChange;
	private JLabel employeeInfo;
	private JTextField newPayRate;
	
	//inventory modify stuff
	private JLabel inventoryBanner;
	
	//inventory add stuff
	private JLabel inventoryAddBanner;
	private JRadioButton inventoryTypeDairy;
	private JRadioButton inventoryTypeMeat;
	private JRadioButton inventoryTypeDryGood;
	private JRadioButton inventoryTypeProduce;
	private ButtonGroup inventoryButtonGroup;
	private JButton addButton;
	private JRadioButton iAdd1; // these buttons are options for the type of inventory item,
	private JRadioButton iAdd2; // ie meat, then iAdd chooses beef, pork, chicken, fish
	private JRadioButton iAdd3;
	private JRadioButton iAdd4;
	private ButtonGroup iAddGroup;
	private JTextField iname;// these are the text fields to enter info for new item
	private JTextField istock;
	private JTextField iaisle;
	private JTextField ibarcode;
	
	public AdminPanel(GroceryStoreProgramGUI aTop) {
		top = aTop;
		setLayout(null);
		
		//general stuff
		EmployeeScroll = new JScrollPane(ListFromArrayEmployee(GroceryStore.EmployeeList));
		ListBanner = new JLabel("Employee List:");
		IListBanner = new JLabel("Invetory List:");
		InventoryScroll = new JScrollPane(ListFromArrayInventory(GroceryStore.InventoryList));
		exit = new JButton("Exit");
		
		//employee hire stuff
		HireBanner = new JLabel("Please enter a new Employee's information and press Hire:");
		HireEmployee = new JButton("Hire");
		name = new JTextField("Name");
		username = new JTextField("Username");
		password = new JTextField("Password");
		adress = new JTextField("Adress");
		phoneNum = new JTextField("Phone Number");
		payRate = new JTextField("Pay Rate");
		HireEmployee.addActionListener(this);
		
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
		inventoryBanner = new JLabel("Please enter an invetory item to price modify:");
		
		//inventory add
		inventoryAddBanner = new JLabel("Please enter an inventory items information and press Add:");
		inventoryTypeDairy = new JRadioButton("Dairy");
		inventoryTypeMeat = new JRadioButton("Meat");
		inventoryTypeDryGood = new JRadioButton("Dry Good");
		inventoryTypeProduce = new JRadioButton("Produce");
		inventoryButtonGroup = new ButtonGroup();
		iAdd1 = new JRadioButton(); 
		iAdd2 = new JRadioButton();
		iAdd3 = new JRadioButton();
		iAdd4 = new JRadioButton();
		iAddGroup = new ButtonGroup();
		addButton = new JButton("Add");
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
		

		
		
		//setBounds is (x, y, width, height)
		//general
		ListBanner.setBounds(100,25,200,30);
		EmployeeScroll.setBounds(100,65, 200,90);
		IListBanner.setBounds(500,25,200,30);
		InventoryScroll.setBounds(500,65,200,90);
		exit.setBounds(850,850,100,100);
		
		//employee hire
		HireBanner.setBounds(100,500,400,40);
		name.setBounds(100,540,300,30);
		username.setBounds(100,570,300,30);
		password.setBounds(100,600,300,30);
		adress.setBounds(100,630,300,30);
		phoneNum.setBounds(100,660,300,30);
		payRate.setBounds(100,690,300,30);
		HireEmployee.setBounds(100, 800, 100, 100);
		
		//wage
		wageBanner.setBounds(100,150,400,40);
		chooseName.setBounds(100, 200, 150, 40);
		viewEmployee.setBounds(100,400,100,40);
		wageChange.setBounds(300,400,100,40);
		employeeInfo.setBounds(100,300,400,40);
		newPayRate.setBounds(300,200,150,40);
		
		//inventory price modify
		inventoryBanner.setBounds(500,150,400,40);
		
		//inventory add
		inventoryAddBanner.setBounds(500,500,400,40);
		inventoryTypeDairy.setBounds(500,550,100,40);
		inventoryTypeMeat.setBounds(600,550,100,40);
		inventoryTypeDryGood.setBounds(700,550,100,40);
		inventoryTypeProduce.setBounds(800,550,100,40);
		addButton.setBounds(500,800,100,100);
		iAdd1.setBounds(800,600,100,40);
		iAdd2.setBounds(800,650,100,40);
		iAdd3.setBounds(800,700,100,40);
		iAdd4.setBounds(800,750,100,40);
		iname.setBounds(500,600,250,30);
		istock.setBounds(500,630,250,30);
		iaisle.setBounds(500,660,250,30);
		ibarcode.setBounds(500,690,250,30);
		
		//adding stuff to panel
		add(EmployeeScroll); add(ListBanner); add(HireBanner); add(HireEmployee); add(wageBanner);
		add(inventoryBanner); add(IListBanner); add(inventoryAddBanner); add(name);
		add(username); add(password); add(adress); add(phoneNum); add(payRate); add(chooseName);
		add(viewEmployee); add(wageChange); add(employeeInfo); add(newPayRate);
		add(InventoryScroll); add(inventoryTypeDairy); add(inventoryTypeMeat); add(inventoryTypeDryGood);
		add(inventoryTypeProduce); add(addButton); add(iAdd1); add(iAdd2); add(iAdd3); add(iAdd4);
		add(iname); add(istock); add(iaisle); add(ibarcode); add(exit);
		
	}
	
	public void actionPerformed(ActionEvent e) {
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
		if(e.getSource() == HireEmployee) {
			
			Employee E = new Employee();
			E.setName(name.getText());
			E.setUsername(username.getText());
			E.setPassword(password.getText());
			E.setAdress(adress.getText());
			E.setPhoneNumber(Integer.parseInt(phoneNum.getText()));
			E.setHourlyRate(Integer.parseInt(payRate.getText()));
			
			remove(employeeInfo);
			EmployeeScroll.setViewportView(ListFromArrayEmployee(GroceryStore.EmployeeList));
			add(employeeInfo);
			
		}
		if(e.getSource() == exit) {
			top.runLogin();
		}
			
		
	}
	
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
	
	
	
}
