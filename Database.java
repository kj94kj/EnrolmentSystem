package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    // MySQL JDBC 드라이버 클래스 이름
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    // MySQL 서버 URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";

    // 사용자 이름과 비밀번호를 저장할 변수
    private String user;
    private String pwd;

    private Connection conn = null;

    // 생성자에서 사용자 이름과 비밀번호를 초기화
    public Database(String username, String password) {
        username = user;
        password = pwd;
    }

    // 데이터베이스에 연결하는 메소드
    public void connect() {
        try {
            // JDBC 드라이버를 로드
            Class.forName(JDBC_DRIVER);

            // 사용자 입력을 기반으로 MySQL 서버에 연결을 설정
            conn = DriverManager.getConnection(DB_URL, user, pwd);
        }
        catch (ClassNotFoundException e) {
            // JDBC 드라이버를 찾을 수 없을 때 예외 처리
            System.out.println("JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        }
        catch (SQLException e) {
            // MySQL 서버에 연결 실패 시 예외 처리
            System.out.println("Failed to connect to MySQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 데이터베이스를 생성하는 메소드
    public void createDatabase(String dbName) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "Create Database IF NOT EXISTS " + dbName; // 주어진 dbName을 이용하여 CREATE DATABASE 쿼리를 생성
            stmt.executeUpdate(sql);
            System.out.println("Database " + dbName + " created.");
        }
        catch (SQLException e) {
            System.out.println("Failed to create the Database: " + e.getMessage()); //오류 메시지 출력
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 테이블을 생성하는 메소드
    public void createTables() {
        Statement stmt = null;
        try {
            String dbURL = DB_URL + "SUGANG";
            conn = DriverManager.getConnection(dbURL, user, pwd);
            stmt = conn.createStatement();

            // UserInfo 테이블 생성 쿼리
            String sqlUserInfo = "CREATE TABLE IF NOT EXISTS UserInfo (" +
                "userid INT AUTO_INCREMENT, " +
                "username VARCHAR(255), " +
                "userType INT, " +
                "PRIMARY KEY (userid))";

            stmt.executeUpdate(sqlUserInfo);

            // StudentInfo 테이블 생성 쿼리
            String sqlStudentInfo =
                "userid INT, " +
                "major VARCHAR(255), " +
                "year INT, " +
                "maxCredit INT, " +
                "currentCredit INT DEFAULT 0, " +
                "totalCredit INT DEFAULT 0, " +
                "PRIMARY KEY (userid), " +
                "FOREIGN KEY (userid) REFERENCES UserInfo(userid))";

            stmt.executeUpdate(sqlStudentInfo);
        }

        catch (SQLException e) {
            System.out.println("Failed to create tables: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        try {
        	
            // enrollmentinfo 테이블 생성 쿼리
            String sqlEnrollmentInfo = 
                "courseid INT NOT NULL, " +
                "section INT NOT NULL, " +
                "currentStudent INT DEFAULT NULL, " +
                "maxStudent INT DEFAULT NULL, " +
                "credits INT DEFAULT NULL, " +
                "building INT DEFAULT NULL, " +
                "room INT DEFAULT NULL, " +
                "type INT DEFAULT NULL, " +
                "day INT NOT NULL, " +
                "time INT NOT NULL, " +
                "major VARCHAR(45) DEFAULT NULL, " +
                "courseName VARCHAR(45) DEFAULT NULL, " +
                "professor VARCHAR(45) DEFAULT NULL, " +
                "prerequisite VARCHAR(45) DEFAULT NULL, " +
                "PRIMARY KEY (courseid, section, day, time)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";

            stmt.executeUpdate(sqlEnrollmentInfo);
        }catch (SQLException e) {
            System.out.println("Failed to create the table 'enrollmentinfo': " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        try {
            // enrollmentinfo 테이블 생성 쿼리
            String sqlCurrentEnrollmentInfo = 
                "section INT NOT NULL, " +
                "courseName VARCHAR(45) DEFAULT NULL, " +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";

            stmt.executeUpdate(sqlCurrentEnrollmentInfo);
        }catch (SQLException e) {
            System.out.println("Failed to create the table 'enrollmentinfo': " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }

    // 데이터 삽입 메소드
    public void insertData() {
        PreparedStatement pstmt = null;
        try {
            String dbURL = DB_URL + "SUGANG";  
            conn = DriverManager.getConnection(dbURL, user, pwd);

            // 데이터 삽입 쿼리
            String sqlInsert = "INSERT INTO enrollmentinfo (courseid, section, currentStudent, maxStudent, credits, " +
                "building, room, type, day, time, major, courseName, professor, prerequisite) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sqlInsert);

            // 데이터 삽입
            pstmt.setInt(1, 10000);
            pstmt.setInt(2, 1);
            pstmt.setInt(3, 20);
            pstmt.setInt(4, 50);
            pstmt.setInt(5, 3);
            pstmt.setInt(6, 310);
            pstmt.setInt(7, 727);
            pstmt.setInt(8, 1);
            pstmt.setInt(9, 1);
            pstmt.setInt(10, 3);
            pstmt.setString(11, "cs");
            pstmt.setString(12, "자료구조");
            pstmt.setString(13, "김교수");
            pstmt.setString(14, null);
            pstmt.executeUpdate();

            pstmt.setInt(1, 10001);
            pstmt.setInt(2, 1);
            pstmt.setInt(3, 50);
            pstmt.setInt(4, 100);
            pstmt.setInt(5, 3);
            pstmt.setInt(6, 310);
            pstmt.setInt(7, 727);
            pstmt.setInt(8, 1);
            pstmt.setInt(9, 2);
            pstmt.setInt(10, 4);
            pstmt.setString(11, "cs");
            pstmt.setString(12, "알고리즘");
            pstmt.setString(13, "김교수");
            pstmt.setString(14, "자료구조");
            pstmt.executeUpdate();
        }

        catch (SQLException e) {
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
    }

    // 데이터베이스 연결을 종료하는 메소드
    public void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        }
        catch (SQLException e) {
            System.out.println("Failed to close the database connection.");
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
}
