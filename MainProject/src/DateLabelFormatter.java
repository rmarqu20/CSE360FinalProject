import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter
{
	
	String datePattern = "dd/MM/yyyy";
    SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    
	@Override
	public Object stringToValue(String words) throws ParseException 
	{
		
		return dateFormatter.parseObject(words);
	}

	@Override
	public String valueToString(Object num) throws ParseException 
	{
		if (num != null) 
		{
            Calendar cal = (Calendar) num;
            return dateFormatter.format(cal.getTime());
        }

        return "";
	}

}
