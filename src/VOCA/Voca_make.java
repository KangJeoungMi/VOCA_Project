package VOCA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class Voca_make extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JTable table;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voca_make frame = new Voca_make();
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
	public Voca_make() {
		setBackground(new Color(255, 248, 242));
		setTitle("단어 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(666, 444);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 242));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setOpaque(true);
		scrollPane.setBounds(0, 0, 314, 408);
		contentPane.add(scrollPane);
		// 스크롤 패널의 뷰포트의 배경색상 변경
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(new Color(255, 244, 226));

		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.window));
		table.setSelectionBackground(new Color(255, 244, 226));
		table.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		table.setShowHorizontalLines(false);
		table.setBackground(new Color(255, 244, 226));
		table.setOpaque(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "k o r e a n", "E n g l i s h" }));
		// 테이블 헤더의 배경색 변경, 글자 중앙정렬
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(254, 197, 116));
		header.setForeground(Color.WHITE);
		header.setPreferredSize(new Dimension(header.getWidth(), header.getHeight() + 30));
		header.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 18));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);

		textField = new JTextField();
		textField.setBounds(419, 144, 218, 40);
		contentPane.add(textField);
		textField.setColumns(10);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(420, 210, 218, 40);
		contentPane.add(textField2);

		JLabel lblNewLabel = new JLabel("한 국 어");
		lblNewLabel.setForeground(new Color(254, 197, 116));
		lblNewLabel.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 25));
		lblNewLabel.setBounds(334, 152, 73, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabe2 = new JLabel("영    어");
		lblNewLabe2.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 25));
		lblNewLabe2.setBounds(335, 218, 73, 23);
		lblNewLabe2.setForeground(new Color(254, 197, 116));

		// 254, 197, 116
		contentPane.add(lblNewLabe2);
		comboBox = new JComboBox();
		// 배경색 설정
		comboBox.setBackground(java.awt.Color.WHITE);
		// 테두리 없애기
		comboBox.setBorder(BorderFactory.createEmptyBorder());
		comboBox.setBounds(326, 58, 261, 30);
		contentPane.add(comboBox);

		JLabel lblgohome = new JLabel("메 인 으 로");
		lblgohome.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		lblgohome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Voca_mainFrame WM = new Voca_mainFrame();
				WM.setVisible(true);
				dispose();
			}
		});
		lblgohome.setBounds(581, 6, 57, 15);
		contentPane.add(lblgohome);

		JLabel lbladdcategory = new JLabel("+");
		lbladdcategory.setForeground(new Color(255, 255, 255));
		lbladdcategory.setBackground(new Color(254, 197, 116));
		lbladdcategory.setOpaque(true);
		lbladdcategory.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 35));
		lbladdcategory.setHorizontalAlignment(JLabel.CENTER);
		lbladdcategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Voca_category ac = new Voca_category();
				ac.setVisible(true);
			}
		});
		lbladdcategory.setBounds(599, 58, 30, 30);
		contentPane.add(lbladdcategory);

		JLabel lblNewLabel_1 = new JLabel("등 록");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(254, 197, 116));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField.getText().equals("") || textField2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "단어를 입력하세요", "정보", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String data[] = { textField.getText(), textField2.getText() };
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(data);
					JOptionPane.showMessageDialog(null, "등록되었습니다", "정보", JOptionPane.INFORMATION_MESSAGE);
				}
				textField.setText("");
				textField2.setText("");

			}
		});
		lblNewLabel_1.setBounds(425, 295, 100, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("저 장");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(254, 197, 116));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 24));
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				if (model.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "저장 할 단어가 없습니다", "정보", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// 데이터베이스 연동
					String EnglishWord, KoreanWord, categoryName;
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM",
								"1234");
						categoryName = comboBox.getSelectedItem().toString();

						for (int i = 0; i < model.getRowCount(); i++) {
							EnglishWord = model.getValueAt(i, 0).toString();
							KoreanWord = model.getValueAt(i, 1).toString();
							String sql = "INSERT INTO Word (KoreanWord, EnglishWord, CategoryName) VALUES (?,?,?)";

							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setString(1, EnglishWord);
							ps.setString(2, KoreanWord);
							ps.setString(3, categoryName); // 선택된 카테고리 이름 적용
							ps.executeUpdate();
						}
						JOptionPane.showMessageDialog(null, "단어를 등록 했습니다", "정보", JOptionPane.INFORMATION_MESSAGE);
						model.setRowCount(0);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		lblNewLabel_2.setBounds(537, 295, 100, 30);
		contentPane.add(lblNewLabel_2);
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
}
