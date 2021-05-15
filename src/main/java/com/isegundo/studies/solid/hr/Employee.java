package com.isegundo.studies.solid.hr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;

    private BigDecimal salary;
    private LocalDate lastSalaryUpdate;

    public void increaseSalary(BigDecimal salaryIncrease) {
        if (salaryIncrease.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Salary increase must be greater than zero");
        }

        var newSalary = this.salary.add(salaryIncrease);

        var percentVariation = newSalary.divide(this.salary, RoundingMode.HALF_UP).subtract(BigDecimal.ONE);

        if (percentVariation.compareTo(new BigDecimal("0.40")) > 0) {
            throw new ValidationException("Salary increase cannot be higher than 40%");
        }

        this.salary = newSalary;
        this.lastSalaryUpdate = LocalDate.now();

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getLastSalaryUpdate() {
        return lastSalaryUpdate;
    }

}
