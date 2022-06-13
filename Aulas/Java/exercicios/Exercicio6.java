import java.util.Scanner;

public class Exercicio6 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo para receber um n�mero do usu�rio e verifique e\n" +
				"mostre na tela se ele � ou n�o divis�vel por \"2\"";
	}
	
	public void execute() {
		System.out.println("Insira um n�mero: ");
		
		Scanner entrada = new Scanner(System.in);
		
		int num = entrada.nextInt();
		
		entrada.close();
		
		if((num % 2) == 0) {
			System.out.println("O n�mero " + num + " � divis�vel por 2.");
		}
		else {
			System.out.println("O n�mero " + num + " n�o � divis�vel por 2.");
		}
	}
}
