package exceptions.ue.transporter;

public class Transporter {

    public Transporter() {
    }

    public void beam (String person, String from, String to, boolean urgent)
            throws TransporterMalfunctionException {
        double malfunction = Math.random();
        if (malfunction < 0.5 && urgent) {
            throw new TransporterMalfunctionException("Beam failed!!!!");
        } else {
            System.out.println("beam successfull!");
        }
    }

    public void shutdown () {
        System.out.println("Beamer is turned off now");
    }

}
