package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static String url = "jdbc:sqlite:TP2.db";
	private static Connection conexion;

	public static Connection getConexion() throws SQLException {
		if (conexion == null) {
			conexion = DriverManager.getConnection(url);
		}

		return conexion;
	}
}
