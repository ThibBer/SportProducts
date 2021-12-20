package be.henallux.spring.sportProjects.model;

import java.time.LocalDate;

public class Category {
    private Integer id;
    private String label;
    private String description;
    private String image;
    private Promotion promotion;

    public Category(){}

    public Category(Integer id, String label, String description, String image, Promotion promotion) {
        this.setId(id);
        this.setLabel(label);
        this.setDescription(description);
        this.setImage(image);
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public boolean isInPromotion(){
        if(promotion == null){
            return false;
        }

        //TODO je crois que c'est inversé ?
        LocalDate now = LocalDate.now();
        return (promotion.getStartDate().isEqual(now) || promotion.getStartDate().isBefore(now)) && (promotion.getEndDate().isAfter(now) || this.promotion.getEndDate().equals(now));
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
