package login;

//E_RequestProcess, B_RequestProcess 두가지 만듦.
public abstract class RequestProcess {
	String state;
	
	// 이전에 수강했던것중 같은이름 있나 체크
	public abstract void checkEnrollmentHistory(String courseName);
	
	// 학생의 과, 잔여학점을 체크
	public abstract void checkStudentInfo(String major, int credit);
	
	public abstract void setMajorCredit(StudentInfo si);
	
	//E에서는 가능, 불가능을 리턴하고 B에서는 장바구니, 예비과목을 리턴한다.
	public String getState() {
		return state;
	}
}
