package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atraccion.Atraccion;
import promociones.Promocion;
import promociones.PromocionAbsoluta;
import promociones.PromocionAxB;
import promociones.PromocionPorcentual;

public class PromocionDAO extends DAOGenerico<Promocion> {
	private static String TIPO_ABSOLUTA = "absoluta";
	private static String TIPO_PORCENTUAL = "porcentual";
	
	public ArrayList<Promocion> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM promocion");
	}
	
	public Promocion armarObjeto(ResultSet resultado) throws SQLException {
		int id = resultado.getInt("id");
		String tipoPromocion = resultado.getString("fk_tipo_promo");
		String tipoAtraccion = resultado.getString("fk_tipo_atraccion");
		Promocion promocion;
		ArrayList<Atraccion> atracciones = DAO.getAtraccionDAO().buscarTodoPorIdPromocion(id);
		
		if (tipoPromocion.equalsIgnoreCase(TIPO_PORCENTUAL)) {
			promocion = new PromocionPorcentual(
					id,
					tipoAtraccion,
					this.getDescuento(id),
					atracciones
				);
		} else if (tipoPromocion.equalsIgnoreCase(TIPO_ABSOLUTA)) {
			promocion = new PromocionAbsoluta(
					id,
					tipoAtraccion,
					this.getDescuento(id),
					atracciones
				);
		} else { // AxB
			promocion = new PromocionAxB(
					id,
					tipoAtraccion,
					DAO.getAtraccionDAO().buscarGratisPorIdPromocion(id),
					atracciones
				);
		}
		
		return promocion;
	}
	
	private double getDescuento(int id) throws SQLException {
		ResultSet resultado = super.getResultsetSelect("SELECT descuento FROM promocion_descuento WHERE fk_id_promocion = " + id);
		resultado.next();
		
		return resultado.getDouble("descuento");
	}
	
	public ArrayList<Promocion> buscarTodoPorIdVisitante(int idVisitante) throws SQLException {
		String sql = "SELECT * FROM promocion"
				+ " JOIN itinerario_promocion ON promocion.id = itinerario_promocion.fk_id_promocion"
				+ " WHERE itinerario_promocion.fk_id_itinerario = " + idVisitante;
		return super.ejecutarSelect(sql);
	}
}
