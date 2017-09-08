
public class MainDB {
	
	DBcode code = new DBcode();
	
	public static void main(String args[]){
		
		MainDB main = new MainDB();
		
		main.code.create();
		
		main.code.read("beat");
	}

}
