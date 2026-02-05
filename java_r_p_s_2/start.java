package java_r_p_s_2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class user{
	String name = "";
	String tel = "";
	String id = "";
	String pw = "";
	int wins;
    int draws;
    int losses;
    String lastLoginTime;
	
    user(String name, String tel, String id, String pw){
		this.name = name;
		this.tel = tel;
		this.id = id;
		this.pw = pw;
	}   
	user(String id, String wins, String draws, String losses, String lastLoginTime ){
		this.id = id;
		this.wins = Integer.parseInt(wins);
		this.draws = Integer.parseInt(draws);
		this.losses = Integer.parseInt(losses);
		this.lastLoginTime = lastLoginTime;
	}
	user(String name, String tel, String id, String pw, int wins, int draw, int losses, String time){
		this.name = name;
		this.tel = tel;
		this.id = id;
		this.pw = pw;
		this.wins = wins;
		this.draws = draw;
		this.losses = losses;
		this.lastLoginTime = time;
	}
	user(String name, String tel, String id, String pw, String wins, String draw, String losses, String time){
		this.name = name;
		this.tel = tel;
		this.id = id;
		this.pw = pw;
		this.wins = Integer.parseInt(wins);
		this.draws = Integer.parseInt(draw);
		this.losses = Integer.parseInt(losses);
		this.lastLoginTime = time;
	}
    public double rate() {
        if ( wins + draws + losses == 0) return 0.0;
        return (double) wins / wins + draws + losses * 100;
    }
    public void LoginTimeupdate(String id, String lastLoginTime) {
    	this.lastLoginTime = lastLoginTime;
    }
}

class user_list{
	List<user> userlist = new ArrayList<user>();
	
	
}

class user_bot{
	String user;
	String bot;

	user_bot(String user, String bot){
		this.user = user;
		this.bot = bot;
	}
}

public class start{	
	private static void check(String in)  {
		Scanner sc = new Scanner(System.in);
		
		switch (in) {
		case "1": {
			//2. 데이터 값 가져와서 로그인하기
			String id,pw;
			System.out.printf("id를 입력해주세요 : ");
			id = sc.next();
			System.out.printf("password를 입력해주세요 : ");
			pw = sc.next();
			
			user player = login(id, pw);
			System.out.printf(" -로그인 성공, 환영합니다 %s 님 \n -마지막 접속일 : %s",player.name, player.lastLoginTime);
			//로그인 성공시 게임메뉴 메소드 새로 만들어서 거기로 넘기기
			break;
		}
		case "2": {
			System.out.println("회원가입");
			System.out.println("--------------------");
			
			System.out.printf("이름을 입력해주세요 : ");
			String name = sc.next();
			System.out.printf("연락처를 입력해주세요 : ");
			String tel = sc.next();
			System.out.printf("id를 입력해주세요 : ");
			String id = sc.next();
			System.out.printf("passward를 입력해주세요 : ");
			String pw = sc.next();
			
			// 아이디 패스워드 값 검증
			
			// 1. 데이터 값 넣기
			signup(new user(name,tel,id,pw));
			System.out.println();
			System.out.println("회원가입 성공!\n로그인해주세요.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menu();
			}
			
		case "3": {
			//3. 이름, 전화번호 일치하는 아이디 주기
			//4. 이름 전화번호 아이디값 으로 일치하는 패스워드 Temp1234! 로 변경 or 비번 알려주기
			break;
		}
		case "4": {
			//1. 승률 기준 정렬해서 랭킹 보여주기'

			//일단 게임하기 테스트
			game();
			break;
		}
		case "5": {
			System.out.println("게임이 종료되었습니다");
			System.exit(0);
		}
		default:
			System.out.println("잘못된 입력, 다시 입력해주세요");
			System.out.println("올바른 예시 : 1");
			menu();
		}
	}
	
	public static void signup(user user)  {
		try (
			FileOutputStream fos = new FileOutputStream("user_data_txt",true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter writer = new BufferedWriter(osw)) {
           
			SimpleDateFormat currentTime = new SimpleDateFormat("yyyy년 MM월 dd일 오전 h시 s분");
            
            String line = user.name + "|" + user.tel + "|" + user.id + "|" + 
            		user.pw + "|" + "0" + "|" + "0" + "|" + 
                        "0" + "|" + currentTime.format(new Date());
           
            writer.write(line);
            writer.newLine();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			File file = new File("C:\\Users\\hallyms\\eclipse-workspace\\javaFund", "user_data.txt");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			signup(user);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static user_bot rand_and_change(String user) {
		String bot = null;
		int rand = (int) (Math.random() * 3 + 1);
		
		if (rand == 1) bot = "가위";
		else if (rand == 2) bot = "바위";
		else if (rand == 3) bot = "보";

		if (user.equals("1")) user = "가위";
		else if (user.equals("2")) user = "바위";
		else if (user.equals("3")) user = "보";
		
		user_bot ub = new user_bot(user,bot);
		return ub;
	}
	
	public static void game_start(user_bot ub){
		if (ub.user.equals(ub.bot)) {
			System.out.printf("컴 : %s, 당신 : %s \n무승부 입니다\n", ub.bot, ub.user);
			//데이터 파일에서 무승부값 올리기
		} else if ((ub.user.equals("가위") && ub.bot.equals("보"))
				|| (ub.user.equals("바위") && ub.bot.equals("가위"))
				|| (ub.user.equals("보") && ub.bot.equals("바위"))) {
			System.out.printf("컴 : %s, 당신 : %s \nUser 승리!\n", ub.bot, ub.user);
			//데이터 파일에서 승리값 올리기
		} else {
			System.out.printf("컴 : %s, 당신 : %s \n컴 승리!\n", ub.bot, ub.user);
			//데이터 파일에서 패배값 올리기
		}
	}
	
	public static void game() {
		String user = null;
		Scanner sc = new Scanner(System.in);
		String[] chk = {"가위","바위","보","1","2","3"};
		System.out.println("가위(1),바위(2),보(3)");
		System.out.printf("원하시는 번호를 입력해주세요 : ");
		user = sc.next();
		
		List<String> chkList = new ArrayList<>(Arrays.asList(chk));

		  if(chkList.contains(user)) {
			user_bot ub = rand_and_change(user);;
		    game_start(ub);
		  }
		  else {
			  System.out.println("잘못된 입력");
			  System.out.println("가위, 바위, 보, 1, 2, 3 중에서 입력해 주세요.");
			  System.out.println("---------------------------");
			  game();
		  }
	}
	
	public static user login(String id, String pw) {
		File file = new File("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\user_data.txt");
        if (!file.exists()) {
        	System.out.println("회원정보가 없습니다.");
            return null;
        }
        try (
        	FileInputStream fis = new FileInputStream("user_data.txt");
        	InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(isr)) {
        	//System.out.println(reader.readLine());
        	
        	String line;
            while ((line = reader.readLine()) != null) {
	        	String[] player = line.split("\\|");
	        	if(player[2].equals(id) && player[3].equals(pw)) {
	        		user play = new user(player[0],player[1],player[2],player[3],player[4],player[5],player[6],player[7]);
	        		return play;
	        	};
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("아이디 또는 비밀번호가 틀립니다.");
		menu();
		return null;
	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println(" 1. 로그인하기 \n 2. 회원가입하기 \n 3. 아이디 비밀번호 찾기 \n 4. 랭킹보기 \n 5. 나가기");
		System.out.println("---------------------------");
		System.out.printf("원하시는 번호를 입력해주세요 : ");
		String in = " "; 
		in = sc.next().strip();
		
		check(in);
	}
	public static void main(String[] args) {
		menu();
	}
}
