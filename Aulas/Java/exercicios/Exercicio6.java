import java.util.Scanner;

public class Exercicio6 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo para receber um número do usuário e verifique e\n" +
				"mostre na tela se ele é ou não divisível por \"2\"";
	}
	
	public void execute() {
		System.out.println("Insira um número: ");
		
		Scanner entrada = new Scanner(System.in);
		
		int num = entrada.nextInt();
		
		entrada.close();
		
		if((num % 2) == 0) {
			System.out.println("O número " + num + " é divisível por 2.");
		}
		else {
			System.out.println("O número " + num + " não é divisível por 2.");
		}
	}
}
