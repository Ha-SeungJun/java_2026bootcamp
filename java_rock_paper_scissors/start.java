package java_rock_paper_scissors;

import java.awt.*;
import javax.swing.*;

public class start extends JFrame {
    private static JFrame jf;
    private static JLabel userLabel;
    private static JPanel buttonPanel;
    
    public static void main(String[] args) {
        jf = new JFrame();
        jf.setSize(1200, 800);
        jf.setLocation(400, 100);
        jf.setTitle("가위바위보");
        jf.setLayout(null);

        // 제목 텍스트
        JLabel titleLabel = new JLabel("가위바위보 게임");
        titleLabel.setBounds(400, 30, 400, 60);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        titleLabel.setForeground(new Color(50, 50, 150));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jf.add(titleLabel);

        // 사용자 정보 표시 라벨 (왼쪽 위)
        userLabel = new JLabel("");
        userLabel.setBounds(20, 20, 300, 30);
        userLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        userLabel.setForeground(new Color(0, 100, 0));
        jf.add(userLabel);

        // 이미지 추가
        ImageIcon icon = new ImageIcon("C:\\Users\\hallyms\\Downloads\\rcp.jpeg");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(scaledImg));
        label.setBounds(300, 100, 600, 400);
        jf.add(label);

        // 초기 화면 표시
        showLoginButtons();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
    // 로그인 전 버튼 표시
    private static void showLoginButtons() {
        // 기존 버튼 패널 제거
        if (buttonPanel != null) {
            jf.remove(buttonPanel);
        }
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 0, 1200, 800);
        buttonPanel.setOpaque(false);
        
        JButton btn1 = new JButton("로그인");
        JButton btn2 = new JButton("회원가입");
        JButton btn3 = new JButton("아이디/비밀번호 찾기");
        JButton btn4 = new JButton("랭킹보기");
        JButton btn5 = new JButton("나가기");

        btn1.setBounds(150, 600, 100, 50);
        btn2.setBounds(350, 600, 100, 50);
        btn3.setBounds(550, 600, 100, 50);
        btn4.setBounds(750, 600, 100, 50);
        btn5.setBounds(950, 600, 100, 50);

        // 로그인 버튼 이벤트
        btn1.addActionListener(e -> {
            new Login();
        });

        // 회원가입 버튼 이벤트
        btn2.addActionListener(e -> {
            new SignUp();
        });

        // 아이디/비밀번호 찾기 버튼 이벤트
        btn3.addActionListener(e -> {
            new Find_id_pw();
        });

        // 랭킹보기 버튼 이벤트
        btn4.addActionListener(e -> {
            new Rank();
        });

        // 나가기 버튼 이벤트
        btn5.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(jf, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btn4);
        buttonPanel.add(btn5);
        
        jf.add(buttonPanel);
        userLabel.setText("");
        jf.revalidate();
        jf.repaint();
    }
    
    // 로그인 후 버튼 표시
    public static void showGameButtons() {
        // 기존 버튼 패널 제거
        if (buttonPanel != null) {
            jf.remove(buttonPanel);
        }
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 0, 1200, 800);
        buttonPanel.setOpaque(false);
        
        JButton btn1 = new JButton("게임하기");
        JButton btn2 = new JButton("전적보기");
        JButton btn3 = new JButton("랭킹보기");
        JButton btn4 = new JButton("로그아웃");
        JButton btn5 = new JButton("나가기");

        btn1.setBounds(150, 600, 120, 50);
        btn2.setBounds(350, 600, 120, 50);
        btn3.setBounds(550, 600, 120, 50);
        btn4.setBounds(750, 600, 120, 50);
        btn5.setBounds(950, 600, 120, 50);

        // 게임하기 버튼 이벤트
        btn1.addActionListener(e -> {
            new Game(); // 게임 화면으로 이동
            JOptionPane.showMessageDialog(jf, "게임 화면으로 이동합니다!", "게임 시작", JOptionPane.INFORMATION_MESSAGE);
        });

        // 전적보기 버튼 이벤트
        btn2.addActionListener(e -> {
            new MyRecord();
        });

        // 랭킹보기 버튼 이벤트
        btn3.addActionListener(e -> {
            new Rank();
        });

        // 로그아웃 버튼 이벤트
        btn4.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(jf, "로그아웃 하시겠습니까?", "로그아웃 확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                User.logout();
                showLoginButtons(); // 로그인 전 화면으로 전환
                JOptionPane.showMessageDialog(jf, "로그아웃 되었습니다.", "로그아웃", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // 나가기 버튼 이벤트
        btn5.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(jf, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btn4);
        buttonPanel.add(btn5);
        
        jf.add(buttonPanel);
        
        // 사용자 정보 표시
        userLabel.setText("User: " + User.getCurrentUserName());
        
        jf.revalidate();
        jf.repaint();
    }
}