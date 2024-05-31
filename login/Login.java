package login;

public class Login {
	private boolean result=false;
	
	public void login(String loginid, String password) {
		//로그인하고 결과만 담는 클래스.
		
		LoginProcess lp=new LoginProcess();
		 result=lp.isLogin(loginid, password);	
		 
		 if(result==true) {
			 System.out.println("로그인 성공");
		 }
		 else {
			 System.out.println("로그인 실패");
		 }
	}
	
	public boolean getResult() {
		return result;
	}
}
