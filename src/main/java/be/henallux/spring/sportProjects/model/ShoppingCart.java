package be.henallux.spring.sportProjects.model;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> productsWithQuantities = new HashMap<>();

    public ShoppingCart() {
    }

    public void addProductWithQuantity(Product product, Integer quantity) {
        productsWithQuantities.put(product, quantity);
    }

    public void changeQuantityForProduct(Product product, Integer newQuantity) {
        if(productsWithQuantities.containsKey(product)) {
            if(newQuantity == 0) {
                productsWithQuantities.remove(product);
            } else {
                productsWithQuantities.put(product, newQuantity);
            }
        }
    }

    public void removeProduct(Product product) {
        if(productsWithQuantities.containsKey(product)) {
            productsWithQuantities.remove(product);
        }
    }

    public HashMap<Product, Integer> getProductsWithQuantities() {
        return productsWithQuantities;
    }

    @Override
    public String toString() {
        String shoppingCartText = "Panier\n";
        for(Product product : productsWithQuantities.keySet()) {
            shoppingCartText += "Nb products : " + productsWithQuantities.size() + "\n";
            shoppingCartText += "Id : " + product.getId() + "\tQuantity : " + productsWithQuantities.get(product) + "\n";
        }
        return shoppingCartText;
    }
}
