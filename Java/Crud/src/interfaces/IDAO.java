package interfaces;

import java.util.List;

public interface IDAO<T> {
	boolean salvar(T obj);
	T getOne(int id);
	List<T> getAll();
	boolean alterar(T obj);
	boolean deletar(int id);
}
