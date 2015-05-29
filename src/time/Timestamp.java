package time;

// @Elinor M.

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp
{
	private static String stringdate;
	private static Date datedate;

	public Timestamp()
	{

	}

	public static Date getTimeNow()
	{
		datedate = new Date();
		datedate.setTime(System.currentTimeMillis());// the number of
														// milliseconds that
														// have passed since
														// January 1, 1970
														// 00:00:00.000 GMT,
														// dette er et date obj
		return datedate;
	}

	public static String convert(Date indputDate)
	{
		SimpleDateFormat datFormat = new SimpleDateFormat("d MMM yyyy HH:mm:ss"); // formatet
																					// datoen
																					// skal
																					// vises
																					// i
		stringdate = datFormat.format(indputDate);// convetere et date obj til
													// en string i angivet
													// format(datFormat obj's
													// format)
		return stringdate;

	}

	public static String convertDateSql(java.sql.Timestamp dateSql)
	{
		Date datedate = new Date(dateSql.getTime());
		return convert(datedate);
	}

}