package models;

import java.net.URL;
import java.util.ArrayList;

public class ShoppingCart {
    private String productName;
    private String descriptionURL;
    private int productCost;
    private int quantity;
    private int id;
    private static ArrayList<ShoppingCart> instances = new ArrayList<>();

    public ShoppingCart(String productName, int productCost, int quantity, String descriptionURL) {
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
    public String getDescriptionURL(){
        return descriptionURL;
    }
    public int getProductCost() {
        return productCost;
    }
    public int getQuantity() {
        return quantity;
    }

    public static ArrayList<ShoppingCart> getAll(){
        return instances;
    }

    public static void clearAllPrice(){
        instances.clear();
    }
    public int getId() {
        return id;
    }
    public static ShoppingCart findById(int id){
        return instances.get(id-1);
    }

}



