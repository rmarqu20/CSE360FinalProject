import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Observable;

/**
 * This class is to be used as the data source
 * which will generate observable data that can
 * change based on user actions.
 * @author 
 *
 */
public class DataSource extends Observable 
{
	public Students studData;
	
	/**
	 * This method is the constructor for
	 * the data source, initializing the
	 * student list.
	 */
	public DataSource()
	{
		studData = new Students();
	}
	
	/**
	 * This function will parse through
	 * a csv file and add to the student
	 * list, notifying observers of changes
	 * @param inFile file to be read
	 */
	public void create(File inFile)
	{
		studData.clearStudents();
		
		//List to hold info from file
		ArrayList<List<String>> unparsedStud = new ArrayList<>();
	
		try(BufferedReader buff = new BufferedReader(new FileReader(inFile)))
		{
			//Moving through file line by line
			String currentLine;
			while((currentLine = buff.readLine()) != null)
			{
				String[] parts = currentLine.split(",");
				unparsedStud.add(Arrays.asList(parts));
			}
		} 
		catch (FileNotFoundException e)
		{	
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//Adding Student objects to list using
		//unparsed list
		for(int i= 0; i<unparsedStud.size();i++)
		{
			String id = unparsedStud.get(i).get(0);
			String fn = unparsedStud.get(i).get(1);
			String ln = unparsedStud.get(i).get(2);
			String prog = unparsedStud.get(i).get(3);
			String lev = unparsedStud.get(i).get(4);
			String asu = unparsedStud.get(i).get(5);
			
			Student toAdd = new Student(id,fn,ln,prog,lev,asu);
			
			studData.addStudent(toAdd);
		}
		
		//Notifying changes
		setChanged();
		notifyObservers();
		
	}
	
	public void addAttendance(File inFile, Date nDate)
	{
		//List to hold info from file
		ArrayList<List<String>> unparsedStud = new ArrayList<>();
	
		try(BufferedReader buff = new BufferedReader(new FileReader(inFile)))
		{
			//Moving through file line by line
			String currentLine;
			while((currentLine = buff.readLine()) != null)
			{
				String[] parts = currentLine.split(",");
				unparsedStud.add(Arrays.asList(parts));
			}
		} 
		catch (FileNotFoundException e)
		{	
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Simple accessor method for 
	 * retrieving student list
	 * @return student list
	 */
	public Students getData()
	{
		return studData;
	}
}
