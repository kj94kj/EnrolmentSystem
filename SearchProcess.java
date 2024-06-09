package login;

import java.sql.*;
import java.util.Scanner;

public class SearchProcess {
    private int day;    // 요일
    private int time;   // 시간
    private int type;   // 전필, 전기, 핵교, 선교 구분.
    private String major;
    private String courseName;

    Scanner sc = new Scanner(System.in);

    // 조건을 입력하는 함수. 편의상 조건을 전부 입력하게함.
    public void condition() {
        System.out.println("과목명을 입력하세요");
        courseName = sc.nextLine();
        System.out.println("전공을 입력하세요");
        major = sc.nextLine();
        System.out.println("전필은 1 전기는 2 핵교는 3 선교는 4를 입력하세요.");
        type = sc.nextInt();
        System.out.println("요일과 시간을 입력하세요.");
        System.out.println("1~6: 월요일~토요일, 1~10 교시");
        day = sc.nextInt();
        time = sc.nextInt();
    }

    public boolean find() {
        // 과목명은 필수 입력임. 다른것은 0을 입력하면 비교안함.
        if (courseName == null || courseName.isEmpty()) {
            System.out.println("과목명은 필수 입력입니다.");
            return false;
        }

        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/sugang";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(DB_URL, username, password)) {
            Class.forName(JDBC_DRIVER);

            // SQL 쿼리 생성
            StringBuilder query = new StringBuilder("SELECT * FROM enrollmentinfo WHERE courseName = ?");
            if (!major.isEmpty()) query.append(" AND major = ?");
            if (type > 0) query.append(" AND type = ?");
            if (day > 0) query.append(" AND day = ?");
            if (time > 0) query.append(" AND time = ?");

            try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
                int paramIndex = 1;
                pstmt.setString(paramIndex++, courseName);

                if (!major.isEmpty()) pstmt.setString(paramIndex++, major);
                if (type > 0) pstmt.setInt(paramIndex++, type);
                if (day > 0) pstmt.setInt(paramIndex++, day);
                if (time > 0) pstmt.setInt(paramIndex++, time);

                try (ResultSet rs = pstmt.executeQuery()) {
                    boolean resultFound = false;
                    while (rs.next()) {
                        resultFound = true;
                        System.out.println("Course ID: " + rs.getInt("courseid"));
                        System.out.println("Section: " + rs.getInt("section"));
                        System.out.println("Current Students: " + rs.getInt("currentStudent"));
                        System.out.println("Max Students: " + rs.getInt("maxStudent"));
                        System.out.println("Credits: " + rs.getInt("credits"));
                        System.out.println("Building: " + rs.getInt("building"));
                        System.out.println("Room: " + rs.getInt("room"));
                        System.out.println("Type: " + rs.getInt("type"));
                        System.out.println("Day: " + rs.getInt("day"));
                        System.out.println("Time: " + rs.getInt("time"));
                        System.out.println("Major: " + rs.getString("major"));
                        System.out.println("Course Name: " + rs.getString("courseName"));
                        System.out.println("Professor: " + rs.getString("professor"));
                        System.out.println("Prerequisite: " + rs.getString("prerequisite"));
                        System.out.println("------------");
                    }

                    if (!resultFound) {
                        System.out.println("No results found.");
                    }

                    return resultFound;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}  