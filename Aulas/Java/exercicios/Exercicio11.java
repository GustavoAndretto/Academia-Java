import java.util.Scanner;

public class Exercicio11 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba duas notas, uma de cada semestre e\n" +
				"calcule a nota anual do aluno ( de 0 a 10) e mostre se o aluno reprovou de ano,\n" +
				"ficará de exame ou passou de ano.\n" +
				"- Nota menor que 3 - reprovado.\n" +
				"- Nota entre 3 (incluso) e 6 - exame.\n" +
				"- Nota entre 6 (incluso) a 10 - Passou de ano.";
	}
	
	public void execute() {
		System.out.println("Entre com duas notas:");
		
		Scanner entrada = new Scanner(System.in);
		
		float[] notas = new float[2];
		
		notas[0] = entrada.nextFloat();
		notas[1] = entrada.nextFloat();
			
		entrada.close();
		
		float notaAnual = (notas[0] + notas[1]) / 2;
		
		if(notaAnual < 3.0f) {
			System.out.print("Reprovado. ");
		}
		else if(notaAnual >= 3.0f && notaAnual < 6.0f) {
			System.out.print("Exame. ");
		}
		else if(notaAnual >= 6.0f && notaAnual <= 10.0f) {
			System.out.print("Passou de ano. ");
		}
		
		System.out.println("Nota anual: " + notaAnual);
	}
}
