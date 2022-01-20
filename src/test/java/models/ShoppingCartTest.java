package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        ShoppingCart shoppingcart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(true, shoppingcart instanceof ShoppingCart);
    }

    @Test
    public void ShoppingInstantiatesWitProducthName_true() throws Exception {
        ShoppingCart shoppingcart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals("Table", shoppingcart.getProductName());
    }
//
    @Test
    public void ShoppingInstantiatesWithDescriptionURL_true() throws Exception {
        ShoppingCart shoppingcart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals("https://tradeantiquewebdesign.com", shoppingcart.getDescriptionURL());

    }
    @Test
    public void ShoppingInstantiatesWithgetProductCost_true() throws Exception {
        ShoppingCart shoppingcart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(5000, shoppingcart.getProductCost());

    }
    @Test
    public void ShoppingInstantiatesWithQuality_true() throws Exception {
        ShoppingCart shoppingcart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(5, shoppingcart.getQuantity());

    }
    @After
    public void tearDown() {
        ShoppingCart.clearAllShopping(); //clear out all the posts before each test.
    }
    //
    @Test
    public void AllPricesAreCorrectlyReturned_true() {
        ShoppingCart shoppingcart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        ShoppingCart shoppingcart1 = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(2, ShoppingCart.getAll().size());
    }

    @Test
    public void AllPriceContainsAllHeros_true() {
        ShoppingCart shoppingcart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        ShoppingCart shoppingcart2 = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertTrue(ShoppingCart.getAll().contains(shoppingcart));
        assertTrue(ShoppingCart.getAll().contains(shoppingcart2));
    }
    //
    @Test
    public void getId_priceInstantiateWithAnID_1() throws Exception {
        ShoppingCart.clearAllShopping();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        ShoppingCart myShoppingCart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(1, myShoppingCart.getId());

    }
    @Test
    public void findReturnsCorrectPriceWhenMoreThanOneHeroExists() throws Exception {
        ShoppingCart shoppingcart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        ShoppingCart otherShoppingCart = new ShoppingCart("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(2, ShoppingCart.findById(otherShoppingCart.getId()).getId());
    }
}
