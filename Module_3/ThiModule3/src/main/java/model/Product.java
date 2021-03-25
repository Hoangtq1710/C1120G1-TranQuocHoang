package model;

public class Product {
    private int productId;
    private String productName;
    private int price;
    private int percent;
    private int stock;

    public Product(int productId, String productName, int price, int percent, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.percent = percent;
        this.stock = stock;
    }

    public Product(String productName, int price, int percent, int stock) {
        this.productName = productName;
        this.price = price;
        this.percent = percent;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
