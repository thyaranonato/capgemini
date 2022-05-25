package testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.ContaBanco;


public class ContaBancoTest {
	ContaBanco conta;
	double saldoAtual = 0;
	@BeforeEach
	public void setup() {
		conta = new ContaBanco(1, 200);
		saldoAtual = conta.getSaldo();
	}
	@Test
	public void retornoSaqueSaldoPositivo() throws Exception {		
		double valorSacado = 50.0;
		conta.sacar(valorSacado);
		double novoSaldo = conta.getSaldo();
		
		Assertions.assertTrue((saldoAtual - valorSacado) == novoSaldo);
	}
	
	@Test
	public void retornoSaqueSaldoNegativoOuZero() {	
		double valorSacado = 201;
	
		Exception ex = Assertions.assertThrows(Exception.class, () -> conta.sacar(valorSacado));
		Assertions.assertTrue(ex.getMessage().contains("Não é possível realizar o saque."));
	}
	
	@Test
	public void retornoDeposito() {
		double valorDepositado = 100;
		conta.depositar(valorDepositado);
		double novoSaldo = conta.getSaldo();
		
		Assertions.assertTrue((novoSaldo - saldoAtual) == valorDepositado);
	}
}
