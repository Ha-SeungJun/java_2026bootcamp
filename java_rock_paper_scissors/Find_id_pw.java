package java_rock_paper_scissors;

import java.awt.*;
import javax.swing.*;

public class Find_id_pw extends JFrame {
    
    public Find_id_pw() {
        setTitle("아이디/비밀번호 찾기");
        setSize(450, 550);
        setLocation(500, 200);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 250));
        
        // 제목
        JLabel titleLabel = new JLabel("아이디/비밀번호 찾기");
        titleLabel.setBounds(100, 20, 250, 35);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 50, 150));
        add(titleLabel);
        
        // 탭 패널 생성
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(30, 70, 390, 400);
        tabbedPane.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        
        // ========== 아이디 찾기 패널 ==========
        JPanel findIdPanel = new JPanel();
        findIdPanel.setLayout(null);
        findIdPanel.setBackground(Color.WHITE);
        
        // 아이디 찾기 - 안내 문구
        JLabel idGuideLabel = new JLabel("이름과 전화번호를 입력하세요");
        idGuideLabel.setBounds(80, 20, 250, 25);
        idGuideLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        idGuideLabel.setForeground(new Color(100, 100, 100));
        findIdPanel.add(idGuideLabel);
        
        // 아이디 찾기 - 이름 라벨
        JLabel nameLabel1 = new JLabel("이름:");
        nameLabel1.setBounds(40, 70, 80, 30);
        nameLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        findIdPanel.add(nameLabel1);
        
        // 아이디 찾기 - 이름 입력 필드
        JTextField nameField1 = new JTextField();
        nameField1.setBounds(40, 100, 300, 35);
        nameField1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        findIdPanel.add(nameField1);
        
        // 아이디 찾기 - 전화번호 라벨
        JLabel phoneLabel1 = new JLabel("전화번호:");
        phoneLabel1.setBounds(40, 150, 100, 30);
        phoneLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        findIdPanel.add(phoneLabel1);
        
        // 아이디 찾기 - 전화번호 입력 필드
        JTextField phoneField1 = new JTextField();
        phoneField1.setBounds(40, 180, 300, 35);
        phoneField1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        findIdPanel.add(phoneField1);
        
        // 아이디 찾기 - 찾기 버튼
        JButton findIdBtn = new JButton("아이디 찾기");
        findIdBtn.setBounds(120, 240, 140, 40);
        findIdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        findIdBtn.setBackground(new Color(100, 149, 237));
        findIdBtn.setForeground(Color.WHITE);
        findIdBtn.setFocusPainted(false);
        findIdPanel.add(findIdBtn);
        
        // 아이디 찾기 - 결과 표시 영역
        JTextArea idResultArea = new JTextArea();
        idResultArea.setBounds(40, 295, 300, 50);
        idResultArea.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        idResultArea.setEditable(false);
        idResultArea.setBackground(new Color(240, 240, 240));
        idResultArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        idResultArea.setLineWrap(true);
        idResultArea.setWrapStyleWord(true);
        findIdPanel.add(idResultArea);
        
        // 아이디 찾기 버튼 이벤트
        findIdBtn.addActionListener(e -> {
            String name = nameField1.getText().trim();
            String phone = phoneField1.getText().trim();
            
            // 입력 값 검증
            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "모든 항목을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // DB에서 이메일 찾기
            String email = UserDatabase.findEmailByNameAndPhone(name, phone);
            
            if (email != null) {
                idResultArea.setText("✓ 찾은 아이디:\n" + email);
                idResultArea.setForeground(new Color(0, 100, 0));
                
                JOptionPane.showMessageDialog(this, 
                    "회원님의 아이디는\n" + email + " 입니다.", 
                    "아이디 찾기 성공", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                idResultArea.setText("✗ 일치하는 사용자 정보를 찾을 수 없습니다.");
                idResultArea.setForeground(new Color(200, 0, 0));
                
                JOptionPane.showMessageDialog(this, 
                    "일치하는 사용자 정보를 찾을 수 없습니다!\n이름과 전화번호를 다시 확인해주세요.", 
                    "아이디 찾기 실패", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // ========== 비밀번호 찾기 패널 ==========
        JPanel findPwPanel = new JPanel();
        findPwPanel.setLayout(null);
        findPwPanel.setBackground(Color.WHITE);
        
        // 비밀번호 찾기 - 안내 문구
        JLabel pwGuideLabel = new JLabel("아이디와 전화번호를 입력하세요");
        pwGuideLabel.setBounds(80, 20, 250, 25);
        pwGuideLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        pwGuideLabel.setForeground(new Color(100, 100, 100));
        findPwPanel.add(pwGuideLabel);
        
        // 비밀번호 찾기 - 아이디 라벨
        JLabel idLabel = new JLabel("아이디(이메일):");
        idLabel.setBounds(40, 70, 150, 30);
        idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        findPwPanel.add(idLabel);
        
        // 비밀번호 찾기 - 아이디 입력 필드
        JTextField idField = new JTextField();
        idField.setBounds(40, 100, 300, 35);
        idField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        findPwPanel.add(idField);
        
        // 비밀번호 찾기 - 전화번호 라벨
        JLabel phoneLabel2 = new JLabel("전화번호:");
        phoneLabel2.setBounds(40, 150, 100, 30);
        phoneLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        findPwPanel.add(phoneLabel2);
        
        // 비밀번호 찾기 - 전화번호 입력 필드
        JTextField phoneField2 = new JTextField();
        phoneField2.setBounds(40, 180, 300, 35);
        phoneField2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        findPwPanel.add(phoneField2);
        
        // 비밀번호 찾기 - 찾기 버튼
        JButton findPwBtn = new JButton("비밀번호 재설정");
        findPwBtn.setBounds(120, 240, 140, 40);
        findPwBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        findPwBtn.setBackground(new Color(220, 20, 60));
        findPwBtn.setForeground(Color.WHITE);
        findPwBtn.setFocusPainted(false);
        findPwPanel.add(findPwBtn);
        
        // 비밀번호 찾기 - 결과 표시 영역
        JTextArea pwResultArea = new JTextArea();
        pwResultArea.setBounds(40, 295, 300, 50);
        pwResultArea.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        pwResultArea.setEditable(false);
        pwResultArea.setBackground(new Color(240, 240, 240));
        pwResultArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        pwResultArea.setLineWrap(true);
        pwResultArea.setWrapStyleWord(true);
        findPwPanel.add(pwResultArea);
        
        // 비밀번호 찾기 버튼 이벤트
        findPwBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            String phone = phoneField2.getText().trim();
            
            // 입력 값 검증
            if (id.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "모든 항목을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // 임시 비밀번호 생성 (규칙에 맞게: 8~12자, 영대문자, 숫자, 특수문자)
            String tempPassword = "Temp1234!";
            
            // DB에서 비밀번호 재설정
            boolean success = UserDatabase.resetPassword(id, phone, tempPassword);
            
            if (success) {
                pwResultArea.setText("✓ 임시 비밀번호:\n" + tempPassword);
                pwResultArea.setForeground(new Color(0, 100, 0));
                
                JOptionPane.showMessageDialog(this, 
                    "비밀번호가 재설정되었습니다!\n\n임시 비밀번호: " + tempPassword + 
                    "\n\n로그인 후 비밀번호를 변경해주세요!", 
                    "비밀번호 재설정 성공", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                pwResultArea.setText("✗ 일치하는 사용자 정보를 찾을 수 없습니다.");
                pwResultArea.setForeground(new Color(200, 0, 0));
                
                JOptionPane.showMessageDialog(this, 
                    "일치하는 사용자 정보를 찾을 수 없습니다!\n아이디와 전화번호를 다시 확인해주세요.", 
                    "비밀번호 재설정 실패", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // 탭에 패널 추가
        tabbedPane.addTab("아이디 찾기", findIdPanel);
        tabbedPane.addTab("비밀번호 찾기", findPwPanel);
        add(tabbedPane);
        
        // 닫기 버튼
        JButton closeBtn = new JButton("닫기");
        closeBtn.setBounds(175, 480, 100, 35);
        closeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        closeBtn.setBackground(new Color(220, 220, 220));
        closeBtn.setFocusPainted(false);
        add(closeBtn);
        
        closeBtn.addActionListener(e -> {
            dispose();
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}