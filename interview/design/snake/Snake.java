/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 17:26:15
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 20:17:43
*/
package interview.design.snake;
import java.util.LinkedList;

class Snake{
	LinkedList<Cell> snakeCellList = new LinkedList<>();
	Cell head;

	public Snake(Cell initCell){
		head = initCell;
		snakeCellList.add(head);
	}

	public void grow(){
		snakeCellList.add(head);
	}

	public void move(Cell nextCell){
		Cell tail = snakeCellList.removeLast();
		tail.type = Cell.CELL_EMPTY;

		head = nextCell;
		snakeCellList.addFirst(head);
	}

	public boolean checkCrash(Cell nextCell){
		for(Cell cell:snakeCellList){
			if(cell == nextCell){
				return true;
			}
		}
		return false;
	}
}