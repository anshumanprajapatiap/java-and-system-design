package com.anshumanprajapati.sorting.merge;

public class MergeSort {

    public void mergeSort(int[] arr, int left, int right){
        if(left<right){
            int mid = (right-left)/2 + left;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right){

        int[] temp = new int[right-left+1];
        int i = left; // left subarray
        int j = mid+1; // right subarray
        int k = 0; // temp array
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for(int l = left; l <= right; l++){
            arr[l] = temp[l-left];
        }
    }
}
