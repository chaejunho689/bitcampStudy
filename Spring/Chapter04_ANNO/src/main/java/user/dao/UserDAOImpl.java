package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;

@Repository
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	};
	
	@Override
	public void write(UserDTO userDTO) {
		Map<String, String> map = new HashMap<>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		String sql = "insert into usertable values(:name,:id,:pwd)";
		getNamedParameterJdbcTemplate().update(sql, map);
	}
	
	
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
	}


	@Override
	public UserDTO getExistId(String id) {
		String sql = "select * from usertable where id = ?";
		try {
			
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO> (UserDTO.class),id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}


	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}


	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=?";
		getJdbcTemplate().update(sql, id);
		
	}
	
}


