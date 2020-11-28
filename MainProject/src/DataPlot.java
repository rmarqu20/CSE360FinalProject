import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public abstract class DataPlot extends JFrame implements Observer
{
	//private static final long serialVersionUID = 6294689542092367723L;
	Students stud;
	
	public void ScatterPlot(String title)
	{
		//super(title);
		XYDataset dataset = createDataset();
		//pull dataset from student attendance
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Attendance Data per Student","X-Axis","Y-Axis",dataset);
		
		XYPlot plot = (XYPlot)chart.getPlot(); 
		plot.setBackgroundPaint(new Color(0,0,0));
		
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}
	
	private XYDataset createDataset() 
	{
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		ArrayList<Student> studList = stud.getStudents();
		ArrayList<Date> dates = stud.getDates();
		
		int listSize = studList.size();
		int datesSize = dates.size();
		int studCount;
		int percCount = 0;
		int temp; 
		
		
		ArrayList<XYSeries> arrSeries = new ArrayList<XYSeries>();
		
		for(int i = 0; i < datesSize; i++)
		{
			arrSeries.add(new XYSeries(prettyString(dates.get(i))));
			
			for(int j = 0; j < listSize; j++)
			{
				//series1.add(i, j);
			}
		}
		
	    //example
	    XYSeries series2 = new XYSeries("Date2");
	    series2.add(1, 72.5);  
	    series2.add(2, 80.1);  
	    series2.add(3, 87.2);  
	    series2.add(4, 94.5);  
	    series2.add(5, 101.4);  
	    series2.add(6, 107.4);  
	    series2.add(7, 112.8);  
	    series2.add(8, 118.2);  
	    series2.add(9, 122.9);  
	    series2.add(10, 123.4); 
	    
	    dataset.addSeries(series2); //how to add series to collection
	    
	    return dataset;
	}
	
	//function that converts dates to correctly formatted strings
	@SuppressWarnings("deprecation")
	public String prettyString(Date i)
	{
		String day = Integer.toString(i.getDay());
		
		if(i.getMonth() == 1)
		{
			return "Jan " + day;
		}
		if(i.getMonth() == 2)
		{
			return "Feb " + day;
		}
		if(i.getMonth() == 3)
		{
			return "Mar " + day;
		}
		if(i.getMonth() == 4)
		{
			return "Apr " + day;
		}
		if(i.getMonth() == 5)
		{
			return "May " + day;
		}
		if(i.getMonth() == 6)
		{
			return "Jun " + day;
		}
		if(i.getMonth() == 7)
		{
			return "Jul " + day;
		}
		if(i.getMonth() == 8)
		{
			return "Aug " + day;
		}
		if(i.getMonth() == 9)
		{
			return "Sep " + day;
		}
		if(i.getMonth() == 10)
		{
			return "Oct " + day;
		}
		if(i.getMonth() == 11)
		{
			return "Nov " + day;
		}
		if(i.getMonth() == 12)
		{
			return "Dec " + day;
		}
		return null;	
	}
	
	//returns percentage attendance
	public double getPercent(int time)
	{
		double perc = time/75;
		if(perc >= 1.0)
		{
			perc = 1;
		}
		perc *= 100;
		return perc;
	}
	
	@Override
	public void update(Observable obs, Object arg) 
	{
		stud = ((DataSource)obs).getData();
	}
}
