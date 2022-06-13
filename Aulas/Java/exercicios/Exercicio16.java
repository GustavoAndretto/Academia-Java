import java.util.Scanner;

public class Exercicio16 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que tenha como registro 7 números, de 1 a 7\n" + 
				"cada um representando um dia da semana ,começando de 1 - Domingo e\n" + 
				"assim respectivamente, receba um número do usuário e mostre o dia da\n" + 
				"semana que esse número representa, se o número digitado não estiver entre 1\n" + 
				"e 7 mostre uma mensagem de número inválido.";
	}
	
	public void execute() {
		System.out.println("Digite um número entre 1-7 que corresponde a um dia da semana:");
		
		Scanner entrada = new Scanner(System.in);
		
		int dia = entrada.nextInt();
		
		entrada.close();
		
		switch(dia)
		{
		case 1:
			System.out.println("Domingo.");
			break;
		case 2:
			System.out.println("Segunda-Feira.");
			break;
		case 3:
			System.out.println("Terça-Feira.");
			break;
		case 4:
			System.out.println("Quarta-Feira.");
			break;
		case 5:
			System.out.println("Quinta-Feira.");
			break;
		case 6:
			System.out.println("Sexta-Feira.");
			break;
		case 7:
			System.out.println("Sábado");
			break;
		default:
			System.out.println("Número inválido.");
		}	
	}
}
