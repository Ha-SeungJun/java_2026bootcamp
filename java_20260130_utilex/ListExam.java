package java_20260130_utilex;

import java.util.*;

public class ListExam {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList(); //인티절 객체만 요소로 관리하겠다는 의미
		System.out.println(list.size());
		
		list.add(1);
		//list.add("이");
		list.add(3);
		list.add(0,100);
		
		Integer i = (Integer)list.get(0);
		System.out.println(list.toString()); 
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(300);
		
		list2.addAll(list);
		System.out.println(list2);
		
		System.out.println(list2.contains(3));
		
		list2.set(1, 2000);
		
		System.out.println(list2);
		
		//Player 2;
		Player p1 = new Player();
		Player p2 = new Player();
		
		p1.setId("p1");
		p1.setPw("p1234");
		p1.setName("p1p1");
		p1.setWin((int)(Math.random() * 10 +1));
		p1.setLoss((int)(Math.random() * 10 +1));
		p1.setDraw((int)(Math.random() * 10 +1));
		
		p2.setId("p2");
		p2.setPw("p1234");
		p2.setName("p2p2");
		p2.setWin((int)(Math.random() * 10 +1));
		p2.setLoss((int)(Math.random() * 10 +1));
		p2.setDraw((int)(Math.random() * 10 +1));
		
		List<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		new userList().showUsers(players);
		
		List<Integer> li = new ArrayList<Integer>();
		for (int ii = 0; ii < 5; ii++) {li.add((int)(Math.random() * 10 +1));}
		
		Collections.sort(li);
		Collections.sort(li, Collections.reverseOrder());
		
		System.out.println(li);
		
		//Arrays.sort(li);
	}
}
