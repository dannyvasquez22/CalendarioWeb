package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import model.dto.EventDTO;
import model.interfaces.IEvent;
import util.Config;

public class EventDAO implements IEvent {

	private static final Config dbInstance = Config.getInstance();
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private EventDTO evento = null;
	private ArrayList<EventDTO> eventos = null;
	private int value = 0;
	private static EventDAO instance = null;
	
	private EventDAO() {
		
	}
	
	public static EventDAO getInstance() {
		if (instance == null) {
			instance = new EventDAO();
		}
		
		return instance;
	}
	
	@Override
	public boolean insert(EventDTO event) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("INSERT INTO evento (idEvento, idCalendario, nombre, anio, mes, dia, hora, minuto, segundo, duracion) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, event.getIdEvent());
		ps.setInt(2, event.getCalendario().getIdCalendario());
		ps.setString(3, event.getNombre());
		ps.setInt(4, event.getAnio());
		ps.setInt(5, event.getMes());
		ps.setInt(6, event.getDia());
		ps.setInt(7, event.getHora());
		ps.setInt(8, event.getMinuto());
		ps.setInt(9, event.getSegundo());
		ps.setInt(10, event.getDuracion());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

	@Override
	public boolean update(EventDTO event) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("UPDATE evento SET idCalendario = COALESCE(?, idCalendario), "
				+ "nombre = COALESCE(?, nombre), anio = COALESCE(?, anio), mes = COALESCE(?, mes), dia = COALESCE(?, dia), hora = COALESCE(?, hora), "
				+ "minuto = COALESCE(?, minuto), segundo = COALESCE(?, segundo), duracion = COALESCE(?, duracion) WHERE idEvento = ?");
		if(event.getCalendario() == null) {
			ps.setNull(1, Types.INTEGER);
		} else {
			ps.setInt(1, event.getCalendario().getIdCalendario()); 
		}
		if(event.getNombre() == null) {
			ps.setNull(2, Types.VARCHAR);
		} else {
			ps.setString(2, event.getNombre()); 
		}
		if(event.getAnio() <= 0) {
			ps.setNull(3, Types.INTEGER);
		} else {
			ps.setInt(3, event.getAnio()); 
		}
		if(event.getMes() <= 0) {
			ps.setNull(4, Types.INTEGER);
		} else {
			ps.setInt(4, event.getMes()); 
		}
		if(event.getDia() <= 0) {
			ps.setNull(5, Types.INTEGER);
		} else {
			ps.setInt(5, event.getDia()); 
		}
		if(event.getHora() <= 0) {
			ps.setNull(6, Types.INTEGER);
		} else {
			ps.setInt(6, event.getHora()); 
		}
		if(event.getMinuto() <= 0) {
			ps.setNull(7, Types.INTEGER);
		} else {
			ps.setInt(7, event.getMinuto()); 
		}
		if(event.getSegundo() <= 0) {
			ps.setNull(8, Types.INTEGER);
		} else {
			ps.setInt(8, event.getSegundo()); 
		}
		if(event.getDuracion() <= 0) {
			ps.setNull(9, Types.INTEGER);
		} else {
			ps.setInt(9, event.getDuracion()); 
		}
		ps.setInt(10, event.getIdEvent());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

	@Override
	public boolean delete(EventDTO event) throws SQLException {
		value = 0;
		ps = dbInstance.getConnection().prepareStatement("DELETE FROM evento WHERE idEvento = ?");
		ps.setInt(1, event.getIdEvent());
		value = ps.executeUpdate();
		ps.close();
		
		return (value > 0);
	}

}
