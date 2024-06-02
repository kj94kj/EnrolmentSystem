package login;

//조건입력받고 해당되는거 보여주는 역할만함. 
public class Search {
	SearchProcess sp=new SearchProcess();
	
	public void search() {
		sp.condition();
		sp.search();
	}
}
