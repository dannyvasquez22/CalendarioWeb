package model.bl;

import java.sql.SQLException;

import model.dao.UserDAO;
import model.dto.UserDTO;

public class UserBL {

	private static UserBL instance = null;
	
	private UserBL() {
		
	}
	
	public static UserBL getInstance() {
		if (instance == null) {
			instance = new UserBL();
		}
		
		return instance;
	}
	
	public UserDTO getLogin(String user, String pass) throws SQLException {
		return UserDAO.getInstance().getByLogin(user, pass);
	}
	
	public boolean insert(UserDTO user) throws SQLException {
		return UserDAO.getInstance().insert(user);
	}
	
	public boolean update(UserDTO user) throws SQLException {
		return UserDAO.getInstance().update(user);
	}
	
	public boolean delete(UserDTO user) throws SQLException {
		return UserDAO.getInstance().delete(user);
	}
}
