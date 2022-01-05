package be.henallux.spring.sportProjects.model;

public class Product {
    private Integer id;
    private Double price;
    private Double priceWithPromotion;
    private Category category;
    private String description;
    private Translation translation;
    private String image;

    public Product(Integer id, Double price, Category category, String description, String image) {
        setId(id);
        setPrice(price);
        setPriceWithPromotion(price);
        setCategory(category);
        setDescription(description);
        setImage(image);
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

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceWithPromotion() {
        return priceWithPromotion;
    }

    public void setPriceWithPromotion(Double priceWithPromotion) {
        this.priceWithPromotion = priceWithPromotion;
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

    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;
        return id.equals(product.getId());
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
