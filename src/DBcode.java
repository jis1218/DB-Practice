import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBcode {
	
	private static final String URL = "jdbc:mysql://localhost:3306/prac";
	private static final String ID = "root";
	private static final String PW = "1004";
	
	public DBcode(){
		
		try {
			//ClassŬ������ �ܺο����ۼ��� Ŭ������ ����ҋ� ����Ŭ�����ε� 
			//�Ű������� JDBC�� ����̹� ���� Ŭ���� ��ġ�� ����־���Ѵ�
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void create(){
		try(Connection con = DriverManager.getConnection(URL, ID, PW)){
			
			String insertQuery = " insert into memo(name) values(?)";
			
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			ps.setString(1, "hello!");
			
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void read(String no){
		ArrayList<Memo> list = new ArrayList<>();
		
		
		try(Connection con = DriverManager.getConnection(URL, ID, PW)){
			
			String selectQuery = " select * from memo where name = '" + no + "'"; 
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(selectQuery);
			
			while(set.next()){		
				Memo memo = new Memo();
				memo.num = set.getInt("no");
				memo.name = set.getString("name");
				
				list.add(memo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Memo memo : list){		
			System.out.println("��ȣ�� " + memo.num);
			System.out.println("�̸��� " + memo.name);
		}
	}
	
	

}
