package entidades;

public class ContaBanco {
	private int id;
	private double saldo;
	
	public void sacar(double valor) throws Exception {
		if(valor >= saldo) {
			throw new Exception("Não é possível realizar o saque.");
		}
		saldo -= valor;
	}
	
	public void depositar(double valor) {
		saldo += valor;
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
