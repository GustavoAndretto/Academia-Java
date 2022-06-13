import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio7 extends Exercicio {
	public String description() {
		return "Desenvolva um algoritmo que receba três números e os ordene em forma\n" +
				"ascendente( do menor para o maior).";
	}
	
	public void execute() {
		System.out.println("Insira três números:");
		
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(entrada.nextInt());
		nums.add(entrada.nextInt());
		
		entrada.close();
		
		Collections.sort(nums);
			
		System.out.println(nums.toString());
	}
}
