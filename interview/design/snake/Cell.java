/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 17:20:14
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 17:22:08
*/
package interview.design.snake;

class Cell{
	final static int CELL_EMPTY = 0,CELL_FOOD = 10,CELL_SNAKE_HEAD = 20;
	final int row,col;
	int type;
	Cell(int row,int col){
		this.row = row;
		this.col = col;
	}
}