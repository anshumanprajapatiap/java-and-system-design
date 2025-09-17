package com.anshumanprajapati.hivepro.round1;

import java.util.ArrayList;
import java.util.List;

//Input: [
//[1, 5, 11, 12], 
//[7, 17, 20, 21], 
//[41, 56, 90, 95], 
//[42, 60, 91, 97]
//]
//
//Input:[
//[1, 5, 11], 
//[13, 17, 20], 
//[41, 56, 90]
//]

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<Integer> checkOn2D(List<List<Integer>> matrix, int target){
		List<Integer> result = new ArrayList<>();
		
		int startRow = 0;
		int endRow = matrix.size()-1;
		int midRow = (startRow+endRow)/2;
		
		int m = matrix.get(0).size()-1;
		
		while(startRow<=endRow) {
			midRow = (startRow+endRow)/2;
			if(matrix.get(midRow).get(0)<target && matrix.get(midRow).get(m)>target) {
				startRow = midRow+1;
			} else if(matrix.get(midRow).get(0)>target && matrix.get(midRow).get(m)<target) {
				endRow = midRow-1;
			} else if(matrix.get(midRow).get(0)>=target && target<=matrix.get(midRow).get(m)) {
				break;
			}
		}
		
		int startCol = 0;
		int endCol = m;
		int midCol = (startCol+endCol)/2;	
		
		
		return result;
		
		
	}

}
