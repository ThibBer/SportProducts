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
    public boolean equals(Object obj) {
        if(!(obj instanceof Language)){
            return false;
        }

        Language language = (Language) obj;

        return language.getId().equals(id) && language.getInternationCode().equals(internationCode);
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", internationCode='" + internationCode + '\'' +
                '}';
    }
}
