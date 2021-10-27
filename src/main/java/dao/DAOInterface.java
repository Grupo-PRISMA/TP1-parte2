package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOInterface<T> {

	public ArrayList<T> buscarTodo() throws SQLException;
}
