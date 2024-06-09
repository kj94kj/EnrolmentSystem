package login;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo extends UserInfo {
    private String major;
    private int year;
    private int maxCredit;   // 신청할 수 있는 최대 학점
    private int currentCredit = 0; // 현재 신청한 학점
    private int totalCredit = 0;   // 지금까지 들었던 총 학점
    private ArrayList<EnrollmentHistoryInfo> enrollmentHistory;
    private int[][] timeslot=new int[6][10];

    public StudentInfo(String major, int year, int maxCredit, String userid, String username, ArrayList<EnrollmentHistoryInfo> enrollments) {
        super(userid, username);
        this.major = major;  
        this.year = year;   
        this.maxCredit = maxCredit;  
        this.enrollmentHistory = enrollments;  
        setTotalCredit(enrollments);
    }

    // 수강신청 과목 선택 후 setCurrentCredit 호출해서 현재학점에 더함
    public void setCurrentCredit(int credit) {
        currentCredit += credit;
    }

    private void setTotalCredit(List<EnrollmentHistoryInfo> enrollmentHistory) {
        for (EnrollmentHistoryInfo enrollment : enrollmentHistory) {
            totalCredit += enrollment.getCredit();
        }
    }

    public void viewUserInfo() {
        super.viewUserInfo();
        System.out.println("전공은: " + major);
        System.out.println("학년은: " + year);
        System.out.println("제한학점은: " + maxCredit);
        System.out.println("신청학점은: " + currentCredit);
    }

    public void viewEnrollmentsInfo() {
        System.out.println("총 이수학점은: " + totalCredit);

        for (EnrollmentHistoryInfo enrollment : enrollmentHistory) {
            System.out.println("수업 학점은: " + enrollment.getCredit());
        }
    }
    
    public int getCurrentCredit() {
        return currentCredit;
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public String getMajor() {
        return major;
    }
    
    public ArrayList<EnrollmentHistoryInfo> getEnrollmentHistory() {
    	return enrollmentHistory;
    }
    
    public int[][] getTimeslot(){
    	return timeslot;
    }
}

