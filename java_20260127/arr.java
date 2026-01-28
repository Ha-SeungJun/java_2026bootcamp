package java_20260127;

import java.util.Arrays;

public class arr {
	public static void main(String[] args) {
		int intArr[] = new int[4];
		double douArr[] = {1,2,3};
		String strArr[] = new String[] {"A","B","C"};
		
		System.out.println(strArr);
		System.out.println(Arrays.toString(strArr));
		
		for(int i = 0 ; i < 3; i++) {
			System.out.println(douArr[i]);
		}
		
		System.out.println(intArr);
		
		for(String str : strArr) {
			System.out.println(str);
		}
		
		System.out.println(strArr[strArr.length-1]);
		
		
		
		//다중 배열
		int[] multi[] = new int[2][3];
		multi[0][0] = 10;
		multi[1][0] = 50;
		
		
	}
}
