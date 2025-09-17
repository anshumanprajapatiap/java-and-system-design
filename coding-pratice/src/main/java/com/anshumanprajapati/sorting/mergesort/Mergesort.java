package com.anshumanprajapati.sorting.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mergesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {7,8,10,11,2,4,6,7,3,2,1,6};
		
		System.out.print("Array : ");printArray(arr);
		divide(arr, 0, arr.length-1);
		System.out.print("Sorted Array : ");printArray(arr);

	}
	static void printArray(int[] arr) {
		for(int ele:arr) System.out.print(ele+" ");
		System.out.println();
	}
	
	
	static void divide(int[] arr, int low, int high) {
		
		if(low==high) return;
		
		int mid = (high+low)/2;
		divide(arr, low, mid);
		divide(arr, mid+1, high);
		
		merge(arr, low, mid, high);
	}
	
	static void merge(int[] arr, int low, int mid, int high){
		List<Integer> temp = new ArrayList<>();
		int left = low;
		int right = mid+1;
		while(left<=mid && right<=high) {
			if(arr[left]<=arr[right]) {
				temp.add(arr[left]);
				left++;
			}else {
				temp.add(arr[right]);
				right++;
			}
		}
		
		while(left<=mid) {
			temp.add(arr[left]);
			left++;
		}
		
		while(right<=high) {
			temp.add(arr[right]);
			right++;
		}
		
		for(int i=low; i<=high; i++) {
			arr[i]=temp.get(i-low);
		}
	}

}
