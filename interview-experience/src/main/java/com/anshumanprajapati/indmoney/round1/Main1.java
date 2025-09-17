package com.anshumanprajapati.indmoney.round1;

import java.util.LinkedList;
import java.util.Queue;

public class Main1 {
/*
        Given a matrix of positive and negative integers convert all the negative integers to positive
        A negative number can be converted to positive if atleast one of its adjacent indexes is positive
        Top, left, right and bottom are considered adjacent
        Note: 0 is neither positive nor negative

        Example

        prev = [
          [0, -2, -1],
          [-5, 2, 0],
          [-6, -2, 0],
        ]

        After pass 1
        [
          [0, 2, -1],
          [5, 2, 0],
          [-6, 2, 0],
        ]

        After pass 2

        [
          [0, 2, 1],
          [5, 2, 0],
          [6, 2, 0],
        ]
         */

    private boolean isValid(int i, int j, int n, int m){
        return i<n && i>=0 && j<m && j>=0;
    }

    private int minTimeToConvertAllNumberToPositive(int[][] mat){
        int[] dir = new int[]{0, 1, 0, -1, 0};

        int n = mat.length;
        if(n==0) return 0;
        int m = mat[0].length;

        Queue<Pair> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] > 0) queue.add(new Pair(i, j, mat[i][j]) );
            }
        }
        if(queue.isEmpty()) return -1;
        int level = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            level++;
            for(int q=0; q<size; q++){
                Pair front = queue.poll();

                for(int d=0; d<4; d++){
                    int newx = front.x + dir[d];
                    int newy = front.y + dir[d+1];
                    if(isValid(newx, newy, n, m) && mat[newx][newy]<0){
                        mat[newx][newy] = -1 * mat[newx][newy];
                        queue.add( new Pair(newx, newy, mat[newx][newy]) );
                    }
                }
            }

        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] < 0) return -1;
            }
        }
        return level;

    }

}

class Pair{
    int x;
    int y;
    int val;
    public Pair(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
