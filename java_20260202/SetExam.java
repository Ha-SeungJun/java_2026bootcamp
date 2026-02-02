package java_20260202;

import java.util.*;

class mycls{
	public String name;
	public int age;
	
	public mycls(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode() + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof mycls target) {
			return target.name.equals(name) && (target.age == age);
	}else {
		return false;
	}
}
	}

public class SetExam {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("java");
		set.add("jdbc");
		set.add("jsp");
		set.add("java");
		set.add("spring boot");
		
		System.out.println(set.size());
		
		set.clear();
		
		mycls my1 = new mycls("홍",30);
		mycls my2 = new mycls("김",35);
		mycls my3 = new mycls("홍",30);
		
		HashSet<mycls> set2 = new HashSet<mycls>();
		
		set2.add(my1);
		set2.add(my2);
		set2.add(my3);
		System.out.println(set2.size());
		
		for(mycls e : set2) {
			System.out.println(e);
		}
		
		Iterator<mycls> iterator = set2.iterator();
		
		while(iterator.hasNext()) {
			mycls m = iterator.next();
			System.out.println(m.name);
			System.out.println(m.age);
		}
		
		ArrayList<mycls> mylist = new ArrayList<mycls>(set2);
		for(mycls ml : mylist) {
			System.out.println(ml.name);
		}
	}
}
