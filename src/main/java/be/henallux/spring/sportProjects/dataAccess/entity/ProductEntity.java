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
    private CategoryEntity categoryEntity;

    @Column(name="image")
    private String image;

    public ProductEntity() {}

    public ProductEntity(Integer id, Double price, CategoryEntity categoryEntity, String description, String image) {
        setId(id);
        setPrice(price);
        setCategoryEntity(categoryEntity);
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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
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