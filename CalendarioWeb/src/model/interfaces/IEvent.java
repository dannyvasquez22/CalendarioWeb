package model.interfaces;

import java.sql.SQLException;

import model.dto.EventDTO;

public interface IEvent {

	public boolean insert(EventDTO event) throws SQLException;
	public boolean update(EventDTO event) throws SQLException;
	public boolean delete(EventDTO event) throws SQLException;
	
}
