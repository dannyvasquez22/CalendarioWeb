package model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import model.pojo.EventCalendar;

public interface IEventCalendar {

	public ArrayList<EventCalendar> getByTime(int anio, int mes, int dia, int idUsuario) throws SQLException;
	public boolean delete(int idCalendar) throws SQLException;
}
