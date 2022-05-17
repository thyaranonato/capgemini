package aula01;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class Aula01 {

	public static void main(String[] args) {
		//variaveis();
		//conversao();
		//desvioCondicional();
		//estruturaControle();
		listaHashMap();		
	}
	
	public static void listaHashMap() {
		HashMap<String, String> capitais = new HashMap<>();
		capitais.put("SC", "Florianópolis");
		capitais.put("RS", "Porto Alegre");
		capitais.put("PR", "Curitiba");
		
		System.out.println(capitais);
		System.out.println(capitais.get("SC"));
	
		for(String key : capitais.keySet()) {
			System.out.println("Chave " + key + " Valores: " + capitais.get(key));
		};
		
	}
	
	public static void estruturaControle() {
		int x = 0;
		System.out.println(x < 5);
		while(x < 5) {
			System.out.println("Linha " + x);
			x++;
		}
		for(int i = 0; i < 5; i++) {
			System.out.println("Linha for " + i);
		};
		int z = 10;
		System.out.println(z < 5);
		do {
			System.out.println("Linha do " + z);
			z++;
		} while(z < 5);
	}
	
	public static void desvioCondicional() {
		int numero = 17;
		System.out.println(numero < 18);
		if(numero < 18) {
			System.out.println(numero + " é menor que 18.");
		} else if(numero > 18) {
			System.out.println(numero + " é maior que 18.");
		} else {
			System.out.println(numero + " é igual a 18.");
		}
	}
	
	public static void conversao() {
		byte idade;
		idade = 30;
		
		idade = Byte.parseByte(JOptionPane.showInputDialog(("Informe a idade")));
		JOptionPane.showMessageDialog(null, "sua idade é: " + idade);
		System.out.print(idade);
		
		float peso = Float.parseFloat(JOptionPane.showInputDialog(("Informe peso")));
		JOptionPane.showMessageDialog(null, "seu peso é: " + peso);
		
		double altura = Double.parseDouble(JOptionPane.showInputDialog(("Informe sua altura")));
		JOptionPane.showMessageDialog(null, "sua altura é: " + altura);
		
		float nota = 9.8f;
		double notad = 9.8;
		String noString = String.valueOf(nota);
		System.out.print(noString);
	}
	
	public static void variaveis() {
		String nome;
		nome = JOptionPane.showInputDialog("Informe nome");
		System.out.print(nome);
	}
}
