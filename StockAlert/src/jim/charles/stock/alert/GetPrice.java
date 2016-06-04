package jim.charles.stock.alert;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class GetPrice 
{
	
	
	/**
	 * 
	 * @return the price of stock as a String
	 * uses getSymbol of the GetInfo class
	 * to look up the stock  
	 */
	public static String price()
	{
		try
		{
			Stock stock = YahooFinance.get(GetInfo.getSymbol());
			return stock.getQuote(true).getPrice().toString();
			
		}
		catch (IOException e) 
		{
			throw new RuntimeException(e);
			
		}
	}
	
	
}