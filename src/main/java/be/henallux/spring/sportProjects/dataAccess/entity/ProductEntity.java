package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class ProductEntity {
    @Id private Integer id;
    private Double price;

    @ManyToOne
    @JoinColumn(name="category", referencedColumnName = "id")
    private CategoryEntity category;

    private String description;

    public ProductEntity() {}

    public ProductEntity(Integer id, Double price, CategoryEntity category, String description) {
        setId(id);
        setPrice(price);
        setCategoryEntity(category);
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

    public CategoryEntity getCategoryEntity() {
        return category;
    }

    public void setCategoryEntity(CategoryEntity category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}