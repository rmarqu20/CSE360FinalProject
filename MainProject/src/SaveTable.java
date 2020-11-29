import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;




public class SaveTable 
{
	
	
	public SaveTable(JTable table, File file) throws IOException 
	{
		TableModel stdTable = table.getModel();
		FileWriter out = new FileWriter(file);
		
		for(int i = 0; i < stdTable.getColumnCount(); i++) {
			out.write(stdTable.getColumnName(i) + "\t");
			
		}
		out.write("\n");
		
		for(int i = 0; i < stdTable.getRowCount(); i++) {
			for(int j = 0; i < stdTable.getColumnCount(); j++) {
				out.write(stdTable.getValueAt(i,j).toString() + "\t");
			}
			out.write("\n");
			
			
		}
		out.close();
		
		System.out.println("output:" + file);	
	}	

}
