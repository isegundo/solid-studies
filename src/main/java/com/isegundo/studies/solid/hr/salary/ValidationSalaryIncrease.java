package com.isegundo.studies.solid.hr.salary;

import com.isegundo.studies.solid.hr.Employee;

import java.math.BigDecimal;

public interface ValidationSalaryIncrease {

    void validate(Employee employee, BigDecimal increaseAmount);
}
