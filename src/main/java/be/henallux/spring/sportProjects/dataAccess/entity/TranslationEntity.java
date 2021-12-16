package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "translation")
public class TranslationEntity implements Serializable {
    @EmbeddedId
    private TranslationPrimaryGroup translationId;

    @Column(name="label")
    private String label;

    public TranslationEntity() {}

    public TranslationEntity(TranslationPrimaryGroup translationId, String label) {
        this.translationId = translationId;
        this.label = label;
    }

    public TranslationPrimaryGroup getTranslationId() {
        return translationId;
    }

    public void setTranslationId(TranslationPrimaryGroup translationId) {
        this.translationId = translationId;
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
                "language=" + translationId.getLanguage() +
                ", productEntity=" + translationId.getProduct() +
                ", label='" + label + '\'' +
                '}';
    }
}
