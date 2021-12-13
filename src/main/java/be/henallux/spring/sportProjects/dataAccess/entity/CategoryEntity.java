package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="category")
public class CategoryEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="label")
    private String label;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "promotion", referencedColumnName = "id")
    private PromotionEntity promotionEntity;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Collection<ProductEntity> productEntities;

    public CategoryEntity(){}

    public CategoryEntity(Integer id, String label, String description, PromotionEntity promotionEntity, Collection<ProductEntity> productEntities) {
        this.setId(id);
        this.setLabel(label);
        this.setDescription(description);
        this.setPromotionEntity(promotionEntity);
        this.setProductEntities(productEntities);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PromotionEntity getPromotion() {
        return promotionEntity;
    }

    public void setPromotionEntity(PromotionEntity promotionEntity) {
        this.promotionEntity = promotionEntity;
    }

    public Collection<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(Collection<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
}
