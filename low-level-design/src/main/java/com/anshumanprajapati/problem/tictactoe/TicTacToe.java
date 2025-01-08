package problem.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	char[][] board;
	int currentPlayer;
	
	private void init() {
		int i=1;
		this.board = new char[3][3];
		for(int row=0; row<3; row++) {
			for(int col=0; col<3; col++) {
				board[row][col] = (char)(i+48);
				i++;
			}
		}
		this.currentPlayer = 1;
		printBoard();
	}
	
	TicTacToe(){
		init();
	}
	
	private void printBoard() {
		System.out.println("|-----------|");
		for(int row=0; row<3; row++) {
			System.out.print("| ");
			for(int col=0; col<3; col++) {
				System.out.print( board[row][col] +" | ");
			}
			System.out.println();
			System.out.println("|-----------|");
			
		}
		System.out.println();
		System.out.println("CurrentPlayer Id : " + currentPlayer);
	}
	
	private void switchPlayer(int playerId) {
		currentPlayer = playerId;
		printBoard();
	}
	
	private void change(char what, int where) {
		int tempRow =  (where%3==0) ? where/4 : where/3;
		int tempCol = (where%3==0) ? 2 :(where%3==2) ? 1 : 0;
		board[tempRow][tempCol]=what;
	}
	
	public void start(Scanner sc) {
		while(true) {
			char sign = currentPlayer == 1 ? 'X' : 'O';
			int where = sc.nextInt();
			boolean isValid = isValidPosition(where);
			if(isValid) {
				change(sign, where);
				boolean stop = checkWinner(sc);
				if(stop) break;
				switchPlayer((currentPlayer==1)? 2:1);
			}else {
				System.out.println("This is not valid place please select valid place");
			}
		}
	}
	
	private boolean checkWinner(Scanner sc) {
		if(gameOver()) {
			System.out.println("Want to play Again? Y/N");
			String again = sc.nextLine();
			if(again=="Y") {
				return true;
			}
			
		}
		return false;
	}
	
	private boolean gameOver() {
		
		for(int i=0; i<3; i++) {
			if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][2]==board[i][0]) {
				System.out.println("Player " + currentPlayer + " is winner");
				return true;
			}
		}
		boolean notAvail = true;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[i][j]!='X' || board[i][j]!='O'){
					notAvail = false;
					break;
				}
			}
		}
		
		return notAvail;
	}
	
	private boolean isValidPosition(int where) {
		if(where<1 && where>9) return false;
		
		int tempRow =  (where%3==0) ? where/4 : where/3;
		int tempCol = (where%3==0) ? 2 :(where%3==2) ? 1 : 0;
		if(board[tempRow][tempCol]!=(char)(where+48)) return false;
		
		return true;
	}
	
	
	public static void main(String[] args) {
		TicTacToe game =  new TicTacToe();
		Scanner sc = new Scanner(System.in);
		game.start(sc);
		
		
	}
	

}
