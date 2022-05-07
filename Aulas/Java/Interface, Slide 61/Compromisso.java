public class Compromisso implements CompromissoInterface {
    String nome, data, hora;

    Compromisso(String nome, String data, String hora) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
    }

    public void exibeCompromisso() {
        System.out.printf("Nome: %s Data %s Hora: %s\n", this.nome, this.data, this.hora);
    }
}