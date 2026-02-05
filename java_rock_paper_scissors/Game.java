package java_rock_paper_scissors;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Game extends JFrame {
    
    // 게임 통계
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;
    
    // UI 컴포넌트
    private JLabel playerImageLabel;
    private JLabel computerImageLabel;
    private JLabel resultLabel;
    private JLabel recordLabel;
    private JButton rockBtn, paperBtn, scissorsBtn;
    
    // 이미지 경로 (나중에 실제 경로로 변경)
    private String playerRockPath = "C:\\Users\\hallyms\\Downloads\\r.png";
    private String playerPaperPath = "C:\\Users\\hallyms\\Downloads\\p.png";
    private String playerScissorsPath = "C:\\Users\\hallyms\\Downloads\\s.png";
    
    private String computerRockPath = "C:\\Users\\hallyms\\Downloads\\r.png";
    private String computerPaperPath = "C:\\Users\\hallyms\\Downloads\\p.png";
    private String computerScissorsPath = "C:\\Users\\hallyms\\Downloads\\s.png";
    
    private Random random;
    
    public Game() {
        random = new Random();
        
        setTitle("가위바위보 게임");
        setSize(1000, 700);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        
        // 제목
        JLabel titleLabel = new JLabel("가위바위보 게임");
        titleLabel.setBounds(350, 20, 300, 50);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        titleLabel.setForeground(new Color(50, 50, 150));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);
        
        // 전적 표시
        recordLabel = new JLabel("전적 - 승: 0 / 무: 0 / 패: 0");
        recordLabel.setBounds(300, 80, 400, 30);
        recordLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        recordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(recordLabel);
        
        // 플레이어 라벨
        JLabel playerLabel = new JLabel("플레이어");
        playerLabel.setBounds(150, 130, 200, 30);
        playerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerLabel);
        
        // 컴퓨터 라벨
        JLabel computerLabel = new JLabel("컴퓨터");
        computerLabel.setBounds(650, 130, 200, 30);
        computerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        computerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerLabel);
        
        // 플레이어 이미지 (왼쪽)
        playerImageLabel = new JLabel("?");
        playerImageLabel.setBounds(100, 180, 300, 250);
        playerImageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 100));
        playerImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerImageLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerImageLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        playerImageLabel.setOpaque(true);
        playerImageLabel.setBackground(Color.WHITE);
        add(playerImageLabel);
        
        // 컴퓨터 이미지 (오른쪽)
        computerImageLabel = new JLabel("?");
        computerImageLabel.setBounds(600, 180, 300, 250);
        computerImageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 100));
        computerImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerImageLabel.setVerticalAlignment(SwingConstants.CENTER);
        computerImageLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        computerImageLabel.setOpaque(true);
        computerImageLabel.setBackground(Color.WHITE);
        add(computerImageLabel);
        
        // 결과 표시
        resultLabel = new JLabel("가위, 바위, 보 중 하나를 선택하세요!");
        resultLabel.setBounds(250, 450, 500, 40);
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setForeground(new Color(100, 100, 100));
        add(resultLabel);
        
        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.setBounds(200, 520, 600, 80);
        buttonPanel.setOpaque(false);
        
        // 가위 버튼
        scissorsBtn = new JButton("가위");
        scissorsBtn.setPreferredSize(new Dimension(150, 60));
        scissorsBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        scissorsBtn.setBackground(new Color(255, 200, 200));
        scissorsBtn.setFocusPainted(false);
        scissorsBtn.addActionListener(e -> playGame("scissors"));
        
        // 바위 버튼
        rockBtn = new JButton("바위");
        rockBtn.setPreferredSize(new Dimension(150, 60));
        rockBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        rockBtn.setBackground(new Color(200, 200, 255));
        rockBtn.setFocusPainted(false);
        rockBtn.addActionListener(e -> playGame("rock"));
        
        // 보 버튼
        paperBtn = new JButton("보");
        paperBtn.setPreferredSize(new Dimension(150, 60));
        paperBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        paperBtn.setBackground(new Color(200, 255, 200));
        paperBtn.setFocusPainted(false);
        paperBtn.addActionListener(e -> playGame("paper"));
        
        buttonPanel.add(scissorsBtn);
        buttonPanel.add(rockBtn);
        buttonPanel.add(paperBtn);
        add(buttonPanel);
        
        // 돌아가기 버튼
        JButton backBtn = new JButton("메인으로");
        backBtn.setBounds(420, 610, 160, 40);
        backBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        backBtn.setBackground(new Color(255, 240, 200));
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(e -> {
            dispose();
        });
        add(backBtn);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
 // playGame 메서드 수정
    private void playGame(String playerChoice) {
        // 컴퓨터의 선택 (랜덤)
        String[] choices = {"rock", "paper", "scissors"};
        String computerChoice = choices[random.nextInt(3)];
        
        // 플레이어 이미지 표시
        displayPlayerChoice(playerChoice);
        
        // 컴퓨터 이미지 표시
        displayComputerChoice(computerChoice);
        
        // 승부 판정
        String result = determineWinner(playerChoice, computerChoice);
        
        // 결과 표시
        displayResult(result, playerChoice, computerChoice);
        
        // 전적 업데이트
        updateRecord();
        
        // DB에 결과 저장
        int winsToAdd = result.equals("win") ? 1 : 0;
        int drawsToAdd = result.equals("draw") ? 1 : 0;
        int lossesToAdd = result.equals("lose") ? 1 : 0;
        User.addGameResult(winsToAdd, drawsToAdd, lossesToAdd);
    }
    
    // 플레이어 선택 이미지 표시
    private void displayPlayerChoice(String choice) {
        try {
            ImageIcon icon = null;
            switch (choice) {
                case "rock":
                    icon = new ImageIcon(playerRockPath);
                    break;
                case "paper":
                    icon = new ImageIcon(playerPaperPath);
                    break;
                case "scissors":
                    icon = new ImageIcon(playerScissorsPath);
                    break;
            }
            
            if (icon != null && icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image img = icon.getImage().getScaledInstance(280, 230, Image.SCALE_SMOOTH);
                playerImageLabel.setIcon(new ImageIcon(img));
                playerImageLabel.setText("");
            } else {
                // 이미지 없을 경우 텍스트로 표시
                playerImageLabel.setIcon(null);
                playerImageLabel.setText(getChoiceEmoji(choice));
            }
        } catch (Exception e) {
            playerImageLabel.setIcon(null);
            playerImageLabel.setText(getChoiceEmoji(choice));
        }
    }
    
    // 컴퓨터 선택 이미지 표시
    private void displayComputerChoice(String choice) {
        try {
            ImageIcon icon = null;
            switch (choice) {
                case "rock":
                    icon = new ImageIcon(computerRockPath);
                    break;
                case "paper":
                    icon = new ImageIcon(computerPaperPath);
                    break;
                case "scissors":
                    icon = new ImageIcon(computerScissorsPath);
                    break;
            }
            
            if (icon != null && icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image img = icon.getImage().getScaledInstance(280, 230, Image.SCALE_SMOOTH);
                computerImageLabel.setIcon(new ImageIcon(img));
                computerImageLabel.setText("");
            } else {
                // 이미지 없을 경우 텍스트로 표시
                computerImageLabel.setIcon(null);
                computerImageLabel.setText(getChoiceEmoji(choice));
            }
        } catch (Exception e) {
            computerImageLabel.setIcon(null);
            computerImageLabel.setText(getChoiceEmoji(choice));
        }
    }
    
    // 선택에 따른 이모지 반환
    private String getChoiceEmoji(String choice) {
        switch (choice) {
            case "rock": return "✊";
            case "paper": return "🖐";
            case "scissors": return "✌";
            default: return "?";
        }
    }
    
    // 승부 판정
    private String determineWinner(String player, String computer) {
        if (player.equals(computer)) {
            draws++;
            return "draw";
        }
        
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))) {
            wins++;
            return "win";
        }
        
        losses++;
        return "lose";
    }
    
    // 결과 표시
    private void displayResult(String result, String playerChoice, String computerChoice) {
        String playerText = getChoiceKorean(playerChoice);
        String computerText = getChoiceKorean(computerChoice);
        
        switch (result) {
            case "win":
                resultLabel.setText("승리! " + playerText + "이(가) " + computerText + "을(를) 이겼습니다!");
                resultLabel.setForeground(new Color(0, 150, 0));
                break;
            case "lose":
                resultLabel.setText("패배! " + computerText + "이(가) " + playerText + "을(를) 이겼습니다!");
                resultLabel.setForeground(new Color(200, 0, 0));
                break;
            case "draw":
                resultLabel.setText("무승부! 둘 다 " + playerText + "을(를) 선택했습니다!");
                resultLabel.setForeground(new Color(100, 100, 100));
                break;
        }
    }
    
    // 선택을 한글로 변환
    private String getChoiceKorean(String choice) {
        switch (choice) {
            case "rock": return "바위";
            case "paper": return "보";
            case "scissors": return "가위";
            default: return "";
        }
    }
    
    // 전적 업데이트
    private void updateRecord() {
        recordLabel.setText(String.format("전적 - 승: %d / 무: %d / 패: %d", wins, draws, losses));
    }
}