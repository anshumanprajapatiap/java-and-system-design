package com.anshumanprajapati;

class Employee {
	int employeId;
	String nameEmp;
	String phoneNo;
	
	Employee (int id, String name, String phone){
		this.employeId = id;
		this.nameEmp = name;
		this.phoneNo = phone;
	}
	
	Employee (int id, String name){
		this.employeId = id;
		this.nameEmp = name;
	}
	
	String getDetails() {
		return employeId+" : "+nameEmp+" : "+phoneNo;
	}
	
	void setPhone(String phone) {
		this.phoneNo=phone;
	}
	
	
	public String toString() {
		return employeId+" : "+nameEmp+" : "+phoneNo;
	}
	
	public int hashCode() {
		return this.employeId;
	}
	
	public boolean equals(Employee e) {
		return this.employeId == e.employeId;
	}
}





public class ClassMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Employee e = new Employee(1, "Anshuman", "9755697556");
		Employee e1 = new Employee(2, "Anshuman", "9755697556");
		System.out.println("toString -> " + e.toString());
		System.out.println("hashCode -> " + e.hashCode());
		System.out.println("equals -> " + e.equals(e1));

	}

}
