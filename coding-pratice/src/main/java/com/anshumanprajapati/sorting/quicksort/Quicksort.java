package com.anshumanprajapati.sorting.quicksort;

public class Quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {7,8,10,11,2,4,6,7,3,2,1,6};
		
		System.out.print("Array : ");printArray(arr);
		quickSort(arr, 0, arr.length-1);
		System.out.print("Sorted Array : ");printArray(arr);
	}
	static void printArray(int[] arr) {
		for(int ele:arr) System.out.print(ele+" ");
		System.out.println();
	}
	
	static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int partitionIndex = findPivot(arr, low, high);
			quickSort(arr, low, partitionIndex-1);
			quickSort(arr, partitionIndex+1, high);
		}
	}
	
	static int findPivot(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i =0;
		int j=high;
		while(i<j) {
			
			while(arr[i]<=pivot && i <= high-1) {
				i++;
			}
			while(arr[j]>pivot && j >= low+1) {
				j--;
			}
			if(i<j) swap(arr, i, j);
			
		}
		swap(arr, low, j);
		return j;
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]=temp;
	}

}
