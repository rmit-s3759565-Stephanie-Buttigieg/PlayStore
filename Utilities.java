import java.util.Calendar;
import java.util.HashMap;

public class Utilities {

	// get map size
	public int GetMapSize(HashMap mapName) {
		return mapName.size();
	}


	// get today's date
	public String getToday() {
		int day		= Calendar.getInstance().get(Calendar.DATE);
		int month	= Calendar.getInstance().get(Calendar.MONTH);
		int year	= Calendar.getInstance().get(Calendar.YEAR);
		
		return String.format("%02d/%02d/%04d", day, month + 1, year);
	}
	
	
	// method will pad string s with char c repeated n times
	// until length of string is i
	public String padStr(String userString, char fillChar, int newLen) {
		
		int 	fillLen	= newLen - userString.length();
		char[]	addChar	= new char[fillLen];

		for (int i = 0; i < fillLen; i++ ) {
			addChar[i] = fillChar;
		}
			
		String	addStr	= new String(addChar);

		return userString += addStr;
	}


	public String getReportFooter() {
		return padStr("", '-', 155);
	}


	public String getReportHeader() {
		
		String str = "";
		
		str = padStr("", '-', 155) + "\n" 
				+ "Id\t" + padStr("Name", ' ', 30) + "\t" 
				+ "Downloads\tPrice\t" + padStr("OS / Publisher", ' ', 30) + "\tPages\tAuthors / Issue No\n" +
				padStr("", '-', 155);

		return str;
	}
}
