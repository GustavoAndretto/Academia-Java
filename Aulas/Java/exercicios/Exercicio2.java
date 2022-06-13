import java.util.Scanner;

public class Exercicio2 extends Exercicio {
	public String description() {
		return "Desenvolva um Algoritmo que receba um n�mero do usu�rio e mostre na\n" +
				"tela se ele � par ou �mpar.";
	}
	
	public void execute() {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Entre com um n�mero:");
		
		int num = entrada.nextInt();
		
		entrada.close();
		
		System.out.println("O n�mero " + num + " � " + ((num % 2) == 0 ? "Par" : "�mpar"));
	}
}
