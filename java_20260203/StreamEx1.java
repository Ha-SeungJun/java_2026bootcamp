package java_20260203;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student implements Comparable<Student>{
	private String name;
	private int score;
	private String sex;
	
	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score);
	}
}

@Data
@AllArgsConstructor
class Product{
	private int pno;
	private String name;
	private String company;
	private int price;
	public Object stream() {
		// TODO Auto-generated method stub
		return null;
	}
}

public class StreamEx1 {
	static int sum = 0;
	public static void main(String[] args) {
//		Set<String> set = new HashSet();
//		set.add("a");
//		set.add("b");
//		set.add("c");
//		
//		for(String s : set) {
//			System.out.println(s);
//		}
//		Iterator<String> it = set.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		
//		Stream<String> stream = set.stream();
//		stream.forEach(t -> System.out.println(t));
//		
//		
//		List<Student> list = Arrays.asList(new Student("AA",10),new Student("BB",20),new Student("CC",30));
//		
//		Stream<Student> str = list.stream();
//		
//		IntStream is = str.mapToInt(student -> student.getScore());
//		OptionalDouble od = is.average();
//		
//		double avg = od.getAsDouble();
		
		List<Product> li = new ArrayList<Product>();
		for(int i = 0; i < 5; i++) {
			Product p = new Product(i, "상품" + i, "삼성", (int)(Math.random()*10000));
			li.add(p);
		}
		Stream<Product> str2 = li.stream();
		str2.forEach(t -> {System.out.printf(t.toString());
							System.out.println();});
		
		IntStream.rangeClosed(0, 100).forEach(v -> sum += v); //100 주면 100도 생성
		System.out.println(sum);
		
		List<String> lt = new ArrayList<String>();
		lt.add("홍");
		lt.add("홍1");
		lt.add("홍2");
		lt.add("홍3");
		lt.add("홍");
		
		lt.stream().distinct().forEach(t -> System.out.println(t));
		
		li.stream().filter(t->t.getPrice() > 5000).forEach(t -> System.out.println(t));
		
	}
}
