import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 * This class to be used to generate a table based
 * the current student info
 * @author Agustin Gomez Arroyo
 * @author Anoop Makam
 * @author August Fowler
 * @author Gerik Swenson
 * @author Richard Marquez Cortes 
 */
public class StudentTable
{	
	//Table and student info list
	JTable table;
	Students studentInfo;
	
	/**
	 * Constructor sets size vars and 
	 * Initialized table
	 */
	StudentTable()
	{
		studentInfo = new Students();
		table = new JTable()
		{
			 public boolean getScrollableTracksViewportWidth() 
			 {
				   return getPreferredSize().width < getParent().getWidth();
			 }
		};
	}
	
	/**
	 * This function will generate the table
	 * by iterating through the student info
	 * and generating columns and rows
	 */
	public void generateTable()
	{
		String[] months = {"Jan","Feb", "Mar", "Apr", "May","Jun","Jul","Aug","Sep", "Oct", "Nov","Dec"};
		String[] columns = new String[studentInfo.colCount()];
		ArrayList <Date> dates = studentInfo.getDates();
		DefaultTableModel currentModel = (DefaultTableModel) table.getModel();
		
		//Pre defined columns
		columns[0] = "ID";
		columns[1] = "First Name";
		columns[2] = "Last Name";
		columns[3] = "Program";
		columns[4] = "Level";
		columns[5] = "ASURITE";
		
		//In the case of added Dates
		if(columns.length > 6)
		{	 
			 for(int i = 0; i < dates.size(); i++)
			 {
				 String fmtDat;
				 Date dat = dates.get(i);
				 String monthFmt = months[dat.getMonth()];
				 String dayFmt = Integer.toString(dat.getDate());
				 
				 fmtDat = monthFmt + " " + dayFmt;
				 
				 columns [6 + i] = fmtDat;
			 }
		}
		
		//Data for each row
		Object[][] data = new Object[studentInfo.rowCount()][columns.length];
		
		//Building each row of data
		for(int i = 0; i< studentInfo.rowCount();i++)
		{
			Student currentStudent = studentInfo.getStudents().get(i);
			
			data[i][0] = currentStudent.id;
			data[i][1] = currentStudent.firstName;
			data[i][2] = currentStudent.lastName;
			data[i][3] = currentStudent.program;
			data[i][4] = currentStudent.level;
			data[i][5] = currentStudent.asuRite;
			
			for(int j = 0; j < dates.size(); j++)
			{
				data[i][6 + j] = currentStudent.getDateTime(dates.get(j));
			}
		}
		currentModel.setRowCount(0);
		currentModel.setColumnCount(0);
		currentModel.setDataVector(data, columns);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	/**
	 * This method regenerates the table based
	 * on new data
	 * @param newInf is the data to be changed
	 */
	public void updateInfo(Students newInf)
	{
		studentInfo = newInf;
		generateTable();
	}
	
	/**
	 * An accessor method for returning the table
	 * @return the table object
	 */
	public JTable getTable()
	{
		return table;
	}
}
