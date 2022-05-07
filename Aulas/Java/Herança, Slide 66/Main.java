public class Main {
    public static void main(String[] args) {
        var funcionario = new Funcionario(new Pessoa("Gustavo", "4002-8922", 27), "Service Desk", "TI", "Analista");

        System.out.printf("%s %s %d\n", funcionario.nome, funcionario.telefone, funcionario.idade);
    }
}