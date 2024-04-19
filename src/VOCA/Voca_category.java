package VOCA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Voca_category extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voca_category frame = new Voca_category();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Voca_category() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(262, 402);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 242));
		contentPane.setBorder(new LineBorder(new Color(254, 197, 116), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
		scrollPane.setBounds(12, 81, 237, 286);
		contentPane.add(scrollPane);
		
		 // 스크롤 패널의 뷰포트의 배경색을 노란색으로 설정합니다.
        JViewport viewport = scrollPane.getViewport();
        viewport.setBackground(new Color(255, 244, 226));
		table = new JTable();
        table.setRowHeight(25); // 각 행의 높이를 20픽셀로 설정
        // 셀의 내용을 가운데 정렬하는 TableCellRenderer 생성
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
		scrollPane.setViewportView(table);
		table.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"책 장"
			}
		));
		table.setSelectionBackground(new Color(255, 244, 226));
		table.setShowHorizontalLines(false);
		table.setBackground(new Color(255, 244, 226));
		table.setOpaque(true);
		/// 테이블 헤더의 배경색 변경, 글자 중앙정렬
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(254, 197, 116));
		header.setForeground(Color.WHITE);
		header.setPreferredSize(new Dimension(header.getWidth(), header.getHeight() + 30));
		header.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 18));
		textField = new JTextField();
		textField.setBounds(12, 46, 168, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("C L O S E");
		lblNewLabel.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(JLabel.RIGHT);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setBounds(170, 377, 80, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("카테고리를 추가하세요.");
		lblNewLabel_1.setForeground(new Color(227,139,75));
		lblNewLabel_1.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_1.setBounds(12, 10, 237, 26);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("저 장");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(254, 197, 116));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String categoryName = textField.getText();
            if (!categoryName.isEmpty()) {
                addToDatabase(categoryName);
                updateTable(); // 저장 후 테이블 업데이트
            } else {
                JOptionPane.showMessageDialog(null, "카테고리 이름을 입력하세요.");
            }
            textField.setText("");
        }
    });

    // 초기 데이터베이스에서 카테고리 테이블 업데이트
    updateTable();
		lblNewLabel_2.setBounds(190, 46, 59, 25);
		contentPane.add(lblNewLabel_2);

        // 초기 데이터베이스에서 카테고리 테이블 업데이트
        updateTable();
    }

    // 데이터베이스 목록 추가
    private void addToDatabase(String categoryName) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234");
            String sql = "INSERT INTO Category (CategoryName) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, categoryName);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "카테고리가 추가되었습니다.");

        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "오류: " + e.getMessage());
        }
    }

    // 테이블 업데이트 메서드
    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // 테이블 초기화

        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234")){
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String sql = "SELECT * FROM category";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String word_lists = rs.getString(1);
                String[] row = {word_lists};
                model.addRow(row); // 테이블에 행 추가
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }
    }
}