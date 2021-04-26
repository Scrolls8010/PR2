package org.campus02.file.productSerializable;

import java.io.Serializable;

public class Product implements Serializable {

    private String productName;
    private String productCategory;
    private double productPrice;

    public Product(String productName, String productCategory, double productPrice) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }


}
