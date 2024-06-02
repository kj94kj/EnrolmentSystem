package login;

import java.util.Scanner;

public class SearchProcess {
	private int[] day=new int[2];	//처음엔 요일, 두번째는 시간
	private int type;	//전필, 전기, 핵교, 선교 구분.
	private String major;
	private String courseName; 
	
	Scanner sc=new Scanner(System.in);
	
	//조건을 입력하는 함수. 편의상 조건을 전부 입력하게함.
	public void condition() {
		System.out.println("과목명을 입력하세요");
		courseName=sc.nextLine();
		System.out.println("전공을 입력하세요");
		major=sc.nextLine();
		System.out.println("전필은 1 전기는 2 핵교는 3 선교는 4를 입력하세요.");
		type=sc.nextInt();
		System.out.println("요일과 시간을 입력하세요.");
		System.out.println("1~6: 월요일~토요일, 1~10 교시");
		day[1]=sc.nextInt();
		day[2]=sc.nextInt();
	}
	
	//! DB로 필드에 저장된거와 비교해서 보여줌.
	public void search() {
		
	}
}

