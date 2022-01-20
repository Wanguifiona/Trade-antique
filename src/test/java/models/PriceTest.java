package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Price price = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(true, price instanceof Price);
    }

    @Test
    public void ProductInstantiatesWitProducthName_true() throws Exception {
        Price price = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals("Table", price.getProductName());
    }

    @Test
    public void PriceInstantiatesWithDescriptionURL_true() throws Exception {
        Price price = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals("https://tradeantiquewebdesign.com", price.getDescriptionURL());

    }
    @Test
    public void PriceInstantiatesWithgetProductCost_true() throws Exception {
        Price price = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(5000, price.getProductCost());

    }
    @Test
    public void PriceInstantiatesWithQuality_true() throws Exception {
        Price price = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(5, price.getQuantity());

    }
    @After
    public void tearDown() {
        Price.clearAllPrice(); //clear out all the posts before each test.
    }
//
    @Test
    public void AllPricesAreCorrectlyReturned_true() {
        Price price = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        Price price1 = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(2, Price.getAll().size());
    }

    @Test
    public void AllPriceContainsAllHeros_true() {
        Price price = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        Price price2 = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertTrue(Price.getAll().contains(price));
        assertTrue(Price.getAll().contains(price2));
    }
//
    @Test
    public void getId_priceInstantiateWithAnID_1() throws Exception {
        Price.clearAllPrice();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Price myPrice = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(1, myPrice.getId());

    }
    @Test
    public void findReturnsCorrectPriceWhenMoreThanOneHeroExists() throws Exception {
        Price price = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        Price otherPrice = new Price("Table",5000, 5, "https://tradeantiquewebdesign.com");
        assertEquals(2, Price.findById(otherPrice.getId()).getId());
    }
}
