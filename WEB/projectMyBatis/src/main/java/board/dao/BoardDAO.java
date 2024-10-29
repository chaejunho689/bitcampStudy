package board.dao;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;


public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	private static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 글작성 
	public void write(BoardDTO boardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.write", boardDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 글 목록
	public List<BoardDTO> boardList(Map<String,Object>map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		
		return list;
	}
	
	// 총 글 수
	public int getTotalA() {
		int totalA = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalA = sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		
		return totalA;
	}

	
}//end line
