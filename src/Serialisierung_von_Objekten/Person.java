package Serialisierung_von_Objekten;

import java.io.Serializable;

public class Person implements Serializable
{

    private String Vorname;
    private String Nachname;
    private String Alter;

    public Person(String vorname, String nachname, String alter) {
        Vorname = vorname;
        Nachname = nachname;
        Alter = alter;
    }

    public String getVorname() {
        return Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public String getAlter() {
        return Alter;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", Alter='" + Alter + '\'' +
                '}';
    }
}
