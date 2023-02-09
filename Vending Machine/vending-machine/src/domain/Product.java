package domain;

import java.util.Date;

public class Product {
    private String name;
    private int price;

    private Date expirationDate;

    public Product(String name, int price, Date expirationDate) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
