import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.table.*;

/**
 * This class to be used to save the currently
 * loaded attendance and dates into a csv file
 * @author Agustin Gomez Arroyo
 * @author Anoop Makam
 * @author August Fowler
 * @author Gerik Swenson
 * @author Richard Marquez Cortes 
 */
public class SaveTable
{
	public SaveTable(JTable table, File file) throws IOException 
	{
		
		try {
				TableModel stdTable = table.getModel();
				System.out.println(stdTable.getColumnCount() + " " + stdTable.getRowCount() );
				FileWriter out = new FileWriter(file);
				
				for(int i = 0; i < stdTable.getColumnCount() ; i++) {
					
					out.write(stdTable.getColumnName(i) + ",");
					
				}
				out.write("\n");
				
				for(int i = 0; i < stdTable.getRowCount(); i++) {
					for(int j = 0; j < stdTable.getColumnCount(); j++) {
						
						out.write(stdTable.getValueAt(i,j).toString() + ",");
					}
					out.write("\n");	
				}
				out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
