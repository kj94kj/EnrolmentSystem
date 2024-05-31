package login;

public class Login {
	//로그인하고 결과담고, 로그인정보 담음.
	private boolean result=false;
	LoginProcess lp;
	LoginInfo li;
	
	public void login(String loginid, String password) {
		
		lp=new LoginProcess();
		 result=lp.isLogin(loginid, password);	
		 
		 if(result==true) {
			 System.out.println("로그인 성공");
			 li=lp.insertLoginInfo();
		 }
		 else {
			 System.out.println("로그인 실패");
		 }
	}
	
	public boolean getResult() {
		return result;
	}
	
	public LoginInfo getLoginInfo() {
		return li;
	}
}
