package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import member.bean.MemberDTO;

public class MemberDAO {
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
//	private String username = "c##java";
//	private String password = "1234";
	
	private PreparedStatement pstmt;
	private Connection con;
	private ResultSet rs;
	
	private DataSource ds;
	
	private static MemberDAO memberDAO = new MemberDAO();

	
	public static MemberDAO getInstance() {
		return memberDAO;
	}
	
	public MemberDAO() {
//		try {
//			Class.forName(ds.driver);
//			//			System.out.println("driver loading...");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

//	public void getConnection() {
//		try {
//			con = DriverManager.getConnection(url, username, password);
//			if (con != null) {
//				System.out.println("Connection established");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connection failed: " + e.getMessage());
//		}
//	}
	
	public boolean isExistId(String id) {
		boolean yn = false;
//		getConnection();
		
		 id = id.toUpperCase(); // JAVA 대문자로 치환
		
		String sql = "SELECT ID FROM MEMBER WHERE UPPER(ID)= ?";


		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();

			 if(!rs.next()) {
				 yn = false;
			 } else {
				 yn = true;
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
		return yn;
	}
	
	
//	public void register(String id, String pwd1, String name, int gender, String tel1, String tel2, String tel3, String email1, String email2, String zipcode, String addr1, String addr2) {
	public void register(MemberDTO memberDTO) {
//		getConnection();
		
		String sql = "INSERT INTO MEMBER(ID, PWD, NAME, GENDER, EMAIL1, EMAIL2, TEL1, TEL2, TEL3, ZIPCODE, ADDR1, ADDR2, LOGTIME) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,memberDTO.getId());
			pstmt.setString(2,memberDTO.getPassword());
			pstmt.setString(3,memberDTO.getName());
			pstmt.setString(4,memberDTO.getGender());
			pstmt.setString(5,memberDTO.getEmail1());
			pstmt.setString(6,memberDTO.getEmail2());
			pstmt.setString(7,memberDTO.getTel1());
			pstmt.setString(8,memberDTO.getTel2());
			pstmt.setString(9,memberDTO.getTel3());
			pstmt.setString(10,memberDTO.getZipcode());
			pstmt.setString(11,memberDTO.getAddr1());
			pstmt.setString(12,memberDTO.getAddr2());
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
	
	
	public MemberDTO login(String id, String pwd) {
		MemberDTO memberDTO = null;

		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PWD=?";
		
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				memberDTO = new MemberDTO();
				
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPassword(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
			}
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
		return memberDTO;
	}
	
	public MemberDTO getMember(String id) {
//		List<MemberDTO> memberSelect = new ArrayList<MemberDTO>();
		MemberDTO memberDTO = null;
		
		String sql = "SELECT ID, PWD, NAME, GENDER, EMAIL1, EMAIL2, TEL1, TEL2, TEL3, ZIPCODE, ADDR1, ADDR2, LOGTIME FROM MEMBER WHERE ID=?";
//		boolean loginYn = false;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
	        // 쿼리와 파라미터 값을 출력
	        System.out.println("Executing SQL: " + sql);
	        System.out.println("With Parameter: ID = " + id);

			
	        if (rs.next()) {
				memberDTO = new MemberDTO();

				memberDTO.setId(rs.getString("ID"));
				memberDTO.setPassword(rs.getString("PWD"));
				memberDTO.setName(rs.getString("NAME"));
				memberDTO.setGender(rs.getString("GENDER"));
				memberDTO.setEmail1(rs.getString("EMAIL1"));
				memberDTO.setEmail2(rs.getString("EMAIL2"));
				memberDTO.setTel1(rs.getString("TEL1"));
				memberDTO.setTel2(rs.getString("TEL2"));
				memberDTO.setTel3(rs.getString("TEL3"));
				memberDTO.setZipcode(rs.getString("ZIPCODE"));
				memberDTO.setAddr1(rs.getString("ADDR1"));
				memberDTO.setAddr2(rs.getString("ADDR2"));
			}
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
		
		return memberDTO;
	}
	
	
	public void update(MemberDTO memberDTO) {
//		List<MemberDTO> memberSelect = new ArrayList<MemberDTO>();
		
		String sql = "UPDATE MEMBER SET PWD=? , NAME=?, GENDER=?, EMAIL1=?, EMAIL2=?, TEL1=?, TEL2=?, TEL3=?, ZIPCODE=?, ADDR1=?, ADDR2=?, LOGTIME=sysdate WHERE ID=?";
//		boolean loginYn = false;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,memberDTO.getPassword());
			pstmt.setString(2,memberDTO.getName());
			pstmt.setString(3,memberDTO.getGender());
			pstmt.setString(4,memberDTO.getEmail1());
			pstmt.setString(5,memberDTO.getEmail2());
			pstmt.setString(6,memberDTO.getTel1());
			pstmt.setString(7,memberDTO.getTel2());
			pstmt.setString(8,memberDTO.getTel3());
			pstmt.setString(9,memberDTO.getZipcode());
			pstmt.setString(10,memberDTO.getAddr1());
			pstmt.setString(11,memberDTO.getAddr2());
			pstmt.setString(12,memberDTO.getId());
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
	
	

}
