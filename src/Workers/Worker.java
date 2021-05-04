package Workers;

public abstract class Worker {

    protected String name;
    protected boolean shouldRun;

    public Worker(String name) {
        this.name = name;
        this.shouldRun = true;
    }

    protected abstract void work();

    protected  void printStarted() {
        System.out.println(this.name + " wurde gestartet");
    }
    protected void printStopped() {
        System.out.println(this.name + " wurde beendet");
    }

    public void stopWorker() {
        this.shouldRun=false;
    }

    public boolean isShouldRun() {
        return shouldRun;
    }
}
