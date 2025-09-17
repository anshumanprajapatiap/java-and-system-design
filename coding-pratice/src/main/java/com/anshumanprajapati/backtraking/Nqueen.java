package com.anshumanprajapati.backtraking;

public class Nqueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void printBoard(int[][] board) {
		for(int[] row: board) {
			for(int ele: row) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}
	}
	
	static void solveSudoku(int col, int[][] board, int n) {
		if(col==n) {
			printBoard(board);
			return;
		}
		for(int row=0; row<n; row++) {
			if(isSafe(row, col, board, n)) {
				board[row][col] = 1;
				solveSudoku(col+1, board, n);
				board[row][col] = 0;
			}
		}
	}
	
	static boolean isSafe(int row, int col, int[][] board, int n){
		int duprow = row;
		int dupcol = col;
		
		while(row>=0 && col>=0) {
			if(board[row][col]==1) return false;
			row--;
			col--;
		}
		
		col = dupcol;
		row = duprow;
		while(col>=0) {
			if(board[row][col]==1) return false;
			col--;
		}
		col = dupcol;
		row = duprow;
		while(row<n && col>=0) {
			if(board[row][col]==1) return false;
			row++;
			col--;
		}
		
		
		return true;
	}

}
