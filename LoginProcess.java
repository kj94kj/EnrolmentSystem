package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginProcess {
	//sqllogininfo라는 DB에 username(아이디) password(비밀번호) userid(유저번호) userType(학생이면 0임)을 담는다.
    private String username;
    private String password;
    private int userid;
    private int userType;
    private LoginInfo li;
    private Connection conn;

    public LoginProcess(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void connect(String dbURL, String dbUser, String dbPwd) {
        try {
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean authenticateUser() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isAuthenticated = false;
        
        try {
            String sql = "SELECT * FROM sqllogininfo WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	userid=rs.getInt(3);
            	userType=rs.getInt(4);
                isAuthenticated = true;
                System.out.println("User authenticated.");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to authenticate user: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isAuthenticated;
    }
    
    public void setLoginInfo() {
    	li=new LoginInfo(userid, userType);
    	
    }
    
    public LoginInfo getLoginInfo() {
    	return li;
    }

    public void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection.");
            e.printStackTrace();
        }
    }

}
