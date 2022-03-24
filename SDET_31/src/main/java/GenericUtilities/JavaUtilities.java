package GenericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * this library is used for Java related methods
 * @author Ramya
 *
 */
public class JavaUtilities {
	/**
	 * used to generate random numbers and append with any excel value/text
	 * @return
	 */
	public int randomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(10000);
		return randomNum;
	}
	/**
	 * used to get system Date and time
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString().replaceAll(":", "-");
	}
	
	public String getSystemDateAndTimeWithFormat() {
		Date date = new Date();
		String dateAndTime = date.toString();
		
		String YYYY = dateAndTime.split(" ")[5];
		
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		
		return finalFormat;

	}
	
}
