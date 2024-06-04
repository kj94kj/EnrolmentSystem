package login;

import java.util.ArrayList;
import java.util.List;

public class EnrollRequestProcess extends RequestProcess {
	
	ArrayList<String> courseNameArr;
	String major;	//학생클래스 전공
	int credit;	//학생클래스 잔여학점
	
	public void setCourseNameArr(StudentInfo si) {
		//학생 객체 입력받고(main)에서 set해줌.
	}
	
	public void setMajorCredit(StudentInfo si) {
		this.major=si.getMajor();
		this.credit=si.getMaxCredit()-si.getCurrentCredit();
	}
	
	// 이전에 수강했던것중 같은이름 있나 체크
	@Override
	public void checkEnrollmentHistory(String courseName) {
		//!! courseNameArr에 EnrollmentHistoryInfo의 수강목록을 담아야함.
		
		for(String pastName: courseNameArr) {
			if(courseName.equals(pastName)) {
				state="실패";
				return;
			}
		}
		state="성공";
	}
	
	// 학생의 과, 잔여학점을 체크
	@Override
	public void checkStudentInfo(String major, int credit) {
		if(!major.equals(this.major)) {
			state="실패";
			return;
		}
		
		if(this.credit-credit<0) {
			state="실패";
			return;
		}
		
		state="성공";
	}
	
}
