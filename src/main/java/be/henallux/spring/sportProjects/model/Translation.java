package be.henallux.spring.sportProjects.model;

public class Translation {
    private Language language;
    private Product product;
    private String label;

    public Translation() {}

    public Translation(Language language, Product product, String label) {
        this.language = language;
        this.product = product;
        this.label = label;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
                "language=" + language +
                ", product=" + product +
                ", label='" + label + '\'' +
                '}';
    }
}
