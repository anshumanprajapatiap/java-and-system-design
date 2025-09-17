package com.anshumanprajapati.walmart.round2;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[9][9];
	}
	
	public void solveSudoku(int[][] board) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				// prefilled continue;
				
				// row 
				// col
				// 3*3
				
			}
		}
	}
	
	boolean validOrNot(int row, int col, int ele) {
		// col
		// row
		// 3 * 3
		// eg- 1 3
		return true;
	}
	
	boolean threeValid(int[][] board, int row, int col, int ele) {
		int blockrow = row%3;
		int blockCol = col%3;
		
		int i = blockrow*3;
		int j = blockrow*3 +3;
		
		int ii = blockCol*3;
		int jj = blockCol*3 +3;
		
		
		for(int k=i; k<j; k++) {
			for(int kk=ii; kk<jj; kk++) {
				
				if(ele==board[k][kk]) {
					return false;
				}
			}
		}
		
		return true;
	}
	

}





/*



name, id , college, subject marks




SELECT *, DENSE_RANK() OVER(PATRTION BY subject ORDER BY marks DESC) rank
FROM Student
where rank = 5;





*/









