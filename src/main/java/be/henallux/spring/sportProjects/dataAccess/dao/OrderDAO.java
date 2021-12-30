package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.entity.OrderEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.OrderRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDAO implements OrderDataAccess {
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Order insertOrder(Order order) {
        OrderEntity entity = orderRepository.save(providerConverter.orderModelToOrderEntity(order));

        return providerConverter.orderEntityToOrderModel(entity);
    }
}
