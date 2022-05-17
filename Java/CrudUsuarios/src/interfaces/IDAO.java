package interfaces;

import java.util.List;

public interface IDAO<T> {
	boolean create(T user);
	T getOne(int id);
	List<T> getAll();
	boolean update(T user);
	boolean delete(int id);
}
