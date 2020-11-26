import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * This class is used to define the bar
 * for the main Window, containing
 * buttons for different actions
 */
public class MainMenuBar extends JMenuBar
{
	
	public MainMenuBar()
	{	
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
		this.add(fileMenu);
		this.add(aboutTab);
	}
}
