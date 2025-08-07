package com.anshumanprajapati.sorting.merge;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array");
        printArray(arr);
    }
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
