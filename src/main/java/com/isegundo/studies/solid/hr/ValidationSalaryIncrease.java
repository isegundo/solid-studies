package com.isegundo.studies.solid.hr;

import java.math.BigDecimal;

public interface ValidationSalaryIncrease {

    void validate(Employee employee, BigDecimal increaseAmount);
}
