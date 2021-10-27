package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import visitante.Visitante;
import jdbc.ConnectionProvider;

public class VisitanteDAO extends DAOGenerico<Visitante> {
	
	@Override
	public Visitante armarObjeto(ResultSet resultado) throws SQLException {
		return new Visitante(
					resultado.getInt("id"), 
					resultado.getString("nombre"), 
					resultado.getString("fk_preferencia"),
					resultado.getDouble("presupuesto"), 
					resultado.getDouble("tiempo") 
		);
	}
	
	public ArrayList<Visitante> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM visitante ORDER BY nombre ASC");
	}
	
	public Visitante buscarPorId(int id) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM visitante WHERE id = " + id).get(0);
	}
	
	public int actualizar(Visitante visitante) throws SQLException {
		String sql = "UPDATE"
						+ " visitante"
					+ " SET"
						+ " presupuesto = " + visitante.getPresupuesto()
						+ ", tiempo = " + visitante.getTiempoDisponibleHs()
					+ " WHERE"
						+ " id = " + visitante.getId();
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
}
