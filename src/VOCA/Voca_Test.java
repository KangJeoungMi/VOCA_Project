package VOCA;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Voca_Test extends JFrame {
	private JLabel labelEnglishWord;
	private JLabel labelKoreanWord;
	private JComboBox<String> comboBoxCategories;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblgohome;

	public Voca_Test() {
		getContentPane().setBackground(new Color(255, 244, 226));
		setBackground(new Color(240, 240, 240));
		setTitle("단어 암기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);

		initComponents();
		loadCategories();
		loadRandomWord();

		setVisible(true);
	}

	private void initComponents() {

		comboBoxCategories = new JComboBox<>();
		comboBoxCategories.setBounds(12, 411, 266, 40);
		comboBoxCategories.setPreferredSize(new Dimension(200, 30));
		comboBoxCategories.addActionListener(e -> loadRandomWord());

		Font font = new Font("국민연금체 Regular", Font.PLAIN, 60);
		labelEnglishWord = new JLabel();
		labelEnglishWord.setText("hello");
		labelEnglishWord.setFont(font);
		labelEnglishWord.setHorizontalAlignment(JLabel.CENTER); // JLabel 가운데 정렬
		labelEnglishWord.setOpaque(true);
		labelEnglishWord.setBackground(new Color(254, 197, 116));
		labelEnglishWord.setBounds(12, 62, 460, 164);
		labelEnglishWord.setPreferredSize(new Dimension(200, 30));
		getContentPane().setLayout(null);

		labelKoreanWord = new JLabel();
		labelKoreanWord.setOpaque(true);
		labelKoreanWord.setBackground(new Color(254, 220, 172));
		labelKoreanWord.setFont(font);
		labelKoreanWord.setBounds(12, 225, 460, 176);
		labelKoreanWord.setHorizontalAlignment(JLabel.CENTER);
		labelKoreanWord.setPreferredSize(new Dimension(200, 30));
		
		// 한글 뜻 라벨을 클릭했을 때 한글 뜻이 보이도록 마우스 클릭 이벤트 추가
		labelKoreanWord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 한글 뜻을 보이게 설정
				labelKoreanWord.setText(getKoreanWord());
			}
		});
		
		lblgohome = new JLabel("메 인 으 로");
		lblgohome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Voca_mainFrame WM = new Voca_mainFrame();
				WM.setVisible(true);
				dispose();
			}
		});
		lblgohome.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 15));
		lblgohome.setBounds(12, 10, 57, 15);
		getContentPane().add(lblgohome);
		getContentPane().add(labelKoreanWord);
		getContentPane().add(comboBoxCategories);
		getContentPane().add(labelEnglishWord);

		lblNewLabel = new JLabel("영 어 단 어 를   보 고   뜻 을   맞 춰 보 세 요.");
		lblNewLabel.setBounds(12, 10, 460, 42);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 20));

		lblNewLabel_1 = new JLabel("N E X T");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadRandomWord();

			}
		});
		lblNewLabel_1.setBounds(290, 411, 183, 40);
		lblNewLabel_1.setBackground(new Color(254, 197, 116));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("온글잎 밑미 Regular", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(lblNewLabel_1);
	}

	private void loadCategories() {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234")) {
			List<String> categories = WordDAO.getAllCategories(conn);
			for (String category : categories) {
				comboBoxCategories.addItem(category);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void loadRandomWord() {
		String selectedCategory = (String) comboBoxCategories.getSelectedItem();
		if (selectedCategory != null) {
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234")) {
				List<Word> words = WordDAO.getWordsByCategory(conn, selectedCategory);
				if (!words.isEmpty()) {
					int randomIndex = new Random().nextInt(words.size());
					Word randomWord = words.get(randomIndex);
					labelEnglishWord.setText(randomWord.getEnglish());
					// 한글 뜻이 보이지 않도록 설정
					labelKoreanWord.setText("");
				} else {
					labelEnglishWord.setText("");
					// 한글 뜻이 보이지 않도록 설정
					labelKoreanWord.setText("선택된 카테고리에 등록된 단어가 없습니다.");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	// 선택된 단어의 한글 뜻을 반환하는 메서드
	private String getKoreanWord() {
		String selectedCategory = (String) comboBoxCategories.getSelectedItem();
		String selectedEnglishWord = labelEnglishWord.getText();
		if (selectedCategory != null && !selectedEnglishWord.isEmpty()) {
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADAM", "1234")) {
				return WordDAO.getKoreanWord(conn, selectedEnglishWord, selectedCategory);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return "";
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Voca_Test::new);
	}
}
