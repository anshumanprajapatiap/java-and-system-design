package com.anshumanprajapati.others.goldmansachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 0, 0, 1),
                Arrays.asList(0,1,1,1),
                Arrays.asList(1,0,0,1)
        );
        System.out.println(countConnections(matrix));
    }
    static int countConnections(List<List<Integer>> matrix){
        int n = matrix.size();
        int m = matrix.get(0).size();
        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix.get(i).get(j)==1){
                    sum += checkAllDirection(i,j,n,m, matrix);
                }
            }
        }
        return sum/2;
    }

    static int checkAllDirection(int i, int j, int n, int m, List<List<Integer>> matrix){
        int singleSum =0;
        int[][] dir = { {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1} };
        for(int[] d: dir){
            if(isValid(d[0]+i, d[1]+j, n, m) && matrix.get(d[0]+i).get(d[1]+j)==1) singleSum++;
        }
        return singleSum;
    }

    static boolean isValid(int i, int j, int n, int m){
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
