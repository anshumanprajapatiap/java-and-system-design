package com.anshumanprajapati.leetcode.contest.weekly469;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> res = new ArrayList<>();
        int base =10;
        while(n>0){
            int rem = n%base;
            n -= rem;
            base *= 10;
            if(rem!=0) res.add(rem);
        }
        int[] ans = new int[res.size()];
        for(int i=res.size()-1; i>=0; i--){
            ans[res.size()-i-1] = res.get(i);
        }
        return ans;
    }
}


public class Q1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.decimalRepresentation(513);

        for(int a: ans){
            System.out.print(a + " ");
        }
    }
}
