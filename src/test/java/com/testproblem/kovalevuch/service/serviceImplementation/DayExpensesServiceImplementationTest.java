package com.testproblem.kovalevuch.service.serviceImplementation;

import com.testproblem.kovalevuch.entity.DayExpenses;
import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.enums.Pln;
import com.testproblem.kovalevuch.repository.DayExpensesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class DayExpensesServiceImplementationTest {

    @Mock
    private DayExpensesRepository dayExpensesRepository;

    @InjectMocks
    private DayExpensesServiceImplementation dayExpensesServiceImplementation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        dayExpensesServiceImplementation.save(new DayExpenses(LocalDate.of(2018, Month.JUNE, 23),
                Collections.<Expenses>singletonList(new Expenses("name", new BigDecimal(0), Pln.AED))));
    }

    @Test
    public void testFindOneByDate() {
        when(dayExpensesRepository.findByDate(any())).thenReturn(new DayExpenses(LocalDate.of(2018, Month.JUNE,
                23), Collections.singletonList(new Expenses("name", new BigDecimal(0), Pln.AED))));

        DayExpenses result = dayExpensesServiceImplementation.findOneByDate(LocalDate.of(2018, Month.JUNE, 23));
        Assert.assertEquals(new DayExpenses(LocalDate.of(2018, Month.JUNE, 23),
                Collections.singletonList(new Expenses("name", new BigDecimal(0), Pln.AED))), result);
    }

    @Test
    public void testFindAll() {
        when(dayExpensesRepository.findAll()).thenReturn(Collections.singletonList(new DayExpenses(LocalDate.of(2018,
                Month.JUNE, 23), Collections.singletonList(new Expenses("name", new BigDecimal(0), Pln.AED)))));

        List<DayExpenses> result = dayExpensesServiceImplementation.findAll();
        Assert.assertEquals(Collections.singletonList(new DayExpenses(LocalDate.of(2018, Month.JUNE, 23),
                Collections.singletonList(new Expenses("name", new BigDecimal(0), Pln.AED)))), result);
    }

    @Test
    public void testDelete() {
        when(dayExpensesRepository.findByDate(any())).thenReturn(new DayExpenses(LocalDate.of(2018, Month.JUNE,
                23), Collections.singletonList(new Expenses("name", new BigDecimal(0), Pln.AED))));

        dayExpensesServiceImplementation.delete(LocalDate.of(2018, Month.JUNE, 23));
    }
}