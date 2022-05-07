public class Veiculo {
    String marca, modelo;

    Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    void imprimeDados() {
        System.out.printf("Marca: %s Modelo: %s\n", marca, modelo);
    }
}
