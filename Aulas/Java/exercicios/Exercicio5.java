import java.util.Scanner;

public class Exercicio5 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba um número do usuário e verifique se esse número\n" +
				"está entre 25 e 70 ( 25 e 70 incluídos) se sim mostrar na tela que o número\n" +
				"está entre eles, se não mostrar para o usuário que eles não estão entre eles.";
	}
	
	public void execute() {
		System.out.println("Digite um número:");
		
		Scanner entrada = new Scanner(System.in);
		
		int num = entrada.nextInt();
		int min = 25;
		int max = 70;
		
		entrada.close();
		
		String strIntervalo = min + "-" + max;
	
		if(num >= min && num <= max) {
			System.out.println("O número " + num + " é ou está entre " + strIntervalo);
		}
		else {
			System.out.println("O número inserido não é ou está entre o intervalo " + strIntervalo);
		}
	}
}
