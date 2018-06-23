package com.testproblem.kovalevuch.repository;

import com.testproblem.kovalevuch.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {

    @Query("DELETE FROM Expenses a WHERE a.dayExpenses.id=?1")
    @Transactional
    @Modifying
    void deleteAllByDayExpensesId(Long id);
}
