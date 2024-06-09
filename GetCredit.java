package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface GetCredit {
    	static int getCredit(String courseName) {
        Database db = new Database("root", "mysql");
        db.connect();
        Connection conn = db.getConnection();
        
        Integer credits = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT prerequisite FROM EnrollmentInfo WHERE courseName = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseName);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                credits = rs.getInt("credits");
            }
        } catch (SQLException e) {
            System.out.println("Failed to get prerequisite: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                db.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return credits;
    }
}
