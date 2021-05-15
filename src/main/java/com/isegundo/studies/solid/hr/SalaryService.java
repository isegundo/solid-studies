package com.isegundo.studies.solid.hr;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryService {

    public void increaseEmployeeSalary(Employee employee, BigDecimal increaseAmount){
        var employeeSalary = employee.getSalary();

        if (increaseAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Salary increase must be greater than zero");
        }

        var newSalary = employeeSalary.add(increaseAmount);

        var percentVariation = newSalary.divide(employeeSalary, RoundingMode.HALF_UP).subtract(BigDecimal.ONE);

        if (percentVariation.compareTo(new BigDecimal("0.40")) > 0) {
            throw new ValidationException("Salary increase cannot be higher than 40%");
        }

        employee.updateSalary(newSalary);

    }
}
