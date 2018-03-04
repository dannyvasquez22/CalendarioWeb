package model.interfaces;

import java.sql.SQLException;

import model.dto.UserDTO;

public interface IUser {

	public UserDTO getByLogin(String user, String pass) throws SQLException;
	public boolean insert(UserDTO user) throws SQLException;
	public boolean update(UserDTO user) throws SQLException;
	public boolean delete(UserDTO user) throws SQLException;
}
