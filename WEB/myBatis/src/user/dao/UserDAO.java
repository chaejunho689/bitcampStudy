package user.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




public class UserDAO {
	private static UserDAO userDAO = new UserDAO();
	private SqlSessionFactory SqlSessionFactory;
	
	public static UserDAO getInstance() {
		return userDAO;
	}
	
	public UserDAO() {
		try {
			Reader reader = Resources.getResourceAsReader(null);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
