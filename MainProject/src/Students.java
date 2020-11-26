import java.util.ArrayList;
import java.util.Date;

public class Students 
{
	ArrayList<Student> students;
	ArrayList<Date> dates;
	
	Students()
	{
		students = new ArrayList<Student>();
		dates = new ArrayList<Date>();
	}
	
	public void addStudent(Student newStudent)
	{
		students.add(newStudent);
	}
	
	public void clearStudents()
	{
		students.clear();
	}
	
	public ArrayList<Student> getStudents()
	{
		return students;
	}
	
	public ArrayList<Date> getDates()
	{
		return dates;
	}
	
	public int findStudent(String asurite)
	{
		int result = -1;
		
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
	
	public void addStudentAttendance(StudentAttendance newAtt, int index)
	{
		students.get(index).addDate(newAtt);
		
		if(!dates.contains(newAtt.getDate()))
		{
			dates.add(newAtt.getDate());
		}
	}
	
	public int rowCount()
	{
		return students.size();
	}
	
	public int colCount()
	{
		
		return 6 + dates.size();
	}
}
