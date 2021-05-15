package com.isegundo.studies.solid.hr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SalaryServiceTest {

    private Employee employee;
    private SalaryService salaryService = new SalaryService();

    @BeforeEach
    void setup() {
        this.employee = new Employee();
        this.employee.setFirstName("John");
        this.employee.setLastName("Doe");
        this.employee.setSalary(new BigDecimal("1000.00"));
    }

    @DisplayName("Valid salary increase")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "50.00,1050.00",
            "400.00,1400.00"
    })
    void increaseSalary_valid(String increase, String resultSalary) {
        // Arrange
        var salaryIncrease = new BigDecimal(increase);

        // Act
        salaryService.increaseEmployeeSalary(this.employee, salaryIncrease);

        // Assert
        assertEquals(new BigDecimal(resultSalary), employee.getSalary());
    }


    @Test
    void increaseSalary_higher_than_40_percent() {
        // Arrange
        var salaryIncrease = new BigDecimal("500.00");

        // Act and Assert
        var exception = assertThrows(ValidationException.class,
                () -> salaryService.increaseEmployeeSalary(this.employee, salaryIncrease)
        );
        assertEquals("Salary increase cannot be higher than 40%", exception.getMessage());
    }


    @DisplayName("Zero or lower salary increase")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "0.00",
            "-10.00"
    })
    void increaseSalary_zero_or_lower(String increase) {
        // Arrange
        var salaryIncrease = BigDecimal.ZERO;

        // Act and Assert
        var exception = assertThrows(ValidationException.class,
                () -> salaryService.increaseEmployeeSalary(this.employee, salaryIncrease)
        );
        assertEquals("Salary increase must be greater than zero", exception.getMessage());
    }

}