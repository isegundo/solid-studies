package com.isegundo.studies.solid.hr;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class PeriodicityValidation implements ValidationSalaryIncrease {

    @Override
    public void validate(Employee employee, BigDecimal increaseAmount) {
        var lastUpdateDate = employee.getLastSalaryUpdate();
        var today = LocalDate.now();

        var months = ChronoUnit.MONTHS.between(lastUpdateDate, today);

        if (months < 6) {
            throw new ValidationException("Salary can only be increased 6 months after the last update");
        }


    }
}
