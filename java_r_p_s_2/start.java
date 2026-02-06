package java_r_p_s_2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


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
        return (double) wins / (wins + draws + losses) * 100;
    }
    public void LoginTimeupdate(String id, String lastLoginTime) {
    	this.lastLoginTime = lastLoginTime;
    }
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
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
	static String p_id;
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
			if (player != null) {
				System.out.printf(" -로그인 성공, 환영합니다 %s 님 \n -마지막 접속일 : %s \n",player.name, player.lastLoginTime);
				p_id = player.id;
				updateLastLoginTime(p_id);
				delay(1000);
				//로그인 성공시 게임메뉴 메소드 새로 만들어서 거기로 넘기기
			game_menu();
			}
			break;
		}
		case "2": {
		    boolean id_chk = false;
		    boolean pw_chk = false;
		    String name = "";
		    String tel = ""; 
		    String id = "";
		    String pw="";
		    
		    System.out.println("회원가입");
		    System.out.println("--------------------");
		    
		    System.out.printf("이름을 입력해주세요 : ");
		    name = sc.next();
		    System.out.printf("연락처를 입력해주세요 : ");
		    tel = sc.next();
		    
		    while(!id_chk){
		        System.out.printf("id(email)를 입력해주세요 : ");
		        id = sc.next();
		        
		        if (!isValidEmail(id)) {
		            System.out.println("email 형식으로 입력해주세요");
		            continue;
		        }
		        
		        if (isIdDuplicate(id)) {
		            System.out.println("이미 사용중인 아이디입니다. 다른 아이디를 입력해주세요");
		            continue;
		        }
		        
		        id_chk = true; // 형식도 맞고 중복도 아니면 통과
		    }
		    
		    while(!pw_chk) {
		        System.out.printf("password를 입력해주세요 : ");
		        pw = sc.next();
		        pw_chk = isValidPassword(pw);
		        if(!pw_chk) System.out.println("대문자, 숫자, 특수문자를 포함해서 8~12자리로 입력해주세요");
		    }
		    
		    // 1. 데이터 값 넣기
		    signup(new user(name,tel,id,pw));
		    System.out.println();
		    System.out.println("회원가입 성공!\n로그인해주세요.");
		    
		    delay(1000);
		    menu();
		    break;
		}
		case "3": {
			System.out.println("아이디, 비밀번호 찾기 미구현");
			//3. 이름, 전화번호 일치하는 아이디 주기
			//4. 이름 전화번호 아이디값 으로 일치하는 패스워드 Temp1234! 로 변경 or 비번 알려주기
			break;
		}
		case "4": {
			//1. 승수 기준 정렬해서 랭킹 보여주기'
			rank(getallusers());
			while(true) {
				System.out.printf("뒤로가기(1) : ");
				String back = sc.next();
				if(back.equals("1")) {
					menu();
					break;
				}
				System.out.println("예시 : 1");
			}
			menu();
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
			break;
		}
	}

	public static void rank(List<user> users) {
	        users.sort(Comparator.comparing(user::getWins).reversed());
	        if (users.size() > 10) {
				for(int i = 0; i < 10; i++) {
		        	System.out.printf("%d등 \t name : %s \t 승리 : %d \t 무승부 : %d \t 패배 : %d \n",i+1,
		        			users.get(i).name, users.get(i).wins, users.get(i).draws, users.get(i).losses );
		        }
	        }else {
				for(int i = 0; i < users.size(); i++) {
		        	System.out.printf("%d등 \t name : %s \t 승리 : %d \t 무승부 : %d \t 패배 : %d \n",i+1,
		        			users.get(i).name, users.get(i).wins, users.get(i).draws, users.get(i).losses );
	        	}
	        }
	}
	public static void g_m_check(String in) {
		Scanner sc = new Scanner(System.in);
		
		switch (in) {
		case "1": {
			game();
			break;
		}
		case "2": {
			//전적보기
			user me = getuser(p_id);
			System.out.printf("name : %s \t 승리 : %d \t 무승부 : %d \t 패배 : %d \t 승률 : %.2f \n",
        			me.name, me.wins, me.draws, me.losses,(double)me.wins/(me.wins+me.draws+me.losses) * 100 );
			while(true) {
				System.out.printf("뒤로가기(1) : ");
				String back = sc.next();
				if(back.equals("1")) {
					menu();
					break;
				}
			break;
			}
		}
		case "3": {
			//랭킹보기
			rank(getallusers());
			while(true) {
				System.out.printf("뒤로가기(1) : ");
				String back = sc.next();
				if(back.equals("1")) {
					game_menu();
					break;
				}
				System.out.println("예시 : 1");
			}
			break;
		}
		case "4": {
			//로그아웃
			p_id = null;
			System.out.println("로그아웃 되었습니다");
			menu();
			break;
		}
		case "5": {
			System.out.println("게임이 종료되었습니다");
			System.exit(0);
		}
		default:
			System.out.println("잘못된 입력, 다시 입력해주세요");
			System.out.println("올바른 예시 : 1");
			g_m_check(in);
			break;
		}
	}
	
	public static void signup(user user)  {
		try (
			FileOutputStream fos = new FileOutputStream("user_data.txt",true);
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
			updateGameResult(p_id, 0, 1, 0);
		} else if ((ub.user.equals("가위") && ub.bot.equals("보"))
				|| (ub.user.equals("바위") && ub.bot.equals("가위"))
				|| (ub.user.equals("보") && ub.bot.equals("바위"))) {
			System.out.printf("컴 : %s, 당신 : %s \nUser 승리!\n", ub.bot, ub.user);
			//데이터 파일에서 승리값 올리기
			updateGameResult(p_id, 1, 0, 0);
		} else {
			System.out.printf("컴 : %s, 당신 : %s \n컴 승리!\n", ub.bot, ub.user);
			//데이터 파일에서 패배값 올리기
			updateGameResult(p_id, 0, 0, 1);
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
		    delay(1000);
		    game_menu();
		  }
		  else {
			  System.out.println("잘못된 입력");
			  System.out.println("가위, 바위, 보, 1, 2, 3 중에서 입력해 주세요.");
			  System.out.println("---------------------------");
			  delay(1000);
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
	
	public static void game_menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println(" 1. 게임하기 \n 2. 전적보기 \n 3. 랭킹보기 \n 4. 로그아웃 \n 5. 나가기");
		System.out.println("---------------------------");
		System.out.printf("원하시는 번호를 입력해주세요 : ");
		String in = " "; 
		in = sc.next().strip();
		
		g_m_check(in);
	}
	
	public static void delay(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	
    // 게임 결과 업데이트
    public static void updateGameResult(String id, int winsToAdd, int drawsToAdd, int lossesToAdd) {
        File file = new File("user_data.txt");
        if (!file.exists()) {
            return;
        }
        
        List<String> lines = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream("user_data.txt");
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3 && parts[2].equals(id)) {
                    int wins = (parts.length > 4 ? Integer.parseInt(parts[4]) : 0) + winsToAdd;
                    int draws = (parts.length > 5 ? Integer.parseInt(parts[5]) : 0) + drawsToAdd;
                    int losses = (parts.length > 6 ? Integer.parseInt(parts[6]) : 0) + lossesToAdd;
                    String lastLogin = parts.length > 7 ? parts[7] : "";
                    
                    String updatedLine = parts[0] + "|" + parts[1] + "|" + 
                                       parts[2] + "|" + parts[3] + "|" +
                                       wins + "|" + draws + "|" + 
                                       losses + "|" + lastLogin;
                    lines.add(updatedLine);
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        // 파일 다시 쓰기
        try (FileOutputStream fos = new FileOutputStream("user_data.txt");
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter writer = new BufferedWriter(osw)) {
            
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 사용자 정보 가져오기
    public static user getuser(String id) {
        File file = new File("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\user_data.txt");
        if (!file.exists()) {
            return null;
        }
        
        try (FileInputStream fis = new FileInputStream("user_data.txt");
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3 && parts[2].equals(id)) {
                    int wins = Integer.parseInt(parts[4]);
                    int draws = Integer.parseInt(parts[5]);
                    int losses = Integer.parseInt(parts[6]);
                    String lastLogin =  parts[7];
                    
                    return new user(parts[0], parts[1], parts[2], parts[3], 
                                       wins, draws, losses, lastLogin);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    // 전체 사용자 목록 가져오기 (랭킹용)
    public static List<user> getallusers() {
        List<user> users = new ArrayList<>();
        File file = new File("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\user_data.txt");
        
        if (!file.exists()) {
            return users;
        }
        
        try (FileInputStream fis = new FileInputStream("user_data.txt");
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                    int wins = Integer.parseInt(parts[4]);
                    int draws = Integer.parseInt(parts[5]);
                    int losses = Integer.parseInt(parts[6]);
                    String lastLogin = parts[7];
                    
                    users.add(new user(parts[0], parts[1], parts[2], parts[3], 
                                          wins, draws, losses, lastLogin));
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return users;
    }
    // 아이디 검사
    private static boolean isValidEmail(String id) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(id).matches();
    }
    
    // 비밀번호 검사
    private static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 12) {
            return false;
        }
        
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;:',.<>?/~`";
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            else if (specialChars.indexOf(c) >= 0) {
                hasSpecialChar = true;
            }
        }
        
        return hasUpperCase && hasDigit && hasSpecialChar;
    }
    // 아이디 중복 확인 
    private static boolean isIdDuplicate(String id) {
        File file = new File("user_data.txt");
        if (!file.exists()) {
            return false; // 파일이 없으면 중복 아님
        }
        
        try (FileInputStream fis = new FileInputStream("user_data.txt");
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3 && parts[2].equals(id)) {
                    return true; // 중복된 아이디 발견
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false; // 중복 없음
    }
    
    public static void updateLastLoginTime(String id) {
        File file = new File("user_data.txt");
        if (!file.exists()) {
            return;
        }
        
        List<String> lines = new ArrayList<>();
        SimpleDateFormat currentTime = new SimpleDateFormat("yyyy년 MM월 dd일 a h시 mm분");
        String newLoginTime = currentTime.format(new Date());
        
        try (FileInputStream fis = new FileInputStream("user_data.txt");
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3 && parts[2].equals(id)) {
                    // 해당 사용자의 마지막 로그인 시간 업데이트
                    String updatedLine = parts[0] + "|" + parts[1] + "|" + 
                                       parts[2] + "|" + parts[3] + "|" +
                                       parts[4] + "|" + parts[5] + "|" + 
                                       parts[6] + "|" + newLoginTime;
                    lines.add(updatedLine);
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        // 파일 다시 쓰기
        try (FileOutputStream fos = new FileOutputStream("user_data.txt");
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter writer = new BufferedWriter(osw)) {
            
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		menu();
	}
}

