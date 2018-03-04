package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CalendarDTO;
import model.dto.UserDTO;
import model.interfaces.ICalendar;
import util.Config;

public class CalendarDAO implements ICalendar {
	
	private static final Config dbInstance = Config.getInstance();
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private CalendarDTO calendario = null;
	private ArrayList<CalendarDTO> calendarios = null;
	private int value = 0;
	private static CalendarDAO instance = null;
	
	private CalendarDAO() {
		
	}
	
	public static CalendarDAO getInstance() {
		if (instance == null) {
			instance = new CalendarDAO();
		}
		
		return instance;
	}
	
	@Override
	public CalendarDTO getById(int idCalendario) throws SQLException {
		calendario = null;
		ps = dbInstance.getConnection().prepareStatement("SELECT idCalendario, idUsuario, nombre, color FROM calendario WHERE idCalendario = ? LIMIT 0, 1");
		ps.setInt(1, idCalendario);
		rs = ps.executeQuery();
		while(rs.next()) {
			calendario = new CalendarDTO(rs.getInt("idCalendario"),
										 new UserDTO(rs.getInt("idUsuario")),
										 rs.getString("nombre"),
										 rs.getString("color"));
		}
		ps.close();
		rs.close();
				
		return calendario;
	}
	
	@Override
	public ArrayList<CalendarDTO> getByIdUser(UserDTO usuario) throws SQLException {
		calendarios = new ArrayList<>();
		calendario = null;
		ps = dbInstance.getConnection().prepareStatement("SELECT idCalendario, idUsuario, nombre, color FROM calendario WHERE idUsuario = ?");
		ps.setInt(1, usuario.getIdUsuario());
		rs = ps.executeQuery();
		while(rs.next()) {
			calendario = new CalendarDTO(rs.getInt("idCalendario"),
										 new UserDTO(rs.getInt("idUsuario")),
										 rs.getString("nombre"),
										 rs.getString("color"));
			
			calendarios.add(calendario);
		}
		ps.close();
		rs.close();
				
		return calendarios;
	}

	@Override
	public ArrayList<CalendarDTO> getAll() throws SQLException {
		calendarios = new ArrayList<>();
		calendario = null;
		ps = dbInstance.getConnection().prepareStatement("SELECT idCalendario, idUsuario, nombre, color FROM calendario");
		rs = ps.executeQuery();
		while(rs.next()) {
			calendario = new CalendarDTO(rs.getInt("idCalendario"),
										 new UserDTO(rs.getInt("idUsuario")),
										 rs.getString("nombre"),
										 rs.getString("color"));
			
			calendarios.add(calendario);
		}
		ps.close();
		rs.close();
		
		return calendarios;
	}

	@Override
	public boolean update(CalendarDTO calendario) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("UPDATE calendario SET idUsuario = ?, nombre = ?, color = ? WHERE idCalendario = ?");
		ps.setInt(1, calendario.getUsuario().getIdUsuario());
		ps.setString(2, calendario.getNombre());
		ps.setString(3, calendario.getColor());
		ps.setInt(4, calendario.getIdCalendario());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

	@Override
	public boolean insert(CalendarDTO calendario) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("INSERT INTO calendario (idUsuario, nombre, color) VALUES (?, ?, ?)");
		ps.setInt(1, calendario.getUsuario().getIdUsuario());
		ps.setString(2, calendario.getNombre());
		ps.setString(3, calendario.getColor());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

	@Override
	public boolean delete(CalendarDTO calendario) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("DELETE FORM calendario WHERE idCalendario = ?");
		ps.setInt(1, calendario.getIdCalendario());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

	
}
