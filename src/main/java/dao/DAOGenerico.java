package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionProvider;

public abstract class DAOGenerico<T> implements DAOInterface<T> {
	
	public ResultSet getResultsetSelect(String sql) throws SQLException {
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeQuery();
	}
	
	public ArrayList<T> ejecutarSelect(String sql) throws SQLException {
		ResultSet resultado = this.getResultsetSelect(sql);

		ArrayList<T> lista = new ArrayList<T>();
		
		while (resultado.next()) {
			lista.add(armarObjeto(resultado));
		}
		
		return lista;
	}
	
	public abstract T armarObjeto(ResultSet resultado) throws SQLException;
}
