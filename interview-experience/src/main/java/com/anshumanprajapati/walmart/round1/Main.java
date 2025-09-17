package com.anshumanprajapati.walmart.round1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Given an unsorted array arr[] of size N having both negative and positive integers. 
		 * The task is place all negative element at the end of array without changing the order of positive element and negative element. 
		 * Creating a new array not allowed, no deletion of any
		 */
		    
		    int [] arr = new int[] {-5, 7, -3, -4, 9, 10, -1, 11}; 
		    //-2 -3 4 5 -6 1 2 -9
		    //-2 -3 4 5 1 2 -6 -9
		    
		   
		    int right = arr.length-1;
		    int left = arr.length-2;
		    
		    while(right>0 && left>=0) {
		    	
		    	if(arr[left]<0 && arr[right]<0) {
		    		
		    		left--;
		    		right--;
		    	}
		    	
		    	else if(arr[left]<0 && arr[right]>0) {
		    		
		    		for(int i=left; i<right; i++) {
		    			swap(arr, i, i+1);
		    		}
		    		right--;
		    		left--;
		    		
		    		
		    	} else if(arr[left]>0 && arr[right]>0) {
		    		left--;
		    	}
		    	
		    	
		    	
		    }
		
		
		    for(int ele:arr) {
		    	System.out.print(ele+ " ");
		    }
		
		
	
		
		

	}
	
	static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
	}

}