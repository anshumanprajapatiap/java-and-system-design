package com.anshumanprajapati;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Employee> pq = new PriorityQueue<>((x,y) -> x.salary==y.salary ? x.id-y.id : x.salary-y.salary);
        Employee e1 = new Employee(1, "A", 200);
        Employee e2 = new Employee(2, "B", 300);
        Employee e3 = new Employee(3, "C", 100);
        Employee e4 = new Employee(4, "D", 200);
        pq.offer(e1);
        pq.offer(e2);
        pq.offer(e3);
        pq.offer(e4);
        System.out.println(pq);
        e1.setId(500);
        System.out.println(pq);
        e4.setId(50);
        System.out.println(pq);
    }
}

class Employee{
    int id;
    String name;
    int salary;

    Employee(int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public String toString(){
        return "id: " + id + ", name: " + name + ", salary: " + salary;
    }
}
