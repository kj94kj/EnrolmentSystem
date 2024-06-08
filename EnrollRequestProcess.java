package login;

import java.util.ArrayList;
import java.util.List;

public class EnrollRequestProcess extends RequestProcess {
	
	private ArrayList<String> courseNameArr;
	private String major;	//학생클래스 전공
	
	public EnrollRequestProcess(String courseName, String major, int section, int courseCredit, 
			ArrayList<int[]> timeSlot, String prerequsite, StudentInfo si) {
		super(courseName, major, section, courseCredit, timeSlot, prerequsite, si);
	}
	
	public void setCourseNameArr() {
		//학생 객체 입력받고(main)에서 courseNameArr에 이전에 들었던 수업들을 세팅해줍니다.
		int size=si.getEnrollmentHistory().size();
		
		for(int i=0; i<size; i++) {
			courseNameArr.add(si.getEnrollmentHistory().get(i).getCourseName());
		}
	}
	
	@Override
	public void setMajorCredit() {
		this.major=si.getMajor();
		this.credit=si.getMaxCredit()-si.getCurrentCredit();
	}
	
	@Override
	public void checkEnrollmentHistory() {
		
		//현재 수강신청하려는 과목과 같은 과목을 수강한적 있는지 체크합니다.
		for(String pastName: courseNameArr) {
			if(courseName.equals(pastName)) {
				state="실패";
				System.out.println("수강 실패: 같은 과목을 수강하신적이 있습니다.");
				return;
			}
		}
		
		//현재 수강신청하려는 과목의 선수과목을 수강했는지 체크합니다.
		
		for(String pastName: courseNameArr) {
			if(pastName.equals(prerequisite)) {
				state="성공";
				return;
			}
		}
		
		state="실패";
		System.out.println("수강 실패: 선수과목을 듣지 않았습니다.");
	}
	
	// 학생의 과, 잔여학점을 체크
	@Override
	public void checkStudentInfo() {
		if(!courseMajor.equals(this.major)) {
			System.out.println("수강 실패: 같은 과의 과목을 선택해주세요.");
			state="실패";
			return;
		}
		
		if(credit-courseCredit<0) {
			System.out.println("수강 실패: 잔여 학점이 부족합니다.");
			state="실패";
			return;
		}
		
		state="성공";
	}
	
	//!!시간표 체크하기 나중에 구현
	public void checkTimeSlot() {
		int size=timeslot.size();
	}
	
	//state가 성공이면 sqlCurrentEnrollmentInfo에 저장하기.
	public void DBInsert() {
		if(state.equals("성공")) {
			InsertCurrent.insertCurrent(major, section);
			si.setCurrentCredit(courseCredit);
		}
	}
}
