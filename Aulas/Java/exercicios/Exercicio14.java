import java.util.Scanner;

public class Exercicio14 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba o salário da pessoa e calcule a\n" + 
				"quantidade de empréstimos que ele pode fazer de acordo com a tabela abaixo.\n" + 
				"Salário\t\tPorcentagem\n" + 
				"< 500\t\t5%\n" + 
				"500 ~ 1000\t10%\n" + 
				"1000 ~ 2000\t20%\n" + 
				"2000 ~ 3000\t30%\n" + 
				"> 3000\t\t40%";
	}
	
	public void execute() {
		
		System.out.println("Insira o salário:");
		
		Scanner entrada = new Scanner(System.in);
		
		float salario = entrada.nextFloat();
		float quantidadeEmprestimo = 0.0f;
		
		entrada.close();
		
		if(salario < 500) {
			quantidadeEmprestimo = salario * 0.05f;
		}
		else if(salario >= 500 && salario < 1000) {
			quantidadeEmprestimo = salario * 0.1f;
		}
		else if(salario >= 1000 && salario < 2000) {
			quantidadeEmprestimo = salario * 0.2f;
		}
		else if(salario >= 2000 && salario < 3000) {
			quantidadeEmprestimo = salario * 0.3f;
		}
		else if(salario > 3000) {
			quantidadeEmprestimo = salario * 0.4f;
		}
		
		System.out.println("A quantidade de emprestimo que pode fazer é: " + quantidadeEmprestimo);
	}
}
