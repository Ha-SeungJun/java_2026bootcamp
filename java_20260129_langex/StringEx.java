package java_20260129_langex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;

public class StringEx {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "hello";
		String b = "hello";
		
		System.out.println(a==b);
		
		String c = new String("hello");
		System.out.println(a == c);
		
		String dft = new String();
		byte[] bs = {49,50,51};
		
		dft = new String(bs);
		System.out.println(dft);
		
		dft = new String(bs, 0, 2, "EUC-KR");
		System.out.println(dft);
		
		Charset cset = Charset.defaultCharset();
		System.out.println(cset.toString());
		
		char[] cc = {'t','e','s','t'};
		String ccc = new String(cc);
		System.out.println(ccc);
		
		String ccc2 = new String(cc,1,2);
		System.out.println(ccc2);
		
		System.out.println(ccc2.contains("e"));
		
		System.out.println(c.equals(a));
		System.out.println(Arrays.toString("안녕 오늘도 같은 자리 같은 창가에 기대 앉은 네게 인사를 해 hi".getBytes()));
		
		bs = new byte[] {
				-20, -107, -120, -21, -123, -107, 32, -20, -104, -92, 
				 -21, -118, -104, -21, -113, -124, 32, -22, -80, -103, 
				 -20, -99, -128, 32, -20, -98, -112, -21, -90, -84, 32, 
				 -22, -80, -103, -20, -99, -128, 32, -20, -80, -67, -22, 
				 -80, -128, -20, -105, -112, 32, -22, -72, -80, -21, -116, -128, 32, 
				 -20, -107, -119, -20, -99, -128, 32, -21, -124, -92, -22, -78, -116, 
				 32, -20, -99, -72, -20, -126, -84, -21, -91, -68, 32, -19, -107, -76, 
				 32, 104, 105};
		
		String bstr = new String(bs);
		System.out.println(bstr);	
		
		//email 을 변수에 담아 @ 을 기준으로 id 분리하고 char 배열로 변환해서 그것의 길이와, 값을 출력하기 > java_quiz 패키지 4번으로  
		
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println("내부 버퍼 크기 : " + sb.capacity());
		
		sb.append("world");
		sb.insert(1, "h");
		sb.delete(0, 3);
		
		System.out.println(sb);
		
		sb.insert(sb.indexOf("o")+1, " ");
		System.out.println(sb);
		
		//sb 객체 값을 Strig 객체로 생성
		String Ssb = new String(sb);
		System.out.println(Ssb);
		
		byte[] bytearr = {'a','b','c','d','e'};
		byte[] bytearr2 = {'f','g','h','i','j'};
		
		System.arraycopy(bytearr, 0, bytearr2, 0, bytearr.length);
		 
		String bstr2 = new String(bytearr2);
		System.out.println(bstr2);
		
		System.out.println(new Date(System.currentTimeMillis()));
		
		//java 강제 종료 메서드
		// System.exit(0);
		
		//wrapper class
		//java 에서 사용하는 모든 Ptype 을 클래스로 정의한 클래스
		//이 클래스를 이용하면 피타입에 관련된 많은 정보를 손쉽게 얻을 수 있다.
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.compare(-2, 0));
		
		int i = 10;
		System.out.println(Integer.valueOf(i).floatValue());
		System.out.println(Integer.parseInt("10"));
		
		String pass = "AasADF1dx";
		int digitcnt = 0;
		int digiacnt = 0;
		
		for(int ii = 0; ii < pass.length(); ii++) {
			char ch = pass.charAt(ii);
			if(Character.isUpperCase(ch)) digitcnt++;
			else if(Character.isDigit(ch)) digiacnt++;
		}
	}
}
