package com.anshumanprajapati.tekion;

public class Round1 {

    public static void main(String[] args) {
        // 2 4 6 8 1 2 3
         int[] arr = new int[]{2, 4, 6, 8, 1, 2, 3};
         int profit = findMaxProfit(arr);
         System.out.println(profit);
         arr = new int[]{2, 4, 6, 8, 1, 2, 3, 10};
         profit = findMaxProfit(arr);
         System.out.println(profit);

        String a = "ebcd";
        String b = "abcefd";
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j]=-1;
            }
        }

        //for(int i=0; i<n; i++){
        //    dp[i][m] = 0;
        //}
        //Arrays.fill(dp[n], 0);

        //int len = commonSubsequence(a, b, n-1, m-1, dp);
        //System.out.println(len);


        a = "zyx";
        b = "abcefd";

        int len = commonSubsequence2(a, b);
        System.out.println(len);
    }


 	public static int findMaxProfit(int[] arr){
 	    int n = arr.length;
 	    if(n<=1) return 0;
 	    int profit = Integer.MIN_VALUE;
 	    int minValue = arr[0];

 	    for(int i=1; i<n; i++){
 	        profit = Math.max(profit, arr[i] - minValue);
 	        minValue = Math.min(arr[i], minValue);
 	    }
 	    return profit<0 ? 0 : profit;
 	}

    /*
        ebcd
        abcefd

        bcd
    */
    /*
    String a = "ebcd";
	String b = "abcefd";
	i=3
	j=5
	 1 +
    */
    public static int commonSubsequence(String a, String b,
                                        int i, int j, int[][] dp){

        if(i<0 || j<0) return 0;


        if(dp[i][j]!=-1) return dp[i][j];

        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j] = 1 + commonSubsequence(a, b, i-1, j-1, dp);
        }else{
            return dp[i][j] = Math.max(
                    commonSubsequence(a,b, i-1, j, dp),
                    commonSubsequence(a,b, i, j-1, dp)
            );
        }

    }


    public static int commonSubsequence2(String a, String b){
        int n = a.length();
        int m = b.length();
        //int[][] dp = new int[n+1][m+1];

        int[] prev = new int[m+1];

        for(int i=1; i<=n; i++){
            int[] curr = new int[m+1];
            for(int j=1; j<=m; j++){

                if(a.charAt(i-1)==b.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max( prev[j], curr[j-1] );
                }
            }
            prev = curr;
        }
        return prev[m];
    }


}