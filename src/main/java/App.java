
import models.Price;
import models.Product;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        post("/product/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String productName = request.queryParams("productName");
            String descriptionURL = request.queryParams("descriptionURL");
            Product newProduct = new Product(descriptionURL, productName);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());




        get("/product-detail", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Product> product = Product.getAll();
            System.out.println(product);
            model.put("product", product);
            return new ModelAndView(model, "product-detail.hbs");
        }, new HandlebarsTemplateEngine());


        post("/price/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String productName = request.queryParams("productName");
            Integer productCost = Integer.parseInt(request.queryParams("productCost"));
            Integer quantity = Integer.parseInt(request.queryParams("quantity"));
            String descriptionURL = request.queryParams("descriptionURL");
            Price newPrice = new Price(productName, productCost, quantity ,descriptionURL);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/price-detail", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Price> price = Price.getAll();
            System.out.println(price);
            model.put("price", price);
            return new ModelAndView(model, "price-detail.hbs");
        }, new HandlebarsTemplateEngine());



    }
}