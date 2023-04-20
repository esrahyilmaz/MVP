package Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentDateTime {

	public static String getSystemDate() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:MM:SS");
		Date date = new Date();
		String formattedDate = formatter.format(date);
		System.out.println("Formatted Date is ::" + formattedDate);

		return formattedDate;
	}

	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		return formatter.format(date);
	}

	public static String getDateRepo() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return formatter.format(date);
	}

	public static String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss-SSS");
		Date date = new Date();
		return formatter.format(date);
	}

	public static String getTimeRepo() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		return formatter.format(date);
	}

	public static String SystemDateMMDD() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String output = sdf.format(c.getTime());
		System.out.println("Date is ::" + output);
		return output;
	}

	public static String SystemDateDay() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String output = sdf.format(c.getTime());
		return output;
	}

	public static String SystemDateMonth() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String output = sdf.format(c.getTime());
		return output;
	}

	public static String SystemDateMonth1() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String output = sdf.format(c.getTime());
		return output;
	}

	public static String SystemDateMonth2() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("M");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String output = sdf.format(c.getTime());
		return output;
	}

	public static String SystemDateYear() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String output = sdf.format(c.getTime());
		return output;
	}

	public static String addDaysToSystemDate(String Days) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int day = Integer.parseInt(Days);
		c.setTime(new Date());
		c.add(Calendar.DATE, day);
		String output = sdf.format(c.getTime());
		return output;
	}

	public static String getDateComp() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		Date date = new Date();
		System.out.println(formatter.format(date));
		String Today = formatter.format(date);
		return Today;
	}

	public static Date dayBeforeyesterday() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		return cal.getTime();
	}

	public static String geDayBeforetYesterdayDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		return dateFormat.format(dayBeforeyesterday());
	}

	public static String geDayBeforetYesterdayDate1() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(dayBeforeyesterday());
	}

	public static String getNextYear() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		return dateFormat.format(dayBeforeyesterday());
	}

	public static String getOrderConfirmationDate() {
		DateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
		String Today = formatter.format(date);
		return Today;
	}
	
	public static void main(String[] args) {
		String date = getOrderConfirmationDate();
		System.out.println(date);
	}

}
