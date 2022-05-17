package entidades;

public class Pessoa {
	private String nome;
	private String email;
	private String cpf;
	
	public Pessoa() {
		System.out.print("Chamou construtor!");
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(String nome, String email, String cpf) {
		this.nome = nome;
		this.setEmail(email);
		this.setCpf(cpf);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		if(email.contains("@")) {
			this.email = email;			
		} else {
			System.out.print("Email inválido!");
		}
	}
	
	public void setCpf(String cpf) {
		if(cpf.length() == 11) {
			this.cpf = cpf;			
		} else {
			System.out.println("Cpf inválido!");
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getCpf() {
		return this.cpf;
	}
}
