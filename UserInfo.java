package login;

public class UserInfo {
	protected int userid;
	protected String username;
	
	public UserInfo(int userid, String username) {
		this.userid=userid;
		this.username=username;
	}
	
	public void viewUserInfo() {
		System.out.println("userid: "+userid);
		System.out.println("username: "+username);
	}
}
