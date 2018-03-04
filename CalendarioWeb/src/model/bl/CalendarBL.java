package model.bl;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.CalendarDAO;
import model.dto.CalendarDTO;
import model.dto.UserDTO;

public class CalendarBL {

	private static CalendarBL instance = null;
	
	private CalendarBL() {
		
	}
	
	public static CalendarBL getInstance() {
		if (instance == null) {
			instance = new CalendarBL();
		}
		
		return instance;
	}
	
	public CalendarDTO getById(int idCalendario) throws SQLException {
		return CalendarDAO.getInstance().getById(idCalendario);
	}
	
	public ArrayList<CalendarDTO> getByIdUser(UserDTO usuario) throws SQLException {
		return CalendarDAO.getInstance().getByIdUser(usuario);
	}
	
	public ArrayList<CalendarDTO> getAll() throws SQLException {
		return CalendarDAO.getInstance().getAll();
	}
	
	public boolean insert(CalendarDTO calendario) throws SQLException {
		return CalendarDAO.getInstance().insert(calendario);
	}
	
	public boolean update(CalendarDTO calendario) throws SQLException {
		return CalendarDAO.getInstance().update(calendario);
	}
	
	public boolean delete(CalendarDTO calendario) throws SQLException {
		return CalendarDAO.getInstance().delete(calendario);
	}
}
