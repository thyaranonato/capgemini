package testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entidades.ContaBanco;


public class ContaBancoTest {
	@Test
	public void retornoSaqueSaldoPositivo() throws Exception {
		ContaBanco saldo = new ContaBanco();
		
		double resultado = saldo.sacar(1000.0, 50.0);
		double valorEsperado = 950.0;
		
		Assertions.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void retornoSaqueSaldoNegativoOuZero() {
		ContaBanco saldo = new ContaBanco();
		
		double saldoConta = -500;
		double valorSaque = 50;
	
		Exception ex = Assertions.assertThrows(Exception.class, () -> saldo.sacar(saldoConta, valorSaque));
		Assertions.assertTrue(ex.getMessage().contains("Não é possível realizar o saque."));
	}
	
	@Test
	public void retornoDeposito() {
		ContaBanco saldo = new ContaBanco();
		
		double resultado = saldo.depositar(1000.0, 50.0);
		double valorEsperado = 1050.0;
		
		Assertions.assertEquals(valorEsperado, resultado);
	}
}
