public class ProductInformationSecsion {
    private String productCode;
    private String description;
    private double price;

    public ProductInformationSecsion(String productCode, String description, double price) {
        this.productCode = productCode;
        this.description = description;
        this.price = price;
    }

    // Constructor overloading
    public ProductInformationSecsion() {
        // Default constructor
    }

    public String getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
