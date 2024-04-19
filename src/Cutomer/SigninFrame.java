package Cutomer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;

public class SigninFrame extends JFrame {

	Connection conn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	ResultSetMetaData rsmd;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField ID;
	private JTextField PW;
	private JTextField Tel;
	private JTextField Email;
	private JLabel SigninBtn;
	private JPanel panel;
	private JLabel namelbl;
	private JLabel IDlbl;
	private JLabel PWlbl;
	private JLabel Tellbl;
	private JLabel Emaillbl;
	private JLabel lblNewLabel;
	private JLabel signup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SigninFrame frame = new SigninFrame();
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
	public SigninFrame() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(812, 630);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 197, 116));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon icon = new ImageIcon("D:\\WORK\\expj\\img\\login.png");
		Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

		panel = new JPanel();
		panel.setBackground(new Color(255, 245, 234));
		panel.setBounds(303, -11, 500, 612);
		contentPane.add(panel);
		panel.setLayout(null);

		Emaillbl = new JLabel("이 메 일");
		Emaillbl.setForeground(new Color(255, 245, 234));
		Emaillbl.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		Emaillbl.setBounds(107, 423, 57, 15);
		panel.add(Emaillbl);

		PWlbl = new JLabel("비 밀 번 호");
		PWlbl.setForeground(new Color(255, 245, 234));
		PWlbl.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		PWlbl.setBounds(107, 293, 57, 15);
		panel.add(PWlbl);

		IDlbl = new JLabel("아 이 디");
		IDlbl.setForeground(new Color(255, 245, 234));
		IDlbl.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		IDlbl.setBounds(107, 228, 57, 15);
		panel.add(IDlbl);

		Tellbl = new JLabel("전 화 번 호");
		Tellbl.setForeground(new Color(255, 245, 234));
		Tellbl.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		Tellbl.setBounds(107, 359, 57, 15);
		panel.add(Tellbl);

		namelbl = new JLabel("이 름");
		namelbl.setForeground(new Color(245, 157, 10));
		namelbl.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		namelbl.setBounds(107, 165, 57, 15);
		panel.add(namelbl);

		name = new CustomTextField("이름을 입력하세요");
		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				namelbl.setForeground(new Color(245, 157, 10));
				IDlbl.setForeground(new Color(255, 245, 234));
				PWlbl.setForeground(new Color(255, 245, 234));
				Tellbl.setForeground(new Color(255, 245, 234));
				Emaillbl.setForeground(new Color(255, 245, 234));

			}
		});

		name.setBorder(new CompoundBorder(new EmptyBorder(1, 3, 1, 1),
				new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
		name.setBounds(109, 178, 282, 40);
		panel.add(name);
		name.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		name.setToolTipText("");
		name.setBackground(new Color(255, 245, 234));
		name.setColumns(10);

		ID = new CustomTextField("아이디를 입력하세요");
		ID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				namelbl.setForeground(new Color(255, 245, 234));
				IDlbl.setForeground(new Color(245, 157, 10));
				PWlbl.setForeground(new Color(255, 245, 234));
				Tellbl.setForeground(new Color(255, 245, 234));
				Emaillbl.setForeground(new Color(255, 245, 234));

			}
		});
		ID.setBorder(new CompoundBorder(new EmptyBorder(1, 3, 1, 1),
				new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
		ID.setBounds(109, 243, 282, 40);
		panel.add(ID);
		ID.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		ID.setBackground(new Color(255, 245, 234));
		ID.setColumns(10);

		PW = new CustomTextField("비밀번호를 입력하세요");
		PW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				namelbl.setForeground(new Color(255, 245, 234));
				IDlbl.setForeground(new Color(255, 245, 234));
				PWlbl.setForeground(new Color(245, 157, 10));
				Tellbl.setForeground(new Color(255, 245, 234));
				Emaillbl.setForeground(new Color(255, 245, 234));

			}
		});
		PW.setBorder(new CompoundBorder(new EmptyBorder(1, 3, 1, 1),
				new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
		PW.setBounds(109, 309, 282, 40);
		panel.add(PW);
		PW.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		PW.setBackground(new Color(255, 245, 234));
		PW.setColumns(10);

		Tel = new CustomTextField("010-0000-0000");
		Tel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				namelbl.setForeground(new Color(255, 245, 234));
				IDlbl.setForeground(new Color(255, 245, 234));
				PWlbl.setForeground(new Color(255, 245, 234));
				Tellbl.setForeground(new Color(245, 157, 10));
				Emaillbl.setForeground(new Color(255, 245, 234));

			}
		});
		Tel.setBorder(new CompoundBorder(new EmptyBorder(1, 3, 1, 1),
				new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
		Tel.setBounds(109, 373, 282, 40);
		panel.add(Tel);
		Tel.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		Tel.setBackground(new Color(255, 245, 234));
		Tel.setColumns(10);

		Email = new CustomTextField("Example@email.com");
		Email.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				namelbl.setForeground(new Color(255, 245, 234));
				IDlbl.setForeground(new Color(255, 245, 234));
				PWlbl.setForeground(new Color(255, 245, 234));
				Tellbl.setForeground(new Color(255, 245, 234));
				Emaillbl.setForeground(new Color(245, 157, 10));

			}
		});
		Email.setBorder(new CompoundBorder(new EmptyBorder(1, 3, 1, 1),
				new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
		Email.setBounds(109, 437, 282, 40);
		panel.add(Email);
		Email.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		Email.setBackground(new Color(255, 245, 234));
		Email.setColumns(10);

		SigninBtn = new JLabel("가 입 하 기");
		SigninBtn.setBorder(new CompoundBorder(new EmptyBorder(1, 3, 1, 1),
				new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
		SigninBtn.setBounds(165, 518, 170, 40);
		panel.add(SigninBtn);
		SigninBtn.setOpaque(true);
		SigninBtn.setHorizontalAlignment(SwingConstants.CENTER);
		SigninBtn.setForeground(Color.WHITE);
		SigninBtn.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		SigninBtn.setBackground(new Color(254, 197, 116));

		lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setForeground(new Color(254, 197, 116));
		lblNewLabel.setBounds(0, 69, 500, 81);
		lblNewLabel.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 58));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);

		panel.add(lblNewLabel);
		
		signup = new JLabel("로그인 하러 가기");
		signup.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 16));
		signup.setBounds(394, 576, 94, 15);
		signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 다음 화면을 보여주는 코드
				loginFrame loginFrame = new loginFrame();
				loginFrame.setVisible(true);
				dispose(); // 현재 창 닫기
			}
		});
		panel.add(signup);
		SigninBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nameText = name.getText();
				String idText = ID.getText();
				String pwText = PW.getText();
				String telText = Tel.getText();
				String emailText = Email.getText();
				if (!nameText.isEmpty() || !idText.isEmpty() || !pwText.isEmpty() || !telText.isEmpty()
						|| !emailText.isEmpty()) {
					addToDB(nameText, idText, pwText, telText, emailText);
					login();
				} else {
					JOptionPane.showMessageDialog(null, "다 입력하세요");
				}
			}
		});
	}

	// 데이터베이스 목록 추가
	private void addToDB(String name, String id, String pw, String tel, String email) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234");
			String sql = "INSERT INTO Login (name, id, pw, tel, email) VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, tel);
			pstmt.setString(5, email);

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

	private void login() {
		// 다음 화면을 보여주는 코드
		loginFrame loginFrame = new loginFrame();
		loginFrame.setVisible(true);
		dispose(); // 현재 창 닫기
	}
}
