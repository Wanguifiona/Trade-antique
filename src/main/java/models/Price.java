package models;

import java.net.URL;
import java.util.ArrayList;

public class Price {
    private String productName;
    private int productCost;
    private int quantity;
    private String descriptionURL;
    private int id;
    private static ArrayList<Price> instances = new ArrayList<>();


    public Price(String productName, int productCost, int quantity, String descriptionURL) {
        this.productName = productName;
        this.productCost = productCost;
        this.quantity = quantity;
        this.descriptionURL = descriptionURL;
        instances.add(this);
        this.id = instances.size();
    }
    public String getProductName() {
        return productName;
    }
    public int getProductCost() {
        return productCost;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getDescriptionURL() {
        return descriptionURL;
    }

    public static ArrayList<Price> getAll(){
        return instances;
    }

    public static void clearAllPrice(){
        instances.clear();
    }
    public int getId() {
        return id;
    }
    public static Price findById(int id){
        return instances.get(id-1);
    }
}
