package adressbuch;

import java.io.*;
import java.util.ArrayList;

public class AddressDemo {

    public static void main(String[] args) {

        AddressManager addressManager = new AddressManager();

        try {
            addressManager.loadFromCsv("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/Adressbuch_Docs/addresses.csv", ";");
        } catch (AddressLoadException | AddressLoadWrongFormatException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < addressManager.getAddresses().size(); i++) {
            System.out.println(addressManager.getAddresses().get(i).toString());
        }

        addressManager.add(new Address("luki", "Reisinger", "06649212454", "luki@luki.at"));

        try {
            addressManager.exportToCsv("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/Adressbuch_Docs/addresses_export.csv", ",");
        } catch (AddressExportException e) {
            e.printStackTrace();
        } catch (AddressExportFileAlreadyExistsException e) {
            e.printStackTrace();
        }

    }

}
