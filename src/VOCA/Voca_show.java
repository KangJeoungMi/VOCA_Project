package VOCA;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JViewport;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Voca_show extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JLabel lblgohome_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voca_show frame = new Voca_show();
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
	public Voca_show() {
		setTitle("단어장");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(513, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CLICK");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 18));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadGroupData();
			}
		});
		lblNewLabel.setBounds(428, 8, 57, 31);
		contentPane.add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 51, 480, 475);
		contentPane.add(scrollPane);

		table = new JTable();
		// 스크롤 패널의 뷰포트의 배경색을 노란색으로 설정합니다.
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(new Color(255, 244, 226));
		table = new JTable();
		table.setRowHeight(25); // 각 행의 높이를 20픽셀로 설정
		// 셀의 내용을 가운데 정렬하는 TableCellRenderer 생성
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "K o r e a n", "E n g l i s h" }));
		/// 테이블 헤더의 배경색 변경, 글자 중앙정렬
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(254, 197, 116));
		header.setForeground(Color.WHITE);
		header.setPreferredSize(new Dimension(header.getWidth(), header.getHeight() + 30));
		header.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 18));
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.RIGHT);

		JLabel lblgohome = new JLabel("메인으로");
		lblgohome.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 16));
		lblgohome.setHorizontalAlignment(JLabel.RIGHT);
		lblgohome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Voca_mainFrame WM = new Voca_mainFrame();
				WM.setVisible(true);
				dispose();
			}
		});
		lblgohome.setBounds(428, 536, 57, 15);
		contentPane.add(lblgohome);

		comboBox = new JComboBox();
		// 배경색 설정
		comboBox.setBackground(java.awt.Color.WHITE);
		// 테두리 없애기
		comboBox.setBorder(BorderFactory.createEmptyBorder());
		comboBox.setBounds(8, 10, 411, 31);
		contentPane.add(comboBox);
		
		lblgohome_1 = new JLabel("인쇄");
		lblgohome_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblgohome_1.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 16));
		lblgohome_1.setBounds(8, 538, 57, 15);
		contentPane.add(lblgohome_1);
		// 초기 데이터베이스 연결 및 콤보박스에 항목 로드
		loadGroups();

	}

	// 그룹 목록을 콤보박스에 로드하는 메서드
	private void loadGroups() {
		comboBox.removeAllItems(); // 기존 목록 지우기
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234")) {
			String sql = "SELECT DISTINCT CategoryName FROM category";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						comboBox.addItem(rs.getString("CategoryName"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 선택한 그룹에 해당하는 데이터베이스 목록을 테이블에 로드하는 메서드
	private void loadGroupData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // 기존 테이블 초기화

		String selectedGroup = (String) comboBox.getSelectedItem();
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234")) {
			String sql = "SELECT KoreanWord, EnglishWord FROM Word WHERE CategoryName=?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, selectedGroup);
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						String korean = rs.getString("KoreanWord");
						String english = rs.getString("EnglishWord");
						model.addRow(new Object[] { korean, english });
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}