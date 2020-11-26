import javax.swing.JTable;

public class StudentTable extends JTable
{	
	Students studentInfo;
	
	StudentTable()
	{
		studentInfo = new Students();
	}
	
	public void generateTable()
	{
		
	}
	
	public void updateInfo(Students newInf)
	{
		studentInfo.clearStudents();
		studentInfo = newInf;
		
		generateTable();
	}
}
