import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio8 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba tr�s n�meros e os ordene em forma\n" +
				"descendente( do maior para o menor).";
	}
	
	public void execute() {
		System.out.println("Insira tr�s n�meros:");
		
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(entrada.nextInt());
		nums.add(entrada.nextInt());
		nums.add(entrada.nextInt());
		
		entrada.close();
		
		Collections.reverse(nums);
			
		System.out.println(nums.toString());
	}
}
