package login;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Login login=new Login();
		LoginInfo li=null;
		
		while(!login.getResult()) {
			System.out.println("아이디를 입력하세요.");
			String loginid=sc.nextLine();
			System.out.println("비밀번호를 입력하세요.");
			String password=sc.nextLine();
			
			login.login(loginid, password);
			if(login.getResult()) {
				li=login.getLoginInfo();
			}
		}
		
		//!! LoginInfo의 userType이용해서 각 DB접근해서 유저객체를 저장하기
		
		try{
			System.out.println(li.userid);
			System.out.println(li.userType);
		}catch(Exception e) {
			
		}
		
		
		sc.close();
	}
}
