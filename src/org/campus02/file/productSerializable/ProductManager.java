package org.campus02.file.productSerializable;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> products = new ArrayList<>();

    public ProductManager(ArrayList<Product> products) {
        this.products = products;
    }

    public ProductManager() {

    }

    public void add (Product p) {
        products.add(p);
    }

    public void saveProductsToFile (String path) {
        File f = new File(path);

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
           for (Product p : products) {
               oos.writeObject(p);
               oos.flush();
           }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
