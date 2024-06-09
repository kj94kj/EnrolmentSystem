package login;

public class Enroll {
	Search search=new Search();
	StudentInfo si;
	Request rq;
	
	public Enroll(StudentInfo si) {
		this.si=si;
	}
	
	public void enroll() {
		search.search();
	}
	
	private void setRQ() {
		
	}
	
}
