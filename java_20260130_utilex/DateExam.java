package java_20260130_utilex;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateExam {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
		String formatDate = sdf.format(now);
		System.out.println(formatDate);
		
		Calendar cNow = Calendar.getInstance();
		//System.out.println(cNow);
		
		//System.out.println(cNow.get(Calendar.YEAR));
		//System.out.println(cNow.get(Calendar.WEEK_OF_MONTH));
		//System.out.println(cNow.get(Calendar.WEEK_OF_YEAR));
		//System.out.println(cNow.get(Calendar.DAY_OF_YEAR));
		
		Calendar cris = Calendar.getInstance();
		cris.set(2026, 11, 25);
		
		System.out.println(cris.get(Calendar.DAY_OF_YEAR) - cNow.get(Calendar.DAY_OF_YEAR));
		
		
		//----------------------------------------------------------------------------------
		Date dt = cNow.getTime();
		System.out.println(dt);
		
		SimpleDateFormat date = new SimpleDateFormat("현재 시간은 a hh시 mm분 ss초 입니다. ");
		String CNOW = date.format(dt);
		
		System.out.println(CNOW);
	}
}
