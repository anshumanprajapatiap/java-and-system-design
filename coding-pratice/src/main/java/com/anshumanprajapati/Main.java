package com.anshumanprajapati;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "AACBAC";
        int K =2;
        System.out.println(findMxmaTCHING(s, K));

    }

    public static int findMxmaTCHING(String s, int k){
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        for(char c='A'; c<='Z'; c++){
            int left = 0, right =0, notMatching = 0;
            while(left<n && right<n) {
                if (c == s.charAt(right)) {
                    right++;
                } else if (notMatching > k){
                    if (c != s.charAt(left)) notMatching--;
                    left++;
                }
                notMatching++;
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}