package java_rock_paper_scissors;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserDatabase {
    private static final String USER_FILE = "users.txt";
    private static final String DELIMITER = "|";
    
    // 사용자 정보 저장 클래스
    public static class UserInfo {
        String name;
        String phone;
        String email;
        String password;
        int wins;
        int draws;
        int losses;
        String lastLoginTime;
        
        public UserInfo(String name, String phone, String email, String password) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.password = password;
            this.wins = 0;
            this.draws = 0;
            this.losses = 0;
            this.lastLoginTime = "";
        }
        
        public UserInfo(String name, String phone, String email, String password, 
                       int wins, int draws, int losses, String lastLoginTime) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.password = password;
            this.wins = wins;
            this.draws = draws;
            this.losses = losses;
            this.lastLoginTime = lastLoginTime;
        }
        
        public double getWinRate() {
            int total = wins + draws + losses;
            if (total == 0) return 0.0;
            return (double) wins / total * 100;
        }
        
        public int getTotalGames() {
            return wins + draws + losses;
        }
    }
    
    // 회원가입
    public static boolean registerUser(String name, String phone, String email, String password) {
        if (isEmailExists(email)) {
            return false;
        }
        
        try (FileOutputStream fos = new FileOutputStream(USER_FILE, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter writer = new BufferedWriter(osw)) {
            
            String currentTime = getCurrentTime();
            String line = name + DELIMITER + phone + DELIMITER + email + DELIMITER + 
                         password + DELIMITER + "0" + DELIMITER + "0" + DELIMITER + 
                         "0" + DELIMITER + currentTime;
            
            writer.write(line);
            writer.newLine();
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // 이메일 중복 체크
    public static boolean isEmailExists(String email) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return false;
        }
        
        try (FileInputStream fis = new FileInputStream(USER_FILE);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + DELIMITER);
                if (parts.length >= 3 && parts[2].equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    // 로그인 검증
    public static UserInfo validateLogin(String email, String password) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return null;
        }
        
        try (FileInputStream fis = new FileInputStream(USER_FILE);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + DELIMITER);
                if (parts.length >= 4 && parts[2].equals(email) && parts[3].equals(password)) {
                    int wins = parts.length > 4 ? Integer.parseInt(parts[4]) : 0;
                    int draws = parts.length > 5 ? Integer.parseInt(parts[5]) : 0;
                    int losses = parts.length > 6 ? Integer.parseInt(parts[6]) : 0;
                    String lastLogin = parts.length > 7 ? parts[7] : "";
                    
                    UserInfo user = new UserInfo(parts[0], parts[1], parts[2], parts[3], 
                                                 wins, draws, losses, lastLogin);
                    
                    // 로그인 시간 업데이트
                    updateLoginTime(email);
                    
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    // 로그인 시간 업데이트
    public static void updateLoginTime(String email) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return;
        }
        
        List<String> lines = new ArrayList<>();
        String currentTime = getCurrentTime();
        
        try (FileInputStream fis = new FileInputStream(USER_FILE);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + DELIMITER);
                if (parts.length >= 3 && parts[2].equals(email)) {
                    // 로그인 시간 업데이트
                    String updatedLine = parts[0] + DELIMITER + parts[1] + DELIMITER + 
                                       parts[2] + DELIMITER + parts[3] + DELIMITER +
                                       (parts.length > 4 ? parts[4] : "0") + DELIMITER +
                                       (parts.length > 5 ? parts[5] : "0") + DELIMITER +
                                       (parts.length > 6 ? parts[6] : "0") + DELIMITER +
                                       currentTime;
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
        try (FileOutputStream fos = new FileOutputStream(USER_FILE);
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
    
    // 게임 결과 업데이트
    public static void updateGameResult(String email, int winsToAdd, int drawsToAdd, int lossesToAdd) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return;
        }
        
        List<String> lines = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(USER_FILE);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + DELIMITER);
                if (parts.length >= 3 && parts[2].equals(email)) {
                    int wins = (parts.length > 4 ? Integer.parseInt(parts[4]) : 0) + winsToAdd;
                    int draws = (parts.length > 5 ? Integer.parseInt(parts[5]) : 0) + drawsToAdd;
                    int losses = (parts.length > 6 ? Integer.parseInt(parts[6]) : 0) + lossesToAdd;
                    String lastLogin = parts.length > 7 ? parts[7] : "";
                    
                    String updatedLine = parts[0] + DELIMITER + parts[1] + DELIMITER + 
                                       parts[2] + DELIMITER + parts[3] + DELIMITER +
                                       wins + DELIMITER + draws + DELIMITER + 
                                       losses + DELIMITER + lastLogin;
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
        try (FileOutputStream fos = new FileOutputStream(USER_FILE);
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
    public static UserInfo getUserInfo(String email) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return null;
        }
        
        try (FileInputStream fis = new FileInputStream(USER_FILE);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + DELIMITER);
                if (parts.length >= 3 && parts[2].equals(email)) {
                    int wins = parts.length > 4 ? Integer.parseInt(parts[4]) : 0;
                    int draws = parts.length > 5 ? Integer.parseInt(parts[5]) : 0;
                    int losses = parts.length > 6 ? Integer.parseInt(parts[6]) : 0;
                    String lastLogin = parts.length > 7 ? parts[7] : "";
                    
                    return new UserInfo(parts[0], parts[1], parts[2], parts[3], 
                                       wins, draws, losses, lastLogin);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    // 전체 사용자 목록 가져오기 (랭킹용)
    public static List<UserInfo> getAllUsers() {
        List<UserInfo> users = new ArrayList<>();
        File file = new File(USER_FILE);
        
        if (!file.exists()) {
            return users;
        }
        
        try (FileInputStream fis = new FileInputStream(USER_FILE);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + DELIMITER);
                if (parts.length >= 4) {
                    int wins = parts.length > 4 ? Integer.parseInt(parts[4]) : 0;
                    int draws = parts.length > 5 ? Integer.parseInt(parts[5]) : 0;
                    int losses = parts.length > 6 ? Integer.parseInt(parts[6]) : 0;
                    String lastLogin = parts.length > 7 ? parts[7] : "";
                    
                    users.add(new UserInfo(parts[0], parts[1], parts[2], parts[3], 
                                          wins, draws, losses, lastLogin));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return users;
    }
    
    // 현재 시간 가져오기
    private static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    // 이메일로 사용자 찾기 (아이디 찾기)
    public static String findEmailByNameAndPhone(String name, String phone) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return null;
        }
        
        try (FileInputStream fis = new FileInputStream(USER_FILE);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + DELIMITER);
                if (parts.length >= 2 && parts[0].equals(name) && parts[1].equals(phone)) {
                    return parts[2]; // 이메일 반환
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    // 비밀번호 재설정
    public static boolean resetPassword(String email, String phone, String newPassword) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return false;
        }
        
        List<String> lines = new ArrayList<>();
        boolean found = false;
        
        try (FileInputStream fis = new FileInputStream(USER_FILE);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + DELIMITER);
                if (parts.length >= 3 && parts[2].equals(email) && parts[1].equals(phone)) {
                    // 비밀번호 변경
                    String updatedLine = parts[0] + DELIMITER + parts[1] + DELIMITER + 
                                       parts[2] + DELIMITER + newPassword + DELIMITER +
                                       (parts.length > 4 ? parts[4] : "0") + DELIMITER +
                                       (parts.length > 5 ? parts[5] : "0") + DELIMITER +
                                       (parts.length > 6 ? parts[6] : "0") + DELIMITER +
                                       (parts.length > 7 ? parts[7] : "");
                    lines.add(updatedLine);
                    found = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        
        if (!found) {
            return false;
        }
        
        // 파일 다시 쓰기
        try (FileOutputStream fos = new FileOutputStream(USER_FILE);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter writer = new BufferedWriter(osw)) {
            
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}