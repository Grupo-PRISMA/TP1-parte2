package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atraccion.Atraccion;
import jdbc.ConnectionProvider;

public class AtraccionDAO extends DAOGenerico<Atraccion> {

	public Atraccion armarObjeto(ResultSet resultado) throws SQLException {
		return new Atraccion(
					resultado.getInt("id"), 
					resultado.getString("nombre"), 
					resultado.getString("fk_tipo"),
					resultado.getDouble("costo"), 
					resultado.getDouble("duracion"), 
					resultado.getInt("cupo")
		);
	}

	public ArrayList<Atraccion> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM atraccion ORDER BY costo DESC, duracion DESC");
	}
	
	public Atraccion buscarPorId(int id) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM atraccion WHERE id = " + id).get(0);
	}

	public int actualizar(Atraccion atraccion) throws SQLException {
		String sql = "UPDATE"
						+ " atraccion"
					+ " SET"
						+ " cupo = " + atraccion.getCupoPersonas()
					+ " WHERE"
						+ " id = " + atraccion.getId();
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	public ArrayList<Atraccion> buscarTodoPorIdPromocion(int idPromocion) throws SQLException {
		String sql = "SELECT * FROM atraccion"
				+ " JOIN promocion_atraccion ON atraccion.id = promocion_atraccion.fk_id_atraccion"
				+ " WHERE promocion_atraccion.fk_id_promocion = " + idPromocion;
		return super.ejecutarSelect(sql);
	}
	
	public Atraccion buscarGratisPorIdPromocion(int idPromocion) throws SQLException {
		String sql = "SELECT * FROM atraccion"
				+ " JOIN promocion_atraccion_gratis ON atraccion.id = promocion_atraccion_gratis.fk_id_atraccion"
				+ " WHERE promocion_atraccion_gratis.fk_id_promocion = " + idPromocion;
		return super.ejecutarSelect(sql).get(0);
	}
	
	public ArrayList<Atraccion> buscarTodoPorIdVisitante(int idVisitante) throws SQLException {
		String sql = "SELECT * FROM atraccion"
				+ " JOIN itinerario_atraccion ON atraccion.id = itinerario_atraccion.fk_id_atraccion"
				+ " WHERE itinerario_atraccion.fk_id_itinerario = " + idVisitante;
		return super.ejecutarSelect(sql);
	}
}
