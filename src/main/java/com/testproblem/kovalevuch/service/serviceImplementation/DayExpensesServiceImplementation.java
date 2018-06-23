package com.testproblem.kovalevuch.service.serviceImplementation;

import com.testproblem.kovalevuch.entity.DayExpenses;
import com.testproblem.kovalevuch.repository.DayExpensesRepository;
import com.testproblem.kovalevuch.service.DayExpensesService;
import com.testproblem.kovalevuch.utils.ConsoleMessagePrinters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DayExpensesServiceImplementation implements DayExpensesService {

    private DayExpensesRepository dayExpensesRepository;

    @Autowired
    public DayExpensesServiceImplementation(DayExpensesRepository dayExpensesRepository) {
        this.dayExpensesRepository = dayExpensesRepository;
    }

    @Override
    public void save(DayExpenses dayExpenses) {
        dayExpensesRepository.save(dayExpenses);
    }

    @Override
    public DayExpenses findOneByDate(LocalDate date) {
        return dayExpensesRepository.findByDate(date);
    }

    @Override
    public List<DayExpenses> findAll() {
        return dayExpensesRepository.findAll();
    }

    @Override
    public void delete(LocalDate localDate) {
        DayExpenses dayExpenses = dayExpensesRepository.findByDate(localDate);
        if (dayExpenses != null) {
            dayExpensesRepository.delete(dayExpensesRepository.findByDate(localDate));
        } else {
            ConsoleMessagePrinters.successPrinter("You did not spend anything that day)))");
        }
    }
}
