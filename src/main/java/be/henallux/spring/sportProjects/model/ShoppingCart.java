package be.henallux.spring.sportProjects.model;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Integer, Integer> productsWithQuantities = new HashMap<>();

    public ShoppingCart() {
    }

    public void addProductWithQuantity(Integer productId, Integer quantity) {
        Integer lastQuantity = productsWithQuantities.get(productId);

        if(quantity > 0){
            if(lastQuantity != null){
                quantity += lastQuantity;
            }

            productsWithQuantities.put(productId, quantity);
        }
    }

    public void updateQuantity(Integer productId, Integer newQuantity) {
        if(productsWithQuantities.containsKey(productId)) {
            if(newQuantity == 0) {
                removeProduct(productId);
            } else {
                productsWithQuantities.put(productId, newQuantity);
            }
        }
    }

    public void removeProduct(Integer productId) {
        productsWithQuantities.remove(productId);
    }

    public HashMap<Integer, Integer> getProductsWithQuantities() {
        return productsWithQuantities;
    }

    public void clear(){
        productsWithQuantities.clear();
    }

    @Override
    public String toString() {
        StringBuilder shoppingCartText = new StringBuilder("Panier\n");

        for(Integer productId : productsWithQuantities.keySet()) {
            shoppingCartText.append("Nb products : ").append(productsWithQuantities.size()).append("\n");
            shoppingCartText.append("Id : ").append(productId).append("\tQuantity : ").append(productsWithQuantities.get(productId)).append("\n");
        }

        return shoppingCartText.toString();
    }
}