package login;

public class LoginProcess {
	private int userid;
	private int userType;
	
	public boolean isLogin(String loginid, String password) {
		//DB에서 로그인 정보를 찾으면 UserInfo에 userid, userType를 담는다.
		//!! DB연결 추가구현해야함.
		boolean temp=true;	//!! 임시로해둠. 원래 로그인성공해야 true로 바뀜.
		
		if(temp) {
			//userid 12345, userType=0 가정
			userid=12345;
			userType=0;
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public LoginInfo insertLoginInfo() {
		return new LoginInfo(userid, userType);
	}
}
