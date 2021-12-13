package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="category", referencedColumnName = "id")
    private CategoryEntity category;

    public ProductEntity() {}

    public ProductEntity(Integer id, Double price, CategoryEntity category, String description) {
        this.id = id;
        this.price = price;
        this.category = category;
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