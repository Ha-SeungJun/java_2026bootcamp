package java_rock_paper_scissors;

import java.awt.*;
import javax.swing.*;

public class MyRecord extends JFrame {
    
    public MyRecord() {
        setTitle("내 전적");
        setSize(500, 400);
        setLocation(450, 250);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 250));
        
        // 제목
        JLabel titleLabel = new JLabel("내 전적");
        titleLabel.setBounds(190, 20, 120, 35);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 28));
        titleLabel.setForeground(new Color(50, 50, 150));
        add(titleLabel);
        
        // 사용자 정보 새로고침
        User.refreshUserInfo();
        
        // 사용자 이름
        JLabel nameLabel = new JLabel("플레이어: " + User.getCurrentUserName());
        nameLabel.setBounds(50, 80, 400, 30);
        nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        add(nameLabel);
        
        // 전적 정보
        int wins = User.getWins();
        int draws = User.getDraws();
        int losses = User.getLosses();
        int total = wins + draws + losses;
        double winRate = total > 0 ? (double) wins / total * 100 : 0.0;
        
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(5, 2, 10, 15));
        statsPanel.setBounds(50, 130, 400, 180);
        statsPanel.setBackground(Color.WHITE);
        statsPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        
        Font labelFont = new Font("맑은 고딕", Font.PLAIN, 16);
        Font valueFont = new Font("맑은 고딕", Font.BOLD, 16);
        
        JLabel totalLabel = new JLabel("  총 게임:");
        totalLabel.setFont(labelFont);
        JLabel totalValue = new JLabel(total + " 게임");
        totalValue.setFont(valueFont);
        
        JLabel winsLabel = new JLabel("  승:");
        winsLabel.setFont(labelFont);
        JLabel winsValue = new JLabel(wins + " 승");
        winsValue.setFont(valueFont);
        winsValue.setForeground(new Color(0, 150, 0));
        
        JLabel drawsLabel = new JLabel("  무:");
        drawsLabel.setFont(labelFont);
        JLabel drawsValue = new JLabel(draws + " 무");
        drawsValue.setFont(valueFont);
        drawsValue.setForeground(new Color(100, 100, 100));
        
        JLabel lossesLabel = new JLabel("  패:");
        lossesLabel.setFont(labelFont);
        JLabel lossesValue = new JLabel(losses + " 패");
        lossesValue.setFont(valueFont);
        lossesValue.setForeground(new Color(200, 0, 0));
        
        JLabel rateLabel = new JLabel("  승률:");
        rateLabel.setFont(labelFont);
        JLabel rateValue = new JLabel(String.format("%.1f%%", winRate));
        rateValue.setFont(valueFont);
        rateValue.setForeground(new Color(0, 100, 200));
        
        statsPanel.add(totalLabel);
        statsPanel.add(totalValue);
        statsPanel.add(winsLabel);
        statsPanel.add(winsValue);
        statsPanel.add(drawsLabel);
        statsPanel.add(drawsValue);
        statsPanel.add(lossesLabel);
        statsPanel.add(lossesValue);
        statsPanel.add(rateLabel);
        statsPanel.add(rateValue);
        
        add(statsPanel);
        
        // 닫기 버튼
        JButton closeBtn = new JButton("닫기");
        closeBtn.setBounds(200, 320, 100, 35);
        closeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        closeBtn.setFocusPainted(false);
        add(closeBtn);
        
        closeBtn.addActionListener(e -> {
            dispose();
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}