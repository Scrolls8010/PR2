package Workers;

import java.util.Date;

public class TimePrintWorker extends  Worker implements Runnable{

    public TimePrintWorker(String name) {
        super(name);
    }

    @Override
    protected void work() {

        this.printStarted();

        while (this.shouldRun) {
            Date d = new Date();
            System.out.println(d.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.printStopped();

    }


    @Override
    public void run() {
        this.work();
    }
}
