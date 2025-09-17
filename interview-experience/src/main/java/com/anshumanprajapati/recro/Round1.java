package com.anshumanprajapati.recro;

import java.util.ArrayList;
import java.util.List;

public class Round1 {

    public static void main(String[] args) {
        // An element is a deputy if it is greater than all the elements to its right side except the largest element to its right.
        //  [2,3,6,7,1] ans = 6
        //  [2,3,6,7,1,8, 3,2,5] ans = 7, 3

    /*     0  1  2  3  4  5  6  7  8
          [2, 3, 6, 7, 1, 8, 3, 2, 5]
          largest = 8, second = 7
     */
        int[] arr = new int[]{2,3,6,7,1};
        System.out.println(getAnswer(arr));
    }




    public static List<Integer> getAnswer(int[] arr){
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if(n==2) return ans;
        int largest = Math.max(arr[n-1], arr[n-2]);
        int second = Math.min(arr[n-1], arr[n-2]);
        int i = n-3;
        while(i >= 0){

            if(arr[i] <= largest && arr[i] > second){
                ans.add(arr[i]);
                second = arr[i];
            }else if(arr[i] > largest){
                second = largest;
                largest = arr[i];
            }
            i--;
        }

        return ans;
    }

    /*
        //         20
        //       /   \
        //      8     22
        //    /  \     \
        //   4   12    11
        //      /  \
        //     10   14
     */

    // 20  22 8 4 12 11 14 10

    // 20
    // 22 8
    // 11 12 4
    // 4 12 11

//    s1 // 20
//
//     s2 // 22 8
//    s1 //  22 8
//
//    s2 // 4 12 11
//    s1 //  4 2 11
//
//    s2// 14 10
//    s1// 14 10
}
