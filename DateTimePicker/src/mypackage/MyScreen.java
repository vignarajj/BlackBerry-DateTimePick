package mypackage;

import java.util.Calendar;
import java.util.Date;
import net.rim.device.api.i18n.SimpleDateFormat;
import net.rim.device.api.ui.UiApplication;
//import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.picker.DateTimePicker;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class MyScreen extends MainScreen
{
	/**
	 * Creates a new MyScreen object
	 */
	Calendar calendar;
	public MyScreen()
	{        
		// Set the displayed title of the screen       
		final DateTimePicker dateTimePicker = DateTimePicker.createInstance(Calendar.getInstance(), "MMM dd,yyyy","hh:mm a");
		calendar = Calendar.getInstance();   
		UiApplication.getUiApplication().invokeLater(new Runnable() 
		{              
			public void run()
			{ 
				if(dateTimePicker.doModal()) 
				{
					calendar = dateTimePicker.getDateTime();
					Date date = calendar.getTime();
					long longDate = date.getTime();
					SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy: hh:mm:a");
					String eventstring = dateFormat.format(date);
					add(new LabelField("Selected Date & Time is "+eventstring));
					//            Dialog.inform("You have selected time =="+eventstring);    
				}
			}
		});
	}
}
