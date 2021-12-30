package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.model.OrderProduct;

import java.util.List;

public interface OrderProductDataAccess {
    void saveAll(List<OrderProduct> orderProducts);
}
