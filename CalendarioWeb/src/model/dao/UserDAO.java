package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import model.dto.UserDTO;
import model.interfaces.IUser;
import util.Config;

public class UserDAO implements IUser {

	private static final Config dbInstance = Config.getInstance();
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private UserDTO user = null;
	//private ArrayList<UserDTO> listUser = null;
	private int value = 0;
	private static UserDAO instance = null;
	
	private UserDAO() {
		
	}
	
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		
		return instance;
	}
	
	@Override
	public UserDTO getByLogin(String usuario, String pass) throws SQLException {
		user = null;
		ps = dbInstance.getConnection().prepareStatement("SELECT idUsuario FROM usuario WHERE usuario_login = ? AND usuario_pass = ? LIMIT 0, 1");
		ps.setString(1, usuario);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		while(rs.next()) {
			user = new UserDTO(rs.getInt("idUsuario"));
		}
		rs.close();
		ps.close();
		
		return user;
	}

	@Override
	public boolean insert(UserDTO userdto) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("INSERT INTO usuario VALUES(NULL, ?, ?, ?, ?, ?)");
		ps.setString(1, userdto.getUsuario_login());
		ps.setString(2, userdto.getUsuario_pass());
		ps.setString(3, userdto.getNombre());
		ps.setString(4, userdto.getApellido());
		ps.setString(5, userdto.getEmail());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

	@Override
	public boolean update(UserDTO userdto) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("UPDATE usuario SET usuario_login = ?, usuario_pass = ?, nombre = ?, apellido = ?, email = ? WHERE idUsuario = ?");
		ps.setString(1, userdto.getUsuario_login());
		ps.setString(2, userdto.getUsuario_pass());
		ps.setString(3, userdto.getNombre());
		ps.setString(4, userdto.getApellido());
		ps.setString(5, userdto.getEmail());
		ps.setInt(6, userdto.getIdUsuario());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

	@Override
	public boolean delete(UserDTO user) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
		ps.setInt(1, user.getIdUsuario());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

}
