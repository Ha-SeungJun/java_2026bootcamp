package java_rock_paper_scissors;

public class User {
    private static String currentUserName = null;
    private static String currentUserEmail = null;
    private static int currentUserWins = 0;
    private static int currentUserDraws = 0;
    private static int currentUserLosses = 0;
    
    // 로그인 설정
    public static void login(String name, String email, int wins, int draws, int losses) {
        currentUserName = name;
        currentUserEmail = email;
        currentUserWins = wins;
        currentUserDraws = draws;
        currentUserLosses = losses;
    }
    
    // 로그아웃
    public static void logout() {
        currentUserName = null;
        currentUserEmail = null;
        currentUserWins = 0;
        currentUserDraws = 0;
        currentUserLosses = 0;
    }
    
    // 로그인 여부 확인
    public static boolean isLoggedIn() {
        return currentUserName != null;
    }
    
    // 현재 사용자 이름 가져오기
    public static String getCurrentUserName() {
        return currentUserName;
    }
    
    // 현재 사용자 이메일 가져오기
    public static String getCurrentUserEmail() {
        return currentUserEmail;
    }
    
    // 게임 결과 추가
    public static void addGameResult(int wins, int draws, int losses) {
        currentUserWins += wins;
        currentUserDraws += draws;
        currentUserLosses += losses;
        
        // DB 업데이트
        if (currentUserEmail != null) {
            UserDatabase.updateGameResult(currentUserEmail, wins, draws, losses);
        }
    }
    
    // 전적 가져오기
    public static int getWins() {
        return currentUserWins;
    }
    
    public static int getDraws() {
        return currentUserDraws;
    }
    
    public static int getLosses() {
        return currentUserLosses;
    }
    
    // 사용자 정보 새로고침
    public static void refreshUserInfo() {
        if (currentUserEmail != null) {
            UserDatabase.UserInfo userInfo = UserDatabase.getUserInfo(currentUserEmail);
            if (userInfo != null) {
                currentUserWins = userInfo.wins;
                currentUserDraws = userInfo.draws;
                currentUserLosses = userInfo.losses;
            }
        }
    }
}