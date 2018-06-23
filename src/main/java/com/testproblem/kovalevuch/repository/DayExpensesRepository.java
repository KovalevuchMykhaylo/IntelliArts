package com.testproblem.kovalevuch.repository;

import com.testproblem.kovalevuch.entity.DayExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayExpensesRepository extends JpaRepository<DayExpenses, Integer> {

//    @Query("SELECT a FROM DayExpenses a LEFT JOIN FETCH a.expenses")
//    List<DayExpenses> findAdll();

    @Query("DELETE FROM DayExpenses a WHERE a.date=?1")
    @Transactional
    @Modifying
    void deleteByDate(LocalDate date);

    DayExpenses findByDate(LocalDate date);

    @Query("SELECT d FROM DayExpenses d ORDER BY d.date")
    List<DayExpenses> findAll();
}
