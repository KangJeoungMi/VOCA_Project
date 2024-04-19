package VOCA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class WordDAO {
	
	
	public static List<Word> getAllWords(Connection conn) throws SQLException {
		List<Word> words = new ArrayList<>();
		String sql = "SELECT EnglishWord, KoreanWord FROM Word";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String englishWord = rs.getString("EnglishWord");
				String koreanWord = rs.getString("KoreanWord");
				words.add(new Word(englishWord, koreanWord));
			}
		}
		return words;
	}
	public static String getKoreanWord(Connection conn, String englishWord, String category) throws SQLException {
		String koreanWord = null;
		String sql = "SELECT KoreanWord FROM Word WHERE EnglishWord = ? AND CategoryName = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, englishWord);
			pstmt.setString(2, category);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					koreanWord = rs.getString("KoreanWord");
				}
			}
		}
		return koreanWord;
	}

	public static List<Word> getWordsByCategory(Connection conn, String category) throws SQLException {
		List<Word> words = new ArrayList<>();
		String sql = "SELECT EnglishWord, KoreanWord FROM Word WHERE CategoryName = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, category);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String englishWord = rs.getString("EnglishWord");
					String koreanWord = rs.getString("KoreanWord");
					words.add(new Word(englishWord, koreanWord));
				}
			}
		}
		return words;
	}

	public static List<String> getAllCategories(Connection conn) throws SQLException {
		List<String> categories = new ArrayList<>();
		String sql = "SELECT CategoryName FROM Category";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String categoryName = rs.getString("CategoryName");
				categories.add(categoryName);
			}
		}
		return categories;
	}

	
}