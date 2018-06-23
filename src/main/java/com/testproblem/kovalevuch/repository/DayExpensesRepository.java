package com.testproblem.kovalevuch.repository;

import com.testproblem.kovalevuch.entity.DayExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayExpensesRepository extends JpaRepository<DayExpenses, Integer> {

    DayExpenses findByDate(LocalDate date);

    @Query("SELECT d FROM DayExpenses d ORDER BY d.date")
    List<DayExpenses> findAll();
}
