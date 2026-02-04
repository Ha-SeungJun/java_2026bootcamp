package java_rock_paper_scissors;

import java.awt.*;
import javax.swing.*;
import java.util.regex.Pattern;

public class SignUp extends JFrame {
    
    public SignUp() {
        setTitle("회원가입");
        setSize(400, 500);
        setLocation(500, 200);
        setLayout(null);
        
        // 제목
        JLabel titleLabel = new JLabel("회원가입");
        titleLabel.setBounds(150, 20, 100, 30);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        add(titleLabel);
        
        // 이름 라벨 및 입력 필드
        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setBounds(50, 80, 100, 30);
        nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        add(nameLabel);
        
        JTextField nameField = new JTextField();
        nameField.setBounds(50, 110, 300, 35);
        nameField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        add(nameField);
        
        // 전화번호 라벨 및 입력 필드
        JLabel phoneLabel = new JLabel("전화번호:");
        phoneLabel.setBounds(50, 160, 100, 30);
        phoneLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        add(phoneLabel);
        
        JTextField phoneField = new JTextField();
        phoneField.setBounds(50, 190, 300, 35);
        phoneField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        add(phoneField);
        
        // 아이디(이메일) 라벨 및 입력 필드
        JLabel emailLabel = new JLabel("아이디(이메일):");
        emailLabel.setBounds(50, 240, 150, 30);
        emailLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        add(emailLabel);
        
        JTextField emailField = new JTextField();
        emailField.setBounds(50, 270, 300, 35);
        emailField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        add(emailField);
        
        // 비밀번호 라벨 및 입력 필드
        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setBounds(50, 320, 100, 30);
        passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        add(passwordLabel);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(50, 350, 300, 35);
        passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        add(passwordField);
        
        // 가입하기 버튼
        JButton signUpBtn = new JButton("가입하기");
        signUpBtn.setBounds(80, 410, 100, 40);
        signUpBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        add(signUpBtn);
        
        // 취소 버튼
        JButton cancelBtn = new JButton("취소");
        cancelBtn.setBounds(220, 410, 100, 40);
        cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        add(cancelBtn);
        
     // 가입하기 버튼 이벤트 수정
        signUpBtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            
            // 1. 빈 칸 검사
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요!", "입력 오류", JOptionPane.WARNING_MESSAGE);
            }
            // 2. 이메일 형식 검사
            else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "올바른 이메일 형식이 아닙니다!\n예: example@email.com", "이메일 오류", JOptionPane.WARNING_MESSAGE);
            }
            // 3. 비밀번호 형식 검사
            else if (!isValidPassword(password)) {
                JOptionPane.showMessageDialog(this, 
                    "비밀번호는 8~12자 사이이며,\n영대문자, 숫자, 특수문자를 각각 하나 이상 포함해야 합니다!", 
                    "비밀번호 오류", 
                    JOptionPane.WARNING_MESSAGE);
            }
            else {
                // DB에 회원 등록
                boolean success = UserDatabase.registerUser(name, phone, email, password);
                
                if (success) {
                    // 회원가입 성공 - 자동 로그인
                    User.login(name, email, 0, 0, 0);
                    start.showGameButtons(); // 메인 화면 버튼 변경
                    
                    JOptionPane.showMessageDialog(this, 
                        "회원가입이 완료되었습니다!\n자동으로 로그인됩니다.", 
                        "가입 완료", 
                        JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // 창 닫기
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "이미 존재하는 이메일입니다!", 
                        "가입 실패", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // 취소 버튼 이벤트
        cancelBtn.addActionListener(e -> {
            dispose(); // 창 닫기
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    // 이메일 형식 검사 메서드
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    
    // 비밀번호 형식 검사 메서드
    private boolean isValidPassword(String password) {
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
}