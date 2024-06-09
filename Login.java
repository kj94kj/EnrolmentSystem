package login;

public class Login {
	//로그인하고 결과담고, 로그인정보 담음.
	private boolean result=false;
	LoginProcess lp;
	LoginInfo li;
	
	public void login(String loginid, String password) {
		
		lp=new LoginProcess(loginid, password);
		result=lp.authenticateUser();	
		 
		if(result==true) {
			lp.setLoginInfo();
			li=lp.getLoginInfo();
		}
	}
	
	public boolean getResult() {
		return result;
	}
	
	public LoginInfo getLoginInfo() {
		return li;
	}
}
