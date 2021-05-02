package Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    private final String path;

    public Logger(String path) {
        this.path = path;
    }

    private void logMessage (ErrorMessage message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)) ) {
            bw.write(message.toLine());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logFatal(String message) {
        ErrorMessage msg =
                new ErrorMessage("FATAL",message, new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
        logMessage(msg);
    }
    public void logError(String message) {
        ErrorMessage msg =
                new ErrorMessage("ERROR",message, new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
        logMessage(msg);
    }
    public void logInfo(String message) {
        ErrorMessage msg =
                new ErrorMessage("INFO",message, new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
        logMessage(msg);
    }

    public void logDebug(String message) {
        ErrorMessage msg =
                new ErrorMessage("DEBUG",message, new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
        logMessage(msg);
    }





}
