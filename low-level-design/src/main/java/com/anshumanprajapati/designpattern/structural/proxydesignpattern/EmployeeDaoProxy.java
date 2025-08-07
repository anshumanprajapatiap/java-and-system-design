package com.anshumanprajapati.designpattern.structural.proxydesignpattern;

public class EmployeeDaoProxy implements EmployeeDao{

    EmployeeDao employeeDaoObj;
    EmployeeDaoProxy(){
        employeeDaoObj = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, Employee obj) throws Exception {
        if(client.equals("ADMIN")){
            employeeDaoObj.create(client, obj);
            return;
        }
        throw new Exception("ACCESS DENIED");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN")){
            employeeDaoObj.delete(client, employeeId);
            return;
        }
        throw new Exception("ACCESS DENIED");
    }

    @Override
    public Employee get(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN") || client.equals("USER")  ){
            return employeeDaoObj.get(client, employeeId);
        }
        throw new Exception("ACCESS DENIED");
    }
}
