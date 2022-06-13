import java.util.Scanner;

public class Exercicio10 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba a nota de um aluno e mostre se ele\n" +
				"passou de ano ou está reprovado.(Média mínima 6.0)";
	}
	
	public void execute() {
		System.out.println("Insira a nota:");
		
		Scanner entrada = new Scanner(System.in);
		
		float nota = entrada.nextFloat();
		
		entrada.close();
		
		if(nota < 6.0) {
			
		}
	}
}