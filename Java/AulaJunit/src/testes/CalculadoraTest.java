package testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Calculadora;

public class CalculadoraTest {
	
	Calculadora calculadora;
	@BeforeEach
	public void setup() {
		calculadora = new Calculadora();
	}
	
	@Test
	public void resultadoDeveSerDezQuandoSomarCincoMaisCinco() {		
		// Act
		double resultado = calculadora.somar(5.0, 5.0);
		double valorEsperado = 10.0;
		
		//Assert
		Assertions.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void resultadoDeveSerDezQuandoSubtrairQuinzeMenosCinco() {	
		// Act
		double resultado = calculadora.subtrair(15.0, 5.0);
		double valorEsperado = 10.0;
		
		//Assert
		Assertions.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void resultadoDeveSerVinteECincoQuandoMultiplicarCincoVezesCinco() {		
		// Act
		double resultado = calculadora.multiplicar(5.0, 5.0);
		double valorEsperado = 25.0;
		
		//Assert
		Assertions.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void resultadoDeveSerDoisQuandoDividirDezPorCinco() throws Exception {
		// Act
		double resultado = calculadora.dividir(10.0, 5.0);
		double valorEsperado = 2.0;
		
		//Assert
		Assertions.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void divisaoLancaExceçaoQuandoDivisorZero() {	
		// Act
		double dividendo = 10;
		double divisor = 0;
		
		//Assert
		Exception ex = Assertions.assertThrows(Exception.class, () -> calculadora.dividir(dividendo, divisor));
		Assertions.assertTrue(ex.getMessage().contains("Não é possível dividir por zero"));
	}
	
}
