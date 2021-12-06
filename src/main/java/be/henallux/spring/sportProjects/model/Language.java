package be.henallux.spring.sportProjects.model;

public class Language {
    private Integer id;
    private String internationCode;

    public Language() {}

    public Language(Integer id, String internationCode) {
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