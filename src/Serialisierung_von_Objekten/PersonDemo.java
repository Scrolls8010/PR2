package Serialisierung_von_Objekten;

public class PersonDemo {

    public static void main(String[] args) {

        Person luki = new Person("Lukas", "Reisinger", "24");
        Person geri = new Person("Gerald", "Reisinger", "32");
        Person kerstin = new Person("Kerstin", "Knapp", "25");
        Person papa = new Person("Erich", "Reisinger", "57");

        PersonManager pm = new PersonManager();
        pm.add(luki);
        pm.add(geri);
        pm.add(kerstin);
        pm.add(papa);

        pm.savePersonsToFile("Files/Serialisierung_von_Objekten/persons.dat");


        PersonManager pm2 = new PersonManager();
        pm2.loadPersonsFromFile("Files/Serialisierung_von_Objekten/persons_to_read_from.dat");
        for (Person p : pm2.getPersons()) {
            System.out.println(p.toString());
        }



    }




}
