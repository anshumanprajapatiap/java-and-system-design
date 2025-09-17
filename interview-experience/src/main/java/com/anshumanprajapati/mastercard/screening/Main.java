package com.anshumanprajapati.mastercard.screening;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;





class Employee {
    public int salary;
    public int age;

    public Employee(int salary, int age) {
        this.salary = salary;
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}

class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		if(e1.getSalary() != e2.getSalary())return Integer.compare(e2.getSalary(), e1.getSalary());
		
		return Integer.compare(e1.getAge(), e2.getAge());
	}
	
}

public class Main {
	
	
	
	public static void main(String[] args) {
		
		/*
		 * 
		 * Most Frequent Element
	["Java", "Scala","GoLang", "Java","GoLang","Javascript","Java"]
	Answer - Java

		 */
		
//		
//		Employee
//	    int id
//	    String name
//	    int age
//	    int salary
//	    String designation
//	    int departmentId
	    
	    // list emp
	    // salary > 
	    // age <
		
		PriorityQueue<Employee> pq = new PriorityQueue<>(new EmployeeComparator());

        // Add some employees to the priority queue
        pq.add(new Employee(50000, 30));
        pq.add(new Employee(60000, 25));
        pq.add(new Employee(50000, 28));
        pq.add(new Employee(60000, 35));
        
        while (!pq.isEmpty()) {
            Employee e = pq.poll();
            System.out.println("Employee with salary: " + e.getSalary() + " and age: " + e.getAge());
        }
		
	}
	
	
//	(Employee e1, Employee e2){
//		if(e1.salary!=e2.salary) {
//			return e1.salary>e2.salary;
//		}
//		return e1.age < e2.age;
//		
//	}
	
	
	
	
	static String findMostFrequent(String[] list) {
		Map<String, Integer> mp = new HashMap<>();
		String element = "";
		Integer maxTillNow = 0;
		
		for(String ele:list) {
			mp.put(ele, mp.getOrDefault(mp.get(ele), 0)+1);
		}
		
		for(String e: mp.keySet()) {
			
		}
		return "";
	}

}
