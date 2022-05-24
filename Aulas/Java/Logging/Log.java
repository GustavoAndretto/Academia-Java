import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private Logger logger;
    private FileHandler fh;

    public Log(String arq) throws IOException {
        File f = new File(arq);
        if(!f.exists()){
            f.createNewFile();
        }

        fh = new FileHandler(arq, true);

        logger = Logger.getLogger("Teste Log");
        logger.addHandler(fh);

        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }

    public void setLevel(Level level) {
        logger.setLevel(level);
    }

    public void info(String msg){
        logger.info(msg);
    }

    public void warning(String msg) {
        logger.info(msg);
    }

    public void severe(String msg) {
        logger.severe(msg);
    }

    public void fine(String msg) {
        logger.fine(msg);
    }
}
