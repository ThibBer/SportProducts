package be.henallux.spring.sportProjects.model;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> sessionShoppingCart = new HashMap<>();

    public ShoppingCart() {}

    public void addProductWithQuantity(Product product, Integer quantity) {
        sessionShoppingCart.put(product, quantity);
    }

    public void changeQuantityForProduct(Product product, Integer newQuantity) {
        if(sessionShoppingCart.containsKey(product)) {
            if(newQuantity == 0) {
                sessionShoppingCart.remove(product);
            } else {
                sessionShoppingCart.put(product, newQuantity);
            }
        }
    }

    public void removeProduct(Product product) {
        if(sessionShoppingCart.containsKey(product)) {
            sessionShoppingCart.remove(product);
        }
    }
}
