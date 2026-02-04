package java_rock_paper_scissors;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Rank extends JFrame {
    
    public Rank() {
        setTitle("랭킹 보기");
        setSize(700, 500);
        setLocation(400, 200);
        setLayout(null);
        
        // 제목
        JLabel titleLabel = new JLabel("랭킹 보기");
        titleLabel.setBounds(280, 20, 150, 30);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        add(titleLabel);
        
        // 테이블 컬럼명
        String[] columnNames = {"순위", "이름", "승", "무", "패", "승률", "총 게임"};
        
        // DB에서 사용자 정보 가져오기
        List<UserDatabase.UserInfo> users = UserDatabase.getAllUsers();
        
        // 승률 기준으로 정렬 (승률이 같으면 승수로 정렬)
        Collections.sort(users, new Comparator<UserDatabase.UserInfo>() {
            @Override
            public int compare(UserDatabase.UserInfo u1, UserDatabase.UserInfo u2) {
                // 게임을 하지 않은 사용자는 하위로
                if (u1.getTotalGames() == 0 && u2.getTotalGames() == 0) return 0;
                if (u1.getTotalGames() == 0) return 1;
                if (u2.getTotalGames() == 0) return -1;
                
                // 승률 비교
                double rate1 = u1.getWinRate();
                double rate2 = u2.getWinRate();
                
                if (rate1 != rate2) {
                    return Double.compare(rate2, rate1); // 내림차순
                } else {
                    return Integer.compare(u2.wins, u1.wins); // 승수 비교
                }
            }
        });
        
        // 테이블 데이터 생성
        Object[][] data = new Object[users.size()][7];
        for (int i = 0; i < users.size(); i++) {
            UserDatabase.UserInfo user = users.get(i);
            data[i][0] = (i + 1);
            data[i][1] = user.name;
            data[i][2] = user.wins;
            data[i][3] = user.draws;
            data[i][4] = user.losses;
            data[i][5] = String.format("%.1f%%", user.getWinRate());
            data[i][6] = user.getTotalGames();
        }
        
        // 테이블 모델 생성
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 셀 편집 불가
            }
        };
        
        // 테이블 생성
        JTable table = new JTable(model);
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 14));
        table.getTableHeader().setReorderingAllowed(false); // 컬럼 이동 불가
        
        // 스크롤 패널
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 70, 600, 350);
        add(scrollPane);
        
        // 닫기 버튼
        JButton closeBtn = new JButton("닫기");
        closeBtn.setBounds(300, 430, 100, 35);
        closeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        add(closeBtn);
        
        closeBtn.addActionListener(e -> {
            dispose();
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}