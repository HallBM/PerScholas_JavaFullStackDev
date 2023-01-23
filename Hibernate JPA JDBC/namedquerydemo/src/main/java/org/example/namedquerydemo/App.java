package org.example.namedquerydemo;

import org.example.employeecontroller.EmployeeController;

public class App 
{
    public static void main( String[] args )
    {
        EmployeeController e = new EmployeeController();
        //e.createEmployeeTable();
        System.out.println("FIND ALL EMPLOYEES:");
        e.findAllEmployees();
        System.out.println("\nFIND EMPLOYEE ID 5:");
        e.findEmployeeById(5);
        System.out.println("\nFIND EMPLOYEE TOM THELE:");
        e.findEmployeeByname("Tom Thele");
        System.out.println("\nSHOW OFFICE CODES AS DEPARTMENT:");
        e.ShowOfficeCodes_AsDepartment();
        
    }
}
