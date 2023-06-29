package com.bridgelabz.employee;

public class EmployeeWage {
    public static final int is_part_time = 1;
    public static final int is_full_time = 2;
    public static int computeEmpWage(String company, int emp_rate_per_hour, int num_Of_working_days,
                                     int max_hours_in_month){
        System.out.println("Welcome to Employee Wage Computation Program!");
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= max_hours_in_month && totalWorkingDays < num_Of_working_days) {
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
        int totalEmpWage = totalEmpHrs * emp_rate_per_hour;
        System.out.println("Total Emp Wage for company: " + company + " is: " + totalEmpWage);
        return totalEmpWage;
    }
    public static void main(String[] args) {
        computeEmpWage("DMart", 20, 2, 10);
        computeEmpWage("Reliance", 10, 4, 20);
    }
}
