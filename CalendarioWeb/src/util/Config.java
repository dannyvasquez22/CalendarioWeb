package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Config {

	private Connection conecta = null;
	public static Config instance = null;	
	private String driver = "com.mysql.jdbc.Driver";
	private String host = "localhost";
	private String port = "3306";
	private String dbName = "calendarioweb";
	private String userName = "root";
	private String password = "1234";
//	private String[] settings = DatabaseFile.read();
//	private String host = settings[0];
//	private String port = settings[1];
//	private String dbName = settings[2];
//	private String userName = settings[3];
//	private String password = settings[4];
	private String url = "jdbc:mysql://" + host + ":" + port + "/";
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	private int value = 0;
	
	public synchronized static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		
		return instance;
	}
	
	private Config() {
		try {
			Class.forName(driver);
			conecta = DriverManager.getConnection(url + dbName, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			destruir();
			System.exit(1);
		}
	}
	
	public Connection getConnection() {
		return conecta;
	}
	
	public int totalRows() throws SQLException {
		value = -1;
		ps = conecta.prepareStatement("SELECT FOUND_ROWS() AS total");
		rs = ps.executeQuery();
		while(rs.next()) {
			value = rs.getInt("total");
		}
		rs.close();
		ps.close();
		
		return value;
	}
	
	public void destruir() {
		if (conecta != null) {
			try {
				conecta.close();
			} catch(Exception e) {
				
			}
		}
	}
	
}
