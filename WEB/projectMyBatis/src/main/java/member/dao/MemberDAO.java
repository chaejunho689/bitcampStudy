package member.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	private static MemberDAO memberDAO = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return memberDAO;
	}
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public boolean isExistId(String id) {
		boolean yn = false;
		
		id = id.toUpperCase(); // JAVA 대문자로 치환
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistId", id);
		sqlSession.close();
		
		if(memberDTO != null) {
			yn = true;
		}
		
		return yn;
	}
	
	
	public void register(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("memberSQL.register", memberDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	public MemberDTO login(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		memberDTO = sqlSession.selectOne("memberSQL.login", memberDTO);
		sqlSession.close();
		
		return memberDTO;
	}
	
	public void update(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("memberSQL.update", memberDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public MemberDTO getMember(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.getMember", id);
		sqlSession.close();
		
		return memberDTO;
	}
	
	
	

}
