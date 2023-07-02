package com.bridgelabz.employee;
import java.util.ArrayList;
import java.util.List;

interface IComputeEmpWage {

    public void addCompanyEmpWage(String company, int wagePerHour, int totalWorkingDays, int maxWorkingHour);

    public int computeEmpWage(CompanyEmpWage companyEmpWage);

    public void printTotalWage();
}

public class EmployeeWage implements IComputeEmpWage {

    public static final int is_part_time = 1;
    public static final int is_full_time = 2;

    private int numOfCompany = 0;
    private List<CompanyEmpWage> companyEmpWageArray;

    public EmployeeWage() {
        companyEmpWageArray = new ArrayList<>();
    }

    public void addCompanyEmpWage(String company, int emp_rate_per_hour, int num_of_working_days,
                                  int max_hours_in_month) {
        companyEmpWageArray
                .add(new CompanyEmpWage(company, emp_rate_per_hour, num_of_working_days, max_hours_in_month));
        numOfCompany++;
    }

    public void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageArray.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));

            System.out.println(companyEmpWage);
        }

    }

    public int computeEmpWage(CompanyEmpWage companyEmpWage) {

        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        while (totalEmpHrs <= companyEmpWage.max_hours_in_month
                && totalWorkingDays < companyEmpWage.num_of_working_days) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case is_part_time:
                    empHrs = 4;
                    break;
                case is_full_time:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day: " + totalWorkingDays + " Emp Hr: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.emp_rate_per_hour;

    }

    public void printTotalWage() {
        for (int i = 0; i < numOfCompany; i++) {
            System.out.println("Total salary for " + companyEmpWageArray.get(i).getCompany() + ": $"
                    + companyEmpWageArray.get(i).getTotalEmpWage());
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program!");

        EmployeeWage empWageBuilder = new EmployeeWage();
        empWageBuilder.addCompanyEmpWage("DMart", 20, 2, 10);
        empWageBuilder.addCompanyEmpWage("Reliance", 10, 4, 20);
        empWageBuilder.computeEmpWage();
        empWageBuilder.printTotalWage();

    }
}
