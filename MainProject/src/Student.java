import java.util.ArrayList;
import java.util.Date;

/**
 * This class to be used for each student listing on the roster.
 * It contains the class definitions and methods for modifying
 * each student and all of the student's fields 
 * @author 
 *
 */
public class Student 
{
	String id;
	String firstName;
	String lastName;
	String program;
	String level;
	String asuRite;
	ArrayList <StudentAttendance> dateTimes;
	/**
	 * Constructor for the student class sets all student info
	 * @param newId the student's id to be assigned
	 * @param fName the first name of the student
	 * @param lName the last name of the student
	 * @param prog the student's educative program
	 * @param lev the student's academic level
	 * @param asu the student's asurite id
	 */
	Student(String newId,String fName,String lName,String prog,String lev,String asu)
	{
		id = newId;
		firstName = fName;
		lastName = lName;
		program = prog; 
		level = lev;
		asuRite = asu;
		dateTimes = new ArrayList <StudentAttendance>();
	}
	
	/**
	 * This function adds a new date to the date list
	 * @param nDate to be added to list
	 */
	void addDate(StudentAttendance nDate)
	{
		int searchRes = dateSearch(nDate.getDate());
		
		//New Date
		if(searchRes == -1)
		{
			dateTimes.add(nDate);
		}
		//Previous date
		else
		{
			addToDate(nDate);
		}
	}
	
	/**
	 * Adds to the time of currently existing date
	 * @param find the date to be added to
	 */
	void addToDate(StudentAttendance find)
	{
		int searchRes = dateSearch(find.getDate());
		
		dateTimes.get(searchRes).addTime(find.getTime());
	}
	
	/**
	 * Searches for the date corresponding to the
	 * entered param
	 * @param comp is the date to be seached for
	 * @return the index of the date
	 */
	int dateSearch(Date comp)
	{
		int result = -1;
		
		//Linear Search
		for(int i = 0; i < dateTimes.size();i++)
		{
			if(dateTimes.get(i).getDate().compareTo(comp) == 0)
			{
				result = i;
			}
		}
		
		return result;
	}
	
	/**
	 * Accessor function
	 * @return the student's asurite id
	 */
	String getASU()
	{
		return asuRite;
	}
	
	/**
	 * Accessor function for date count
	 * @return
	 */
	int getDateCount()
	{
		return dateTimes.size();
	}
	
	public ArrayList <StudentAttendance> getDates()
	{
		return dateTimes;
	}
	
	public int getDateTime(Date in)
	{
		int timeForDate = 0;
		int result = dateSearch(in);
		if(result != -1)
		{
			timeForDate = dateTimes.get(result).getTime();
		}
		
		return timeForDate;
	}
}
