package be.henallux.spring.sportProjects.model;

public class Category {
    private Integer id;
    private String label;
    private String description;
    private Promotion promotion;

    public Category(){}

    public Category(Integer id, String label, String description, Promotion promotion) {
        this.setId(id);
        this.setLabel(label);
        this.setDescription(description);
        this.setPromotion(promotion);
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

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() +
                ", label='" + getLabel() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", promotion=" + getPromotion() +
                '}';
    }
}
