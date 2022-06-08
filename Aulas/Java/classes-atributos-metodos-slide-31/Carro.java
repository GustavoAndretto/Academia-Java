public class Carro {
    String marca, modelo;

    void defineMarcaModelo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    void exibeDados() {
        System.out.printf("A marca e modelo é: %s %s\n", this.marca, this.modelo);
    }
}
