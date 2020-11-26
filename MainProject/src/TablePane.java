import java.util.Observable;
import java.util.Observer;
import javax.swing.JScrollPane;

public class TablePane extends JScrollPane implements Observer
{
	StudentTable table;
	
	public TablePane()
	{
		
	}

	@Override
	public void update(Observable obs, Object arg) 
	{
		
	}
}
