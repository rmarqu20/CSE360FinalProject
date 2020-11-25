import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * This class will be utilized to create the main window of the 
 * application. This window will serve as a way for the user
 * to interact with the student roster through the use of a menu.
 * @author 
 *
 */
public class MainWindow extends JFrame implements ActionListener
{
	/**
	 * This is the constructor for the main window
	 * creating a menu, handling object sizes and 
	 * connecting components.
	 */
	public MainWindow()
	{
		//Window Info
		setTitle("CSE360 Final Project");
		setSize(800,600);
		
		//Main Window Bar
		JMenuBar menBar = new JMenuBar();
		
		//Building menuItems for file menu
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadB = new JMenuItem("Load a Roster");
		JMenuItem addB = new JMenuItem("Add Attendance");
		JMenuItem saveB = new JMenuItem("Save");
		JMenuItem plotB = new JMenuItem("Plot Data");
		
		JMenu aboutTab = new JMenu("About");
		
		//Adding items to the file menu
		fileMenu.add(loadB);
		fileMenu.add(addB);
		fileMenu.add(saveB);
		fileMenu.add(plotB);
		
		//Adding file and about tabs to menu bar
		menBar.add(fileMenu);
		menBar.add(aboutTab);
		
		//Setting main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(800,600);
		mainPanel.add(menBar);
		
		//Adding mainPanel to the main window frame
		getContentPane().add(mainPanel);
		this.setJMenuBar(menBar);
	}
	
	public void actionPerformed(ActionEvent e)
    {
		
    }
	
	public static void main(String[] args)
	{
		MainWindow window = new MainWindow();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
	}
}
