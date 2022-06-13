import java.util.Scanner;

public class Exercicio15 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba a idade de um atleta e verifique a\n" + 
				"qual categoria ele se encaixa e mostre na tela.\n" + 
				"Idade\t\t\tCategoria\n" + 
				"7 - 12 anos\t\tInfantil\n" + 
				"13 - 16 anos\t\tJuvenil 1\n" + 
				"17 e 18 anos\t\tJuvenil 2\n" + 
				"19 - 31 anos\t\tProfissional\n" + 
				"32 - 41 anos\t\tSênior\n" + 
				"42 anos+\t\tMasters";
	}
	
	public void execute() {
		System.out.println("Entre com a idade do atleta:");
		
		Scanner entrada = new Scanner(System.in);
		
		int idade = entrada.nextInt();
		
		entrada.close();
		
		if(idade >= 7 && idade <= 12) {
			System.out.println("Categoria: Infantil.");
		}
		else if(idade >= 13 && idade <= 16) {
			System.out.println("Categoria: Juvenil 1.");
		}
		else if(idade >= 17 && idade <= 18) {
			System.out.println("Categoria: Juvenil 2.");
		}
		else if(idade >= 19 && idade <= 31) {
			System.out.println("Categoria: Profissional");
		}
		else if(idade >= 32 && idade <= 41) {
			System.out.println("Categoria: Sênior.");
		}
		else if(idade > 42) {
			System.out.println("Categoria: Masters.");
		}
		else {
			System.out.println("A idade não se encaixa em nenhuma categoria.");
		}
	}
}
