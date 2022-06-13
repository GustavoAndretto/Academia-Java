import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio13 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba 3 números ascendentes( do menor\n" + 
				"para o maior) e um quarto número qualquer, verifique esse quarto número com\n" + 
				"os outros anteriores e o coloque na devida posição.( ascendente).";
	}
	
	public void execute() {
		System.out.println("Insira três números em ordem ascendente:");
		
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		// Insere o primeiro número
		numeros.add(entrada.nextInt());
		
		// Insere o segundo número
		numeros.add(entrada.nextInt());
		
		// Verifica se o segundo número é maior que o primeiro
		if(numeros.get(1) < numeros.get(0)) {
			System.out.println("Você inseriu um número na ordem errada.");
			entrada.close();
			return;
		}
		
		// Insere o terceiro número
		numeros.add(entrada.nextInt());
		
		// Verifica se o terceiro número é maior que o segundo
		if(numeros.get(2) < numeros.get(1)) {
			System.out.println("Você inseriu um número na ordem errada.");
			entrada.close();
			return;
		}
		
		// Insere o quarto número
		numeros.add(entrada.nextInt());
		
		// Usa a biblioteca collection para ordenar o array
		Collections.sort(numeros);
		
		// Imprime o array
		System.out.println(numeros.toString());
		
		entrada.close();	
	}
}
