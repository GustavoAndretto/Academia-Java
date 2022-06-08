public class Pessoal extends Compromisso {
    
    Pessoal(String nome, String data, String hora) {
        super(nome, data, hora);
    }


    @Override
    public void exibeCompromisso() {
        System.out.println("[Compromisso Pessoal]");

        super.exibeCompromisso();
    }
}
