package Workers;

public class WorkerDemo {

    public static void main(String[] args) {
        try {
        FileReadWorker frw = new FileReadWorker("FileWorker1","Files/Worker/input.txt");
        TimePrintWorker tpw = new TimePrintWorker("Timer");

        Thread th = new Thread(frw);
        Thread th2 = new Thread(tpw);

        th.start();
        th2.start();

            th.join();

            tpw.stopWorker();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
