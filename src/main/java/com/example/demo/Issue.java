package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity(name="Issue")
public class Issue {
    private @Id String code;
    private String name;
    private int maturityDate;
    private BigDecimal rate;
    private int couponPaymentsNumber;

    public Issue() {}

    public Issue(String code, String name, int maturityDate, BigDecimal rate, int couponPaymentsNumber) {
        this.code = code;
        this.name = name;
        this.maturityDate = maturityDate;
        this.rate = rate;
        this.couponPaymentsNumber = couponPaymentsNumber;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMaturityDate() {
        return maturityDate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public int getCouponPaymentsNumber() {
        return couponPaymentsNumber;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaturityDate(int maturityDate) {
        this.maturityDate = maturityDate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setCouponPaymentsNumber(int couponPaymentsNumber) {
        this.couponPaymentsNumber = couponPaymentsNumber;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", maturityDate=" + maturityDate +
                ", rate=" + rate +
                ", couponPaymentsNumber=" + couponPaymentsNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return maturityDate == issue.maturityDate && couponPaymentsNumber == issue.couponPaymentsNumber && Objects.equals(code, issue.code) && Objects.equals(name, issue.name) && Objects.equals(rate, issue.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, maturityDate, rate, couponPaymentsNumber);
    }
}
