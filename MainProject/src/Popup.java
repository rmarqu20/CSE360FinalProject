/**
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;



/**
 * @author 
 *
 */
public class Popup implements Observer {
	
	Students stud;
	Students found;
	
	Popup()
	{
		
		String list;
		ArrayList<Student> info = stud.getStudents();
		for(int i = 0; i < info.size(); i++)
		{
			list = 
		}
		
			String aboutText = 	"<html><head><style>"+
	                "h3 {text-align: center;}" +
	                "p {text-align: center;}" +
	                "</head></style><body>" +
	                            "<p><h3>CSE 360    Tuesday 9:00am - 10:15am<br></h3>" +
	                            "Professor: Javier Gonzalez Sanchez<br><br>" +
	                            "Richard Marquez Cortes<br>" +
	                            "Agustin Gomez Arroyo<br>" +
	                            "Anoop Makam<br>" +
	                            "Gerik Swenson<br>" +
	                            "August Fowler<br><br></p></body></html>";
		
		JLabel aboutInfo = new JLabel(aboutText,SwingConstants.CENTER);
		JDialog aboutDialog = new JDialog();
		aboutDialog.add(aboutInfo);
		aboutDialog.setSize(275,200);
		aboutDialog.setLocation(this.getX() + 300,this.getY() + 200);
		aboutDialog.show();
	}
	
	
	/*
	 * 
	 */
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		stud = ((DataSource)o).getMis();
		found = ((DataSource)o).getData();
		
	}
	
	
	

}
