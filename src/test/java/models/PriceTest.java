package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Product product = new Product("Table", "https://tradeantiquewebdesign.com");
        assertEquals(true, product instanceof Product);
    }

    @Test
    public void ProductInstantiatesWitProducthName_true() throws Exception {
        Product product = new Product("Table", "https://tradeantiquewebdesign.com");
        assertEquals("Table", product.getProductName());

    }

    @Test
    public void ProductInstantiatesWithDescriptionURL_true() throws Exception {
        Product product = new Product("Table", "https://tradeantiquewebdesign.com");
        assertEquals("https://tradeantiquewebdesign.com", product.getDescriptionURL());

    }

    @After
    public void tearDown() {
        Product.clearAllProduct(); //clear out all the posts before each test.
    }

    @Test
    public void AllHerosAreCorrectlyReturned_true() {
        Product product = new Product("Table", "https://tradeantiquewebdesign.com");
        Product product1 = new Product("Table", "https://tradeantiquewebdesign.com");
        assertEquals(2, Product.getAll().size());
    }

    @Test
    public void AllHerosContainsAllHeros_true() {
        Product product = new Product("Table", "https://tradeantiquewebdesign.com");
        Product product2 = new Product("Table", "https://tradeantiquewebdesign.com");
        assertTrue(Product.getAll().contains(product));
        assertTrue(Product.getAll().contains(product2));
    }

    @Test
    public void getId_heroInstantiateWithAnID_1() throws Exception {
        Product.clearAllProduct();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Product myProduct = new Product("Table", "https://tradeantiquewebdesign.com");
        assertEquals(1, myProduct.getId());

    }
    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception {
        Product product = new Product("Table", "https://tradeantiquewebdesign.com");
        Product otherProduct = new Product("Table", "https://tradeantiquewebdesign.com");
        assertEquals(2, Product.findById(otherProduct.getId()).getId());
    }
}
