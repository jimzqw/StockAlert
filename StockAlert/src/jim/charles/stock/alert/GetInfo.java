package jim.charles.stock.alert;

public class GetInfo 
{
	private static String email;
	private static String phoneNumber;
	private static String name;
	private static String userPrice;
	private static String symbol;

	/**
	 * @return the email
	 */
	public static String getEmail() 
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public static void setEmail(String email) 
	{
		GetInfo.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public static String getPhoneNumber() 
	{
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public static void setPhoneNumber(String phoneNumber) 
	{
		GetInfo.phoneNumber = phoneNumber;
	}

	/**
	 * @return the name
	 */
	public static String getName() 
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public static void setName(String name) 
	{
		GetInfo.name = name;
	}

	/**
	 * @return the price
	 */
	public static String getUserPrice() 
	{
		return userPrice;
	}

	/**
	 * @param price the price to set
	 */
	public static void setUserPrice(String price) 
	{
		GetInfo.userPrice = price;
	}

	/**
	 * @return the symbol
	 */
	public static String getSymbol() 
	{
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public static void setSymbol(String symbol) 
	{
		GetInfo.symbol = symbol;
	}
}
