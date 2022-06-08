public class Moto extends Veiculo {
    int cilindradas;

    Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo);

        this.cilindradas = cilindradas;
    }

    void imprimeDados() {
        System.out.printf("Marca: %s Modelo: %s Cilindradas: %d\n", this.marca, this.modelo, cilindradas);
    }
}