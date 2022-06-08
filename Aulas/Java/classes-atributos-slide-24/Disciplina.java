public class Disciplina {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.nome = "Lucas Schlestein";

        Laboratorio laboratorio = new Laboratorio();
        laboratorio.local = "Aula 2";

        System.out.println("O nome do professor é: " + professor.nome);
        System.out.println("O laboratório é: " + laboratorio.local);
    }
}
