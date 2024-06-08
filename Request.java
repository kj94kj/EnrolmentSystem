package login;

import java.util.ArrayList;
import java.util.List;

public class Request {
	private RequestProcess rp;
	private EnrollRequestProcess erp;
	private String state;
	
	public Request(String courseName, String major, int section, int courseCredit, 
			ArrayList<int[]> timeSlot, String prerequsite, StudentInfo si) {
		this.rp=new EnrollRequestProcess(courseName,major,section,courseCredit, timeSlot,prerequsite, si);
	}
	
	
	public void setRequestProcess(RequestProcess rp) {
		this.rp=rp;
	}
	
	public void request() {
		if(rp instanceof EnrollRequestProcess) {
			erp=(EnrollRequestProcess)rp;
			
			erp.setMajorCredit();
			erp.setCourseNameArr();
			erp.checkEnrollmentHistory();
			erp.checkStudentInfo();
			erp.DBInsert();
		}
	}
}
