package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface InsertCurrent {
	static void insertCurrent(String courseName, int section) {
        Database db = new Database("root", "mysql");
        db.connect();
        Connection conn = db.getConnection();
		
        PreparedStatement pstmt = null;
        try {
            String sqlInsert = "INSERT INTO sqlcurrentEnrollmentinfo (section, courseName) " +
                "VALUES (?, ?)";
            
            pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setInt(1, section);
            pstmt.setString(2, courseName);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Failed to insert data: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                if (pstmt != null)
                    pstmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        db.disconnect();
	}
}
