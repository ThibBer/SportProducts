package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.repository.OrderProductRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductDAO implements OrderProductDataAccess{
    private OrderProductRepository orderProductRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderProductDAO(OrderProductRepository orderProductRepository, ProviderConverter providerConverter) {
        this.orderProductRepository = orderProductRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public void saveAll(List<OrderProduct> orderProducts) {
        orderProductRepository.saveAll(providerConverter.orderProductModelsToOrderProductEntities(orderProducts));
    }
}
