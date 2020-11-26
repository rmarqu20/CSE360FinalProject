/**
 * 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/**
 * @author 
 *
 */
public class Popup extends JFrame implements ActionListener{
	
	static JFrame frame;
	
	static JDialog d, d1;
	
	/*
	 * 
	 */
	public static void main(String[] args){
		
		frame = new JFrame("popup message");
		
		JPanel p = new JPanel();
		
		frame.add(p);
		
		frame.setSize(350, 350);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.show();
		
		
	}
	
	/*
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
		JPanel p = new JPanel();
		
		d1 = new JDialog(d, "Popup Message");
		
		JLabel l = new JLabel("Data loaded for 2 users in the roster \n1 aditional attendee was found: ");
		
		
		
		p.add(l);
		
		
		d1.add(l);
		
		d1.setSize(200, 200);
		
		d1.setLocation(200, 200);
		
		d1.setVisible(true);
		
	}
	
	
	

}
