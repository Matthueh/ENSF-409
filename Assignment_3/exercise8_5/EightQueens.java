/** 
	@author Matthew Ho <a href = "mailto:matthew.ho1@ucalgary.ca">
		matthew.ho1@ucalgary.ca</a>
	@version 1.0
	@since 1.0
	*/

import java.util.Arrays;

public class EightQueens{
	
	private char[][] chessBoard = new char[8][8]; //This is the chess board

	
	public EightQueens(){
		for(char[] row : chessBoard ){ //This is the default constructor.
			Arrays.fill(row , 'o');
		}
	}
	
	/**@return copy returns a deep copy of the object
	*	
	*/
	public EightQueens clone(){ //This makes a deep copy of the object
		EightQueens copy = new EightQueens(); // This activates the default constructor
		copy = clone_Call(this, copy, 0, 0);
		copy.getRidOft();
		return copy;
	}
	/** @param src will take in a source object that we would like to copy.
	* 	@param dest will take in a destination object that we would like to copy into.
	*	@param row will take in the starting indices for rows.
	*	@param column will take in the starting indices for columns.
	*	@return dest will return the destination object with deep copies.
	*/
	
	public EightQueens clone_Call(EightQueens src, EightQueens dest, int row, int column){ //This is a helper method 
		if(column != 8 && row != 8){
			if(src.getChar(row,column) == 'o' || src.getChar(row,column) == 't'){
				//do nothing 
				return clone_Call( src, dest, row, column + 1);
			}
			else if(src.getChar(row,column) == 'Q'){
				dest.setQueen(row, column);
				return clone_Call(src, dest, row, column + 1); 
			}
			return dest;
		}
		else if( column == 8 && row != 8){
			return clone_Call( src, dest, row + 1, 0);
		}
		
		else{
			return dest;
		}
	}
	
	/**	@return chessBoard will return the current 2 dimensional array.
	*/
	public char[][] getBoard(){ //This will return the chess board.
		return chessBoard;
	}
	/**	@param i will take in the row indices.
	*	@param j will take in the column indices.
	*	@return chessBoard[i][j] will return the char located in this indices.
	*/
	
	public char getChar(int i, int j){	//this getes a particular character in the call 
		return chessBoard[i][j];
	}
	
	/**	@param row will take in the rows.
	*	@param column will take in the columns
	*/
	public void setQueen( int row, int column){ //this marks a 'Q' on the board as well as placing 't's' along the board.
		chessBoard[row][column] = 'Q';
		threatened(row, column);
		checkingDiagonals();
	}
	
	/**	@param row will take in the row argument.
	*	@param column will take in the column argument.
	*/
	
	public void emptySquare(int row, int column){ //this marks an 'o' on the board
		chessBoard[row][column] = 'o';
	}
	
	/**	@param row will take in the row argument.
	*	@param column will take in the column argument.
	*	@return will return a 2 dimensional array.
	*/
	
	public char[][] threatened(int row, int column){

			setThreatened(row, column, 0, 0);
			return chessBoard;
			
	}
	
	/**	@param Qrow this will be the row where a Queen resides.
	*	@param Qcolumn this will be the column where a Queen resides.
	*	@param row this will take in a row argument.
	*	@param column this will take in a column argument.
	*	@return chessBoard This will return the 2 dimensional array.
	*/
	public char[][] setThreatened(int Qrow, int Qcolumn, int row, int column){ //This will place a character t whenever a queen is threatening a place
		if(column < 8){
			if( column == Qcolumn){
				return setThreatened(Qrow, Qcolumn, row, column +1);
			}
			else if ( row != Qrow || ( Qrow == 0)){
				chessBoard[Qrow][column] = 't';
				return setThreatened(Qrow, Qcolumn, row, column + 1);
			}
			return chessBoard;
		}
		
		else if(row < 8){
			if( row == Qrow){
				return setThreatened(Qrow, Qcolumn, row + 1, column);
			}
			else if(column != Qcolumn) {
				chessBoard[row][Qcolumn] = 't';
				return setThreatened(Qrow, Qcolumn, row + 1, column);
			}
			return chessBoard;
		}
		
		else{
			return chessBoard;
		}
		
	}
	
