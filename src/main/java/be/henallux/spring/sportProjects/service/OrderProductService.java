package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.OrderProductDataAccess;
import be.henallux.spring.sportProjects.model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {
    private OrderProductDataAccess orderProductDataAccess;

    @Autowired
    public OrderProductService(OrderProductDataAccess orderProductDataAccess) {
        this.orderProductDataAccess = orderProductDataAccess;
    }

    public void saveAll(List<OrderProduct> orderProducts){
        orderProductDataAccess.saveAll(orderProducts);
    }
}
