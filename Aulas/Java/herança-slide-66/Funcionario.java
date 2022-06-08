public class Funcionario extends Pessoa {
    String cargo, setor, funcao;

    Funcionario(Pessoa pessoa, String cargo, String setor, String funcao){
        super(pessoa.nome, pessoa.telefone, pessoa.idade);
        this.cargo = cargo;
        this.setor = setor;
        this.funcao = funcao;
    }
}
