import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio13 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba 3 n�meros ascendentes( do menor\n" + 
				"para o maior) e um quarto n�mero qualquer, verifique esse quarto n�mero com\n" + 
				"os outros anteriores e o coloque na devida posi��o.( ascendente).";
	}
	
	public void execute() {
		System.out.println("Insira tr�s n�meros em ordem ascendente:");
		
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		// Insere o primeiro n�mero
		numeros.add(entrada.nextInt());
		
		// Insere o segundo n�mero
		numeros.add(entrada.nextInt());
		
		// Verifica se o segundo n�mero � maior que o primeiro
		if(numeros.get(1) < numeros.get(0)) {
			System.out.println("Voc� inseriu um n�mero na ordem errada.");
			entrada.close();
			return;
		}
		
		// Insere o terceiro n�mero
		numeros.add(entrada.nextInt());
		
		// Verifica se o terceiro n�mero � maior que o segundo
		if(numeros.get(2) < numeros.get(1)) {
			System.out.println("Voc� inseriu um n�mero na ordem errada.");
			entrada.close();
			return;
		}
		
		// Insere o quarto n�mero
		numeros.add(entrada.nextInt());
		
		// Usa a biblioteca collection para ordenar o array
		Collections.sort(numeros);
		
		// Imprime o array
		System.out.println(numeros.toString());
		
		entrada.close();	
	}
}
