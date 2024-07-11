package DAO;
import java.sql.*; //디비연결
import java.util.*;//리스트 불러오기
import DTO.BoardDTO;

public class BoardDAO {
	private BoardDAO() {
		
	}//생성자 막기
	private static BoardDAO instance = new BoardDAO();
	//스태틱변수로 객체생성, 
	
	public static BoardDAO getInstance() {
		return instance;
	}//겟터만 만들어서 사용가능, 세터안만들어서 수정 불가
	
	public Connection getConnection()throws Exception {
		Connection conn = null;
		String url= "jdbc:mysql://127.0.0.1:3306/sample";
		String db_id = "root";
		String db_pw = "iotiot";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn= DriverManager.getConnection(url,db_id,db_pw);
		
		
		
		return conn; //Connection 생성
		
		
	}//getConection
	
	public List<BoardDTO> getList(int currentPage, int recordsPerPage) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int start = (currentPage-1)*recordsPerPage;
		
		String sql = "select * from board limit ? , ?;";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,start);
			pstmt.setInt(2, recordsPerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO bDTO = new BoardDTO();
				bDTO.setNum(rs.getInt("num"));
				bDTO.setTitle(rs.getString("title"));
				bDTO.setContent(rs.getString("content"));
				list.add(bDTO);
				
				
			}//while
			
		}catch(Exception e) {
			System.out.println("getList ing error"+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception ex) {
				System.out.println("getList end error "+ex);
			}
		}//trycatch
		
		
		
		return list;
	}//getList
	
	public int getPage() {
		int npage = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select count(num) from board;";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			rs.next();
			npage = rs.getInt("count(num)");
			
			
		}catch(Exception e) {
			System.out.println("getPage ing error "+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception ex) {
				System.out.println("getPage end erro "+ex);
			}
		}//finally
		
		
		
		return npage;
	}
}
