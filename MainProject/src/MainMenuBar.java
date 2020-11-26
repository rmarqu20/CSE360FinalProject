import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * This class is used to define the bar
 * for the main Window, containing
 * buttons for different actions
 */
public class MainMenuBar extends JMenuBar
{
	JMenu fileMenu;
	JMenuItem loadB;
	JMenuItem addB;
	JMenuItem saveB;
	JMenuItem plotB;
	JMenu aboutTab;
	
	public MainMenuBar()
	{	
		//Building menuItems for file menu
		fileMenu = new JMenu("File");
		loadB = new JMenuItem("Load a Roster");
		addB = new JMenuItem("Add Attendance");
		saveB = new JMenuItem("Save");
		plotB = new JMenuItem("Plot Data");
		
		aboutTab = new JMenu("About");
		
		//Adding items to the file menu
		fileMenu.add(loadB);
		fileMenu.add(addB);
		fileMenu.add(saveB);
		fileMenu.add(plotB);
		
		//Adding file and about tabs to menu bar
		this.add(fileMenu);
		this.add(aboutTab);
	}
	
	/**
	 * This function to be used to 
	 * associate listeners with
	 * the menu object items
	 * @param list
	 */
	public void addListener(ActionListener list)
	{
		loadB.addActionListener(list);
	}
}
