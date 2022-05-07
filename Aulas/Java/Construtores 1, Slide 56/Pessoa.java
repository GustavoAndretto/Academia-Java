public class Pessoa {
    String nome;
    int idade;

    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;

        System.out.printf("Nome: %s, Idade: %d\n", this.nome, this.idade);
    }

    Pessoa(int idade) {
        this.idade = idade;

        System.out.printf("Idade: %d\n",this.idade);
    }
}
