package be.henallux.spring.sportProjects.model;

public class OrderProduct {
    private Integer id;
    private Integer quantity;
    private Double accordedPrice;
    private Order order;
    private Product product;

    public OrderProduct(Integer id, Integer quantity, Double accordedPrice, Order order, Product product) {
        setId(id);
        setQuantity(quantity);
        setAccordedPrice(accordedPrice);
        setOrder(order);
        setProduct(product);
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", accordedPrice=" + accordedPrice +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
