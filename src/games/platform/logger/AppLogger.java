package games.platform.logger;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class AppLogger {

    private final Logger logger;

    public AppLogger() {
        logger = Logger.getLogger("");
        try {

            Properties conf = getLogConf();

            Handler handler = new FileHandler(conf.getProperty("arquivo"), Boolean.parseBoolean(conf.getProperty("acrescentar")));

            handler.setFormatter(new SimpleFormatter());

            logger.addHandler(handler);

        } catch (IOException | SecurityException ex) {
            System.out.println(ex);
        }
    }

    public Logger getLogger() {
        return logger;
    }

    public void addLog(Level level, String mensagem) {
        logger.setLevel(level);

        if (level.equals(AppLogger.getSevereLevel())) {
            logger.severe(mensagem);
        } else if (level.equals(AppLogger.getWarningLevel())) {
            logger.warning(mensagem);
        } else if (level.equals(AppLogger.getInfoLevel())) {
            logger.info(mensagem);
        }

    }

    private Properties getLogConf() {
        Properties conf = new Properties();

        conf.setProperty("arquivo", "logs/all-logs.log");
        conf.setProperty("acrescentar", "true");
        conf.setProperty("suprimir-saida-console", "false");
        conf.setProperty("formato-saida", "SIMPLE");

        return conf;
    }

    public static Level getSevereLevel() {
        return Level.SEVERE;
    }

    public static Level getWarningLevel() {
        return Level.WARNING;
    }

    public static Level getInfoLevel() {
        return Level.INFO;
    }
}
