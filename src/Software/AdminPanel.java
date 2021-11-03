package Software;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import People.Employee;
import People.Person;
import Tangibles.GroceryStore;

public class AdminPanel extends JPanel implements ActionListener{

	//general program stuff
	private GroceryStoreProgramGUI top;
	private JList Employees; //list of employees
	private JScrollPane EmployeeScroll; //scroll the employee list
	private JLabel ListBanner;
	private JLabel IListBanner;
	
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
	
	//managing inventory stuff
	private JLabel inventoryBanner;
	
	
	public AdminPanel(GroceryStoreProgramGUI aTop) {
		top = aTop;
		setLayout(null);
		
		//generalstuff
		EmployeeScroll = new JScrollPane(ListFromArrayEmployee(GroceryStore.EmployeeList));
		ListBanner = new JLabel("Employee List:");
		IListBanner = new JLabel("Invetory List:");
		
		//employee hire stuff
		HireBanner = new JLabel("Please enter a new Employee's information and press Hire:");
		HireEmployee = new JButton("Hire");
		
		//wage stuff
		wageBanner = new JLabel("Please enter the Employees Name to view or change thier wage:");
		
		//inventory stuff
		inventoryBanner = new JLabel("Please enter an invtory item to price modify, or enter a new inventory item:");
		
		
		
		//setBounds is (x, y, width, height)
		//general
		ListBanner.setBounds(100,50,200,30);
		EmployeeScroll.setBounds(100,100, 200,100);
		IListBanner.setBounds(100,200,200,30);
		//employee hire
		HireBanner.setBounds(100,400,400,30);
		HireEmployee.setBounds(100, 850, 100, 100);
		//wage
		wageBanner.setBounds(500,500,400,40);
		//inventory
		inventoryBanner.setBounds(500,100,400,40);
		
		
		//adding stuff to panel
		add(EmployeeScroll);
		add(ListBanner);
		add(HireBanner);
		add(HireEmployee);
		add(wageBanner);
		add(inventoryBanner);
		add(IListBanner);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public JList ListFromArrayEmployee(ArrayList<Employee> aList) {
		DefaultListModel temp = new DefaultListModel();
		
		for(int i = 0; i < aList.size(); i++) {
			temp.addElement(aList.get(i).getName());
		}
		
		JList lTemp = new JList(temp);
		return(lTemp);
	}	
	
	
	
	
	
}
