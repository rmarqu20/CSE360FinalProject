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
public class Popup extends JFrame implements ActionListner{
	
	static JFrame frame;
	
	static JDialog d, d1;
	
	/*
	 * 
	 */
	public static void main(String[] args){
		
		frame = new JFrame("frame");
		
		Popup s = new Popup();
		
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
		
		d1 = new JDialog(d, "Popup Message");
		
		JLabel l = new JLabel("Data loaded for 2 users in the roster \n1 aditional attendee was found: ");
		
		d1.add(l);
		
		d1.setSize(200, 200);
		
		d1.setLocation(200, 200);
		
		d1.setVisible(true);
		
	}
	
	
	

}
