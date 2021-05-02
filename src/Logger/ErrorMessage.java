package Logger;





public class ErrorMessage {

    private String errorLevel;
    private String errorMessage;
    private String errorTime;

    public ErrorMessage(String errorLevel, String errorMessage, String errorTime) {
        switch (errorLevel) {
            case "INFO":
            case "DEBUG":
            case "ERROR":
            case "FATAL":
                this.errorLevel = errorLevel;
                break;
            default:
                System.out.println("Wrong error Level" + errorLevel);
                this.errorLevel = "INFO";
                break;
        }
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }

    public String toLine() {
        return errorTime+":"+errorLevel+"-"+errorMessage;
    }
}
