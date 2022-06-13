import java.util.Scanner;

public class Exercicio4 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba do usu�rio a letra correspondente ao\n" +
				"sexo M - Masculino / F - Feminino, se o usu�rio digitar algo que n�o seja F ou\n" +
				"M mostrar que o conte�do digitado � inv�lido.";
	}
	
	public void execute() {	
		System.out.println("Entre com M para Masculino ou F para Feminino:");
		
		Scanner entrada = new Scanner(System.in);
		
		String letra = entrada.next();
		
		entrada.close();
				
		if(!letra.equalsIgnoreCase("M") && !letra.equalsIgnoreCase("F")) {
			System.out.println("Entrada inv�lida. " + letra);
		}
	}
}
