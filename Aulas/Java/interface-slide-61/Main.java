public class Main {
    public static void main(String[] args) { 
        Pessoal pessoal = new Pessoal("Acadeima", "09/05/2022", "07:00");
        Profissional profisssional = new Profissional("Aula Java", "09/05/2022", "19:00");

        pessoal.exibeCompromisso();
        profisssional.exibeCompromisso();
    }
}
