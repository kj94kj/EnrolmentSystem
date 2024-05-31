package login;

public class LoginInfo {
	//userid, userType를 담는다.
	//!! userType에따라 자식객체를 만들어서(StudentInfo, ProfessorInfo, AdminInfo) 저장하는거 구현.
	protected int userid;
	protected int userType;	
}
