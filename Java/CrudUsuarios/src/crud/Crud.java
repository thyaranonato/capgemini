package crud;

import java.util.List;

import dao.DaoUsuarios;
import entidades.Usuario;

public class Crud {

	public static void main(String[] args) {
		//create();
		//getOne();
		//getAll();
		//update();
		delete();
	}
	
	public static void create() {
		Usuario user = new Usuario();
		user.setEmail("ana@gmail.com");
		user.setPassword("123456");
		user.setPerfil("adm");
		
		DaoUsuarios dUser = new DaoUsuarios();
		if(dUser.create(user)) {
			System.out.println("Usuário cadastrado com sucesso!");
		}
	}
	
	public static void getOne() {
		Usuario user = new DaoUsuarios().getOne(1);
		if(user != null) {
			System.out.println(user.toString());
		}
	}
	
	public static void getAll() {
		List<Usuario> lista = new DaoUsuarios().getAll();
		for(Usuario user : lista) {
			System.out.println(user.toString());
		}
	}
	
	public static void update() {
		Usuario user = new DaoUsuarios().getOne(3);
		if(user != null) {
			System.out.println(user.toString());
		}
		
		user.setEmail("paulo@yahoo.com");
		user.setPassword("12589");
		user.setPerfil("usuario");
		
		if(new DaoUsuarios().update(user)) {
			System.out.println("Registro alterado com sucesso!!");
		}
		
		Usuario user2 = new DaoUsuarios().getOne(3);
		if(user2 != null) {
			System.out.println(user2.toString());
		}		
	}
	
	public static void delete() {
		if(new DaoUsuarios().delete(3)) {
			System.out.println("Usuário excluído com sucesso!!");
		}
	}
}
