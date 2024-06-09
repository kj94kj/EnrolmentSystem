package login;

public class UserInfo {
	protected String userid;
	protected String username;
	
	public UserInfo(String userid, String username) {
		this.userid=userid;
		this.username=username;
	}
	
	public UserInfo(String userid) {
		
	}
	
	public void viewUserInfo() {
		System.out.println("userid: "+userid);
		System.out.println("username: "+username);
	}
}
