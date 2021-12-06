package Software;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;

import People.Admin;
import People.Customer;
import People.Employee;
import People.Person;
import Tangibles.Dairy;
import Tangibles.GroceryStore;
import Tangibles.InventoryItem;
import Tangibles.Produce;

public class GroceryStoreProgramGUI extends JFrame{

	//these fields are added to allow GUI panel classes to use the current users members
	public static Admin currentAdminUser;
	public static Employee currentEmployeeUser;
	public static Customer currentCustomerUser;
	
	//constructs GUI Frame and loads login page
	public GroceryStoreProgramGUI() {
		super("Grocery Store Program");
		
		//deSerialization
		deSerialize();
		
		//adding test objects, must be after deSerializing
		// if statement to check if object was retained through last serialization
		if(GroceryStore.AdminList.size() == 0) {
		Admin A1 = new Admin();
		A1.setUsername("Username");
		A1.setPassword("Password");
		}
		
		//setting size of window
		setSize(1000,800);
		
		//adding close button that serializes
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent closeEvent) {
				closeProgram();
			}
			
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.runLogin();
		
	}
	
	public void closeProgram() {
		serialize();
		
		System.exit(0);
	}
	
	//loads login
	public void runLogin() {
		//clears last panel
		getContentPane().removeAll();
		//this.setContentPane(new JLabel(new ImageIcon("\\Resorces\\groceryImage.png")));
		
		Login login;
		login = new Login(this);
		
		JScrollPane sPane = new JScrollPane(login);
		sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		getContentPane().add(sPane);
		setVisible(true);
		
	}
	
	//loads make acount page
	public void runMakeAcount() {
		//clears last panel
		getContentPane().removeAll();
		
		MakeAcount makeacount;
		makeacount = new MakeAcount(this);
		
		JScrollPane sPane = new JScrollPane(makeacount);
		sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(sPane);
		setVisible(true);
	}
	
	//loads admin page
	public void runAdmin(Admin aAdmin) {
		//clears last panel
		getContentPane().removeAll();
		
		
		AdminPanel adminP = new AdminPanel(this);
		
		JScrollPane sPane = new JScrollPane(adminP);
		sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(sPane);
		setVisible(true);
	}
	
	//loads employee page
	public void runEmployeePanel() {
		//clears last panel
		getContentPane().removeAll();
		
		EmployeePanel ePanel;
		ePanel = new EmployeePanel(this);
		
		JScrollPane sPane = new JScrollPane(ePanel);
		sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(sPane);
		setVisible(true);

		
		
	}
	
	//loads customer checkout page
	public void runCheckout() {
		//clears last panel
		getContentPane().removeAll();
		
		CheckoutPanel cPanel;
		cPanel = new CheckoutPanel(this);
		
		JScrollPane sPane = new JScrollPane(cPanel);
		sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(sPane);
		setVisible(true);
		
	}
	
	//Serialization Process
	public void serialize() {
		
		SaveGroceryStore sStore = new SaveGroceryStore();
		
		sStore.tempAdminList= (ArrayList)GroceryStore.AdminList.clone();
		sStore.tempEmployeeList = (ArrayList)GroceryStore.EmployeeList.clone();
		sStore.tempCustomerList = (ArrayList)GroceryStore.CustomerList.clone();
		sStore.tempInventoryList = (ArrayList)GroceryStore.InventoryList.clone();
		sStore.tempCheckoutList = (ArrayList)GroceryStore.CheckoutList.clone();
		
		try {
			//need to make file for each list...
			FileOutputStream sFile = new FileOutputStream("sFile.ser");
			ObjectOutputStream oStream = new ObjectOutputStream(sFile);
			
			oStream.writeObject(sStore);

			oStream.close();
			sFile.close();
			
			System.out.println("Serialization of GroceryStore complete.");
		}
		catch(IOException exception) {
			System.out.println("Serialization exception.");
			exception.printStackTrace();
		}
	
		
	}
	
	//DeSerialization Process
	public void deSerialize() {
		SaveGroceryStore lStore = new SaveGroceryStore();
		
		try {
			FileInputStream lFile = new FileInputStream("sFile.ser");
			ObjectInputStream iStream = new ObjectInputStream(lFile);
			
			lStore = (SaveGroceryStore) iStream.readObject();
			lFile.close();
			iStream.close();
			
			System.out.println("DeSerialization of GroceryStore complete.");
		}
		catch(IOException exception){
			System.out.println("DeSerialization exception.");
			exception.printStackTrace();
		}
		catch(ClassNotFoundException exception){
			System.out.println("Object not found exception.");
			exception.printStackTrace();
		}
		
		GroceryStore.AdminList = (ArrayList)lStore.tempAdminList.clone();
		GroceryStore.EmployeeList = (ArrayList)lStore.tempEmployeeList.clone();
		GroceryStore.CustomerList = (ArrayList)lStore.tempCustomerList.clone();
		GroceryStore.InventoryList = (ArrayList)lStore.tempInventoryList.clone();
		GroceryStore.CheckoutList = (ArrayList)lStore.tempCheckoutList.clone();
		
	}
	
	

}
