package java_quiz;

import javax.swing.JOptionPane;

public class quiz_2 {

	public static void main(String[] args) {
		int win = 0, lose = 0, draw = 0;

		while (true) {
			String input = JOptionPane.showInputDialog("게임을 시작함\n가위(1),바위(2),보(3)");
			if (input == null) break;

			int rand = (int) (Math.random() * 3 + 1);
			String bot = "";
			
			if (rand == 1) bot = "가위";
			else if (rand == 2) bot = "바위";
			else if (rand == 3) bot = "보";

			String user = input;
			if (input.equals("1")) user = "가위";
			else if (input.equals("2")) user = "바위";
			else if (input.equals("3")) user = "보";

			
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

			String replay = JOptionPane.showInputDialog("계속하기 y/n");
			
			if ("n".equalsIgnoreCase(replay)) {
				break;
			}
		}

		double total = win + lose + draw;
		double winRate = (win / total) * 100;

		System.out.printf("승리 : %d, 패배 : %d, 무승부 : %d\n승률 : %.2f%%", win, lose, draw, winRate);
	}
}