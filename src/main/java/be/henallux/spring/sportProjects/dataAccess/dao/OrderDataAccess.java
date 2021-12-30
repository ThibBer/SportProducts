package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.model.Order;

public interface OrderDataAccess {
    Order insertOrder(Order order);
}
