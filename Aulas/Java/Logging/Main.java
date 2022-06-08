import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        try {
            Log log = new Log("Debug.log");

            log.setLevel(Level.WARNING);
            log.info("Ola Mundo!!");
            log.warning("Hello!!");
            log.severe("Severe!!!");
            log.fine("Aula Java!!");

        } catch (Exception e) {
            System.out.println(e);
        }  
    }
}