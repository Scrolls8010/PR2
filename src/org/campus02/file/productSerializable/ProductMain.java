package org.campus02.file.productSerializable;

public class ProductMain {

    public static void main(String[] args) {

        Product p1 = new Product ("Deo", "Hygiene", 100);
        Product p2 = new Product ("Klobär", "Klo", 1000);






        ProductManager pm = new ProductManager();
        pm.add(p1);
        pm.add(p2);

        pm.saveProductsToFile("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/Docs/ProductOutput/products.dat");












    }




}
