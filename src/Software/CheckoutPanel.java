package Software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import People.Employee;
import People.Person;

public class CheckoutPanel extends JPanel implements ActionListener{
	
	private GroceryStoreProgramGUI top;
	private JButton exitButton; //Button to exit
	
	public CheckoutPanel(GroceryStoreProgramGUI aTop) {
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
