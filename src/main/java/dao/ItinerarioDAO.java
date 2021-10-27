package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atraccion.Atraccion;
import jdbc.ConnectionProvider;
import promociones.Promocion;
import sugerencia.Sugerencia;
import visitante.Visitante;

public class ItinerarioDAO extends DAOGenerico<Sugerencia> {
	
	public ArrayList<Sugerencia> buscarTodoPorIdVisitante(int idVisitante) throws SQLException {

		ArrayList<Sugerencia> sugerencias = new ArrayList<>();
		
		ArrayList<Promocion> promociones = DAO.getPromocionDAO().buscarTodoPorIdVisitante(idVisitante);
		for (Promocion promocion : promociones) {
			sugerencias.add(new Sugerencia(promocion));
		}

		ArrayList<Atraccion> atracciones = DAO.getAtraccionDAO().buscarTodoPorIdVisitante(idVisitante);
		for (Atraccion atraccion : atracciones) {
			sugerencias.add(new Sugerencia(atraccion));
		}

		return sugerencias;
	}

	@Override
	public Sugerencia armarObjeto(ResultSet resultado) throws SQLException {
		return null;
	}
	
	public int insertarParaVisitante(Visitante visitante, ArrayList<Sugerencia> itinerario) throws SQLException {
		int filas = 0;
		
		String sql = "INSERT INTO itinerario(fk_id_visitante) VALUES(" + visitante.getId() + ")";
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		try {
			filas += declaracion.executeUpdate();
		} catch (SQLException e) {
		}
		
		for (Sugerencia sugerencia : itinerario) {
			if (sugerencia.esPromo()) {
				sql = "INSERT INTO itinerario_promocion(fk_id_itinerario, fk_id_promocion)"
						+ " VALUES(" + visitante.getId() + ", " + sugerencia.getIds().get(0) + ")";
		
				declaracion = conexion.prepareStatement(sql);
				try {
					filas += declaracion.executeUpdate();
				} catch (SQLException e) {
				}
				
			} else {
				for (Integer id : sugerencia.getIds()) {
					sql = "INSERT INTO itinerario_atraccion(fk_id_itinerario, fk_id_atraccion)"
							+ " VALUES(" + visitante.getId() + ", " + id + ")";
				}

				declaracion = conexion.prepareStatement(sql);
				try {
					filas += declaracion.executeUpdate();	
				} catch (SQLException e) {
				}
			}
		}
		
		return filas;
	}

	@Override
	public ArrayList<Sugerencia> buscarTodo() throws SQLException {
		return null;
	}
}
