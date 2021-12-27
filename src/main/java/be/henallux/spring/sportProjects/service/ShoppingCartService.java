package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService {
    public double getTotalPrice(HashMap<Product, Integer> products){
        double price = 0;

        for(Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            price += product.getPriceWithPromotion() * quantity;
        }

        return price;
    }
}
