package login;

//조건입력받고 해당되는거 보여주는 역할만함. 
//검색할때 7, 8, 9교시면 객체 3개가 나와서 ~~7교시입니다. ~~8교시입니다.
//~~9교시 입니다. 하게 나오면 좋을듯.
public class Search {
	SearchProcess sp=new SearchProcess();
	
	public void search() {
		sp.condition();
		sp.find();
	}
}
