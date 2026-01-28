package java_quiz;

import javax.swing.JOptionPane;

class game{
	private String user;
	private String bot;
	int win = 0, lose = 0, draw = 0;
	int rand;
	public game() {
		this.user = "가위";
	}
	public game(String user) {
		this.user = user;
	}
	
	public void rand_and_change(String user) {
		rand = (int) (Math.random() * 3 + 1);
		
		if (rand == 1) this.bot = "가위";
		else if (rand == 2) this.bot = "바위";
		else if (rand == 3) this.bot = "보";

		if (user.equals("1")) this.user = "가위";
		else if (user.equals("2")) this.user = "바위";
		else if (user.equals("3")) this.user = "보";
	}
	
	public void game_start(){
		if (user.equals(bot)) {
			System.out.printf("컴 : %s, 당신 : %s \n무승부 입니다\n", bot, user);
			draw++;
		} else if ((user.equals("가위") && bot.equals("보"))
				|| (user.equals("바위") && bot.equals("가위"))
				|| (user.equals("보") && bot.equals("바위"))) {
			System.out.printf("컴 : %s, 당신 : %s \nUser 승리!\n", bot, user);
			win++;
		} else {
			System.out.printf("컴 : %s, 당신 : %s \n컴 승리!\n", bot, user);
			lose++;
		}
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public void Rate() {
		double total = win + lose + draw;
		double winRate = (win / total) * 100;

		System.out.printf("승리 : %d, 패배 : %d, 무승부 : %d\n승률 : %.2f%%", win, lose, draw, winRate);
	}
}


public class quiz_3 {
	//가위바위보 클래스로 
	public static void main(String[] args) {
		game quiz3 = new game();
		
		while(true) {
			String user = JOptionPane.showInputDialog("게임을 시작함\n가위(1),바위(2),보(3)");
			quiz3.setUser(user);
			quiz3.rand_and_change(user);
			quiz3.game_start();
			
			String replay = JOptionPane.showInputDialog("계속하기 y/n");
			if ("n".equalsIgnoreCase(replay)) {
				break;
			}
		}
		quiz3.Rate();
	}
}