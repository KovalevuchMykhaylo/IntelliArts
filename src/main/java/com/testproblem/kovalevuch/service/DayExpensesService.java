package com.testproblem.kovalevuch.service;

import com.testproblem.kovalevuch.entity.DayExpenses;

import java.time.LocalDate;
import java.util.List;

public interface DayExpensesService {

    void save(DayExpenses dayExpenses);

    DayExpenses findOneByDate(LocalDate date);

    List<DayExpenses> findAll();

    void delete(LocalDate localDate);
}
