package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;


public class BoardDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private ResultSet rs;
	
	private DataSource ds;
	
	
	private static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	
	public BoardDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	// 글작성 
	public void write(BoardDTO boardDTO) {
		
		String sql = "INSERT INTO BOARD(SEQ, ID, SUBJECT, CONTENT, EMAIL, NAME, REF, LEV, STEP, PSEQ, REPLY, HIT, LOGTIME) "
				+ "SELECT seq_board.NEXTVAL, ?, ?, ?, EMAIL1 || '@' || EMAIL2 AS EMAIL, NAME, 0, 0, 0, 0, 0, 0, SYSDATE "
				+ "FROM MEMBER "
				+ "WHERE ID = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,boardDTO.getId());
			pstmt.setString(2,boardDTO.getSubject());
			pstmt.setString(3,boardDTO.getContent());
			pstmt.setString(4,boardDTO.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	// 글작성 
	// 글 목록 조회를 Map으로 변경
	public List<Map<String, Object>> boardList() {
	    List<Map<String, Object>> boardList = new ArrayList<>();
	    String sql = "SELECT * FROM BOARD";
	    
	    try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery(); // executeUpdate는 변경 작업에 사용되고 조회에는 executeQuery를 사용해야 합니다.
	        
	        while (rs.next()) {
	            Map<String, Object> boardMap = new HashMap<>();
	            
	            boardMap.put("seq", rs.getInt("seq"));
	            boardMap.put("id", rs.getString("id"));
	            boardMap.put("name", rs.getString("name"));
	            boardMap.put("email", rs.getString("email"));
	            boardMap.put("subject", rs.getString("subject"));
	            boardMap.put("content", rs.getString("content"));
	            boardMap.put("ref", rs.getInt("ref"));
	            boardMap.put("lev", rs.getInt("lev"));
	            boardMap.put("step", rs.getInt("step"));
	            boardMap.put("pseq", rs.getInt("pseq"));
	            boardMap.put("reply", rs.getInt("reply"));
	            boardMap.put("hit", rs.getInt("hit"));
	            
	            boardList.add(boardMap);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return boardList;
	}
	*/
	

	public List<BoardDTO> boardList(int startNum, int endNum) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String sql = """	
					select * from
					(select rownum rn, tt.* from
					(select * from board order by ref desc, step asc)tt
					)where rn>=? and rn<=?
					""";

		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNum);			
			pstmt.setInt(2, endNum);
			
	        rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
		        boardDTO.setEmail(rs.getString("email"));
		        boardDTO.setSubject(rs.getString("subject"));
		        boardDTO.setContent(rs.getString("content"));
		        boardDTO.setRef(rs.getInt("ref"));
		        boardDTO.setLev(rs.getInt("lev"));
		        boardDTO.setStep(rs.getInt("step"));
		        boardDTO.setPseq(rs.getInt("pseq"));
		        boardDTO.setReply(rs.getInt("reply"));
		        boardDTO.setHit(rs.getInt("hit"));
		        boardDTO.setLogtime(rs.getDate("logtime"));
				
				list.add(boardDTO);	
				
			}//while
			
		} catch(SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		      
		return list;
	}; 
	
	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) from board";
		
		try {
			con = ds.getConnection();

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
	
			rs.next();
			totalA = rs.getInt(1); //1번 컬럼의 값
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		return totalA;
	}

	
	
}//end line
