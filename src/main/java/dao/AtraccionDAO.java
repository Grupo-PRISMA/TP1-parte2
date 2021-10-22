package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import atraccion.Atraccion;
import jdbc.ConnectionProvider;

public class AtraccionDAO implements DAOInterface<Atraccion> {

	//Este metodo de findAll podría ser generico, ya que lo vamos a utilizar en todos los DAO)
	@Override
	public List<Atraccion> findAll() throws SQLException {
		String sql = "SELECT * FROM atraccion";
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		ResultSet resultado = declaracion.executeQuery();
		
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		while(resultado.next()) {
			atracciones.add(toAtraccion(resultado));
		}
		return atracciones;
	}

	private Atraccion toAtraccion(ResultSet resultado) {
		
		return null;
	}

	@Override
	public int update(Atraccion t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}	
}
