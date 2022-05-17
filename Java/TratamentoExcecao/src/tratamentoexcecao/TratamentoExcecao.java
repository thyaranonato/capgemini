package tratamentoexcecao;

import javax.swing.JOptionPane;

import entidades.Contato;

public class TratamentoExcecao {

	public static void main(String[] args) {
		Contato ct = new Contato();
		int x = 10;
		int y = 2;
		try {
			int z = x / y;			
			System.out.println(z);
			
			ct.setNome("Maria");
			System.out.println(ct.getNome());
			
			String speso = JOptionPane.showInputDialog("Informe peso");
			float peso = Float.parseFloat(speso);
			
			int[] numeros = {10, 20, 30};
			System.out.println(numeros[2]);
		} catch(ArithmeticException e) {
			System.out.println(" Não é possível dividir por 0");
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace().toString());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição inválida!");
		} catch(NullPointerException e) {
			System.out.println("Erro na execução do programa!" + e.getMessage());
			System.out.println(e.toString());
		} catch(NumberFormatException e) {
			System.out.println("Entrada incorreta: " + e.getMessage());
		}

	}

}
