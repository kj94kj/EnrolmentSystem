package login;

import java.util.Scanner;

public class SearchProcess implements Find{
	private int day;
	private int time;
	private String major;
	private String courseName; 
	
	Scanner sc=new Scanner(System.in);
	
	//조건을 입력하는 함수. 편의상 조건을 전부 입력하게함.
	public void condition() {
		System.out.println("과목명을 입력하세요");
		courseName=sc.nextLine();
		System.out.println("전공을 입력하세요");
		major=sc.nextLine();
		System.out.println("요일과 시간을 입력하세요.");
		System.out.println("1~6: 월요일~토요일, 1~10 교시");
		day=sc.nextInt();
		time=sc.nextInt();
	}
	
	//! DB로 필드에 저장된거와 비교해서 보여줌.
	@Override
	public boolean find() {
		//과목명은 필수 입력임.
		//다른것은 0을 입력하면 비교안함.
	}
}

