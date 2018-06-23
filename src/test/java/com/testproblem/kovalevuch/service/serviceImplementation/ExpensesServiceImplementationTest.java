package com.testproblem.kovalevuch.service.serviceImplementation;

import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.enums.Pln;
import com.testproblem.kovalevuch.repository.ExpensesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class ExpensesServiceImplementationTest {

    @Mock
    private ExpensesRepository expensesRepository;

    @InjectMocks
    private ExpensesServiceImplementation expensesServiceImplementation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteAllByDayExpensesId() {
        expensesServiceImplementation.deleteAllByDayExpensesId(1L);
    }

    @Test
    public void testSave() {
        expensesServiceImplementation.save(new Expenses("name", new BigDecimal(0), Pln.AED));
    }

    @Test
    public void testFindAll() {
        List<Expenses> result = expensesServiceImplementation.findAll();
        Assert.assertEquals(Collections.<Expenses>emptyList(), result);
    }
}