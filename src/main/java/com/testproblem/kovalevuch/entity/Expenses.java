package com.testproblem.kovalevuch.entity;

import com.testproblem.kovalevuch.entity.abstractClasses.AbstractId;
import com.testproblem.kovalevuch.enums.Pln;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "expenses")
public class Expenses extends AbstractId {

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Enumerated
    private Pln pln;

    @ManyToOne
    @JoinColumn(name = "day_expenses")
    private DayExpenses dayExpenses;

    public Expenses() {
    }

    public Expenses(String name, BigDecimal price, Pln pln) {
        this.name = name;
        this.price = price;
        this.pln = pln;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Pln getPln() {
        return pln;
    }

    public void setPln(Pln pln) {
        this.pln = pln;
    }

    public DayExpenses getDayExpenses() {
        return dayExpenses;
    }

    public void setDayExpenses(DayExpenses dayExpenses) {
        this.dayExpenses = dayExpenses;
    }

    @Override
    public String toString() {
        return "\033[34m" + name + " " + price.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros() + " " + pln + "\033[0m";
    }
}
