package be.henallux.spring.sportProjects.model;

import java.util.ArrayList;

public class Category {
    private Integer id;
    private String label;
    private String description;
    private Promotion promotion;
    private ArrayList<Product> products;

    public Category(){}

    public Category(Integer id, String label, String description, Promotion promotion, ArrayList<Product> products) {
        this.setId(id);
        this.setLabel(label);
        this.setDescription(description);
        this.setPromotion(promotion);
        this.setProducts(products);
    }
    public Category(Integer id, String label, String description, Promotion promotion) {
        this(id, label, description, promotion, new ArrayList<>());
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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
