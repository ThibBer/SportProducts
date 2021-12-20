package be.henallux.spring.sportProjects.dataAccess.entity;

import be.henallux.spring.sportProjects.model.Promotion;

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

    @Column(name="category")
    private Integer categoryId;

    @Column(name="image")
    private String image;

    public ProductEntity() {}

    public ProductEntity(Integer id, Double price, Integer categoryId, String description, String image) {
        setId(id);
        setPrice(price);
        setCategoryId(categoryId);
        setDescription(description);
        setImage(image);
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}