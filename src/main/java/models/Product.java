package models;

import java.net.URL;
import java.util.ArrayList;

public class Product {

    private String productName;
    private String descriptionURL;
    private int id;
    private static ArrayList<Product> instances = new ArrayList<>();


    public Product(String productName, String descriptionURL) {
        this.productName = productName;
        this.descriptionURL = descriptionURL;
        instances.add(this);
        this.id = instances.size();
    }

    public String getProductName() {
        return productName;
    }
    public String getDescriptionURL(){
        return descriptionURL;
    }

    public static ArrayList<Product> getAll(){
        return instances;
    }

    public static void clearAllProduct(){
        instances.clear();
    }
    public int getId() {
        return id;
    }
    public static Product findById(int id){
        return instances.get(id-1);
    }
}