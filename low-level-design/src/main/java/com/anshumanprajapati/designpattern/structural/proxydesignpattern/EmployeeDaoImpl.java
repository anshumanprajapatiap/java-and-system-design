package com.anshumanprajapati.designpattern.structural.proxydesignpattern;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void create(String client, Employee employee) throws Exception {
        System.out.println("create new row in the Employee Table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("deleted row with employee id: " + employeeId);
    }

    @Override
    public Employee get(String client, int employeeId) throws Exception {
        System.out.println("Fetching data from the DB");
        return new Employee();
    }
}
