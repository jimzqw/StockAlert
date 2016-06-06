package jim.charles.stock.alert;

import java.util.Timer;
import java.util.TimerTask;

public class Helper 
{
	
	/**
	 * Refresh every ten minutes 
	 * to check if current stock price 
	 * meets target stock price
	 * if stock current stock price hits target price,
	 * an alert will be sent to user
	 */
	public Helper()
	{
		while (helpHelper())
		{
			tenMinTimer();
		}
	}

	
	
	/**
	 * 
	 * @return false if stock current price meets target price
	 * and send an alert to the user
	 * return true if stock current price does not meet target price
	 */
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

	
	/**
	 * Will run helpHelper to check 
	 * current price in MINUTES minutes
	 * this case MINUTES is 10
	 * can be changed based on requirement
	 */
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

	
	/**
	 * 
	 * @return alert message with stock symbol and stock price as a string
	 * will be sent when stock current price hits target price 
	 */
	private String alertMessage()
	{
		return "Hello, Stock Alert here,\n We are informing you that "
				+ GetInfo.getSymbol() + " has reached "
				+ GetInfo.getUserPrice() + "\n Thanks again for using Stock Alert!";
	}
}

