package Logger;

public class DemoLogger {

    public static void main(String[] args) {
        ErrorMessage testMessage = new ErrorMessage("FATAL","TESTERROR","2021");
        Logger logger = new Logger("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/Logs/log.txt");

        logger.logDebug("DEBUGTEST");


    }




}
