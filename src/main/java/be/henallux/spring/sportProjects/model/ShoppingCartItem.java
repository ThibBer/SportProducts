package be.henallux.spring.sportProjects.model;

public class ShoppingCartItem {
    private Integer productId;
    private Integer quantity;

    public ShoppingCartItem() {}

    public ShoppingCartItem(Integer productId, Integer quantity) {
        this.setProductId(productId);
        this.setQuantity(quantity);
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
