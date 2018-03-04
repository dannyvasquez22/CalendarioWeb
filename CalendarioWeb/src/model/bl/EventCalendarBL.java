package model.bl;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.EventCalendarDAO;
import model.pojo.EventCalendar;

public class EventCalendarBL {

	private static EventCalendarBL instance;
	
	private EventCalendarBL() {
		
	}
	
	public static EventCalendarBL getInstance() {
		if (instance == null) {
			instance = new EventCalendarBL();
		}
		
		return instance;
	}
	
	public ArrayList<EventCalendar> getByTime(int anio, int mes, int dia, int idUsuario) throws SQLException {
		return EventCalendarDAO.getInstance().getByTime(anio, mes, dia, idUsuario);
	}
	
	public boolean delete(int idCalendar) throws SQLException {
		return EventCalendarDAO.getInstance().delete(idCalendar);
	}
}
