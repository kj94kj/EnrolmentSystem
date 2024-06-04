package login;

import java.util.ArrayList;
import java.util.List;

public class Request {
	private StudentInfo si;
	
	//!클래스로 받던지 해야함..
	private String courseName;
	private String major;
	private int section;
	private int credit;
	private ArrayList<int[]> timeSlot;	//요일하고 시간을 담음.
	
	
	private RequestProcess rp;
	private String state;
	
	//!검색해서 선택한것을 입력받음. 나중에구현
	public void setField(String courseName, String major, int section, int credit, 
			ArrayList<int[]> timeSlot){
		this.courseName=courseName;
		this.major=major;
		this.section=section;
		this.credit=credit;
		this.timeSlot=timeSlot;
	}
	
	//다른것도 생성자 수준에서 세팅되게
	public Request(StudentInfo si) {
		this.si=si;
	}
	
	public void setRequestProcess(RequestProcess rp) {
		this.rp=rp;
	}
	
	public void request() {
		rp.checkEnrollmentHistory(courseName);
		rp.setMajorCredit(si);
		rp.checkStudentInfo(major, credit);
		state=rp.getState();
	}
}
