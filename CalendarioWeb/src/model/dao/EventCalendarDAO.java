package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.pojo.EventCalendar;
import model.interfaces.IEventCalendar;
import util.Config;

public class EventCalendarDAO implements IEventCalendar {

	private static final Config dbInstance = Config.getInstance();
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private EventCalendar eventCalendar = null;
	private ArrayList<EventCalendar> eventCalendars = null;
	private int value = 0;
	private static EventCalendarDAO instance = null;
	
	private EventCalendarDAO() {
		
	}
	
	public static EventCalendarDAO getInstance() {
		if (instance == null) {
			instance = new EventCalendarDAO();
		}
		
		return instance;
	}
	
	@Override
	public ArrayList<EventCalendar> getByTime(int anio, int mes, int dia, int idUsuario) throws SQLException {
		eventCalendars = new ArrayList<>();
		eventCalendar = null;
		ps = dbInstance.getConnection().prepareStatement("SELECT idEvento, evento.nombre AS nombre, anio, mes, dia, hora, minuto, segundo, duracion, color" + 
				" FROM evento LEFT JOIN calendario ON evento.idCalendario = calendario.idCalendario" + 
				" WHERE anio = ? AND mes = ? AND dia = ? AND idUsuario = ? ");
		ps.setInt(1, anio);
		ps.setInt(2, mes);
		ps.setInt(3, dia);
		ps.setInt(4, idUsuario);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			eventCalendar = new EventCalendar(rs.getInt("idEvento"),
											  rs.getString("nombre"),
											  rs.getInt("anio"),
											  rs.getInt("mes"),
											  rs.getInt("dia"),
											  rs.getInt("hora"),
											  rs.getInt("minuto"),
											  rs.getInt("segundo"),
											  rs.getInt("duracion"),
											  rs.getString("color"));
			
			eventCalendars.add(eventCalendar);
		}
		ps.close();
		rs.close();
				
		return eventCalendars;
	}

	@Override
	public boolean delete(int idCalendar) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("DELETE FROM evento WHERE idCalendario = ?");
		ps.setInt(1, idCalendar);
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

}
