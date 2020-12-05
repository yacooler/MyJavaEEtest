package entity;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String title;
    private BigDecimal cost;

    public Product(Integer id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
