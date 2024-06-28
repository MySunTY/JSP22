package DAO;
import java.sql.*; //conn불러오기

public class MemberDAO {
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn=null;
		String url = "jdbc:mysql://127.0.0.1:3306/sample";
		String db_id ="root";
		String db_pw="iotiot";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,db_id,db_pw);
		
		return conn;
	}
}
