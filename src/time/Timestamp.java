package time;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//@Elinor

public class Timestamp  {
	private static String stringdate;
	private static Date datedate;
	
	public static void main(String[]args) throws ParseException{
		System.out.println(convert(getTimeNow()));
	}
	public static Date getTimeNow() {
		datedate = new Date();
		datedate.setTime(System.currentTimeMillis());// the number of milliseconds that have passed since January 1, 1970 00:00:00.000 GMT, dette er et date obj
		return datedate;
	}

	public static String convert(Date indputDate) throws ParseException {
		SimpleDateFormat datFormat = new SimpleDateFormat("d MMM yyyy HH:mm:ss, z"); // formatet datoen skal vises i
		stringdate = datFormat.format(indputDate);// convetere et date obj til en string i angivet format(datFormat obj's format)
		return  stringdate;
		
		
	}
	
}