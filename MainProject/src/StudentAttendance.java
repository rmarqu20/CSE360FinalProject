import java.util.Date;

/**
 * This class holds a studentAttendance record containing 
 * a date and an associated attendance time
 */
public class StudentAttendance 
{
	Date date;
	int time;
	
	/**
	 * Constructor for attendance record
	 * @param nTime time value
	 * @param nDate date of attendance
	 */
	StudentAttendance(int nTime, Date nDate)
	{
		date = nDate;
		time = nTime;
	}
	
	/**
	 * Function used for adding onto the 
	 * current time value
	 * @param addTime
	 */
	void addTime(int addTime)
	{
		time += addTime; 
	}
	
	/**
	 * Accessor method for the date 
	 * object
	 * @return the date for rec
	 */
	Date getDate()
	{
		return date;
	}
	
	/**
	 * Accessor 
	 * @return the time value
	 */
	int getTime()
	{
		return time;
	}
	
}
