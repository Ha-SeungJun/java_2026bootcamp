package java_rock_paper_scissors;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {
    
    public Login() {
        setTitle("로그인");
        setSize(400, 350);
        setLocation(500, 250);
        setLayout(null);
        
        // 제목
        JLabel titleLabel = new JLabel("로그인");
        titleLabel.setBounds(160, 20, 100, 30);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        add(titleLabel);
        
        // 아이디 라벨 및 입력 필드
        JLabel idLabel = new JLabel("아이디(이메일):");
        idLabel.setBounds(50, 80, 150, 30);
        idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        add(idLabel);
        
        JTextField idField = new JTextField();
        idField.setBounds(50, 110, 300, 35);
        idField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        add(idField);
        
        // 비밀번호 라벨 및 입력 필드
        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setBounds(50, 160, 100, 30);
        passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        add(passwordLabel);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(50, 190, 300, 35);
        passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        add(passwordField);
        
        // 로그인 버튼
        JButton loginBtn = new JButton("로그인");
        loginBtn.setBounds(80, 250, 100, 40);
        loginBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        add(loginBtn);
        
        // 취소 버튼
        JButton cancelBtn = new JButton("취소");
        cancelBtn.setBounds(220, 250, 100, 40);
        cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        add(cancelBtn);
        
        // 로그인 버튼 이벤트
     // 로그인 버튼 이벤트 수정
        loginBtn.addActionListener(e -> {
            String id = idField.getText();
            String password = new String(passwordField.getPassword());
            
            if (id.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력해주세요!", "입력 오류", JOptionPane.WARNING_MESSAGE);
            } else {
                // DB에서 로그인 검증
                UserDatabase.UserInfo userInfo = UserDatabase.validateLogin(id, password);
                
                if (userInfo != null) {
                    // 로그인 성공
                    User.login(userInfo.name, userInfo.email, userInfo.wins, userInfo.draws, userInfo.losses);
                    start.showGameButtons(); // 메인 화면 버튼 변경
                    
                    JOptionPane.showMessageDialog(this, 
                        "로그인 성공!\n마지막 로그인: " + userInfo.lastLoginTime, 
                        "로그인", 
                        JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // 창 닫기
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "아이디 또는 비밀번호가 올바르지 않습니다!", 
                        "로그인 실패", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // 취소 버튼 이벤트
        cancelBtn.addActionListener(e -> {
            dispose();
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}