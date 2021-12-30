package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.OrderDataAccess;
import be.henallux.spring.sportProjects.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderDataAccess orderDataAccess;

    @Autowired
    public OrderService(OrderDataAccess orderDataAccess) {
        this.orderDataAccess = orderDataAccess;
    }

    public Order insertOrder(Order order){
        return orderDataAccess.insertOrder(order);
    }
}
