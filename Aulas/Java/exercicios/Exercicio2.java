import java.util.Scanner;

public class Exercicio2 extends Exercicio {
	public String description() {
		return "Desenvolva um Algoritmo que receba um número do usuário e mostre na\n" +
				"tela se ele é par ou ímpar.";
	}
	
	public void execute() {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Entre com um número:");
		
		int num = entrada.nextInt();
		
		entrada.close();
		
		System.out.println("O número " + num + " é " + ((num % 2) == 0 ? "Par" : "Ímpar"));
	}
}
