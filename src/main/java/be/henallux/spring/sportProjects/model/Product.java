package be.henallux.spring.sportProjects.model;

public class Product {
    private Integer id;
    private Double price;
    private Category category;
    private String description;

    public Product() {}

    public Product(Integer id, Double price, Category category, String description) {
        setId(id);
        setPrice(price);
        setCategory(category);
        setDescription(description);
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
