package login;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo extends UserInfo{ 
	//!! enroll도 부모객체 만들고 수강신청 클래스, 장바구니 클래스, 수강신청 했던 클래스 나누기.
	private String major;
	private int year;
	private int maxCredit;	//신청할 수 있는 학점.
	private int currentCredit=0; //현재 신청한 학점.
	private int totalCredit=0;	//여태 들었던 총 학점.
	private ArrayList<EnrollmentHistoryInfo> enrollments;	//StudentProcess에서 리스트 만들 예정.
	
	public StudentInfo(String major, int year,int maxCredit,int userid, String username, ArrayList<EnrollmentHistoryInfo> enrollments) {
		super(userid, username);
		this.major=major;
		this.year=year;
		this.maxCredit=maxCredit;
		this.enrollments=enrollments;
		setTotalCredit(this.enrollments);
	}
	
	//수강신청 과목 선택했을 때 setCurrentCredit호출해서 현재학점에 더함.
	public void setCurrentCredit(int credit) {
		currentCredit+=credit;
	}
	
	private void setTotalCredit(List<EnrollmentHistoryInfo> enrollments) {
		
		for(EnrollmentHistoryInfo enrollment: enrollments) {
			totalCredit+=enrollment.getCredit();
		}
		
	}
	
	@Override
	public void viewUserInfo() {
		super.viewUserInfo();
		System.out.println("전공은: "+major);
		System.out.println("학년은: "+year);
		System.out.println("제한학점은: "+maxCredit);
		System.out.println("신청학점은: "+currentCredit);
	}
	
	public void viewEnrollmentsInfo() {
		System.out.println("총 이수학점은: "+totalCredit);
		
		for(EnrollmentHistoryInfo enrollment: enrollments) {
			System.out.println("수업 학점은: "+enrollment.getCredit());
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
}
