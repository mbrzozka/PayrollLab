package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testCalculateGrossPay() {
        assertEquals(671.2, Calculator.calculateGrossPay(40), 0.1);
        assertEquals(797.05, Calculator.calculateGrossPay(45), 0.1);
    }

    @Test
    public void testCalculateDeductions() {
        double grossPay = 671.2;
        int dependents = 2;
        double expectedDeductions = (grossPay * Calculator.socialSecurityTaxRate) + (grossPay * Calculator.federalIncomeTaxRate) 
                                + (grossPay * Calculator.stateIncomeTaxRate) + Calculator.unionDues + Calculator.insuranceCostUnder3Dep;
        assertEquals(expectedDeductions, Calculator.calculateDeductions(grossPay, dependents), 0.1);
    }

    @Test
    public void testCalculateNetPay() {
        double grossPay = 671.2;
        double deductions = 150.0;
        assertEquals(521.2, Calculator.calculateNetPay(grossPay, deductions), 0.1);
    }

    @Test
    public void testCalculateGrossPayWithCustomRate() {
        double hoursWorked = 45;
        double payRate = 20.0;
        double expectedGrossPay = (40 * payRate) + (5 * payRate * Calculator.overtimeMultiplier);
        assertEquals(expectedGrossPay, Calculator.calculateGrossPay(hoursWorked, payRate), 0.1);
    }

    @Test
    public void testCalculateDeductionsTreatsNegativeDependentsAsZero() {
        double grossPay = 500.0;
        int negativeDependents = -2;
        double expectedDeductions = (grossPay * Calculator.socialSecurityTaxRate)
                + (grossPay * Calculator.federalIncomeTaxRate)
                + (grossPay * Calculator.stateIncomeTaxRate)
                + Calculator.unionDues
                + Calculator.insuranceCostUnder3Dep;
        assertEquals(expectedDeductions, Calculator.calculateDeductions(grossPay, negativeDependents), 0.1);
    }
}