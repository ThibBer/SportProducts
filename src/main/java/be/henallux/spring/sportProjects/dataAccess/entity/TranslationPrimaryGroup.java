package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TranslationPrimaryGroup implements Serializable {
    private Integer language;
    private Integer product;

    public TranslationPrimaryGroup() {
    }

    public TranslationPrimaryGroup(Integer language, Integer product) {
        this.language = language;
        this.product = product;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }
}
