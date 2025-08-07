package com.anshumanprajapati.designpattern.structural.proxydesignpattern;

public class Main {

    public static void main(String[] args) {
        try{
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.create("ADMIN", new Employee());
            System.out.println("Operation successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.create("USER", new Employee());
            System.out.println("Operation successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
