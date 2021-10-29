package dao;

public class DAO {
	private static AtraccionDAO atraccionDAO;
	private static VisitanteDAO visitanteDAO;
	private static PromocionDAO promocionDAO;
	private static ItinerarioDAO itinerarioDAO;

	public static AtraccionDAO getAtraccionDAO() {
		if (atraccionDAO == null) {
			atraccionDAO = new AtraccionDAO();
		}

		return atraccionDAO;
	}

	public static VisitanteDAO getVisitanteDAO() {
		if (visitanteDAO == null) {
			visitanteDAO = new VisitanteDAO();
		}

		return visitanteDAO;
	}

	public static PromocionDAO getPromocionDAO() {
		if (promocionDAO == null) {
			promocionDAO = new PromocionDAO();
		}

		return promocionDAO;
	}

	public static ItinerarioDAO getItinerarioDAO() {
		if (itinerarioDAO == null) {
			itinerarioDAO = new ItinerarioDAO();
		}

		return itinerarioDAO;
	}
}
