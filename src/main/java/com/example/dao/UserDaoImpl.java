package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.model.Login;
import com.example.model.User;

public class UserDaoImpl implements UserDao {

	class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int unused) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setPhone(rs.getInt("phone"));
			return user;
		}
		
	}
	
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int register(User user) {
		String sql = "insert into public.users values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { user.getUsername(),
						                               user.getPassword(),
						                               user.getFirstname(),
						                               user.getLastname(),
						                               user.getEmail(),
						                               user.getAddress(),
						                               user.getPhone() });
	}
	
	public User validateUser(Login login) {
		String sql = "select * from public.users where username='" + login.getUsername() 
		                                      + "' and password='" + login.getPassword() + "'";
		final List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return !users.isEmpty() ? users.get(0) : null;
	}
	
}
