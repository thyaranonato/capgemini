package dao;

import java.util.List;

import entidades.Contato;
import interfaces.IDAO;

public class DaoContato implements IDAO<Contato> {

	@Override
	public boolean salvar(Contato obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contato getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Contato obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
