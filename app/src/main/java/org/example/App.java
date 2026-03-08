package org.example;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to the Payroll Tool. First, please enter the number of hours worked this week: ");
    double hoursWorked = scanner.nextDouble();
    System.out.println("Please enter your hourly pay rate: ");
    double payRate = scanner.nextDouble();
    while (payRate < 0) {
      System.out.println("Pay rate cannot be negative. Please re-enter your hourly pay rate: ");
      payRate = scanner.nextDouble();
    }
    System.out.println("Please enter the number of dependents: ");
    int dependents = scanner.nextInt();
    if (dependents < 0) {
      dependents = 0;
    }
    Calculator calculator = new Calculator();
    double grossPay = calculator.calculateGrossPay(hoursWorked, payRate);
    double deductions = calculator.calculateDeductions(grossPay, dependents);
    double netPay = calculator.calculateNetPay(grossPay, deductions);
    System.out.println("\n*****Payroll Report*****");
    System.out.printf("Hours worked: %.2f\n", hoursWorked);
    System.out.printf("Rate of pay: $%.2f\n", payRate);
    System.out.printf("Gross earnings: $%.2f\n", grossPay);
    System.out.printf("Calculated expenses: $%.2f\n", deductions);
    System.out.printf("Net pay: $%.2f\n", netPay);
    System.out.println("\nThank you for using the Payroll Tool, Goodbye.");
    scanner.close();
  }
}