package com.example.demo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity(name="Position")
public class Position {
    private @Id String code;

    //@ManyToOne
    //@JoinColumn(name = "issue_code")
    //private Issue issue;
    private BigDecimal quantity;
    private BigDecimal bookValue;
    private BigDecimal profitOrLossFromValuation;

    /*public void setIssue(Issue issue) {
        this.issue = issue;
    }*/


    public Position() {
    }

    public Position(String code, Issue issue, BigDecimal quantity, BigDecimal bookValue, BigDecimal profitOrLossFromValuation) {
        this.code = code;
        //this.issue = issue;
        this.quantity = quantity;
        this.bookValue = bookValue;
        this.profitOrLossFromValuation = profitOrLossFromValuation;
    }

    /*public Issue getIssue() {
        return issue;
    }*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getBookValue() {
        return bookValue;
    }

    public void setBookValue(BigDecimal bookValue) {
        this.bookValue = bookValue;
    }

    public BigDecimal getProfitOrLossFromValuation() {
        return profitOrLossFromValuation;
    }

    public void setProfitOrLossFromValuation(BigDecimal profitOrLossFromValuation) {
        this.profitOrLossFromValuation = profitOrLossFromValuation;
    }

    @Override
    public String toString() {
        return "Position{" +
                "code='" + code + '\'' +
                ", quantity=" + quantity +
                ", bookValue=" + bookValue +
                ", profitOrLossFromValuation=" + profitOrLossFromValuation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(code, position.code) && Objects.equals(quantity, position.quantity) && Objects.equals(bookValue, position.bookValue) && Objects.equals(profitOrLossFromValuation, position.profitOrLossFromValuation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, quantity, bookValue, profitOrLossFromValuation);
    }
}
