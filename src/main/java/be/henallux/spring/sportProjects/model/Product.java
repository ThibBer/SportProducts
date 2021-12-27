package be.henallux.spring.sportProjects.model;

public class Product {
    private Integer id;
    private Double price;
    private Category category;
    private String description;
    private Translation translation;
    private String image;

    public Product() {}

    public Product(Integer id, Double price, Category category, String description, String image) {
        this.id = id;
        this.price = price;
        this.category = category;
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

    public Double getPriceWithPromotion(){
        Promotion promotion = category.getPromotion();
        if(promotion == null){
            return price;
        }

        return price * ( 1 - (promotion.getPercentage() / 100.0));
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", translation=" + translation +
                ", image='" + image + '\'' +
                '}';
    }
}
