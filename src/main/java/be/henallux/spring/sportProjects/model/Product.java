package be.henallux.spring.sportProjects.model;

public class Product {
    private Integer id;
    private Double price;
    private Integer categoryId;
    private String description;
    private Translation translation;
    private String image;

    public Product() {}

    public Product(Integer id, Double price, Integer categoryId, String description, String image) {
        this.id = id;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
        this.image = image;
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

    public Double getPriceWithPromotion(Promotion promotion){
        if(promotion == null){
            return price;
        }

        return price * ( 1 - (promotion.getPercentage() / 100.0));
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
