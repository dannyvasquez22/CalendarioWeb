package model.bl;

import java.sql.SQLException;

import model.dao.EventDAO;
import model.dto.EventDTO;

public class EventBL {

	private static EventBL instance = null;
	
	private EventBL() {
		
	}
	
	public static EventBL getInstance() {
		if (instance == null) {
			instance = new EventBL();
		}
		
		return instance;
	}
	
	public boolean insert(EventDTO event) throws SQLException {
		return EventDAO.getInstance().insert(event);
	}
	
	public boolean update(EventDTO event) throws SQLException {
		return EventDAO.getInstance().update(event);
	}
	
	public boolean delete(EventDTO event) throws SQLException {
		return EventDAO.getInstance().delete(event);
	}
}
