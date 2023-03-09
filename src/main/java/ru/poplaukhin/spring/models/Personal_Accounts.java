package ru.poplaukhin.spring.models;

import java.math.BigInteger;

public class Personal_Accounts {
    private BigInteger account_code;
    private BigInteger account_number;
    private BigInteger street_code;
    private BigInteger house;
    private BigInteger frame;
    private BigInteger apartment;
    private String full_name;

    public Personal_Accounts(BigInteger account_code, BigInteger account_number, BigInteger street_code, BigInteger house, BigInteger frame, BigInteger apartment, String full_name) {
        this.account_code = account_code;
        this.account_number = account_number;
        this.street_code = street_code;
        this.house = house;
        this.frame = frame;
        this.apartment = apartment;
        this.full_name = full_name;
    }

    public Personal_Accounts() {
    }

    public BigInteger getAccount_code() {
        return account_code;
    }

    public void setAccount_code(BigInteger account_code) {
        this.account_code = account_code;
    }

    public BigInteger getAccount_number() {
        return account_number;
    }

    public void setAccount_number(BigInteger account_number) {
        this.account_number = account_number;
    }

    public BigInteger getStreet_code() {
        return street_code;
    }

    public void setStreet_code(BigInteger street_code) {
        this.street_code = street_code;
    }

    public BigInteger getHouse() {
        return house;
    }

    public void setHouse(BigInteger house) {
        this.house = house;
    }

    public BigInteger getFrame() {
        return frame;
    }

    public void setFrame(BigInteger frame) {
        this.frame = frame;
    }

    public BigInteger getApartment() {
        return apartment;
    }

    public void setApartment(BigInteger apartment) {
        this.apartment = apartment;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "Personal_Accounts{" +
                "account_code=" + account_code +
                ", account_number=" + account_number +
                ", street_code=" + street_code +
                ", house=" + house +
                ", frame=" + frame +
                ", apartment=" + apartment +
                ", full_name='" + full_name + '\'' +
                '}';
    }
}
