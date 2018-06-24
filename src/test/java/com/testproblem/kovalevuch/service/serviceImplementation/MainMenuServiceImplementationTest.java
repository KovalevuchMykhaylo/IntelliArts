package com.testproblem.kovalevuch.service.serviceImplementation;

import com.testproblem.kovalevuch.entity.DayExpenses;
import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.enums.Pln;
import com.testproblem.kovalevuch.service.DayExpensesService;
import com.testproblem.kovalevuch.service.mainMenuComponents.AddCommand;
import com.testproblem.kovalevuch.service.mainMenuComponents.ClearCommand;
import com.testproblem.kovalevuch.service.mainMenuComponents.TotalCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class MainMenuServiceImplementationTest {

    @Mock
    private AddCommand addCommand;

    @Mock
    private ClearCommand clearCommand;

    @Mock
    private TotalCommand totalCommand;

    @Mock
    private DayExpensesService dayExpensesService;

    @InjectMocks
    private MainMenuServiceImplementation mainMenuServiceImplementation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCommand() {
        mainMenuServiceImplementation.addCommand("fullInput");
    }

    @Test
    public void testClearCommand() {
        mainMenuServiceImplementation.clearCommand("fullInput");
    }

    @Test
    public void testTotalCommand() {
        mainMenuServiceImplementation.totalCommand("fullInput");
    }

    @Test
    public void testListCommand() {
        when(dayExpensesService.findAll()).thenReturn(Collections.singletonList(new DayExpenses(LocalDate.of(2018, Month.JUNE, 23), Collections.singletonList(new Expenses("name", new BigDecimal(0), Pln.AED)))));
        mainMenuServiceImplementation.listCommand();
        verify(dayExpensesService, times(1)).findAll();
    }
}