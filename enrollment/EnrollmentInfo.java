package login;

//수업목록 검색후 해당 조건에 맞는 수업들을 보여준다.
public class EnrollmentInfo {
	private int courseid;
	private int currentStudent;
	private int maxStudent;
	private int credits;
	private int building;
	private int room;
	private int section;
	private int type; //전필, 전기, 핵교, 선교 구분.
	private int[] day;	//처음엔 요일, 두번째는 시간
	private String major;
	private String courseName; 
	private String professor;
	
	public EnrollmentInfo(int courseid, int currentStudent, int maxStudent, int credits, int building,
			int room, int section, int[] day, String major, String courseName, String professor) {
		this.courseid=courseid;
		this.currentStudent=currentStudent;
		this.maxStudent=maxStudent;
		this.credits=credits;
		this.building=building;
		this.room=room;
		this.section=section;
		this.day=day;
		this.major=major;
		this.courseName=courseName;
		this.professor=professor;
	}
	
	
}
