package com.testproblem.kovalevuch.service;

import com.testproblem.kovalevuch.entity.Expenses;

import java.util.List;

public interface ExpensesService {

    void deleteAllByDayExpensesId(Long dayExpensesId);

    void save(Expenses expenses);

    List<Expenses> findAll();
}
