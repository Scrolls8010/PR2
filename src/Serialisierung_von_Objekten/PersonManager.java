package Serialisierung_von_Objekten;

import java.io.*;
import java.util.ArrayList;

public class PersonManager {

    private ArrayList<Person> persons = new ArrayList<>();

    public PersonManager(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public PersonManager() {

    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void add (Person p) {
        persons.add(p);
    }

    public void savePersonsToFile (String path) {
        File output = new File(path);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output))) {
            for (Person p : persons) {
                oos.writeObject(p);
                oos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadPersonsFromFile (String path) {

        File input = new File(path);

        try
                (
                        FileInputStream fis = new FileInputStream(input);
                        ObjectInputStream ois = new ObjectInputStream(fis);

        )
        {

            while (fis.available() > 0) {
                this.add((Person) ois.readObject());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }




}
