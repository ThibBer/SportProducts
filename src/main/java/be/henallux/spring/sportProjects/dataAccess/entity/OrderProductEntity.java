package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="order_product")
public class OrderProductEntity {
    @Id private Integer id;
    private Integer quantity;
    private Double accordedPrice;

    @ManyToOne
    @JoinColumn(name = "order", referencedColumnName = "id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id")
    private ProductEntity productEntity;

    public OrderProductEntity() {}

    public OrderProductEntity(Integer id, Integer quantity, Double accordedPrice, OrderEntity orderEntity, ProductEntity productEntity) {
        setId(id);
        setQuantity(quantity);
        setAccordedPrice(accordedPrice);
        setOrderEntity(orderEntity);
        setProductEntity(productEntity);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAccordedPrice() {
        return accordedPrice;
    }

    public void setAccordedPrice(Double accordedPrice) {
        this.accordedPrice = accordedPrice;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity order) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", accordedPrice=" + accordedPrice +
                ", orderEntity=" + orderEntity +
                ", productEntity=" + productEntity +
                '}';
    }
}
