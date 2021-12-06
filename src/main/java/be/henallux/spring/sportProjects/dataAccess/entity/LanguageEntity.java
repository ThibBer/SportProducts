package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class LanguageEntity {
    @Id private Integer id;
    private String internationCode;

    public LanguageEntity() {}

    public LanguageEntity(Integer id, String internationCode) {
        this.id = id;
        this.internationCode = internationCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInternationCode() {
        return internationCode;
    }

    public void setInternationCode(String internationCode) {
        this.internationCode = internationCode;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", internationCode='" + internationCode + '\'' +
                '}';
    }
}