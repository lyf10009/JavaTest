package com.BasicApp;

import java.util.*;

public class ArraySortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000);
        staff[1] = new Employee("Harry Hacker", 50000);
        staff[2] = new Employee("Tony Tester", 40000);
        Arrays.sort(staff);
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    @Override
    public int compareTo(Employee other) {
        if (salary < other.salary) return -1;
        if (salary > other.salary) return 1;
        return 0;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
}
