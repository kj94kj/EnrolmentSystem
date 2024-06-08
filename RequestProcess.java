package login;

import java.util.ArrayList;

//E_RequestProcess, B_RequestProcess 두가지 만듦.
public abstract class RequestProcess {
	protected String courseName;	//수강신청하려는 과목이름
	protected String major;
	protected int section;
	protected int courseCredit;	//수강신청하려는 과목 학점
	protected String courseMajor;	//수강신청하려는 과목 전공
	protected ArrayList<int[]> timeslot;
	protected String prerequisite; //수강신청하려는 과목의 선수과목
	protected StudentInfo si;
	protected int credit;
	
	public RequestProcess(String courseName, String courseMajor, int section, int courseCredit, 
			ArrayList<int[]> timeSlot, String prerequsite, StudentInfo si) {
		this.courseName=courseName;
		this.courseMajor=courseMajor;
		this.section=section;
		this.courseCredit=courseCredit;
		this.timeslot=timeSlot;
		this.prerequisite=prerequsite;
		this.si=si;
	}
	
	String state="성공";
	
	// 이전에 수강했던것중 같은이름 있나 체크
	public abstract void checkEnrollmentHistory();
	
	// 학생의 과, 잔여학점을 체크
	public abstract void checkStudentInfo();
	
	public abstract void setMajorCredit();
	
	//E에서는 가능, 불가능을 리턴하고 B에서는 장바구니, 예비과목을 리턴한다.
	public String getState() {
		return state;
	}
}
