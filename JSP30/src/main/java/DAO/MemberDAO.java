package DAO;
import java.sql.*;
import DTO.Member; //자바에게 member가 무엇인지 설계도를 보여줌

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
	//사용자 정보 조회(userid기반 검색) -전체정보조회 -session에 들어갈 데이터를 제작
	public Member getMember(String userid){
		Member m=null;
		String sql= "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) { //resultset이 empty set이 아니라면 한줄을 읽고 {}내부를 실행
				m=new Member(); // private타입 변수 7개와 getset메서드 14개로 이루어진 객체
				m.setNum(rs.getString("num"));  //DB내부의 데이터를 객체 내부 필드에 복사
				m.setName(rs.getString("name"));
				m.setUserid(rs.getString("userid"));
				m.setPwd(rs.getString("pwd"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAdmin(rs.getString("admin"));
			}
			
			
			
		}catch(Exception e) {
			System.out.println("getMember(String userid)접속중 오류발생 "+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception ex) {
				System.out.println("getMember(String userid)접속해제중 오류발생 "+ex);
			}
		}
		return m;
	}
	// 사용자 정보 조회(userid 기반 검색) - 비밀번호만 조회
	public int userCheck(String userid, String pwd) {
		int result = -1; // -1:회원 가입이 안된 경우, 0 : 비밀번호오류  1: 로그인성공
		String sql = "select pwd from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = getConnection();// 위에서 만든 연결 메서드 불러오기
			pstmt = conn.prepareStatement(sql); //stmt는 선제작후 실행시 sql 주입 , pstmt는 제작시 sql 주입
			pstmt.setString(1, userid); 		//pstmt 의 ? 순서는 0이 아니고 1부터 시작
			rs = pstmt.executeQuery();				//pstmt는 실행시에는 sql을 별도로 주지 않는다.
			
			if(rs.next()) {
				// select 문의 결과가 있는 경우
				System.out.println("비밀번호 확인 : "+rs.getString("pwd"));
				System.out.println("결과확인1 : "+rs.getString("pwd").equals(pwd));
				System.out.println("결과확인2 : "+rs.getString("pwd")!=null);
				if(rs.getString("pwd").equals(pwd) && rs.getString("pwd")!=null) {
					//비밀번호가 일치하고 데이터베이스의 pwd가 null이 아닐경우 ( pwd는 primarykey가 아니라 null값이 가능하기 때문)
					result=1;
				}else {
					//비밀번호가 틀렸거나, 회원가입시 비밀번호를 null로 만든경우
					result = 0;
				}
			}else { 
				//select문의 결과가 empty set인 경우
				result = -1;
			}
			
		}catch(Exception e) {
			System.out.println("usercheck(userid,pwd) error"+e); //메소드 오버로드가 있을수있기때문에 매개변수도 같이 적어줌
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception ex) {
				System.out.println("usercheck(userid,pwd) 해제중 error"+ex);
			}
		}
		
		return result;
		
	}
	//아이디 중복체크 확인용 메서드
	public int confirmId(String userId) {
		int result = -1;	//select문 결과가 있으면 1 결과가 없으면 -1
		String sql = "select userid from member where userid=?";
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result=1; // 이미 가입된 아이디가 있음
			}else {
				result =-1; // 사용가능한 아이디
			}
			
		}catch(Exception e) {
			System.out.println("confirmId(String userId) 접속중 error"+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception ex){
				System.out.println("confirmId(String userId) 접속해제중 error"+ex); //해제중 오류발생시 서버 껐다키면 해결
			}
		}
		
		
		
		return result;
	}
	
	
}