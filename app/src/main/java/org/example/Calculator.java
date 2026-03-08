// Program prompts number of hours worked this week and number of dependents. Program prints out report with hours 
// worked, rate of pay, gross earnings, calculated expenses, and net pay. Current hourly rate is $16.78 for first 40 
// hours worked per week. If employee works overtime those hours are paid one and a half times normal rate. Gross pay 
// is hourly rate times number of hours worked. Tax deductions: 6% social security tax, 14% federal income tax, 5% 
// state income tax. $10.00 local union dues. Three or more dependents pay $35 per paycheck, others pay $15 per 
// paycheck. Net pay is equal to gross pay minus expenses.
package org.example;

public class Calculator {
    public static final double hourlyRate = 16.78;
    public static final double overtimeMultiplier = 1.5;
    public static final double socialSecurityTaxRate = 0.06;
    public static final double federalIncomeTaxRate = 0.14;
    public static final double stateIncomeTaxRate = 0.05;
    public static final double unionDues = 10.00;
    public static final double insuranceCostUnder3Dep = 15.00;
    public static final double insuranceCost3OrMoreDep = 35.00;

    public static double calculateGrossPay(double hoursWorked) {
        return calculateGrossPay(hoursWorked, hourlyRate);
    }

    public static double calculateGrossPay(double hoursWorked, double payRate) {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        } else {
            double regularPay = 40 * payRate;
            double overtimePay = (hoursWorked - 40) * payRate * overtimeMultiplier;
            return regularPay + overtimePay;
        }
    }

    public static double calculateDeductions(double grossPay, int dependents) {
        int normalizedDependents = Math.max(0, dependents);
        double socialSecurityTax = grossPay * socialSecurityTaxRate;
        double federalIncomeTax = grossPay * federalIncomeTaxRate;
        double stateIncomeTax = grossPay * stateIncomeTaxRate;
        double insuranceCost = (normalizedDependents >= 3) ? insuranceCost3OrMoreDep : insuranceCostUnder3Dep;
        return socialSecurityTax + federalIncomeTax + stateIncomeTax + unionDues + insuranceCost;
    }
    public static double calculateNetPay(double grossPay, double deductions) {
        return grossPay - deductions;
    }
}
