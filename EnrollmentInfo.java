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
	private int day;
	private int time;
	private String major;
	private String courseName; 
	private String professor;
	private String prerequisite;
	
	public EnrollmentInfo(int courseid, int currentStudent, int maxStudent, int credits, int building,
			int room, int section, int day, int time, String major, String courseName, String professor, String prerequisite) {
		this.courseid=courseid;
		this.currentStudent=currentStudent;
		this.maxStudent=maxStudent;
		this.credits=credits;
		this.building=building;
		this.room=room;
		this.section=section;
		this.day=day;
		this.time=time;
		this.major=major;
		this.courseName=courseName;
		this.professor=professor;
		this.prerequisite=prerequisite;
	}
	
}
