package com.anshumanprajapati.here.round3R1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Move all zeroes to End (or) Front of array ex : 
		 * input {12,0,0,7,8,0,1} 
		 * o/p End : {12,7,8,1,0,0,0}
		 * 
		 */
		int[] array = new int[] {12, 0, 0, 7, 8, 0, 1};
		moveZeroAtEnd(array);
		for(int ele: array) {
			System.out.print(ele+ " ");
		}

	}
	
	public static void moveZeroAtEnd(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		
		while(start<end) {
			System.out.println(start+ " " +end);
			System.out.print(arr);
			
			if(arr[start]!=0 && arr[end]!=0) {
				start++;
		
			} 
			else if(arr[start]==0 && arr[end]!=0) {
				System.out.println("swap : " + start+ " " +end);
				//swap(start, end);
				arr[end] = arr[start];
				arr[start] = arr[end];
//				end--;
				start++;
	
			} 
			else if(arr[end]==0){
				end--;
		
			}
			
		}
		
	}
	
	

}
/*
 * 
 * DEPT            AND EMP
 * ID NAME		   name DEPTID
 * 
 * SELECT EMP.name, DEPT.name FROM
 * LEFT JOIN EMP.deptId = DEPT.id
 * GROUP BY DEPT.id
 * 
 */


//public class Employee{
//	
//	int empId;
//	String name;
//	int age;
//	String city;
//	
//}