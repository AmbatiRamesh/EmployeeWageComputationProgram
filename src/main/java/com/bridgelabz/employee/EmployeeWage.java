package com.bridgelabz.employee;

public class EmployeeWage {
    public static final int is_part_time = 1;
    public static final int is_full_time = 2;
    private final String company;
    private final int emp_rate_per_hour;
    private final int num_of_working_days;
    private final int max_hours_in_month;
    private int totalEmpWage;
    public EmployeeWage(String company, int emp_rate_per_hour, int num_of_working_days,
                                   int max_hours_in_month) {
        this.company = company;
        this.emp_rate_per_hour = emp_rate_per_hour;
        this.num_of_working_days = num_of_working_days;
        this.max_hours_in_month = max_hours_in_month;
    }
    public void computeEmpWage() {
        System.out.println("Welcome to Employee Wage Computation Program!");
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= max_hours_in_month && totalWorkingDays < num_of_working_days) {
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
        totalEmpWage = totalEmpHrs * emp_rate_per_hour;
    }
    @Override
    public String toString() {
        return "Total Emp Wage for company: " + company + " is: " + totalEmpWage;
    }
    public static void main(String[] args) {
        EmployeeWage dMart = new EmployeeWage("DMart", 20, 2, 10);
        EmployeeWage reliance = new EmployeeWage("Reliance", 10, 4, 20);
        dMart.computeEmpWage();
        System.out.println(dMart);
        reliance.computeEmpWage();
        System.out.println(reliance);
    }
}
