import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * This class to be used as a scroll pane
 * for holding the Jtable as well as acting
 * as an observer of data
 * @author Agustin Gomez Arroyo
 * @author Anoop Makam
 * @author August Fowler
 * @author Gerik Swenson
 * @author Richard Marquez Cortes 
 */
public class TablePane implements Observer
{
	StudentTable studtable;
	JScrollPane pane;
	/**
	 * This function to be used as a constructor
	 * which initializes data and sets size vars
	 */
	public TablePane()
	{
		studtable = new StudentTable();
		pane = new JScrollPane();
		JTable tab = studtable.getTable();
		tab.getTableHeader().setReorderingAllowed(false);
		pane.setViewportView(tab);
		pane.setHorizontalScrollBarPolicy(
	    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setVerticalScrollBarPolicy(
	    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	/**
	 * This method to run anytime that 
	 * the observers are notified, it 
	 * updates the table based on any
	 * data changes
	 */
	@Override
	public void update(Observable obs, Object arg) 
	{
		studtable.updateInfo(((DataSource)obs).getData());
	}
}
