package com.isegundo.studies.solid.hr.salary;

import com.isegundo.studies.solid.hr.Employee;
import com.isegundo.studies.solid.hr.ValidationException;

import java.math.BigDecimal;

public class PositiveIncreaseValidation implements ValidationSalaryIncrease {

    @Override
    public void validate(Employee employee, BigDecimal increaseAmount) {
        if (increaseAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Salary increase must be greater than zero");
        }
    }
}
