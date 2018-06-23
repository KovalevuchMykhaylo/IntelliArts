package com.testproblem.kovalevuch.entity;


import com.testproblem.kovalevuch.entity.abstractClasses.AbstractId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "day_expenses")
public class DayExpenses extends AbstractId {

    @Column(columnDefinition = "TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @OneToMany(mappedBy = "dayExpenses", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Expenses> expenses = new ArrayList<>();

    public DayExpenses() {
    }

    public DayExpenses(LocalDate date, List<Expenses> expenses) {
        this.date = date;
        this.expenses = expenses;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Expenses> getProducts() {
        return expenses;
    }

    public void setProducts(List<Expenses> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return date + "\n";
    }
}
