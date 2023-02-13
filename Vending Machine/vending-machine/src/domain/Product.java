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

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(!(obj instanceof Product))
            return false;
        return this.name.equals(((Product) obj).name);
    }
}
