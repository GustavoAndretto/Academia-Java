public class Main {
    public static void main(String[] args) {
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.idade = 18;

        Pessoa pessoa2 = new Pessoa();
        pessoa2.idade = 20;

        Pessoa pessoa3 = new Pessoa();
        pessoa3.idade = 30;

        System.out.println("A idade da pessoa1 é: " + pessoa1.idade);
        System.out.println("A idade da pessoa2 é: " + pessoa2.idade);
        System.out.println("A idade da pessoa3 é: " + pessoa3.idade);
    }
}
