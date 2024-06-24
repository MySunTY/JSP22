package DAO;
import java.sql.*;

public class MemberDAO {
	//회선의 역할을 해줄 개체이므로 여러개가 생겨버리면 데이터의 일관성문제의 원인이 될 수 있다.
	//따라서 회선은 전체 서비스에서 단 하나만 사용할 수 있도록 객체 생성을 만든다.
	private MemberDAO() { //private이기때문에 해당 클래스내부에서만 사용가능, 객체생성 원천 차단
		
	}
	private static MemberDAO instance = new MemberDAO();
	//필드를 만들어봐야 생성자를 막았으니 사용이 불가능
	//생성자가 막혔음에도 해당 필드의 내용을 사용할 수 있도록 static 타입으로 변경
	//static 타입의 변수에 객체를 담았으니 해당 객체는 2개 이상 존재할 수 없다.(1개만 존재)
	//해당 필드의 값을 다른 개발자가 변경하면 문제의 원인이 되니 private 타입으로 변경해서 사용불가처리
	//회선의 단일성 유지 ; get으로 데이터를 꺼낼수는 있게하고 set은 안만들어서 수정 안되게함
	public static MemberDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception {
		Connection conn=null;
		String url ="jdbc:mysql://127.0.0.1:3306/sample";
		String db_id="root";
		String db_pw = "iotiot";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,db_id,db_pw);
		
		
		return conn;
	}
	
}
