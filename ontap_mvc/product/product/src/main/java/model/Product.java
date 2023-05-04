package model;

public class Product {
    private int id ;
    private String nameProduct;
    private  String priceProduct;
    private String description;
    private String producer;

    public Product() {
    }

    public Product(int id, String nameProduct, String priceProduct, String description, String producer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.description = description;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
