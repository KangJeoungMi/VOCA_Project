package Cutomer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import VOCA.Voca_mainFrame;

import javax.swing.plaf.basic.BasicBorders;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class loginFrame extends JFrame {

	Connection conn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	ResultSetMetaData rsmd;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PW;
	private JLabel signup;
	private JLabel loginbtn;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField IDtextField;	    



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame() {
		setBackground(new Color(254, 197, 116));
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(812, 471);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 197, 116));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(-11, -11, 500, 475);
		contentPane.add(panel);
		panel.setBackground(new Color(255, 245, 234));
		panel.setLayout(null);

		lblNewLabel = new JLabel("로 그 인");
		lblNewLabel.setForeground(new Color(254, 197, 116));
		lblNewLabel.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 58));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(0, 59, 500, 81);
		panel.add(lblNewLabel);

		IDtextField = new CustomTextField("아이디를 입력하세요");
		IDtextField.setBounds(108, 166, 282, 40);
		IDtextField.setBorder(new CompoundBorder(new EmptyBorder(1, 3, 1, 1),
				new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
		IDtextField.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		panel.add(IDtextField);
		IDtextField.setBackground(new Color(255, 229, 178));
		IDtextField.setColumns(10);

		PW = new CustomTextField("비밀번호를 입력하세요");
		PW.setBorder(new CompoundBorder(new EmptyBorder(1, 3, 1, 1),
				new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
		PW.setBounds(108, 239, 282, 40);
		panel.add(PW);
		PW.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		PW.setBackground(new Color(255, 229, 178));
		PW.setColumns(10);

		loginbtn = new JLabel("로 그 인");
		loginbtn.setBounds(164, 311, 170, 40);
		panel.add(loginbtn);
		loginbtn.setOpaque(true);
		loginbtn.setForeground(Color.WHITE);
		loginbtn.setBackground(new Color(254, 197, 116));
		loginbtn.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 22));
		loginbtn.setHorizontalAlignment(JLabel.CENTER);

		signup = new JLabel("계정이 없습니다");
		signup.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		signup.setBounds(23, 404, 94, 15);
		panel.add(signup);

		signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 레이블 클릭 시 다음 화면을 보여주는 메서드 호출
				Singin();
			}
		});

		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = ""; // 입력된 아이디
				String pw = ""; // 입력된 비밀번호

				// 아이디와 비밀번호 입력란에서 값을 가져옴
				id = IDtextField.getText();
				pw = PW.getText();

				// 입력된 아이디와 비밀번호가 비어 있는지 확인
				if (!id.isEmpty() && !pw.isEmpty()) {
					// 데이터베이스에서 아이디와 비밀번호를 검색하여 일치하는지 확인
					// 관리자 로그인 페이지

					if (checkLogin(id, pw)) {
						wordmainFrame();

					} else if (id.equals("admin") && pw.equals("admin")) {
						AdminFrame();
					} else {
						// 로그인 실패 메시지 표시
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다.");
					}
				} else {
					// 아이디 또는 비밀번호가 입력되지 않은 경우 메시지 표시
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하세요.");
				}

			}
		});
	}

	private void wordmainFrame() { // 단어장 메인 프레임 이동
		// 다음 화면을 보여주는 코드
		Voca_mainFrame wordmainFrame = 
				new Voca_mainFrame();
		wordmainFrame.setVisible(true);
		dispose(); // 현재 창 닫기
	}

	private void AdminFrame() { // 회원가입 프레임 이동
		// 다음 화면을 보여주는 코드
		AdminFrame AdminFrame = new AdminFrame();
		AdminFrame.setVisible(true);
		dispose(); // 현재 창 닫기
	}

	private void Singin() { // 회원가입 프레임 이동
		// 다음 화면을 보여주는 코드
		SigninFrame SigninFrame = new SigninFrame();
		SigninFrame.setVisible(true);
		dispose(); // 현재 창 닫기
	}

	private boolean checkLogin(String id, String pw) {
		boolean isSuccess = false; // 로그인 성공 여부

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234");
			String sql = "SELECT id, pw FROM Login WHERE id=? AND pw=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();

			// 결과셋에 값이 존재하면 로그인 성공
			if (rs.next()) {
				isSuccess = true;
			}

			if (rs.next()) {
				String admin_id = rs.getString("id=admin");
				String admin_pw = rs.getString("pw=admin");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
			JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "오류: " + e.getMessage());
		}

		return isSuccess;
	}
}
