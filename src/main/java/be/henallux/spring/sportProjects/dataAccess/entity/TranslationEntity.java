package be.henallux.spring.sportProjects.dataAccess.entity;

import be.henallux.spring.sportProjects.model.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "translation")
public class TranslationEntity implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "language", referencedColumnName = "id")
    private LanguageEntity language;

    @Id
    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id")
    private ProductEntity productEntity;

    private String label;

    public TranslationEntity() {}

    public TranslationEntity(LanguageEntity language, ProductEntity productEntity, String label) {
        this.language = language;
        this.productEntity = productEntity;
        this.label = label;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "language=" + language +
                ", productEntity=" + productEntity +
                ", label='" + label + '\'' +
                '}';
    }
}
