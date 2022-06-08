import java.util.Scanner;

public class LocadoraVeiculos {
    public static void main(String[] args) {
        var carro = inputCarro();
        var moto1 = inputMoto();
        var moto2 = inputMoto();
        
        carro.imprimeDados();
        moto1.imprimeDados();
        moto2.imprimeDados();
    }

    public static Carro inputCarro() {
        Scanner in = new Scanner(System.in);

        System.out.print("Informe o modelo do carro: ");
        String modelo = in.next();

        System.out.print("Informe a marca do carro: ");
        String marca = in.next();

        in.close();

        return new Carro(modelo, marca);
    }

    public static Moto inputMoto() {
        Scanner in = new Scanner(System.in);

        System.out.print("Informe o modelo da moto: ");
        String modelo = in.next();

        System.out.print("Informe a marca do moto: ");
        String marca = in.next();

        System.out.print("Informe a quantidade de cilindradas: ");
        int cilindradas = in.nextInt();

        in.close();

        return new Moto(modelo, marca, cilindradas);      
    }
    
}
