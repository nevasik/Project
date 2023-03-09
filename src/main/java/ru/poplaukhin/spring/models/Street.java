package ru.poplaukhin.spring.models;

import java.math.BigInteger;

public class Street {
    private BigInteger street_code;
    private String title;

    public Street(BigInteger street_code, String title) {
        this.street_code = street_code;
        this.title = title;
    }

    public Street() {
    }

    public BigInteger getStreet_code() {
        return street_code;
    }

    public void setStreet_code(BigInteger street_code) {
        this.street_code = street_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Street{" +
                "street_code=" + street_code +
                ", title='" + title + '\'' +
                '}';
    }
}
