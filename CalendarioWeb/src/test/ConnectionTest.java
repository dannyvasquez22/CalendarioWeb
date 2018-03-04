package test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import util.Config;

class ConnectionTest {

	@Test
	void test() {
		Config dbInstance = Config.getInstance();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			ps = dbInstance.getConnection().prepareStatement("SELECT * FROM usuario");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt("idUsuario"));
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
