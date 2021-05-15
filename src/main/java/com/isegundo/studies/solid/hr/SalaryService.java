package com.isegundo.studies.solid.hr;

import java.math.BigDecimal;
import java.util.List;

public class SalaryService {

    private final List<ValidationSalaryIncrease> validators;

    public SalaryService(List<ValidationSalaryIncrease> validators) {
        this.validators = validators;
    }

    public void increaseEmployeeSalary(Employee employee, BigDecimal increaseAmount) {

        validators.forEach(v -> v.validate(employee, increaseAmount));

        var employeeSalary = employee.getSalary();
        var newSalary = employeeSalary.add(increaseAmount);
        employee.updateSalary(newSalary);
    }

}
