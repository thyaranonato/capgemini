package crud;

import java.util.List;

import dao.DaoContato;
import entidades.Contato;
//import utilidades.Conexao;

public class Crud {

	public static void main(String[] args) {
		//chamaSalvar();
		//chamaBuscaPorId();
		//chamarPegarTodos();
		//chamarDelete();
		chamarUpdate();
	}
	
	public static void chamarUpdate() {
		Contato ct = new DaoContato().getOne(22);
		if(ct != null) {
			System.out.println(ct.toString());
		}
		
		ct.setNome("João Santos");
		ct.setEmail("joao@yahoo.com");
		
		if(new DaoContato().alterar(ct)) {
			System.out.println("Registro alterado com sucesso!!");
		}
		
		Contato ct2 = new DaoContato().getOne(22);
		if(ct2 != null) {
			System.out.println(ct2.toString());
		}		
		
	}
	
	public static void chamarDelete() {
		if(new DaoContato().deletar(11)) {
			System.out.println("Registro excluido em sucesso!!");
		}
	}
	
	public static void chamarPegarTodos() {
		List<Contato> lista = new DaoContato().getAll();
		for(Contato ct : lista) {
			System.out.println(ct.toString());
		}
	}
	
	public static void chamaBuscaPorId(int id) {
		Contato ct = new DaoContato().getOne(id);
		if(ct != null) {
			System.out.println(ct.toString());
		}
	}
	
	public static void chamaSalvar() {
		Contato ct = new Contato();
		ct.setNome("Antonieta");
		ct.setEmail("antonieta@gmail.com");
		
		DaoContato dc = new DaoContato();
		if(dc.salvar(ct)) {
			System.out.println("Contato salvo com sucesso!");
		}
	}

}
