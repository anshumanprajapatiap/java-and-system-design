package com.anshumanprajapati.newron.walmart.round1;

public class Main {

	public static void main(String[] args) {
		
//		[1,2,3,4,5,6,7,8,...]
//
//		isBuildSuccefuly(int version) -> boolean
		
		
		
//		I am no -47 for you
//
//		I am no 4 7 for you
//
//
//
//
//
//		6736327447364387434638468
//
//
//
//
//		47


	}
	
	
	boolean isBuild(int v) {
		return true;
	}



	int firstFail(int[] arr, int start, int end){

		int mid = start + (end-start)/2;

		boolean res = isBuild(arr[mid]);

		if(!res) {
			if( mid-1>=0 && isBuild(arr[mid-1] ) ){
				// this mid is first failing

				return mid;
			}
			firstFail(arr, start, mid-1);
		}else{

			firstFail(arr, mid+1, end);
		}


		return -1;
		

	}

}
