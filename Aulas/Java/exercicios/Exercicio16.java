import java.util.Scanner;

public class Exercicio16 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que tenha como registro 7 n�meros, de 1 a 7\n" + 
				"cada um representando um dia da semana ,come�ando de 1 - Domingo e\n" + 
				"assim respectivamente, receba um n�mero do usu�rio e mostre o dia da\n" + 
				"semana que esse n�mero representa, se o n�mero digitado n�o estiver entre 1\n" + 
				"e 7 mostre uma mensagem de n�mero inv�lido.";
	}
	
	public void execute() {
		System.out.println("Digite um n�mero entre 1-7 que corresponde a um dia da semana:");
		
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
			System.out.println("Ter�a-Feira.");
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
			System.out.println("S�bado");
			break;
		default:
			System.out.println("N�mero inv�lido.");
		}	
	}
}
