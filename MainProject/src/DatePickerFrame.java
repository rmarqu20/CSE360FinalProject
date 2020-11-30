import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DatePickerFrame extends JFrame implements ActionListener
{
	DataSource rep;
	JDatePickerImpl datePicker;
	File toParse;
	DatePickerFrame(JFrame par,DataSource in, File nFile)
	{
		rep = in;
		toParse = nFile;
		setTitle("Choose A Date");
		setSize(300,100);
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		JButton sub = new JButton("Add to Chart");
		
		setLocation(par.getX() + 300,par.getY() + 200);
		
		JPanel pan = new JPanel(new GridLayout(2,1));
		
		sub.addActionListener(this);
		pan.add(datePicker);
		pan.add(sub);
		getContentPane().add(pan);
		show();
	}

	@Override
	public void actionPerformed(ActionEvent eve) 
	{
		String dateStr = datePicker.getJFormattedTextField().getText();
		try 
		{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
			rep.addAttendance(toParse,date);
			
			JDialog aboutDialog = new JDialog();
    		
    		String msg = "Data loaded for " + 
    		Integer.toString(rep.foundStuds) + " users in the roster.";
    		JLabel lab1 = new JLabel(msg,SwingConstants.CENTER);
    		ArrayList<Student> list = rep.notFound.getStudents();
    		
    		String line2 = Integer.toString(list.size());
    		line2 += " additional attendees were found:";
    		JLabel lab2 = new JLabel(line2,SwingConstants.CENTER);
    		
    		GridLayout grid = new GridLayout(2 + list.size(),1);
    		JPanel panel = new JPanel(grid);
    		
    		panel.add(lab1);
    		panel.add(lab2);
    		
    		if(list.size() > 0)
    		{
    			for(int i = 0; i<list.size();i++)
    			{
    				String studMess = list.get(i).getASU();
    				
    				studMess += ", connected for " + Integer.toString(list.get(i).getDateTime(date));
    				studMess += " minute";
    				JLabel newLab = new JLabel(studMess,SwingConstants.CENTER);
    				panel.add(newLab);
    			}
    		}
    		
    		
    		aboutDialog.add(panel);
    		aboutDialog.setLocation(this.getX(),this.getY());
			aboutDialog.pack();
			aboutDialog.setSize(aboutDialog.getSize().width + 30,aboutDialog.getSize().height + 30 );
			aboutDialog.show();
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}	
		
		dispose();
	}
}
