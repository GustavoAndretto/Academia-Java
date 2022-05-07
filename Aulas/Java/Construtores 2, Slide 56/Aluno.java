//# Construtores 2, Slide 56

//Criar uma classe chamada Aluno com 3 construtores, sendo que o primeiro recebe o nome e a matrícula do aluno,
//o segundo recebe apenas a data de nascimento do aluno e o terceiro construtor recebe o nome do aluno, a data de
//nascimento e o ano em que o aluno ingressou na faculdade. Crie uma classe principal, com 3 objetos, cada um
//instanciando a classe com um construtor diferente. 

public class Aluno {
    String nome, dataNascimento;
    int matricula, anoIngresso;

    Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;

        System.out.printf("Nome: %s, Matricula: %s\n", this.nome, this.matricula);
    }

    Aluno(String dataNascimento) {
        this.dataNascimento = dataNascimento;

        System.out.printf("DataNascimento %s\n", this.dataNascimento);
    }

    Aluno(String nome, String dataNascimento, int anoIngresso) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoIngresso = anoIngresso;

        System.out.printf("Nome: %s, DataNascimento: %s, AnoIngresso: %s\n", this.nome, this.dataNascimento, this.anoIngresso);
    }
}