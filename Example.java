package login;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Login login=new Login();
		
		while(!login.getResult()) {
			System.out.println("아이디를 입력하세요.");
			String loginid=sc.nextLine();
			System.out.println("비밀번호를 입력하세요.");
			String password=sc.nextLine();
			
			login.login(loginid, password);
		}
		
		
		sc.close();
	}
}
