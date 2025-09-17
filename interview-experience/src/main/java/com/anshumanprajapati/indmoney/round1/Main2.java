package com.anshumanprajapati.indmoney.round1;

import java.util.TreeMap;

public class Main2
{
    public static void main(String[] args) {
	    /*
	        Given an integer array split the array into strictly decreasing sequences,
	        return the minimum number of decreasing arrays you can get from splitting the array.

            Input: [5, 2, 4, 3, 1, 7]
            Output: 3

            Explain: [5, 2, 1], [4, 3], [7]

            Input: [2, 9, 13, 14, 4, 8, 7, 6, 10]
            Output: 4

            Input: [2, 9, 13, 14, 4, 8, 7, 6, 10]
            Explain: [2], [9, 4], [13, 10], [14, 8, 7, 6]



                   1   2  3   4   4

                   min 2 0
                       4 1
                       9 2
                   max 14

                    // 13
                    // 14

                    // 2
                    // 9
                    // 13
                    // 14

                    // 2 0
                    // 4 1
                    // 6 2
                    // 10 3

	    */

        int[] input1 = {5, 2, 4, 3, 1, 7};
        int[] input2 = {2, 9, 13, 14, 4, 8, 7, 6, 10};

        System.out.println("Output 1: " + minDecreasingSequences(input1)); // Output: 3
        System.out.println("Output 2: " + minDecreasingSequences(input2)); // Output: 4
    }


    public static int minDecreasingSequences(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int num: nums){
            Integer higher = map.higherKey(num);
            if (higher != null) {
                map.put(higher, map.get(higher) - 1);
                if (map.get(higher) == 0) {
                    map.remove(higher);
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
            System.out.println("Current Map: " + map);
        }

        return map.size();
    }
}
