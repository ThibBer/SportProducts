package be.henallux.spring.sportProjects.model;

public class Translation {
    private Integer languageId;
    private Integer productId;
    private String label;

    public Translation(Integer languageId, Integer productId, String label) {
        this.languageId = languageId;
        this.productId = productId;
        this.label = label;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
                "language=" + languageId +
                ", product=" + productId +
                ", label='" + label + '\'' +
                '}';
    }
}
