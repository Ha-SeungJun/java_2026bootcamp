package java_20260130_utilex;

import java.util.Collections;
import java.util.List;

public class userList{
	public void showUsers(List<Player> lists) {
		Collections.sort(lists);
		System.out.println(lists);
		
		for(Player user : lists) {
			System.out.printf("id : %s, ",user.getId());
			System.out.printf("pw : %s, ",user.getPw());
			System.out.printf("name : %s, ",user.getName());
			System.out.printf("win : %d, ",user.getWin());
			System.out.printf("loss : %d, ",user.getLoss());
			System.out.printf("draw : %d,  ",user.getDraw());
			System.out.printf("Rate : %.2f",user.getRate());
			System.out.println();
		}
	}
	
}
