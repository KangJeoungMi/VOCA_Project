package Cutomer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MemebrDAO {
	// 데이터베이스 연결 정보
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "ADAM";
    private static final String PASSWORD = "1234";
	// 회원 추가
    public void addToDB(MemberDTO member) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO Login (name, id, pw, tel, email) VALUES (?,?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, member.getName());
                pstmt.setString(2, member.getId());
                pstmt.setString(3, member.getPw());
                pstmt.setString(4, member.getTel());
                pstmt.setString(5, member.getEmail());
               
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "회원이 추가되었습니다.");
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + e.getMessage());
        }
    }

    // 회원 수정
    public void updateToDB(MemberDTO member, String oldName, String oldId, String oldPw, String oldTel, String oldEmail) {
    	 try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "UPDATE Login SET name=?, id=?, pw=?, tel=?, email=? WHERE name=? AND id=? AND pw=? AND tel=? AND email=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 수정할 값들을 설정합니다.
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getEmail());
			 // 기존 값들을 설정합니다.
			 pstmt.setString(6, oldName);
             pstmt.setString(7, oldId);
             pstmt.setString(8, oldPw);
             pstmt.setString(9, oldTel);
             pstmt.setString(10, oldEmail);
	        int rowsAffected = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "항목이 수정되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "수정할 항목이 없습니다.");
			}

		} catch (SQLException se) {
			se.printStackTrace();
			JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "오류: " + e.getMessage());
		}
    }

    // 회원 삭제
    public void deleteToDB(MemberDTO member) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM Login WHERE name=? AND id=? AND pw=? AND tel=? AND email=?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, member.getName());
                pstmt.setString(2, member.getId());
                pstmt.setString(3, member.getPw());
                pstmt.setString(4, member.getTel());
                pstmt.setString(5, member.getEmail());

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "회원이 삭제되었습니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "삭제할 회원 정보가 없습니다.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + e.getMessage());
        }
    }

    // 회원 조회
    public void selectDB(DefaultTableModel model) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM Login";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String id = rs.getString("id");
                    String password = rs.getString("pw");
                    String tel = rs.getString("tel");
                    String email = rs.getString("email");
                    Object[] rowData = { name, id, password, tel, email };
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + e.getMessage());
        }
    }
    
 // 회원 검색
    public void search(DefaultTableModel model, String name) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM Login WHERE name=?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String memberName = rs.getString("name");
                        String id = rs.getString("id");
                        String password = rs.getString("pw");
                        String tel = rs.getString("tel");
                        String email = rs.getString("email");
                        Object[] rowData = { memberName, id, password, tel, email };
                        model.addRow(rowData);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + e.getMessage());
        }
    }
    
    
}