import java.util.Scanner;

public class Exercicio5 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba um n�mero do usu�rio e verifique se esse n�mero\n" +
				"est� entre 25 e 70 ( 25 e 70 inclu�dos) se sim mostrar na tela que o n�mero\n" +
				"est� entre eles, se n�o mostrar para o usu�rio que eles n�o est�o entre eles.";
	}
	
	public void execute() {
		System.out.println("Digite um n�mero:");
		
		Scanner entrada = new Scanner(System.in);
		
		int num = entrada.nextInt();
		int min = 25;
		int max = 70;
		
		entrada.close();
		
		String strIntervalo = min + "-" + max;
	
		if(num >= min && num <= max) {
			System.out.println("O n�mero " + num + " � ou est� entre " + strIntervalo);
		}
		else {
			System.out.println("O n�mero inserido n�o � ou est� entre o intervalo " + strIntervalo);
		}
	}
}
