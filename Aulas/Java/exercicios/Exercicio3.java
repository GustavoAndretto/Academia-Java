import java.util.Scanner;

public class Exercicio3 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que verifica se a senha digitada pelo usu�rio � a\n" + 
				"senha correta .(Utilize a senha \"4433\").";
	}
	
	public void execute() {
		int senha = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a senha:");
		
		senha = entrada.nextInt();
		
		if(senha != 4433) {
			System.out.println("Senha inv�lida, tente novamente.");
		}
		else {
			System.out.println("Senha correta.");
		}
		
		entrada.close();
	}
}
