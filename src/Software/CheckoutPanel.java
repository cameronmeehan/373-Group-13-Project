package Software;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import People.Employee;
import People.Person;
import Tangibles.Dairy;
import Tangibles.GroceryStore;
import Tangibles.InventoryItem;
import Tangibles.Produce;

public class CheckoutPanel extends JPanel implements ActionListener{
	
	private GroceryStoreProgramGUI top;
	private JButton exitButton; //Button to exit
	private Checkout checkout;
	//private ArrayList<InventoryItem> ckarraylist = new ArrayList<InventoryItem>();
	
	private JLabel AddItemText;
	private JTextField AddItemInput;
	private JButton AddCheckoutItemButton;
	private JButton RemoveFromCartButton;
	private JButton AddItemToCartButton;
	private JLabel CheckoutBanner;
	private JLabel InventoryBanner;
	private JScrollPane InventoryScroll;
	
	
	private JLabel CartText;
	private String ItemName;
	private JLabel DisplayCartInfo;
	private JScrollPane CartListScroll;
	private JScrollPane CartQuanityScroll;
	private JLabel PriceDisplay;
	private JLabel CheckoutMessage;
	 
	//private JButton AddItemButton;
	public CheckoutPanel() {
		
	}
	
	public JList ListFromArrayInventory(ArrayList<InventoryItem> aList) {
		DefaultListModel temp = new DefaultListModel();
		
		for(int i = 0; i < aList.size(); i++) {
			temp.addElement(aList.get(i).getName());
		}
		
		JList lTemp = new JList(temp);
		return(lTemp);
	}	
	
	public CheckoutPanel(GroceryStoreProgramGUI aTop) {
		top = aTop;
		setLayout(null);
		checkout = new Checkout();
		

		double TotalCost = 0;
		
	
		for(InventoryItem ItemtoCart: checkout.getCartList()) {
			TotalCost += ItemtoCart.getPrice() * checkout.getQuantity(ItemtoCart);
		}
		String TotalCostString = "Total Cost of purchase is " + TotalCost+"";
		PriceDisplay = new JLabel(TotalCostString);
		
		System.out.println(checkout.getCartList().size());
		
		
		CheckoutMessage = new JLabel("<html>Thank you for shopping with us<br/>  We hope you found everything you were looking.<br/>On behalf of the whole team, thank you for choosing our store.  <br/>we hope to see you again");
		
		
		//general page stuff creation
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		
		CheckoutBanner = new JLabel ("Welcome to Checkout");
		CheckoutBanner.setFont(new Font("Calibri", Font.BOLD, 45));
		AddItemText = new JLabel("Please finalize your items in the Cart");
		AddItemInput = new JTextField("Remove Items from Cart");
		AddCheckoutItemButton = new JButton ("Checkout");
		RemoveFromCartButton = new JButton ("Remove");
		CartText = new JLabel ("Items in Cart");
		AddItemToCartButton = new JButton ("Add");
		InventoryBanner = new JLabel("Items available in store");
		InventoryScroll = new JScrollPane(ListFromArrayInventory(GroceryStore.InventoryList));
		InventoryBanner.setFont(new Font("Calibri", Font.BOLD, 20));
		
		AddCheckoutItemButton.addActionListener(this);
		
		
		ListFromArrayInventory(checkout.getCartList());
		CartListScroll = new JScrollPane(ListFromArrayInventory(checkout.getCartList()));


		
		RemoveFromCartButton.addActionListener(this);
		AddItemToCartButton.addActionListener(this);
		
		
		//general page stuff allignment
		AddItemText.setBounds(100,265,325,50);
		CartText.setBounds(100,320,325,100);
		AddCheckoutItemButton.setBounds(100,600,100,30);
		RemoveFromCartButton.setBounds(385,300,85,50);
		AddItemInput.setBounds(100,300,200,50);
		//invView.setBounds(400,350,500,30);
		exitButton.setBounds(850,600,100,100);
		CartListScroll.setBounds(100,380,100,200);
		AddItemToCartButton.setBounds(300,300,85,50);
		CheckoutBanner.setBounds(100,50,700,200);
		PriceDisplay.setBounds(220,515,200,200);
		CheckoutMessage.setBounds(210, 260, 500, 300);
		InventoryScroll.setBounds(600, 380, 100,200);
		InventoryBanner.setBounds(600,250,250,100);
		
		
		//adding stuff to page
		add(exitButton);
		add(AddItemText);
		add(AddItemInput);
		add(AddItemToCartButton);
		add(AddCheckoutItemButton);
		add(RemoveFromCartButton);
		add(CartText);
		add(CartListScroll);
		add(PriceDisplay);
		add(CheckoutMessage);
		add(CheckoutBanner);
		add(InventoryScroll);
		add(InventoryBanner);
		
	}
	
