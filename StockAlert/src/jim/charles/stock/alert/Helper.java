package jim.charles.stock.alert;

import java.util.Timer;
import java.util.TimerTask;

public class Helper 
{
	public Helper()
	{
		while (helpHelper())
		{
			tenMinTimer();
		}
	}

	private boolean helpHelper()
	{
//		System.out.println("user price -> " + GetInfo.getUserPrice());
//		System.out.println("stock price -> " + GetPrice.price());
//		System.out.println(GetInfo.getUserPrice().equals(GetPrice.price()));
		if (GetInfo.getUserPrice().equals(GetPrice.price()))
		{
			Email.sendEmail(GetInfo.getEmail(), alertMessage());
			return false;
		}
		else return true;
	}

	private void tenMinTimer()
	{
		int MINUTES = 10; // The delay in minutes
		Timer timer = new Timer();
		timer.schedule(new TimerTask() 
		{
			@Override
			// runs every MINUTES minutes.
			public void run() 
			{
				helpHelper();
			}
		}, 0, 1000 * 60 * MINUTES);
		// 1000 milliseconds in a second * 60 per minute * the MINUTES variable. 
	}

	private String alertMessage()
	{
		return "Hello, Stock Alert here,\n We are informing you that "
				+ GetInfo.getSymbol() + " has reached "
				+ GetInfo.getUserPrice() + "\n Thanks again for using Stock Alert!";
	}
}

