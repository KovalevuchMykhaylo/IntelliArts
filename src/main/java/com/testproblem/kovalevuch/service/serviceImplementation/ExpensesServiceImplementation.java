package com.testproblem.kovalevuch.service.serviceImplementation;

import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.repository.ExpensesRepository;
import com.testproblem.kovalevuch.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesServiceImplementation implements ExpensesService {

    private ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesServiceImplementation(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @Override
    public void deleteAllByDayExpensesId(Long dayExpensesId) {
        expensesRepository.deleteAllByDayExpensesId(dayExpensesId);
    }

    @Override
    public void save(Expenses expenses) {
        expensesRepository.save(expenses);
    }

    @Override
    public List<Expenses> findAll() {
        return expensesRepository.findAll();
    }
}