	public void setcheckout ( Checkout CopyofCartList) {
		checkout = CopyofCartList;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitButton) {
			top.runLogin();
		}
		if (e.getSource() == RemoveFromCartButton) {
			if(checkout.getCartList().size() == 0) {
				JOptionPane.showMessageDialog(null, "Cart is empty");
			}
			for (int i = 0; i < checkout.getCartList().size(); i++) {
					if(checkout.getCartList().get(i).getName().equals(AddItemInput.getText())) {
							if(checkout.getQuantity(checkout.getCartList().get(i)) == 0) {
								JOptionPane.showMessageDialog(null, "Unable to remove, Item already not in cart");
					}
							else {
								checkout.removeItem(checkout.getCartList().get(i));
								JOptionPane.showMessageDialog(null, AddItemInput.getText() + " has been removed");
								CartListScroll.setViewportView(ListFromArrayInventory(checkout.getCartList()));
								double TotalCost = 0;
								for(InventoryItem ItemtoCart: checkout.getCartList()) {
									TotalCost += ItemtoCart.getPrice() * checkout.getQuantity(ItemtoCart);
								}
								String TotalCostString = "Total Cost of purchase is " + TotalCost+"";
								PriceDisplay.setText(TotalCostString);
							    }
					}
					
					remove(CartListScroll);
					CartListScroll.setViewportView(ListFromArrayInventory(checkout.getCartList()));
					add(CartListScroll);
			}
			
		}
			
		
		if(e.getSource() == AddItemToCartButton) {
			for (int i = 0; i < GroceryStore.InventoryList.size(); i++) 
				if(GroceryStore.InventoryList.get(i).getName().equals(AddItemInput.getText())) {
					checkout.addItemToCart(GroceryStore.InventoryList.get(i));
					JOptionPane.showMessageDialog(null,AddItemInput.getText() + " has been added");
					CartListScroll.setViewportView(ListFromArrayInventory(checkout.getCartList()));
					double TotalCost = 0;
					for(InventoryItem ItemtoCart: checkout.getCartList()) {
						TotalCost += ItemtoCart.getPrice() * checkout.getQuantity(ItemtoCart);
					}
					String TotalCostString = "Total Cost of purchase is " + TotalCost+"";
					PriceDisplay.setText(TotalCostString);
					
			    }
				
			remove(CartListScroll);
			CartListScroll.setViewportView(ListFromArrayInventory(checkout.getCartList()));
			add(CartListScroll);
		}
		
//gonna make this a pop up.
		if (e.getSource() == AddCheckoutItemButton) {
			
			Paymentwindow();
//						double TotalCostReCalc = 0;
//			for(InventoryItem ItemtoCart: checkout.getCartList()) {
//							TotalCostReCalc += ItemtoCart.getPrice() * checkout.getQuantity(ItemtoCart);
//							
//			}
//			PriceDisplay.setText("Total Cost of purchase is " + TotalCostReCalc+"");
//			add(PriceDisplay);
//			System.out.println(TotalCostReCalc);
		}
		
		
	}
	
	public void Paymentwindow() {
		
		JOptionPane.showMessageDialog(null, checkout.checkout());
		JLabel Total = new JLabel("Total for items:");
		Total.setBounds(25,160,400,50);
		
		
	}
	
	
	
}
