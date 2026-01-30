package java_20260130_utilex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArraysExam {
	public static void main(String[] args) {
		int arr[] = {0,0,0,0,0};
		
		for(int i = 0; i < 5; i++) {
			int rand = (int) (Math.random() * 10 + 1);
			arr[i] = rand;
		}
		
		for(int ar:arr) {
			System.out.printf("%d ",ar);
		}
		System.out.println();
		Arrays.sort(arr);
		
		//toString 써도됨
		for(int ar:arr) {
			System.out.printf("%d ",ar);
		}
		//toStirng
		System.out.println(Arrays.toString(arr));
		
		//===========================================================
		Pattern pa = Pattern.compile("s[a-z]*");
		Matcher ma = null;
		
		ma = pa.matcher("super");
		System.out.println(ma.matches());
	}
}
