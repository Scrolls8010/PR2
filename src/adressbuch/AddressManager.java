package adressbuch;

import java.io.*;
import java.util.ArrayList;

public class AddressManager {

    private ArrayList <Address> addresses = new ArrayList<>();

    public AddressManager(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public AddressManager() {

    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void add (Address a) {
        addresses.add(a);
    }

    public void loadFromCsv (String path, String seperator) throws AddressLoadException, AddressLoadWrongFormatException
    {
        File csvInput = new File(path);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvInput)))) {
            String content;
            while ((content = br.readLine()) != null) {
                String[] contentArray = content.split(seperator);
                if (contentArray.length !=4) {
                    throw new AddressLoadWrongFormatException("Wrong format!!!");
                }
                Address address = new Address(contentArray[0], contentArray[1], contentArray[2], contentArray[3]);
                this.add(address);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void exportToCsv (String path, String seperator) throws AddressExportException, AddressExportFileAlreadyExistsException {
        if (new File(path).exists()) {
            throw new AddressExportFileAlreadyExistsException ("File Already Exists!!");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < this.getAddresses().size(); i++) {
                bw.write(
                        getAddresses().get(i).getFirstName()
                                + seperator +
                                getAddresses().get(i).getLastName()
                                + seperator +
                                getAddresses().get(i).getPhoneNumber()
                                + seperator +
                                getAddresses().get(i).getEmail()
                                + seperator);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
