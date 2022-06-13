import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio12 extends Exercicio {
	class Bimestre {
		public ArrayList<Float> notas;
				
		public Bimestre() {
			this.notas = new ArrayList<Float>();
		}
		
		public void addNota(Float nota) {
			this.notas.add(nota);
		}
					
		float getMedia() {
			return ((this.notas.get(0) * 3) + (this.notas.get(1) * 7)) / (3 + 7);
		}
	}
	
	public String description() {
		return "Desenvolva um algoritmo que receba a média (0 a 10) de dois bimestres e\n" +
				"calcule a nota final do aluno. (Cada nota bimestral consiste em 2 notas, as\n" +
				"duas de 0 a 10, mas uma com peso 3 e outra com peso 7).\n" +
				"- Caso o aluno tire uma nota final menor que 6 mostre o quanto precisará tirar\n" + 
				"para em um exame passar de ano.";
	}
	
	public void execute() {
		ArrayList<Bimestre> bimestre = new ArrayList<Bimestre>();
		
		bimestre.add(new Bimestre());
		bimestre.add(new Bimestre());
		
		System.out.println("Entre com as notas do 1º bimestre:");
		
		Scanner entrada = new Scanner(System.in);
		
		bimestre.get(0).addNota(entrada.nextFloat());
		bimestre.get(0).addNota(entrada.nextFloat());
		
		System.out.println("Entre com as notas do 2º bimestre:");
		
		bimestre.get(1).addNota(entrada.nextFloat());
		bimestre.get(1).addNota(entrada.nextFloat());
		
		entrada.close();
		
		float notaFinal = (bimestre.get(0).getMedia() + bimestre.get(1).getMedia()) / 2;
		
		System.out.println("A nota final é: " + notaFinal);
		
		if(notaFinal < 6.0f) {
			System.out.println("Você precisa tirar " + (6.0f - notaFinal) + " para passar.");
		}
	}
}