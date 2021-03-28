package exceptions.ue.transporter;

public class Episode42Demo {

    public static void main(String[] args)  {

        Transporter transporter = new Transporter();

        try {
            transporter.beam("luki", "HB", "Graz", true);
        } catch (TransporterMalfunctionException e) {
            e.printStackTrace();
        }
        finally {
transporter.shutdown();
        }





    }


}
