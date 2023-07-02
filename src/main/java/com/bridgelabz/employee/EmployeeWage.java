package com.bridgelabz.employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface IComputeEmpWage {

    public void addCompanyEmpWage(String company, int wagePerHour, int totalWorkingDays, int maxWorkingHour);

    public int computeEmpWage(CompanyEmpWage companyEmpWage);

    public void printTotalWage();
}

public class EmployeeWage implements IComputeEmpWage {

    public static final int is_part_time = 1;
    public static final int is_full_time = 2;

    private int numOfCompany = 0;
    private LinkedList<CompanyEmpWage> companyEmpWageList;
    private Map<String, CompanyEmpWage> companyToEmpWageMap;

    public EmployeeWage() {
        companyEmpWageList = new LinkedList<>();
        companyToEmpWageMap = new HashMap<>();
    }

    public void addCompanyEmpWage(String company, int emp_rate_per_hour, int num_of_working_days,
                                  int max_hours_in_month) {

        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, emp_rate_per_hour, num_of_working_days,
                max_hours_in_month);
        companyEmpWageList.add(companyEmpWage);
        companyToEmpWageMap.put(company, companyEmpWage);
        numOfCompany++;
    }

    public void computeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));

            System.out.println(companyEmpWage);
        }

    }

    public int getTotalWage(String company) {
        return companyToEmpWageMap.get(company).totalEmpWage;
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
            System.out.println("Total salary for " + companyEmpWageList.get(i).getCompany() + ": $"
                    + companyEmpWageList.get(i).getTotalEmpWage());
            System.out.println("Daily Wages for " + companyEmpWageList.get(i).getCompany() + " : $"
                    + companyEmpWageList.get(i).getDailyWages());

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
