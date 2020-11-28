import java.util.ArrayList;
import java.util.Date;

/**
 * This class is to be used as collection of student objects
 * as well as the unique dates associated with each collection
 * Functions to modify data also included
 * @author 
 *
 */
public class Students 
{
	//Student and Date Lists
	ArrayList<Student> students;
	ArrayList<Date> dates;
	
	/**
	 * This method is the constructor and it
	 * initializes both student and date lists
	 */
	Students()
	{
		students = new ArrayList<Student>();
		dates = new ArrayList<Date>();
	}
	
	/**
	 * This method to be used to add a student
	 * to collection
	 * @param newStudent new student to be added
	 */
	public void addStudent(Student newStudent)
	{
		students.add(newStudent);
	}
	
	/**
	 * This function to be used in order to clear
	 * both collection lists
	 */
	public void clearStudents()
	{
		students.clear();
		dates.clear();
	}
	
	/**
	 * This function to be used in order to 
	 * access the student objects
	 * @return the student list collection
	 */
	public ArrayList<Student> getStudents()
	{
		return students;
	}
	
	/**
	 * This method to be used in order to
	 * access the date objects
	 * @return a list of dates
	 */
	public ArrayList<Date> getDates()
	{
		return dates;
	}
	
	/**
	 * This function to be used in order
	 * to search collection for a student
	 * and return the index
	 * @param asurite of searched student
	 * @return the index of the student
	 */
	public int findStudent(String asurite)
	{
		//Returns -1 if not found
		int result = -1;
		
		//Linear list search
		for(int i = 0; i <students.size();i++)
		{
			if(students.get(i).getASU().compareTo(asurite) == 0)
			{
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * This function to add to a student's
	 * attendance list
	 * @param newAtt the new attendance object
	 * @param index the index of the student to be added to
	 */
	public void addStudentAttendance(StudentAttendance newAtt, int index)
	{
		students.get(index).addDate(newAtt);
		
		if(!dates.contains(newAtt.getDate()))
		{
			dates.add(newAtt.getDate());
		}
	}
	
	public void addUniqueDate(Date uDate)
	{
		if(!dates.contains(uDate))
		{
			dates.add(uDate);
		}
	}
	
	/**
	 * Accessor method for count of rows
	 * @return the number of rows
	 */
	public int rowCount()
	{
		return students.size();
	}
	
	/**
	 * Accessor method for returning
	 * the number of columns
	 * @return
	 */
	public int colCount()
	{
		
		return 6 + dates.size();
	}
}
