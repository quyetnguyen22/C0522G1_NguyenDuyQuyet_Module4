package product.manager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
@Entity
public class Product {

    @Id
    private int id;
    private String productName;
    private double productPrice;
    private String productDetail;
    private String producer;

    public Product() {
    }

    public Product(int id, String productName, double productPrice, String productDetail, String producer) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDetail = productDetail;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
