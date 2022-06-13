import java.util.Scanner;

public class Exercicio1 extends Exercicio {
	public String description() {
		return "Desenvolva um Algoritmo que receba dois números do usuário e mostre na\n" + 
				"tela qual dos dois números escolhidos é maior.";
	}
	
	public void execute() {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Insira dois números: ");
		
		int num1 = entrada.nextInt();
		int num2 = entrada.nextInt();
		
		entrada.close();
		
		int maior = 0;
		
		if(num1 > num2) {
			maior = num1;
		}
		else {
			maior = num2;
		}
		
		System.out.println("O maior número é " + maior);
	}
}
