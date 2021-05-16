package com.isegundo.studies.solid.hr.salary;

import com.isegundo.studies.solid.hr.Employee;
import com.isegundo.studies.solid.hr.ValidationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentageValidation implements ValidationSalaryIncrease {
    @Override
    public void validate(Employee employee, BigDecimal increaseAmount) {
        var employeeSalary = employee.getSalary();
        var newSalary = employeeSalary.add(increaseAmount);

        var percentVariation = newSalary.divide(employeeSalary, RoundingMode.HALF_UP).subtract(BigDecimal.ONE);

        if (percentVariation.compareTo(new BigDecimal("0.40")) > 0) {
            throw new ValidationException("Salary increase cannot be higher than 40%");
        }
    }
}
