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
	Students studData;
	Students notFound;
	boolean showPlot;
	/**
	 * This method is the constructor for
	 * the data source, initializing the
	 * student list.
	 */
	public DataSource()
	{
		studData = new Students();
		notFound = new Students();
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
		
		if(unparsedStud.get(0).size() != 6)
		{
			return;
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
		
		showPlot = false;
		//Notifying changes
		setChanged();
		notifyObservers();
		
	}
	
	public void addAttendance(File inFile, Date nDate)
	{
		notFound.clearStudents();
		
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
		
		if(unparsedStud.get(0).size() != 2)
		{
			return;
		}
		else
		{
			for(int i= 0; i<unparsedStud.size();i++)
			{
				String id = unparsedStud.get(i).get(0);
				String time = unparsedStud.get(i).get(1);
				StudentAttendance att = new StudentAttendance(Integer.parseInt(time),nDate);
				int search = studData.findStudent(id);
				System.out.println(search);
				
				if(search == -1)
				{
					int misSearch = notFound.findStudent(id);
					if(misSearch == -1)
					{
						Student missingStudent = new Student("","","","","",id);	
						notFound.addStudent(missingStudent);
						notFound.addStudentAttendance(att, notFound.getStudents().size() - 1);
					}
					else
					{
						notFound.addStudentAttendance(att, misSearch);
					}
					
				}
				else
				{
					studData.addStudentAttendance(att, search);
				}
			}
		}
		
		showPlot = false;
		setChanged();
		notifyObservers();
		
	}
	
	public void showPlot()
	{
		showPlot = true;
		setChanged();
		notifyObservers();
	}
	
	public boolean getPlot()
	{
		return showPlot;
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
	
	public Students getMis()
	{
		return notFound;
	}
}
