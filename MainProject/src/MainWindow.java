import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 * This class will be utilized to create the main window of the 
 * application. This window will serve as a way for the user
 * to interact with the student roster through the use of a menu.
 * @author 
 *
 */
public class MainWindow extends JFrame implements ActionListener
{
	DataSource data;
	JTable table;
	/**
	 * This is the constructor for the main window
	 * creating a menu, handling object sizes and 
	 * connecting components.
	 */
	public MainWindow()
	{
		data = new DataSource();
		//Window Info
		setTitle("CSE360 Final Project");
		setSize(800,600);
		
		MainMenuBar menBar = new MainMenuBar();
		menBar.addListener(this);
		
		JPanel mainPanel = new JPanel(new GridLayout(1,1));
		
		//Associating table with data source
		TablePane tab = new TablePane();
		DataPlot plot = new DataPlot();

		data.addObserver(tab);
		data.addObserver(plot);
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		table = tab.studtable.table;
		tabs.addTab("Table", tab.pane);
		
		tabs.addTab("Data Plot",plot);
		//Adding objects to main panel
		mainPanel.setSize(800,600);
		mainPanel.add(menBar);
		mainPanel.add(tabs);
		
		//Adding mainPanel to the main window frame
		getContentPane().add(mainPanel);
		this.setJMenuBar(menBar);
	}
	
	public static void main(String[] args)
	{
		MainWindow window = new MainWindow();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
	}
	
	/**
	 * This function to be used as
	 * a reaction to button presses
	 */
	@Override
	public void actionPerformed(ActionEvent eve) 
	{
		//Determining which button was pushed
		String menuPushed = ((JMenuItem)eve.getSource()).getText();
		
		//Spawn file chooser
	
		DatePickerFrame dateChoose;
		
		//Loading the roster case
		if(menuPushed == "Load a Roster" || menuPushed == "Add Attendance")
		{
			File fileChoose = null;
			JFileChooser chooser = new JFileChooser();
			//Adding filter to file choices
			FileNameExtensionFilter filter = new FileNameExtensionFilter
			("Comma Separated Value Files","csv");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(this);
		    
		    //If a file is chosen
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	fileChoose = chooser.getSelectedFile();
		    }
		    
		    if(fileChoose != null)
		    {
		    	if(menuPushed == "Load a Roster")
				{
		    		//Update datasource using file
			    	data.create(fileChoose);
				}
		    	else
		    	{
		    		dateChoose = new 
		    		DatePickerFrame(this,data,fileChoose);
		    	}
		    }
		    
		}
		//About page case
		else if (menuPushed == "About") 
		{
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
		
		else if(menuPushed == "Save")
		{
			 JFileChooser chooser = new JFileChooser();
			 int retrival = chooser.showSaveDialog(null);
			 if (retrival == JFileChooser.APPROVE_OPTION) {
		        try {
		            File fileChoose = chooser.getSelectedFile();
		            SaveTable sav= new SaveTable(table,fileChoose);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			    }
		}
		
		else if(menuPushed == "Plot Data")
		{
			data.showPlot();
		}
	}
}


