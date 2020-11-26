import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JScrollPane;

/**
 * This class to be used as a scroll pane
 * for holding the Jtable as well as acting
 * as an observer of data
 * @author 
 *
 */
public class TablePane extends JScrollPane implements Observer
{
	StudentTable studtable;
	
	/**
	 * This function to be used as a constructor
	 * which initializes data and sets size vars
	 */
	public TablePane()
	{
		studtable = new StudentTable();
		this.setViewportView(studtable.getTable());
		this.setPreferredSize(new Dimension (750,300));
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
