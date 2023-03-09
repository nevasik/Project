package ru.poplaukhin.spring.models;

import java.math.BigInteger;

public class Accruals {
    private BigInteger accrual_code;
    private BigInteger account_code;
    private BigInteger service_code;
    private int quantity;

    public Accruals(BigInteger accrual_code, BigInteger account_code, BigInteger service_code, int quantity) {
        this.accrual_code = accrual_code;
        this.account_code = account_code;
        this.service_code = service_code;
        this.quantity = quantity;
    }

    public Accruals() {
    }

    public BigInteger getAccrual_code() {
        return accrual_code;
    }

    public void setAccrual_code(BigInteger accrual_code) {
        this.accrual_code = accrual_code;
    }

    public BigInteger getAccount_code() {
        return account_code;
    }

    public void setAccount_code(BigInteger account_code) {
        this.account_code = account_code;
    }

    public BigInteger getService_code() {
        return service_code;
    }

    public void setService_code(BigInteger service_code) {
        this.service_code = service_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Accruals{" +
                "accrual_code=" + accrual_code +
                ", account_code=" + account_code +
                ", service_code=" + service_code +
                ", quantity=" + quantity +
                '}';
    }
}
