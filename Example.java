package login;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
        // 사용자에게 사용자 이름을 입력받습니다
        String username = "root"; 
        // 사용자에게 비밀번호를 입력받습니다
        String password = "mysql";

        // Database 객체를 생성하고 데이터베이스에 연결, 생성, 초기화 및 종료
        Database db = new Database(username, password);

        db.connect();
        db.createDatabase("sugang");  // 실제 사용할 데이터베이스 이름 입력
        db.createTables();
        db.insertData();
		
		Scanner sc=new Scanner(System.in);
		Login login=new Login();
		LoginInfo li=null;
		
		while(!login.getResult()) {
			System.out.println("아이디를 입력하세요.");
			String loginid=sc.nextLine();
			System.out.println("비밀번호를 입력하세요.");
			String loginPassword=sc.nextLine();
			
			login.login(loginid, loginPassword);
			if(login.getResult()) {
				li=login.getLoginInfo();
			}
		}
		
		//학생일경우 userType=0이다.
		if(li.getuserType()==0) {
			
		}
		
		sc.close();
        db.disconnect();
	}
}
