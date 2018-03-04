package model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CalendarDTO;
import model.dto.UserDTO;

public interface ICalendar {
	
	public CalendarDTO getById(int idCalendario) throws SQLException;
	public ArrayList<CalendarDTO> getByIdUser(UserDTO usuario) throws SQLException;
	public ArrayList<CalendarDTO> getAll() throws SQLException;
	public boolean update(CalendarDTO calendario) throws SQLException;
	public boolean insert(CalendarDTO calendario) throws SQLException;
	public boolean delete(CalendarDTO calendario) throws SQLException;
	
}
