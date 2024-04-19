package Cutomer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private JTable table;
	private JTable table_1;
	private JTextField serchtext, Nametext, Idtext, Pwtext, Teltext, Emailtext;
	private JLabel searchlbl, updatelbl, dellbl, namelbl, idlbl, pwlbl, tellbl, emaillbl, addlbl;
	private MemebrDAO memberDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setBackground(new Color(255, 128, 0));
		// 기본 룩 앤 필을 변경하여 창의 헤더 배경색을 설정
		JFrame.setDefaultLookAndFeelDecorated(true);

		setTitle("회원 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(951, 427);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 578, 387);
		scrollPane.setBackground(Color.WHITE);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		// 스크롤 패널의 뷰포트의 배경색을 노란색으로 설정합니다.
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(new Color(240, 240, 240));
		table_1 = new JTable();
		table_1.setBackground(new Color(240, 240, 240));
		table_1.setRowHeight(25); // 각 행의 높이를 20픽셀로 설정
		// 셀의 내용을 가운데 정렬하는 TableCellRenderer 생성
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "\uC774\uB984", "\uC544\uC774\uB514", "\uBE44\uBC00\uBC88\uD638",
						"\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C" }));
		scrollPane.setViewportView(table_1);
		JTableHeader header = table_1.getTableHeader();
		header.setBackground(new Color(145, 145, 145));
		header.setForeground(new Color(255, 255, 255));
		header.setPreferredSize(new Dimension(header.getWidth(), header.getHeight() + 30));
		header.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 18));

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.RIGHT);
		serchtext = new CustomTextField("검색할 이름을 입력하세요");
		serchtext.setBounds(601, 31, 244, 32);
		contentPane.add(serchtext);
		serchtext.setColumns(10);

		searchlbl = new JLabel("검색");
		searchlbl.setBackground(new Color(240, 240, 240));
		searchlbl.setOpaque(true);
		searchlbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		searchlbl.setHorizontalAlignment(JLabel.CENTER);
		searchlbl.setBounds(857, 31, 66, 32);
		contentPane.add(searchlbl);

		updatelbl = new JLabel("수   정");
		updatelbl.setBackground(new Color(240, 240, 240));
		updatelbl.setOpaque(true);
		updatelbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		updatelbl.setHorizontalAlignment(JLabel.CENTER);
		updatelbl.setBounds(696, 353, 119, 35);
		contentPane.add(updatelbl);

		dellbl = new JLabel("삭   제");
		dellbl.setBackground(new Color(240, 240, 240));
		dellbl.setOpaque(true);
		dellbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		dellbl.setHorizontalAlignment(JLabel.CENTER);
		dellbl.setBounds(578, 353, 119, 35);
		contentPane.add(dellbl);

		Nametext = new JTextField();
		Nametext.setBounds(696, 93, 205, 32);
		contentPane.add(Nametext);
		Nametext.setColumns(10);

		namelbl = new JLabel("이름");
		namelbl.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		namelbl.setBounds(601, 93, 83, 32);
		contentPane.add(namelbl);

		Idtext = new JTextField();
		Idtext.setColumns(10);
		Idtext.setBounds(696, 143, 205, 32);
		contentPane.add(Idtext);

		idlbl = new JLabel("아이디");
		idlbl.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		idlbl.setBounds(601, 143, 83, 32);
		contentPane.add(idlbl);

		Pwtext = new JTextField();
		Pwtext.setColumns(10);
		Pwtext.setBounds(696, 195, 205, 32);
		contentPane.add(Pwtext);

		pwlbl = new JLabel("비밀번호");
		pwlbl.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		pwlbl.setBounds(601, 195, 83, 32);
		contentPane.add(pwlbl);

		Teltext = new JTextField();
		Teltext.setColumns(10);
		Teltext.setBounds(696, 247, 205, 32);
		contentPane.add(Teltext);

		tellbl = new JLabel("전화번호");
		tellbl.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		tellbl.setBounds(601, 247, 83, 32);
		contentPane.add(tellbl);

		Emailtext = new JTextField();
		Emailtext.setColumns(10);
		Emailtext.setBounds(696, 298, 205, 32);
		contentPane.add(Emailtext);

		emaillbl = new JLabel("이메일");
		emaillbl.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		emaillbl.setBounds(601, 298, 83, 32);
		contentPane.add(emaillbl);

		addlbl = new JLabel("추   가");
		addlbl.setBackground(new Color(240, 240, 240));
		addlbl.setOpaque(true);
		addlbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		addlbl.setHorizontalAlignment(JLabel.CENTER);
		addlbl.setBounds(815, 353, 120, 35);
		contentPane.add(addlbl);

		// MemberDAO 객체 생성
		memberDAO = new MemebrDAO();

		check(); // 초기 데이터베이스 조회

		// 마우스 클릭 이벤트 핸들링
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRowIndex = table_1.getSelectedRow();
				if (selectedRowIndex != -1) {
					// 테이블에서 선택한 행의 데이터를 텍스트 필드에 설정
					Nametext.setText(table_1.getValueAt(selectedRowIndex, 0).toString());
					Idtext.setText(table_1.getValueAt(selectedRowIndex, 1).toString());
					Pwtext.setText(table_1.getValueAt(selectedRowIndex, 2).toString());
					Teltext.setText(table_1.getValueAt(selectedRowIndex, 3).toString());
					Emailtext.setText(table_1.getValueAt(selectedRowIndex, 4).toString());
				}
			}
		});

		// 수정 버튼 클릭 이벤트 핸들링
		updatelbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateMember();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				updatelbl.setBackground(new Color(120, 154, 219));
				updatelbl.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				updatelbl.setBackground(new Color(240, 240, 240));
				updatelbl.setForeground(new Color(0, 0, 0));
			}
		});

		// 삭제 버튼 클릭 이벤트 핸들링
		dellbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteMember();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				dellbl.setBackground(new Color(120, 154, 219));
				dellbl.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				dellbl.setBackground(new Color(240, 240, 240));
				dellbl.setForeground(new Color(0, 0, 0));
			}
		});

		// 추가 버튼 클릭 이벤트 핸들링
		addlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addMember();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				addlbl.setBackground(new Color(120, 154, 219));
				addlbl.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				addlbl.setBackground(new Color(240, 240, 240));
				addlbl.setForeground(new Color(0, 0, 0));

			}
		});

		searchlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = serchtext.getText();
				if (!name.isEmpty()) {
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					model.setRowCount(0); // 테이블 초기화
					memberDAO.search(model, name); // 이름으로 회원 검색
				} else {
					JOptionPane.showMessageDialog(null, "검색할 이름을 입력하세요.");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				searchlbl.setBackground(new Color(120, 154, 219));
				searchlbl.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				searchlbl.setBackground(new Color(240, 240, 240));
				searchlbl.setForeground(new Color(0, 0, 0));

			}
		});
	}

	// 회원 추가
	private void addMember() {
		String nameText = Nametext.getText();
		String idText = Idtext.getText();
		String pwText = Pwtext.getText();
		String telText = Teltext.getText();
		String emailText = Emailtext.getText();
		if (!nameText.isEmpty() && !idText.isEmpty() && !pwText.isEmpty() && !telText.isEmpty()
				&& !emailText.isEmpty()) {
			MemberDTO member = new MemberDTO(nameText, idText, pwText, telText, emailText);
			memberDAO.addToDB(member);
			resetFields(); // 텍스트 필드 리셋
			check();
		} else {
			JOptionPane.showMessageDialog(null, "모든 필드를 입력하세요.");
		}
	}

	// 회원 삭제
	private void deleteMember() {
		int selectedRowIndex = table_1.getSelectedRow();
		if (selectedRowIndex != -1) {
			String nameText = table_1.getValueAt(selectedRowIndex, 0).toString();
			String idText = table_1.getValueAt(selectedRowIndex, 1).toString();
			String pwText = table_1.getValueAt(selectedRowIndex, 2).toString();
			String telText = table_1.getValueAt(selectedRowIndex, 3).toString();
			String emailText = table_1.getValueAt(selectedRowIndex, 4).toString();
			MemberDTO member = new MemberDTO(nameText, idText, pwText, telText, emailText);
			memberDAO.deleteToDB(member);
			resetFields(); // 텍스트 필드 리셋
			check();
		} else {
			JOptionPane.showMessageDialog(null, "삭제할 행을 선택하세요.");
		}
	}

	// 회원 수정
	private void updateMember() {
		int selectedRowIndex = table_1.getSelectedRow();
		if (selectedRowIndex != -1) {
			String nameText = Nametext.getText();
			String idText = Idtext.getText();
			String pwText = Pwtext.getText();
			String telText = Teltext.getText();
			String emailText = Emailtext.getText();
			if (!nameText.isEmpty() && !idText.isEmpty() && !pwText.isEmpty() && !telText.isEmpty()
					&& !emailText.isEmpty()) {
				String oldName = table_1.getValueAt(selectedRowIndex, 0).toString();
				String oldId = table_1.getValueAt(selectedRowIndex, 1).toString();
				String oldPw = table_1.getValueAt(selectedRowIndex, 2).toString();
				String oldTel = table_1.getValueAt(selectedRowIndex, 3).toString();
				String oldEmail = table_1.getValueAt(selectedRowIndex, 4).toString();
				MemberDTO member = new MemberDTO(nameText, idText, pwText, telText, emailText);
				memberDAO.updateToDB(member, oldName, oldId, oldPw, oldTel, oldEmail);
				resetFields(); // 텍스트 필드 리셋
				check();
			} else {
				JOptionPane.showMessageDialog(null, "모든 필드를 입력하세요.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "수정할 행을 선택하세요.");
		}
	}

	// 데이터베이스 조회 및 테이블 업데이트
	private void check() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0); // 기존 데이터 초기화
		memberDAO.selectDB(model); // 데이터베이스 조회 및 테이블 업데이트
	}

	// 텍스트 필드 리셋
	private void resetFields() {
		Nametext.setText("");
		Idtext.setText("");
		Pwtext.setText("");
		Teltext.setText("");
		Emailtext.setText("");
	}

}
