package entidades;

public class Usuario {
	private int id;
	private String email;
	private String senha;
	private String perfil;
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + ", perfil=" + perfil + "]";
	}

	public Usuario(int id, String email, String password, String perfil) {
		this.id = id;
		this.email = email;
		this.senha = password;
		this.perfil = perfil;
	}

	public Usuario() {
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return senha;
	}
	
	public void setPassword(String password) {
		this.senha = password;
	}
	
	public String getPerfil() {
		return perfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
}
