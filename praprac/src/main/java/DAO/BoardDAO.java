package DAO;
import java.sql.*;
import java.util.*;
import DTO.BoardDTO;

public class BoardDAO {
	
	private BoardDAO() {
		
	}
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}//회선 싱글톤 처리
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/sample";
		String db_id = "root";
		String db_pw = "iotiot";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,db_id,db_pw);
		
		return conn;
	}//conn
	
	public List<BoardDTO> findList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board;";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO bDTO = new BoardDTO();
				
				bDTO.setNum(rs.getInt("num"));
				bDTO.setTitle(rs.getString("title"));
				bDTO.setContent(rs.getString("content"));
				list.add(bDTO);
				
				
			}
			
			
		}catch(Exception e) {
			System.out.println("findList ing error "+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
				
			}catch(Exception ex) {
				System.out.println("findList end error"+ex);
			}
		}//finally
		
		
		return list;
	}
	
	
	
}
