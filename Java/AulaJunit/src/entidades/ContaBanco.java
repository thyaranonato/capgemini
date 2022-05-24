package entidades;

public class ContaBanco {
	private int id;
	private double saldo;
	
	public double sacar(double saldo, double n) throws Exception {
		if(saldo <= 0) {
			throw new Exception("Não é possível realizar o saque.");
		}
		return saldo - n;
	}
	
	public double depositar(double saldo, double n) {
		return saldo + n;
	}
	
	public ContaBanco(int id, double saldo) {
		super();
		this.id = id;
		this.saldo = saldo;
	}

	public ContaBanco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
