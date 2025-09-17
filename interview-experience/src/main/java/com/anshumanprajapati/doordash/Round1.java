package com.anshumanprajapati.doordash;

import java.util.Arrays;

public class Round1 {

    /*
        You are given:
        d = 8, representing the number of available Dashers (delivery agents).
        An array orders = [3, 5, 7, 9], where each element represents the number of orders placed at a restaurant.
        A single Dasher may only serve one restaurant on a trip and can carry at most k orders from that restaurant.

        For a given capacity k, the number of Dashers required for restaurant i is
        and the platform needs the sum of those Dashers over all restaurants.

        Task Find the minimum integer k such that all orders can be delivered with at most d Dashers.
     */

    public static void main(String[] args) {
        test1();
        test1();
    }

    public static void test1(){
        int[] orders = new int[]{3, 5, 7, 9};
        int d = 8;
        System.out.println(findMinK(orders, d)==4);
    }

    public static void test2(){
        int[] orders = new int[]{0, 0, 0, 0};
        int d = 8;
        System.out.println(findMinK(orders, d)==0);
    }
    public static  boolean check(int[] orders, int k, int d){
        int daaserNeeded = 0;

        for(int i=0; i<orders.length; i++){
            daaserNeeded += (int)orders[i]/k;
            if(orders[i]%k!=0) daaserNeeded++;
        }
        return daaserNeeded <= d;
    }

    public static int findMinK(int[] orders, int d){
        int n = orders.length;
        if(n==0) return 0;
        if(d==0) return -1;
        int left = 1;
        int right = Arrays.stream(orders).max().getAsInt();
        if(right==0) return 0;
        int ans = Integer.MAX_VALUE;


        while(left<=right){

            int k = left + (right-left)/2;

            if(check(orders, k, d)){
                ans = Math.min(ans, k);
                right = k-1;
            }else{
                left = k+1;
            }
        }
        return ans;
    }

    /*
    Follow up - Each Dasher can visit at most two adjacent restaurants on a single trip
    (i.e., if a Dasher picks up from restaurants i and i+1).
     */

    private static boolean canDeliverWithK(int[] orders, int k, int d) {
        int n = orders.length;
        int[] remaining = Arrays.copyOf(orders, n);
        int dashersUsed = 0;
        int i = 0;

        while (i < n) {
            if (i + 1 < n) {
                int fromI = Math.min(k, remaining[i]);
                int fromI1 = Math.min(k, remaining[i + 1]);

                remaining[i] -= fromI;
                remaining[i + 1] -= fromI1;
                dashersUsed++;
                i += 2;
            } else {
                int fromI = Math.min(k, remaining[i]);
                remaining[i] -= fromI;
                dashersUsed++;
                i++;
            }
        }

        for (int r : remaining) {
            if (r > 0) {
                int needed = (r + k - 1) / k;
                dashersUsed += needed;
            }
        }

        return dashersUsed <= d;
    }
}
