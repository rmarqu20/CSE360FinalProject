import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class to be used to generate a scatter plot
 * using student attendance information
 * @author Agustin Gomez Arroyo
 * @author Anoop Makam
 * @author August Fowler
 * @author Gerik Swenson
 * @author Richard Marquez Cortes 
 */
public class DataPlot extends JPanel implements Observer
{
	Students stud;
	/**
	 *  Creates graph object 
	 */
	public void ScatterPlot()
	{
		XYDataset dataset = createDataset();
		//pull dataset from student attendance
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Attendance Data per Student","% Attendance","Amount of Students",dataset);
		//create plot
		XYPlot plot = (XYPlot)chart.getPlot(); 
		plot.setBackgroundPaint(new Color(211,211,211));
		NumberAxis domain = (NumberAxis) plot.getDomainAxis();
		domain.setRange(0, 100);
		
		NumberAxis range = (NumberAxis) plot.getRangeAxis();
		ArrayList<Student> studList = stud.getStudents();
		int yRange = studList.size();
		range.setRange(0, yRange);
		
		//create panel
		ChartPanel panel = new ChartPanel(chart);
		this.removeAll();
		this.add(panel);
	}
	/**
	 * This class uses other methods to pull percent and dates 
	 * and adds them to a series as plot points
	 * @returns dataset taken in from the students objects
	 */
	private XYDataset createDataset() 
	{
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		ArrayList<Student> studList = stud.getStudents();
		ArrayList<Date> dates = stud.getDates();
		
		//int listSize = studList.size();
		int datesSize = dates.size();; 
		
		ArrayList<XYSeries> arrSeries = new ArrayList<XYSeries>();
		XYSeries tempSeries = null;
		int[][] percDate = makePercChart(studList);
		int[][] perc30Date = getCount(percDate);
		
		for(int i = 0; i < datesSize; i++) //iterate dates
		{
			arrSeries.add(new XYSeries(prettyString(dates.get(i))));
			tempSeries = arrSeries.get(i);
			//iterate through students to see freq of %
			for(int j = 0; j <= 100; j++) 
			{
				if(perc30Date[j][i] != 0)
				{
					tempSeries.add(j,perc30Date[j][i]);			//add in % at date
				}
			}
			dataset.addSeries(tempSeries); //add series to graph
		}
	    return dataset;
	}
	/**
	 * function that converts dates to correctly formatted strings
	 * @param i is the date pulled from arrayList dates
	 * @return string month + day
	 */
	@SuppressWarnings("deprecation")
	public String prettyString(Date i)
	{
		String day = Integer.toString(i.getDate());
		//array of months based on number passed in
		String[] months = {"Jan","Feb", "Mar", "Apr", "May","Jun",
				"Jul","Aug","Sep", "Oct", "Nov","Dec"}; 
		
		return months[i.getMonth()] + " " + day;	
	}
	
	
	public double getPercent(int time)
	{
		double perc = ((double)time)/75; //attendance out of 75 min
		if(perc >= 1.0) //if student has over time
		{
			perc = 1;
		}
		perc *= 100; //multiply by 100 for %
		return perc;
	}
	/**
	 * returns percentage attendance with the dates accordingly
	 * @param studList containing dates and the minutes that each student
	 * 		  attended class for
	 * @return twoD_arr contains a chart of percentages for each student on each date
	 */
	public int[][] makePercChart(ArrayList<Student> studList)
	{
		ArrayList<Date> dates = stud.getDates(); //get dates 
		int[][] twoD_arr = new int[studList.size()][dates.size()]; //create 2d array of stud size and amount of dates
		
		for(int i = 0; i < dates.size(); i++) //iterate through dates
		{
			for(int j = 0; j < studList.size(); j++) //iterates through students
			{
				double perc = getPercent(studList.get(j).getDateTime(dates.get(i))); //create percent for student at date		
				//System.out.println("double perc test: " + perc);
				twoD_arr[j][i] = (int)perc; //add percent to 2d array
			}			
		}	
		return twoD_arr;		
	}
	
	/**
	 * takes in a 2D array and takes count for each %
	 * @param twoD_arr hold the percent attendance for each student
	 * 		  takes count of each percent that shows up
	 * @return counts for each percent
	 */
	public int[][] getCount(int[][] twoD_arr)
	{
		ArrayList<Student> studList = stud.getStudents();
		ArrayList<Date> dates = stud.getDates();
		int[][] counts = new int[101][dates.size()];
		
		for(int i = 0; i < dates.size(); i++) //iterate through all dates
		{
			for(int j = 0; j <= 100; j++) //look for every possible %
			{
				for(int k = 0; k < studList.size();k++) //iterate through all students
				{
					if(j == twoD_arr[k][i]) //if match
					{
						counts[j][i] += 1; //increase count for a %
					}
				}				 
			}			
		}	
		return counts;		
	}
	
	/**
	 * updates data every time the plot dropdown is clicked under "file"
	 */
	@Override
	public void update(Observable obs, Object arg) 
	{
		stud = ((DataSource)obs).getData();

		if(((DataSource)obs).getPlot())
		{
			ScatterPlot();
		}
	}
}
