/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 17:22:23
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 20:37:49
*/
package interview.design.snake;

class Board{

	final int ROWS,COLS;
	Cell[][] cells;

	Board(int rows,int cols){
		ROWS = rows;
		COLS = cols;

		cells = new Cell[ROWS][COLS];
		for(int row=0;row<ROWS;row++){
			for(int col=0;col<COLS;col++){
				cells[row][col] = new Cell(row,col);
			}
		}
	}

	public void generateFood(){
		int row = (int)(Math.random()*ROWS);
		int col = (int)(Math.random()*COLS);
		cells[row][col].type = Cell.CELL_FOOD;
	}

	public int getRow(int row,Character type){

		if(type == '+')
			row++;
		else
			row--;

		if(row >= ROWS){
			row = 0;
		}

		if(row < 0){
			row = ROWS - 1;
		}
		return row;
	}

	public int getCol(int col,Character type){
		if(type == '+')
			col++;
		else
			col--;

		System.out.println("col is"+col);
		if(col >= COLS){
			col = 0;
		}

		if(col < 0){
			col = COLS - 1;
		}
		System.out.println("col updated  is "+col);
		return col;
	}
}