	public void checkingDiagonals(){ // This will populate the diagonals of the queens

		int forward_x = 0;
		int backward_x = 0;
		int forward_y = 0;
		int backward_y = 0;
		
		int forward_negx = 0;
		int forward_negy = 0;
		int backward_negx = 0;
		int backward_negy = 0;
		
		for(int i = 0; i < 8 ; i++){
			for( int j = 0; j < 8; j++){
				if( chessBoard[i][j] == 'Q'){
					
					forward_x = i + 1; //this is used to move along the the positive slope
					backward_x = i - 1;
					forward_y = j + 1;
					backward_y = j - 1;
					
					while(true){ // forward first
						if( forward_x < 8 && forward_y < 8){
							if( chessBoard[forward_x][forward_y] != 'Q' ){
								chessBoard[forward_x][forward_y] = 't';
							}
							forward_x++;
							forward_y++;
						}
						else{
							break;
						}
					}
					
					while(true){
						if( backward_x >= 0 && backward_y >= 0){
							if(chessBoard[backward_x][backward_y] != 'Q'){
								chessBoard[backward_x][backward_y] = 't';
							}
							backward_x--;
							backward_y--;
						}
						else{
							break;
						}
					}
					
					forward_negx = i + 1;
					forward_negy = j + 1;
					backward_negx = i - 1;
					backward_negy = j - 1;
					
					while(true){
						if(forward_negx < 8 && backward_negy >= 0){
							if(chessBoard[forward_negx][backward_negy] != 'Q'){
								chessBoard[forward_negx][backward_negy] = 't';
							}
							forward_negx++;
							backward_negy--;
						}
						else{
							break;
						}
					}
					
					while(true){
						if(backward_negx >= 0 && forward_negy < 8){
							if(chessBoard[backward_negx][forward_negy] != 'Q'){
								chessBoard[backward_negx][forward_negy] = 't';
							}
							backward_negx--;
							forward_negy++;
						}
						else{
							break;
						}
					}

				}

				}
			}
		
	}
	
	public void getRidOft(){ //This gets rid of the t's that are marked up on the chessBoard.
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8 ; j++){
				if( chessBoard[i][j] == 't'){
					chessBoard[i][j] =  'o';
				}
			}
		}
	}
	
	/** @param queensRemaining this will be how many queens will remain
	* 	@return bool will return a boolean if the amount of queens 
	*/
	public boolean setQueens(int queensRemaining){//This is will do it's best to place down the queens 
		boolean bool = false;
		if(queensRemaining != 1){
			helperQueens( 0, 0, false, true);
			return setQueens(queensRemaining - 1);
		}
		else{
			bool = helperQueens(0, 0, false, true);
			getRidOft();
			return bool;
		}
	}
	/**	@param row this will handle the rows. 
	* 	@param column this will handle the columns.
	*	@param truth this will act like a switch and should turn false once the method is done executing.
	* 	@param start this will act like a swtich to allow us to start at 0 without infinetely looping.
	*	@return bool this will return a boolean.
	*/
	
	public boolean helperQueens(int row, int column, boolean truth, boolean start){//this is a helper method for set queens,
		if(chessBoard[findQ(0, column)][column] == 'Q' && start == true){
			row = findQ(0, column);
			chessBoard[row][column] = 't';
			start = false;
			return helperQueens( row + 1, column , truth, start);
			
		}
		else if((chessBoard[row][column] == 't' || chessBoard[row][column] == 'Q') && row < 8 && column < 8 && truth == false && start == true){
			start = false;
			return helperQueens( row , column , truth, start); 
		}
		else if( (chessBoard[row][column] == 't' || chessBoard[row][column] == 'Q') && row < 8 && column < 7 && truth == false ){
			return helperQueens(row, column + 1, truth, start);
		}
		else if((chessBoard[row][column] == 't' || chessBoard[row][column] == 'Q') && row < 7 && column == 7 && truth == false){
			start = true;
			return helperQueens(row + 1, 0, truth, start); 
		}
		else if((chessBoard[row][column] == 't' || chessBoard[row][column] == 'Q') && row == 8 && column == 7 && truth == false){
			return false;
		}
		else{
			setQueen(row, column);
			threatened(row, column);
			checkingDiagonals();
			if( safe(row, column) == false){
				start = true;
				return helperQueens(row - 1, 0, truth , start);
			}
			else{
				return false;
			}
		}
		
			
	}
	
	/**	@param row this will handle the rows.
	*	@param column this will handle the column.
	*	@return row this will be the row at which Q is located.
	*/
	public int findQ(int row, int column){ //this will find the q in the previous row if there is no solution to the future row.
		if(chessBoard[row][column] != 'Q' && row < 7){
			return findQ(row + 1, column);
		}
		else{
			return row;
		}
	}
	/**	@param row will handle the rows.
	* 	@param column will handle the columns.
	*	@return bool this will return a boolean.
	*/
	
	public boolean safe(int row, int column){ //This tries to revert back one row behind.

		if(chessBoard[row][column] == 't'&& row < 7){
			return safe(row + 1, column); 
		}
		else if ( chessBoard[row][column] !=  't' && row == 7){
			return true;
		}
		else{
			return false;
		}
	}
	/** @param args will handles command line arguments.
	*	
	*/
	
	public static void main(String [] args){ //a series of tests done 
		EightQueens check = new EightQueens();
		EightQueens copy = new EightQueens();
		check.setQueen( 0, 0);
		
		copy = check.clone();
		//check.setQueen(0,1)

		//check.setQueen(3, 4);
		check.setQueens(7);
		
		for( int i = 0; i < 8; i++){
			for( int j = 0; j < 8; j++){
				System.out.print(copy.getChar(i, j));
			}
			System.out.println();
		}
		System.out.println();
		for( int i = 0; i < 8; i++){
			for( int j = 0; j < 8; j++){
				System.out.print(check.getChar(i, j));
			}
			System.out.println();
		}
	}
	
}