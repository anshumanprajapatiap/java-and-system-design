package com.anshumanprajapati.hivepro.round2;

//1 2 3 4 5 6 7 3 8 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 .....
//you are given a large array of integers and a 4 core machine
//We need to write a program that adds all elements of the array concurrently and produce sum


class Main{
 public static void main(String[] args){
     int[] array = new int[] { 2, 3, 4, 5, 6, 7, 3, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7};
     
     
     Utility utility = new Utility(array);
     System.out.println(utility.getConcurrentSum());
     //testing
     int sum = 0;
     for(int ele: array){
         sum += ele;
     }
     System.out.println(sum);
 }
}