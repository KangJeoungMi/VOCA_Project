package VOCA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cutomer.loginFrame;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class Voca_mainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voca_mainFrame frame = new Voca_mainFrame();
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
	public Voca_mainFrame() {
		setBackground(Color.WHITE);
		setTitle("단어장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(467, 579);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 461, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblVoca_test = new JLabel("단 어 암 기");
		lblVoca_test.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 20));
		lblVoca_test.setHorizontalAlignment(JLabel.CENTER);
		lblVoca_test.setBackground(new Color(254, 197, 116));
		lblVoca_test.setOpaque(true);
		lblVoca_test.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblVoca_test.setBackground(new Color(255, 157, 11));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스가 라벨을 벗어났을 때 배경색을 흰색으로 변경합니다.
				lblVoca_test.setBackground(new Color(254, 197, 116));
			}
		});
		lblVoca_test.setBounds(150, 0, 150, 53);
		panel.add(lblVoca_test);

		JLabel lblshow_voca = new JLabel("단 어 보 기");
		lblshow_voca.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		lblshow_voca.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 20));
		lblshow_voca.setBackground(new Color(254, 197, 116));
		lblshow_voca.setOpaque(true);
		lblshow_voca.setHorizontalAlignment(JLabel.CENTER);
		lblshow_voca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblshow_voca.setBackground(new Color(255, 157, 11));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스가 라벨을 벗어났을 때 배경색을 흰색으로 변경합니다.
				lblshow_voca.setBackground(new Color(254, 197, 116));
			}
		});
		lblshow_voca.setBounds(0, 0, 150, 53);
		panel.add(lblshow_voca);

		JLabel lbVoca_make = new JLabel("단 어 만 들 기");
		lbVoca_make.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 20));
		lbVoca_make.setHorizontalAlignment(JLabel.CENTER);
		lbVoca_make.setBackground(new Color(254, 197, 116));
		lbVoca_make.setOpaque(true);
		lbVoca_make.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbVoca_make.setBackground(new Color(255, 157, 11));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스가 라벨을 벗어났을 때 배경색을 흰색으로 변경합니다.
				lbVoca_make.setBackground(new Color(254, 197, 116));
			}
		});
		lbVoca_make.setBounds(300, 0, 161, 53);
		panel.add(lbVoca_make);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(-11, 26, 472, 529);
		contentPane.add(tabbedPane);

		JPanel show_voca = new JPanel();
		show_voca.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, show_voca, null);
		show_voca.setLayout(null);

		JLabel lblshow = new JLabel("CLICK!");
		lblshow.setFont(new Font("나눔고딕코딩", Font.PLAIN, 25));
		lblshow.setHorizontalAlignment(JLabel.CENTER);
		lblshow.setOpaque(true);
		lblshow.setBackground(new Color(127, 173, 117));
		lblshow.setBounds(129, 434, 209, 41);
		show_voca.add(lblshow);

		JLabel lblIMG = new JLabel("");
		ImageIcon icon = new ImageIcon("D:\\WORK\\expj\\img\\study.png");
		Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		lblIMG.setIcon(new ImageIcon(img));
		lblIMG.setBounds(94, 38, 278, 183);
		show_voca.add(lblIMG);

		JLabel lblNewLabel_1 = new JLabel("영 어 단 어 보 기");
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_1.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(84, 259, 299, 58);
		show_voca.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("하루에 한번씩 꼭 보세요!");
		lblNewLabel_1_2.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 25));
		lblNewLabel_1_2.setHorizontalAlignment(JLabel.CENTER);

		lblNewLabel_1_2.setBounds(84, 319, 299, 58);
		show_voca.add(lblNewLabel_1_2);
		JLabel lbllogout = new JLabel("L o g o u t");
		lbllogout.setHorizontalAlignment(JLabel.RIGHT);
		lbllogout.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		lbllogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame();
			}
		});
		lbllogout.setBounds(374, 10, 81, 15);
		show_voca.add(lbllogout);
		
		
		lblshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Voca_show show_voca = new Voca_show();
				show_voca.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblshow.setBackground(new Color(36,54,16));
				lblshow.setForeground(new Color(255,255,255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스가 라벨을 벗어났을 때 배경색을 흰색으로 변경합니다.
				lblshow.setBackground(new Color(127, 173, 117));
				lblshow.setForeground(new Color(0,0,0));

			}

		});

		JPanel Voca_Test = new JPanel();
		Voca_Test.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, Voca_Test, null);
		Voca_Test.setLayout(null);

		JLabel lbltest = new JLabel("CLICK!");
		lbltest.setFont(new Font("나눔고딕코딩", Font.PLAIN, 25));
		lbltest.setHorizontalAlignment(JLabel.CENTER);
		lbltest.setOpaque(true);
		lbltest.setBackground(new Color(127, 173, 117));
		lbltest.setBounds(129, 434, 209, 41);
		Voca_Test.add(lbltest);

		JLabel lblIMG2 = new JLabel("");
		ImageIcon icon1 = new ImageIcon("D:\\WORK\\expj\\img\\study1.png");
		Image img1 = icon1.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		lblIMG2.setIcon(new ImageIcon(img1));
		lblIMG2.setBounds(94, 38, 278, 183);
		Voca_Test.add(lblIMG2);
		
		JLabel lbllogout2 = new JLabel("L o g o u t");
		lbllogout2.setHorizontalAlignment(JLabel.RIGHT);
		lbllogout2.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		lbllogout2.setBounds(374, 10, 81, 15);
		Voca_Test.add(lbllogout2);
		
		JLabel lblNewLabel_1_1 = new JLabel("영 어 단 어 암 기");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 40));
		lblNewLabel_1_1.setBounds(84, 268, 299, 58);
		Voca_Test.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("반복해서 계속 암기하세요!");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 25));
		lblNewLabel_1_2_1.setBounds(84, 328, 299, 58);
		Voca_Test.add(lblNewLabel_1_2_1);
		lbltest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Voca_Test Voca_Test = new Voca_Test();
				Voca_Test.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbltest.setBackground(new Color(36,54,16));
				lbltest.setForeground(new Color(255,255,255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스가 라벨을 벗어났을 때 배경색을 흰색으로 변경합니다.
				lbltest.setBackground(new Color(127, 173, 117));
				lbltest.setForeground(new Color(0,0,0));

			}

		});

		JPanel Voca_make = new JPanel();
		Voca_make.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, Voca_make, null);
		Voca_make.setLayout(null);

		JLabel lblmake = new JLabel("CLICK!");
		lblmake.setFont(new Font("나눔고딕코딩", Font.PLAIN, 25));
		lblmake.setHorizontalAlignment(JLabel.CENTER);
		lblmake.setOpaque(true);
		lblmake.setBackground(new Color(127, 173, 117));
		lblmake.setBounds(129, 434, 209, 41);
		Voca_make.add(lblmake);

		JLabel lblIMG3 = new JLabel("");
		ImageIcon icon2 = new ImageIcon("D:\\WORK\\expj\\img\\student.jpg");
		Image img2 = icon2.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		lblIMG3.setIcon(new ImageIcon(img2));
		lblIMG3.setBounds(94, 38, 278, 183);
		Voca_make.add(lblIMG3);
		
		JLabel lbllogout3 = new JLabel("L o g o u t");
		lbllogout3.setHorizontalAlignment(JLabel.RIGHT);
		lbllogout3.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		lbllogout3.setBounds(374, 10, 81, 15);
		Voca_make.add(lbllogout3);
		
		JLabel lblNewLabel_1_3 = new JLabel("내 단 어 장 만 들 기");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 40));
		lblNewLabel_1_3.setBounds(84, 263, 299, 58);
		Voca_make.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("새로 배우는 단어나\r\n");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 25));
		lblNewLabel_1_2_2.setBounds(84, 323, 299, 58);
		Voca_make.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("외우고 싶은 단어를 추가하세요!");
		lblNewLabel_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_1.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 25));
		lblNewLabel_1_2_2_1.setBounds(84, 361, 299, 58);
		Voca_make.add(lblNewLabel_1_2_2_1);
		lblmake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Voca_make MW = new Voca_make();
				MW.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblmake.setBackground(new Color(36,54,16));
				lblmake.setForeground(new Color(255,255,255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스가 라벨을 벗어났을 때 배경색을 흰색으로 변경합니다.
				lblmake.setBackground(new Color(127, 173, 117));
				lblmake.setForeground(new Color(0,0,0));
			}
		});
	}

	private void LoginFrame() { // 단어장 메인 프레임 이동
		// 다음 화면을 보여주는 코드
		loginFrame loginFrame = new loginFrame();
		loginFrame.setVisible(true);
		dispose();
	}
}
