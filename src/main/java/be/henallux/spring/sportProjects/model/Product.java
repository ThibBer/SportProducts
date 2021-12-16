package be.henallux.spring.sportProjects.model;

public class Product {
    private Integer id;
    private Double price;
    private Integer categoryId;
    private String description;

    public Product() {}

    public Product(Integer id, Double price, Integer categoryId, String description) {
        this.id = id;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
