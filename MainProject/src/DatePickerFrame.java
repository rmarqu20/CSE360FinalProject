import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}	
		
		dispose();
	}
}
