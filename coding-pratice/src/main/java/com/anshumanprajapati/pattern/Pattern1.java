package com.anshumanprajapati.pattern;

public class Pattern1 {
    public static void main(String[] args) {
          /*
          1
          7 2
          12 8 3
          16 12 9 4
          19 17 14 10 5
          21 20 18 15 11 6
        */
        int n = 6;

        for(int i=0; i<=n; i++){
            int sum = n-1;
            backtracking(i, i, sum);
            System.out.println();
        }
    }

    public static  void backtracking(int i, int num, int sum){
        if(i==0) return;
        backtracking(i-1, num+sum, sum-1);
        System.out.print(num + " ");

    }
}
