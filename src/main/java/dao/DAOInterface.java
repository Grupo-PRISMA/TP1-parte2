package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {

	public List<T> findAll() throws SQLException;

	public int update(T t) throws SQLException;
}
