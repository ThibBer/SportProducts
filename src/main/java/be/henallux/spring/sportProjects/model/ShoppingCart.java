package be.henallux.spring.sportProjects.model;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> sessionShoppingCart;
    private static ShoppingCart instance;

    private ShoppingCart() {
        this.sessionShoppingCart = new HashMap<>();
    }

    public static ShoppingCart getInstance() {
        if(instance == null)
            instance = new ShoppingCart();
        return instance;
    }

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

    public HashMap<Product, Integer> getSessionShoppingCart() {
        return sessionShoppingCart;
    }

    @Override
    public String toString() {
        String shoppingCartText = "Panier\n";
        for(Product product : sessionShoppingCart.keySet()) {
            shoppingCartText += "Nb products : " + sessionShoppingCart.size() + "\n";
            shoppingCartText += "Id : " + product.getId() + "\tQuantity : " + sessionShoppingCart.get(product) + "\n";
        }
        return shoppingCartText;
    }
}
