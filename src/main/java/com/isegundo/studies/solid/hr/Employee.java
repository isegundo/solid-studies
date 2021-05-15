package com.isegundo.studies.solid.hr;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;

    private BigDecimal salary;
    private LocalDate lastSalaryUpdate;

    public void updateSalary(BigDecimal salaryAmount) {
        this.salary = salaryAmount;
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
