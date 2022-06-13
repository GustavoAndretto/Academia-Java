import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio9 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba dois números do usuário e crie a\n" +
				"opção de escolha somar ou subtrair esses dois números um do outro e\n" +
				"mostrar o resultado.";
	}
	
	public void execute() {
		System.out.println("Insira dois números:");
		
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(entrada.nextInt());
		nums.add(entrada.nextInt());
		
		int operacao = 0;
		
		System.out.print("Insira a operação:\n\t 1 - Somar\n\t 2 - Subtrair\n");
		
		operacao = entrada.nextInt();
		
		entrada.close();
		
		if(operacao != 1 && operacao != 2) {
			System.out.println("Operação inválida, tente novamente.");
			return;
		}
		
		if(operacao == 1) {
			System.out.println(nums.get(0) + " + " + nums.get(1) + " = " + (nums.get(0) + nums.get(1)));
		}
		else if(operacao == 2) {
			System.out.println(nums.get(0) + " - " + nums.get(1) + " = " + (nums.get(0) - nums.get(1)));
		}		
	}
}
