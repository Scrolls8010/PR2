package PersonManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonLoader {

    private String path;

    public PersonLoader(String path) {
        this.path = path;
    }

    public ArrayList<Person> load() throws PersonLoadException {
        ArrayList<Person> persons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) !=null) {
                String[] values = line.split(";");
                persons.add(new Person(Integer.parseInt(values[0]),values[1],values[2]));
            }

            return persons;

        } catch (FileNotFoundException e) {
           throw new PersonLoadException("Person loader error!", e);
        } catch (IOException e) {
            throw new PersonLoadException("Person loader error!", e);
        }

    }


}

