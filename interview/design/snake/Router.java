/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 18:09:21
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 20:49:38
*/
package interview.design.snake;

class Router{

	public static int DIRECTION_NONE = 0,DIRECTION_LEFT = -1,DIRECTION_RIGHT = 1,DIRECTION_UP = 2,DIRECTION_DOWN = -2;
	public Snake snake;
	public Board board;
	public int direction;
	private boolean gameOver;

	public Router(Snake snake,Board board){
		this.snake = snake;
		this.board = board;
	}

	public void setDirection(int direction){
		this.direction = direction;
	}

	public void update(){
		if(!gameOver && direction != DIRECTION_NONE){
			Cell nextCell = getNextCell(snake.head);
			if(snake.checkCrash(nextCell)){
				setDirection(DIRECTION_NONE);
				gameOver = true;
			}else{
				snake.move(nextCell);
				if(nextCell.type == Cell.CELL_FOOD){
					snake.grow();
					board.generateFood();
				}
			}
		}
	}

	public Cell getNextCell(Cell curPosition){
		int row = curPosition.row;
		int col = curPosition.col;

		if(direction == DIRECTION_RIGHT){
			col = this.board.getCol(col,'+');
		}else if(direction == DIRECTION_UP){
			row = this.board.getRow(row,'-');
		}else if(direction == DIRECTION_DOWN){
			row = this.board.getRow(row,'+');
		}else if(direction == DIRECTION_LEFT){
			col = this.board.getCol(col,'-');
		}

		System.out.println(row+" "+col+"----------");
		Cell nextCell = board.cells[row][col];
		return nextCell;
	}
}